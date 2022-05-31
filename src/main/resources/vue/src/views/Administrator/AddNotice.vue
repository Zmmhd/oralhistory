<template>
  <div class="form-content">
    <el-form ref="form" :rules="rules" :model="form" class="formItems">
      <el-form-item label="通知类型" prop="type">
        <el-radio-group v-model="form.type" @change="radioChange">
          <el-radio label="1">征集公告</el-radio>
          <el-radio label="2">建设进程动态</el-radio>
          <el-radio label="3">口述规范</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="标题" prop="title">
        <el-input v-model="form.title" maxlength="50" show-word-limit/>
      </el-form-item>
      <el-form-item label="文件上传">
        <el-upload
            v-if="isDisabled === false"
            ref="upload"
            :show-file-list="false"
            action="#"
            :on-change="handleSelectFile"
            :auto-upload="false"
            :http-request="overSubmit">
          <el-button type="info">点击上传文件</el-button>
          <!--          <template #tip>-->
          <!--            <div>-->
          <!--              jpg/png files with a size less than 500KB.-->
          <!--            </div>-->
          <!--          </template>-->
        </el-upload>
        <span v-if="isDisabled === true" style="font-weight: 600; user-select: none;">请先选择通知类型后再上传</span>
        <span v-if="hasFile === true" style="font-weight: 600; user-select: none; margin: 0 10px;">您的文件符合要求，待上传</span>
      </el-form-item>
      <el-button @click="save" type="info">提 交</el-button>
    </el-form>
  </div>
</template>

<script>
import {UploadFilled} from '@element-plus/icons-vue'
import request from "@/utils/request";
import baseUrl from "@/assets/Config"

export default {
  name: "AddNotice",
  components: {
    UploadFilled
  },
  data() {
    return {
      form: {},
      url: "http://localhost:8888/uploadfile",
      currentUrl: "",
      hasFile: false,
      isDisabled: true,
      rules: {
        type: [
          {required: true, message: '请选择类型', trigger: 'blur'},
        ],
        title: [
          {required: true, message: '请输入标题', trigger: 'blur'},
        ]
      }
    }
  },
  methods: {
    radioChange() {
      this.isDisabled = false;
    },
    handleSelectFile(file, fileList) {
      // 保证文件列表内只有一个文件
      if (fileList.length > 1) {
        fileList.shift();
      }
      // 检查这个文件
      this.hasFile = true;
      // 获取文件类型
      const fileSuffix = file.name.substring(file.name.lastIndexOf(".") + 1);
      console.log(fileSuffix);
      console.log(this.form.type)
      const whiteList = ["doc", "docx"];
      if (whiteList.indexOf(fileSuffix) === -1) {
        this.$message.error('上传文件只能是doc,docx格式');
        this.hasFile = false;
        return;
      }

      // 文件大小判定
      // const isLt2M = file.size / 1024 / 1024 < 2;
      // if (!isLt2M) {
      //   this.$message.error('上传文件大小不能超过 2MB');
      //   this.hasFile = false;
      //   this.$refs.upload.clearFiles();
      //   return;
      // }
    },

    overSubmit(params) {
      console.log("正在上传。。。")
      const formData = new FormData()
      formData.append('file', params.file)
      request.post("/uploadnoticefile", formData).then(res => {
        console.log(res);
        this.currentUrl = res.data;
        let notice = {
          "type": this.form.type,
          "url": this.currentUrl,
          "title": this.form.title,
        };
        console.log("notice", notice);
        request.post("/notice/add", notice).then(res => {
          console.log(res)
          this.$message({
            type: 'success',
            message: "新增通知成功"
          })
        });
      })
    },
    save() {
      this.$refs['form'].validate((valid) => {
        if (valid) {
          if (this.hasFile === true) {
            this.$refs.upload.submit();
          } else {
            this.$message.error("请先上传合适的文件")
          }
        }
      })
    }
  }
}
</script>

<style scoped>
.form-content {
  margin: 50px 20px 0 20px;
  display: flex;
  justify-content: center;
}

.formItems {
  width: 75%;
}

</style>
