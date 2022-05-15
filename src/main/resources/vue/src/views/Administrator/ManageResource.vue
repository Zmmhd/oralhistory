<template>
<div style="margin: 10px;">
  <div style="margin: 10px 0;">
    <el-input v-model="search" placeholder="请输入关键字" style="width: 30%;" clearable/>
    <el-button type="info" style="margin-left: 5px;" @click="load">查询</el-button>
<!--    <el-select v-model="selectStatus" style="margin-left: 400px;" @change="load">-->
<!--      <el-option label="待审核" :value="0"></el-option>-->
<!--      <el-option label="审核通过" :value="1"></el-option>-->
<!--      <el-option label="审核不通过" :value="-1"></el-option>-->
<!--    </el-select>-->
  </div>

    <el-table :data="tableData" style="width: 100%;" @row-click="rowClick">
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
      <el-table-column fixed="right" label="操作" width="120">
        <template #default="scope">
          <el-button type="text" size="small" @click="handleEdit(scope.row)">编辑</el-button>
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
</template>

<script>
import request from "@/utils/request";

export default {
  name: "ManageResource",
  data() {
    return {
      tableData: [],
      search: "",
      selectStatus: 0,
      pageNum: 1,
      pageSize: 10,
      total: 0,
    }
  },
  created() {
    this.load();
  },
  methods: {
    load() {
      request.get("review/getbystatus/" + 0, {
        params: {
          pageNum: this.pageNum,
          pageSize: this.pageSize
        }
      }).then(res => {
        console.log(res);
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
      })
    },
    handleSizeChange(pageSize) {
      this.pageSize = pageSize
      this.load()
    },
    handleCurrentChange(pageNum) {
      this.pageNum = pageNum
      this.load()
    },
    handleEdit(row){

    },
    rowClick(){

    }
  }
}
</script>

<style scoped>

</style>
