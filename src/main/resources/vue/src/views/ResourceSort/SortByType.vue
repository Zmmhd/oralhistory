<template>
  <div style="margin: 10px;">
    <el-input v-model="province" placeholder="请输入类型" style="width: 30%;" clearable/>
    <el-button type="info" style="margin-left: 5px;" @click="load">查询</el-button>
    <el-table :data="tableData" style="width: 100%">
      <el-table-column prop="title" label="标题"/>
      <el-table-column prop="type" label="类型"/>
      <el-table-column prop="province" label="省份"/>
      <el-table-column prop="theme" label="主题曲"/>
      <el-table-column prop="synopsis" label="简介"/>
    </el-table>
  </div>
</template>

<script>
import request from "@/utils/request";

export default {
  name: "SortByType",
  data() {
    return {
      tableData: [
        {
          title: "我是标题",
          type: "类型",
          province: "上海",
          theme: "抗疫",
          synopsis: "一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十"
        }
      ],
      province: ""
    }
  },
  created() {
    // load();
  },
  methods: {
    load() {
      request.get("/get").then(res =>{
        this.tableData = res.data;
      })
    }
  }
}
</script>

<style scoped>

</style>