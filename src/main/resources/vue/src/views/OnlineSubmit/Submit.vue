<template>
  <el-form :model="form">
    <el-form-item label="资源类型">
      <el-input v-model="form.type"/>
    </el-form-item>
    <el-form-item label="标题">
      <el-input v-model="form.title"/>
    </el-form-item>
    <el-form-item label="资源简介">
      <el-input v-model="form.synopsis"/>
    </el-form-item>
    <el-form-item label="省份">
      <el-input v-model="form.province"/>
    </el-form-item>
    <el-form-item label="档案馆名称">
      <el-input v-model="form.archives"/>
    </el-form-item>
    <el-form-item label="主题曲">
      <el-input v-model="form.theme"/>
    </el-form-item>
    <el-form-item label="上传者城市">
      <el-input v-model="form.upercity"/>
    </el-form-item>
    <el-form-item label="上传者姓名">
      <el-input v-model="form.upername"/>
    </el-form-item>
    <el-form-item label="上传者手机号">
      <el-input v-model="form.upernumber"/>
    </el-form-item>
    <el-form-item label="文件上传">
      <!--      <el-upload action="" :auto-upload="false" ref="uploadRef" :http-request="uploadFile">-->
      <!--        <el-button type="primary">Click to upload</el-button>-->
      <!--        <template #tip>-->
      <!--          <div>-->
      <!--            jpg/png files with a size less than 500KB.-->
      <!--          </div>-->
      <!--        </template>-->
      <!--      </el-upload>-->
      <el-upload :action=url :on-success="fileUploadSuccess">
        <el-button type="primary">Click to upload</el-button>
        <template #tip>
          <div>
            jpg/png files with a size less than 500KB.
          </div>
        </template>
      </el-upload>
    </el-form-item>
    <el-button type="primary" @click="save">确 定</el-button>
  </el-form>
</template>

<script>
import {UploadFilled} from '@element-plus/icons-vue'
import request from "@/utils/request";
import baseUrl from "@/assets/Config"

export default {
  name: "Submit",
  components: {
    UploadFilled
  },
  data() {
    return {
      form: {},
      url: "http://localhost:8888/uploadfile",
      currentUrl: ""
    }
  },
  created() {
    this.myFile = new FormData();
  },
  methods: {
    // 自定义上传
    // uploadFile(params) {
    //   const fileObj = params.file;
    //   let data = new FormData();
    //   data.append("multipartFile", fileObj);
    //   let resource = {
    //     "type": this.form.type,
    //     "title": this.form.title,
    //     "synopsis": this.form.synopsis,
    //     "province": this.form.province,
    //     "archives": this.form.archives,
    //     "theme": this.form.theme,
    //     "upercity": this.form.upercity,
    //     "upername": this.form.upername,
    //     "upernumber": this.form.upernumber
    //   };
    //   data.append('resource', JSON.stringify(resource));
    //   let review = {
    //     "title": this.form.title,
    //     "synopsis": this.form.synopsis,
    //     "upernumber": this.form.upernumber
    //   };
    //   data.append('review', JSON.stringify(review));
    //   console.log("fsdfdsfsfdsfsdfd")
    //   request.post("/review/upload", data).then(res => {
    //     console.log(res);
    //   })
    // },
    // save() {
    //   this.$refs.uploadRef.submit(); //触发自定义上传
    // }
    fileUploadSuccess(response) {
      this.currentUrl = response;
    },
    save() {
      let resource = {
        "type": this.form.type,
        "url": this.currentUrl,
        "title": this.form.title,
        "synopsis": this.form.synopsis,
        "province": this.form.province,
        "archives": this.form.archives,
        "theme": this.form.theme,
        "upercity": this.form.upercity,
        "upername": this.form.upername,
        "upernumber": this.form.upernumber
      };
      console.log(this.currentUrl);
      console.log(resource);
      request.post("/review/addreview", resource).then(res => {
        console.log(1)
        this.$message({
          type: 'success',
          message: "成功"
        })
      })
    }
  }
}
</script>

<style scoped>

</style>
