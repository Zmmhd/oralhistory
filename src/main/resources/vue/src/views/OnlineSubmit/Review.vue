<template>
  <div style="margin: 10px;">
    <div>
      <el-input v-model="tele" placeholder="请输入关键字" style="width: 30%;" clearable/>
      <el-button type="info" style="margin-left: 5px;" @click="load">查询</el-button>
    </div>

    <div v-if="isNone === true" class="nothingFound">
      <i class="fa-solid fa-people-pulling pulling"></i>
      <div>别找啦，啥都没有。</div>
    </div>

    <div v-if="isNone === false">
      <el-table :data="tableData" style="width: 100%; cursor: pointer;" @row-click="">
        <el-table-column prop="title" label="标题"/>
        <el-table-column prop="upernumber" label="上传者手机号"/>
        <el-table-column prop="synopsis" label="简介"/>
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
      isNone: true,
      tableData: [],
      pageNum: 1,
      pageSize: 5,
      total: 0,
    }
  },
  methods: {
    load() {

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
