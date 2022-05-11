<template>
  <div style="margin: 10px;">
    <div style="border-bottom: #f05053 dashed 1px;">
      <el-button style="margin: 10px 0;" @click="back" type="info">返回</el-button>
    </div>
    <div style="margin: 20px; padding: 20px; border: 2px #e7ac94 solid; border-radius: 5px;">
      <videoPlayer class="video-player vjs-custom-skin"
                   ref="videoPlayer"
                   :playsinline="true"
                   :options="playerOptions">
      </videoPlayer>
    </div>
  </div>
</template>
<script>
import {videoPlayer} from 'vue-video-player/src'
import 'vue-video-player/src/custom-theme.css'
import 'video.js/dist/video-js.css'

import baseUrl from "@/assets/Config"
import request from "@/utils/request";

export default {
  name: "VideoResource",
  components: {
    videoPlayer
  },
  created() {
    console.log(this.currentId);
    console.log(this.playerOptions.sources[0].src);
  },
  data() {
    return {
      currentId: sessionStorage.getItem("currentId"),
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
    }
  }
};
</script>

<style scoped>

</style>
