<template>
  <div style="margin: 10px;">
    <div style="margin-bottom: 10px;">
      <el-button type="info" @click="add">新增公告</el-button>
    </div>

    <el-table :data="tableData" style="width: 100%">
      <el-table-column prop="title" label="标题"/>

      <el-table-column label="上传时间" width="180">
        <template #default="scope">
          <div style="display: flex; align-items: center">
            <el-icon>
              <timer/>
            </el-icon>
            <span style="margin-left: 10px">{{ scope.row.time }}</span>
          </div>
        </template>
      </el-table-column>

      <el-table-column fixed="right" label="操作" width="120">
        <template #default="scope">
          <el-button type="text" size="small" @click="handleEdit(scope.row)">编辑</el-button>
          <el-popconfirm title="确定删除此公告吗？" @confirm="handleDelete(scope.row)">
            <template #reference>
              <el-button type="text" size="small">删除</el-button>
            </template>
          </el-popconfirm>
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

export default {
  name: "MomentsNotice",
  components: {
    Timer
  },
  data() {
    return {
      tableData: [
        {
          title: 'Tom',
          time: '2016-05-03'
        },
        {
          title: 'Tom',
          time: '2016-05-03'
        }
      ],
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

    },
    handleSizeChange(pageSize) {
      this.pageSize = pageSize
      this.load()
    },
    handleCurrentChange(pageNum) {
      this.pageNum = pageNum
      this.load()
    },
    handleEdit(row) {

    },
    handleDelete(row) {

    },
    add() {

    }
  }
}
</script>

<style scoped>

</style>