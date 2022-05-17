<template>
  <div style="margin: 10px;">

    <el-table :data="tableData" style="width: 100%; cursor: pointer;" @row-click="rowClick">
      <el-table-column prop="title" label="标题"/>

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
        style="margin-top: 10px; margin-left: 50px;"
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
import {Timer} from '@element-plus/icons-vue'
import request from "@/utils/request";

export default {
  name: "MomentsNotice",
  components: {
    Timer
  },
  data() {
    return {
      tableData: [],
      pageNum: 1,
      pageSize: 10,
      total: 0
    }
  },
  created() {
    this.load();
  },
  methods: {
    load() {
      request.get("/notice/getbytype/" + 2, {
        params: {
          pageNum: this.pageNum,
          pageSize: this.pageSize
        }
      }).then(res => {
        console.log(res);
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
    rowClick(row, event, column) {
      // 以下内容需要往下一个路由传
      sessionStorage.setItem("currentId", row.id); // 当前通知id
      sessionStorage.setItem("currentSort", "/momentsNotice"); // 当前路由
      sessionStorage.setItem("currentUrl", row.url); // 当前通知的url

      sessionStorage.setItem("currentTitle", row.title);
      sessionStorage.setItem("currentUptime", row.uptime);

      this.$router.push("/readNotice");
    }
  }
}
</script>

<style scoped>

</style>
