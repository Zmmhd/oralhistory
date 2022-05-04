<template>
<div style="margin: 10px;">
  <div style="margin: 10px 0;">
    <el-input v-model="search" placeholder="请输入关键字" style="width: 30%;" clearable/>
    <el-button type="info" style="margin-left: 5px;" @click="load">查询</el-button>
    <el-select v-model="selectStatus" style="margin-left: 400px;" @change="load">
      <el-option label="待审核" :value="0"></el-option>
      <el-option label="审核通过" :value="1"></el-option>
      <el-option label="审核不通过" :value="-1"></el-option>
    </el-select>
  </div>

  <el-table :data="tableData" style="width: 100%">
    <el-table-column prop="id" label="编号"/>
    <el-table-column prop="status" label="审核状态"/>
    <el-table-column prop="title" label="标题"/>
    <el-table-column prop="uptime" label="上传时间"/>
    <el-table-column prop="upernumber" label="上传者手机号"/>
    <el-table-column prop="synopsis" label="简介"/>

  </el-table>
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
    }
  },
  created() {
    this.load();
  },
  methods: {
    load() {

    }
  }
}
</script>

<style scoped>

</style>