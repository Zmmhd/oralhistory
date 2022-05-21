<template>
  <div style="margin: 20px 75px;">
    <div style="border-bottom: #4682B4 dashed 1px;">
      <el-button style="margin: 0 0 10px 10px;" @click="back" type="info">返回</el-button>
      <el-button style="margin: 0 10px 10px 10px;" @click="handleEdit" type="info">审核管理</el-button>
    </div>

    <div style="margin: 10px;">
      <div style="font-weight: bolder; margin-bottom: 10px;">当前筛选条件：</div>
      <div style="margin: 2px 0;">标题：<span style="color :#494241;">{{ currentTitle }}</span></div>
      <div style="margin: 2px 0;">时间：<span style="color :#494241;">{{ currentUptime }}</span></div>
      <div style="margin: 2px 0;">省份：<span style="color :#494241;">{{ currentProvince }}</span></div>
      <div style="margin: 2px 0;">主题：<span style="color :#494241;">{{ currentTheme }}</span></div>
      <div style="margin: 2px 0;">简介：<span style="color :#494241;">{{ currentSynopsis }}</span></div>
    </div>

    <div style="margin: 20px; padding: 20px; border: 2px #4682B4 solid; border-radius: 5px;">
      <iframe :src=url frameborder="0" style="width: 100%; min-height: 250vh;"></iframe>
    </div>
  </div>

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
</template>

<script>
import baseUrl from "@/assets/Config";
import request from "@/utils/request";

export default {
  name: "ManageRead",
  created() {
    console.log(typeof this.currentId);
    console.log(this.currentId);
    console.log(this.url);
  },
  data(){
    return{
      currentId: sessionStorage.getItem("currentId"),
      url: baseUrl.BASE_URL + sessionStorage.getItem("currentUrl"),

      currentTitle: sessionStorage.getItem("currentTitle"),
      currentSynopsis: sessionStorage.getItem("currentSynopsis"),
      currentUptime: sessionStorage.getItem("currentUptime"),
      currentProvince: sessionStorage.getItem("currentProvince"),
      currentTheme: sessionStorage.getItem("currentTheme"),

      dialogVisible: false,
      form: {}
    }
  },
  methods: {
    back(){
      this.$router.push(sessionStorage.getItem('currentSort'));
    },
    handleEdit() {
      this.form.title = sessionStorage.getItem("currentTitle");
      this.form.upernumber = sessionStorage.getItem("currentUpernumber");
      this.form.synopsis = sessionStorage.getItem("currentSynopsis");
      this.form.uptime = sessionStorage.getItem("currentUptime");
      this.form.status = sessionStorage.getItem("currentStatus");
      this.form.type = 1;
      this.dialogVisible = true;
    },
    save() {
      let formData = new FormData();
      formData.append('status', this.form.status);
      request.put("/review/update/" + sessionStorage.getItem("currentId"), formData).then(res => {
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
