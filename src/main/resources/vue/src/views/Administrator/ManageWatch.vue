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
      <videoPlayer class="video-player vjs-custom-skin"
                   ref="videoPlayer"
                   :playsinline="true"
                   :options="playerOptions">
      </videoPlayer>
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
import {videoPlayer} from 'vue-video-player/src'
import 'vue-video-player/src/custom-theme.css'
import 'video.js/dist/video-js.css'

import baseUrl from "@/assets/Config"
import request from "@/utils/request";

export default {
  name: "ManageWatch",
  components: {
    videoPlayer
  },
  created() {
    console.log(this.currentId);
    console.log(this.playerOptions.sources[0].src);
  },
  data() {
    return {
      form: {},
      dialogVisible: false,

      currentId: sessionStorage.getItem("currentId"),

      currentTitle: sessionStorage.getItem("currentTitle"),
      currentSynopsis: sessionStorage.getItem("currentSynopsis"),
      currentUptime: sessionStorage.getItem("currentUptime"),
      currentProvince: sessionStorage.getItem("currentProvince"),
      currentTheme: sessionStorage.getItem("currentTheme"),

      playerOptions: {
        //播放速度
        playbackRates: [0.5, 1.0, 1.5, 2.0],
        //如果true,浏览器准备好时开始回放。
        autoplay: false,
        // 默认情况下将会消除任何音频。
        muted: false,
        // 导致视频一结束就重新开始。
        loop: false,
        // 建议浏览器在<video>加载元素后是否应该开始下载视频数据。auto浏览器选择最佳行为,立即开始加载视频（如果浏览器支持）
        preload: "auto",
        language: "zh-CN",
        // 将播放器置于流畅模式，并在计算播放器的动态大小时使用该值。值应该代表一个比例 - 用冒号分隔的两个数字（例如"16:9"或"4:3"）
        aspectRatio: "16:9",
        // 当true时，Video.js player将拥有流体大小。换句话说，它将按比例缩放以适应其容器。
        fluid: true,
        sources: [
          {
            //类型
            type: "video/mp4",
            //url地址
            // src: "https://cdn.theguardian.tv/webM/2015/07/20/150716YesMen_synd_768k_vp8.webm",
            src: baseUrl.BASE_URL + sessionStorage.getItem("currentUrl")
          },
        ],
        //你的封面地址
        poster: "",
        //允许覆盖Video.js无法播放媒体源时显示的默认信息。
        notSupportedMessage: "此视频暂无法播放，请稍后再试",
        controlBar: {
          timeDivider: true,
          durationDisplay: true,
          remainingTimeDisplay: false,
          //全屏按钮
          fullscreenToggle: true,
        },
      }
    }
  },
  methods: {
    back(){
      this.$router.push(sessionStorage.getItem("currentSort"));
    },
    handleEdit() {
      this.form.title = sessionStorage.getItem("currentTitle");
      this.form.upernumber = sessionStorage.getItem("currentUpernumber");
      this.form.synopsis = sessionStorage.getItem("currentSynopsis");
      this.form.uptime = sessionStorage.getItem("currentUptime");
      this.form.status = sessionStorage.getItem("currentStatus");
      this.form.type = 2;
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
};
</script>

<style scoped>

</style>
