<template>
  <div class="form-content">
    <el-form ref="form" :rules="rules" :model="form" class="formItems">
      <el-form-item label="资源类型" prop="type">
        <el-radio-group v-model="form.type" @change="radioChange">
          <el-radio label="1">文章</el-radio>
          <el-radio label="2">视频</el-radio>
          <el-radio label="3">音频</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="标题" prop="title">
        <el-input v-model="form.title" maxlength="50" show-word-limit/>
      </el-form-item>
      <el-form-item label="省份" prop="province">
        <el-select v-model="form.province" placeholder="--选择省份--">
          <el-option
              v-for="item in allProvince"
              :label="item"
              :value="item"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="档案馆名称" prop="archives">
        <el-input v-model="form.archives"/>
      </el-form-item>
      <el-form-item label="主题曲" prop="theme">
        <el-select v-model="form.theme" placeholder="--选择主题曲--">
          <el-option
              v-for="item in allTheme"
              :label="item"
              :value="item"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="上传者城市" prop="upercity">
        <el-input v-model="form.upercity"/>
      </el-form-item>
      <el-form-item label="上传者姓名" prop="upername">
        <el-input v-model="form.upername"/>
      </el-form-item>
      <el-form-item label="上传者手机号" prop="upernumber">
        <el-input v-model="form.upernumber" oninput="value=value.replace(/[^\d]/g,'')" maxlength="11"/>
      </el-form-item>
      <el-form-item label="资源简介" prop="synopsis">
        <el-input type="textarea" v-model="form.synopsis" :autosize="{ minRows: 2, maxRows: 4 }" placeholder="请描述一下您所提供的资源" maxlength="50" show-word-limit/>
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
        <span v-if="isDisabled === true" style="font-weight: 600; user-select: none;">请先选择文件类型后再上传</span>
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
  name: "Submit",
  components: {
    UploadFilled
  },
  data() {
    return {
      form: {},
      url: "http://localhost:8888/uploadfile",
      currentUrl: "",
      allTheme: [],
      allProvince: ["北京市", "天津市", "上海市", "重庆市", "河北省", "山西省", "辽宁省", "吉林省", "黑龙江省", "江苏省", "浙江省", "安徽省", "福建省", "江西省", "山东省", "河南省", "湖北省", "湖南省", "广东省", "海南省", "四川省", "贵州省", "云南省", "陕西省", "甘肃省", "青海省", "台湾省", "内蒙古自治区", "广西壮族自治区", "西藏自治区", "宁夏回族自治区", "新疆维吾尔自治区", "香港特别行政区", "澳门特别行政区"],
      hasFile: false,
      isDisabled: true,
      rules: {
        type: [
          {required: true, message: '请选择类型', trigger: 'blur'},
        ],
        title: [
          {required: true, message: '请输入标题', trigger: 'blur'},
        ],
        province: [
          {required: true, message: '请选择省份', trigger: 'change'},
        ],
        archives: [
          {required: true, message: '请输入档案馆', trigger: 'blur'},
        ],
        theme: [
          {required: true, message: '请选择主题曲', trigger: 'change'},
        ],
        upercity: [
          {required: true, message: '请输入你所在的城市', trigger: 'blur'},
        ],
        upername: [
          {required: true, message: '请留下你的姓名', trigger: 'blur'},
        ],
        upernumber: [
          {required: true, message: '请留下你的手机号码', trigger: 'blur'},
        ],
        synopsis: [
          {required: true, message: '请描述一下你的资源', trigger: 'blur'},
        ]
      }
    }
  },
  created() {
    this.getAllTheme();
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
    //   request.post("/review/upload", data).then(res => {
    //     console.log(res);
    //   })
    // },
    // save() {
    //   this.$refs.uploadRef.submit(); //触发自定义上传
    // }

    radioChange(){
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
      if (this.form.type === '1') {
        const whiteList = ["doc", "docx"];
        if (whiteList.indexOf(fileSuffix) === -1) {
          this.$message.error('上传文件只能是doc,docx格式');
          this.hasFile = false;
          return;
        }
      } else if (this.form.type === '2') {
        const whiteList = ["mp4"];
        if (whiteList.indexOf(fileSuffix) === -1) {
          this.$message.error('上传文件只能是mp4格式');
          this.hasFile = false;
          return;
        }
      } else if (this.form.type === '3') {
        const whiteList = ["mp3"];
        if (whiteList.indexOf(fileSuffix) === -1) {
          this.$message.error('上传文件只能是mp3格式');
          this.hasFile = false;
          return;
        }
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
      request.post("/uploadfile", formData).then(res => {
        console.log(res);
        this.currentUrl = res.data;
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
        console.log("resource", resource);
        request.post("/review/addreview", resource).then(res => {
          console.log(res)
          this.$message({
            type: 'success',
            message: "新增成功，请等待审核"
          })
        });
      })
    },

    save() {
      this.$refs['form'].validate((valid) => {
        if (valid) {
          if(this.hasFile === true){
            this.$refs.upload.submit();
          } else{
            this.$message.error("请先上传合适的文件")
          }
        }
      })
    },
    getAllTheme() {
      request.get("/resource/getClassification/" + "theme").then(res => {
        console.log(res);
        this.allTheme = res.data;
      })
    }
  }
}
</script>

<style scoped>
.form-content{
  margin: 20px;
  display: flex;
  justify-content: center;
  align-items: center;
}

.formItems{
  width: 75%;
}

</style>
