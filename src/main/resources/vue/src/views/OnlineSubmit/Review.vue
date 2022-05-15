<template>
  <div style="margin: 10px;">
    <div>
      <el-input v-model="tele" placeholder="请输入你的手机号" style="width: 30%;" clearable oninput="value=value.replace(/[^\d]/g,'')" maxlength="11"/>
      <el-button type="info" style="margin-left: 5px;" @click="load">查询</el-button>
    </div>

    <div v-if="isNone === ''" class="nothingFound">
      <i class="fa-solid fa-bell"></i>
      <div>请根据手机号进行查询。</div>
    </div>

    <div v-if="isNone === true" class="nothingFound">
      <i class="fa-solid fa-people-pulling pulling"></i>
      <div>别找啦，啥都没有。</div>
    </div>

    <div v-if="isNone === false">
      <el-table :data="tableData" style="width: 100%;">
        <el-table-column prop="title" label="标题"/>
        <el-table-column prop="upernumber" label="上传者手机号"/>
        <el-table-column prop="synopsis" label="简介"/>
        <el-table-column label="审核状态">
          <template #default="scope">
            <el-tag>{{ scope.row.status }}</el-tag>
          </template>
        </el-table-column>
        <el-table-column label="上传时间" width="180" sortable>
          <template #default="scope">
            <div style="display: flex; align-items: center">
              <el-icon>
                <timer/>
              </el-icon>
              <span style="margin-left: 10px">{{ scope.row.uptime }}</span>
            </div>
          </template>
        </el-table-column>
      </el-table>

      <el-pagination
          style="margin-top: 30px; margin-left: 50px;"
          :currentPage="pageNum"
          :page-size="pageSize"
          :page-sizes="[5, 10, 20]"
          layout="total, sizes, prev, pager, next, jumper"
          :total="total"
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
      />
    </div>
  </div>
</template>

<script>
import {Timer} from '@element-plus/icons-vue'
import request from "@/utils/request";

export default {
  name: "Review",
  components: {
    Timer
  },
  data() {
    return {
      tele: "",
      isNone: "",
      tableData: [],
      pageNum: 1,
      pageSize: 5,
      total: 0,
    }
  },
  methods: {
    load() {
      if(this.tele.length !== 11){
        this.$message.error("手机号长度不合法");
        this.tele = "";
        return;
      }
      request.get("/review/upernumberlike/" + this.tele, {
        params: {
          pageNum: this.pageNum,
          pageSize: this.pageSize
        }
      }).then(res => {
        console.log(res);
        if(res.data.total !== 0) {
          for (let i of res.data.list) {
            if (i.status === 0) {
              i.status = "审核中"
            } else if (i.status === 1) {
              i.status = "已通过"
            } else {
              i.status = "未通过"
            }
          }
          this.tableData = res.data.list;
          this.total = res.data.total;
          this.isNone = false;
        } else {
          this.tableData = [];
          this.total = res.data.total;
          this.isNone = true;
        }
      })
    },
    handleSizeChange(pageSize) {
      this.pageSize = pageSize
      this.load()
    },
    handleCurrentChange(pageNum) {
      this.pageNum = pageNum
      this.load()
    }
  }
}
</script>

<style scoped>
.nothingFound {
  min-height: 100vh;
  width: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 50px;
  flex-direction: column;
  color: #ccc;
  user-select: none;
}
</style>
