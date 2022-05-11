<template>
  <div style="margin: 10px;">
    <div>
      <el-input v-model="title" placeholder="请输入关键字" style="width: 30%;" clearable/>
      <el-button type="info" style="margin-left: 5px;" @click="load">查询</el-button>
    </div>
    <div style="margin: 5px 0;">
      <el-tag style="margin: 5px; cursor: pointer;" type="warning" @click="changeTheme('');">全部</el-tag>
      <el-tag style="margin: 5px; cursor: pointer;" v-for="t in allTheme" type="warning" @click="changeTheme(t);">
        {{ t }}
      </el-tag>
    </div>
    <el-table :data="tableData" style="width: 100%" @row-click="rowClick">
      <el-table-column prop="title" label="标题"/>
      <el-table-column label="类型">
        <template #default="scope">
          <el-tag>{{ scope.row.type }}</el-tag>
        </template>
      </el-table-column>
      <el-table-column label="省份">
        <template #default="scope">
          <el-tag type="success">{{ scope.row.province }}</el-tag>
        </template>
      </el-table-column>
      <el-table-column label="主题曲">
        <template #default="scope">
          <el-tag type="warning">{{ scope.row.theme }}</el-tag>
        </template>
      </el-table-column>
      <el-table-column prop="synopsis" label="简介"/>
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
import request from "@/utils/request";

export default {
  name: "SortByTheme",
  data() {
    return {
      tableData: [],
      theme: "",
      pageNum: 1,
      pageSize: 10,
      total: 0,
      title: "",
      allTheme: []
    }
  },
  created() {
    this.getAllTheme();
    this.load();
  },
  methods: {
    load() {
      request.get("/resource/query", {
        params: {
          title: this.title,
          type: 0,
          province: "",
          theme: this.theme,
          pageNum: this.pageNum,
          pageSize: this.pageSize
        }
      }).then(res => {
        // console.log(res);
        for (let i of res.list) {
          if (i.type === 1) {
            i.type = "文章"
          } else if (i.type === 2) {
            i.type = "视频"
          } else {
            i.type = "音频"
          }
        }
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
    getAllTheme() {
      request.get("/resource/getClassification/" + "theme").then(res => {
        console.log(res);
        this.allTheme = res;
      })
    },
    changeTheme(t){
      this.theme = t;
      this.load();
    },
    rowClick(row, event, column) {
      // 以下内容需要往下一个路由传
      sessionStorage.setItem("currentId", row.id); // 当前资源id
      sessionStorage.setItem("currentSort", "/sortByTheme"); // 当前路由
      if (row.type === "文章") {
        this.$router.push("/articleResource");
      } else if (row.type === "视频") {
        this.$router.push("/videoResource");
      } else if (row.type === "音频") {
        this.$router.push("/audioResource");
      }
    }
  }
}
</script>

<style scoped>

</style>
