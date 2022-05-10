<template>
  <div style="margin: 10px;">

    <el-table :data="tableData" style="width: 100%">
      <el-table-column prop="title" label="标题"/>

      <el-table-column label="上传时间" width="180">
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
  name: "RaiseNotice",
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
      request.get("/notice/getbytype/" + 1, {
        params: {
          pageNum: this.pageNum,
          pageSize: this.pageSize
        }
      }).then(res => {
        console.log(res);
        this.tableData = res.list;
        this.total = res.total;
        this.pageNum = res.pageNum;
        this.pageSize = res.pageSize;
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
  }
}
</script>

<style scoped>

</style>