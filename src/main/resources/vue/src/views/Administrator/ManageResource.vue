<template>
  <div style="margin: 10px;">
    <!--    <div style="margin: 10px 0;">-->
    <!--      <el-input v-model="search" placeholder="请输入关键字" style="width: 30%;" clearable/>-->
    <!--      <el-button type="info" style="margin-left: 5px;" @click="load">查询</el-button>-->
    <!--          <el-select v-model="selectStatus" style="margin-left: 400px;" @change="load">-->
    <!--            <el-option label="待审核" :value="0"></el-option>-->
    <!--            <el-option label="审核通过" :value="1"></el-option>-->
    <!--            <el-option label="审核不通过" :value="-1"></el-option>-->
    <!--          </el-select>-->
    <!--    </div>-->

    <el-table :data="tableData" style="width: 100%; cursor: pointer;" @row-click="rowClick">
      <el-table-column prop="title" label="标题"/>
      <el-table-column label="资源类型">
        <template #default="scope">
          <el-tag>{{ scope.row.type }}</el-tag>
        </template>
      </el-table-column>
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
          <el-button type="text" size="small" @click.native.stop="handleEdit(scope.row)">编辑</el-button>
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

    <el-dialog v-model="dialogVisible" title="审核管理" width="30%">
      <el-form :model="form" label-width="120px">
        <el-form-item label="资源类型">
          <el-radio v-model="form.type" :label="1" disabled>文章</el-radio>
          <el-radio v-model="form.type" :label="2" disabled>视频</el-radio>
          <el-radio v-model="form.type" :label="3" disabled>音频</el-radio>
        </el-form-item>
        <el-form-item label="标题">
          <el-input v-model="form.title" style="width: 80%;" readonly/>
        </el-form-item>
        <el-form-item label="上传者手机号">
          <el-input v-model="form.upernumber" style="width: 80%;" readonly/>
        </el-form-item>
        <el-form-item label="简介">
          <el-input type="textarea" style="width: 80%;" v-model="form.synopsis" :autosize="{ minRows: 2, maxRows: 4 }"
                    maxlength="50" show-word-limit readonly/>
        </el-form-item>
        <el-form-item label="上传时间">
          <el-input v-model="form.uptime" style="width: 80%;" readonly/>
        </el-form-item>
        <el-form-item label="更改审核状态">
          <el-radio v-model="form.status" :label="1">通过</el-radio>
          <el-radio v-model="form.status" :label="-1">不通过</el-radio>
        </el-form-item>
      </el-form>
      <template #footer>
      <span>
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="info" @click="save">确 定</el-button>
      </span>
      </template>
    </el-dialog>
  </div>
</template>

<script>
import {Timer} from '@element-plus/icons-vue'
import request from "@/utils/request";

export default {
  name: "ManageResource",
  components: {
    Timer
  },
  data() {
    return {
      tableData: [],
      // search: "",
      selectStatus: 0,
      pageNum: 1,
      pageSize: 10,
      total: 0,
      dialogVisible: false,
      form: {}
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
        for (let i of res.data.list) {
          if (i.type === 1) {
            i.type = "文章"
          } else if (i.type === 2) {
            i.type = "视频"
          } else {
            i.type = "音频"
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
    handleEdit(row) {
      this.form = JSON.parse(JSON.stringify(row));
      if (row.type === "文章") {
        this.form.type = 1;
      } else if (row.type === "视频") {
        this.form.type = 2;
      } else {
        this.form.type = 3;
      }
      console.log(this.form);
      this.dialogVisible = true;
    },
    rowClick(row, column, cell, event) {
      console.log(row, column, cell, event)
      console.log()
      // 以下内容需要往下一个路由传
      console.log(row);
      // 发个post拿一下当前资源
      let formData = new FormData();
      formData.append("resourceId", row.resourceid);
      request.post("/resource/getbyid", formData).then(res => {
        console.log(res);
        sessionStorage.setItem("currentId", row.id); // 当前资源id
        sessionStorage.setItem("currentSort", "/manageResource"); // 当前路由
        sessionStorage.setItem("currentUrl", res.data.url); // 当前资源的url

        sessionStorage.setItem("currentTitle", row.title);
        sessionStorage.setItem("currentUpernumber", row.upernumber);
        sessionStorage.setItem("currentSynopsis", row.synopsis);
        sessionStorage.setItem("currentUptime", row.uptime);
        sessionStorage.setItem("currentStatus", 0);
        sessionStorage.setItem("currentProvince", res.data.province);
        sessionStorage.setItem("currentTheme", res.data.theme);

        if (res.data.type === 1) {
          this.$router.push("/manageRead");
        } else if (res.data.type === 2) {
          this.$router.push("/manageWatch");
        } else if (res.data.type === 3) {
          this.$router.push("/manageListen");
        }
      });
    },
    save() {
      console.log("this.form.id: ", this.form.id)
      console.log("this.form.status", this.form.status)
      let formData = new FormData();
      formData.append('status', this.form.status);
      // for (let key of formData.keys()) {
      //   console.log("key:" + key + " value:" + formData.get(key));
      // }
      request.put("/review/update/" + this.form.id, formData).then(res => {
        console.log(res);
        this.$message.success("更新成功");
        this.dialogVisible = false;
      });
    }
  }
}
</script>

<style scoped>

</style>
