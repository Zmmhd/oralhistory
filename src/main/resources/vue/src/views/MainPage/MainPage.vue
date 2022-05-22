<template>
  <div style="background: #EAEAEA">
    <Search></Search>
    <div>
      <el-carousel :interval=2000 type="card" height="400px" class="backgroundColor">
        <el-carousel-item v-for="item in imageBox" :key="item.signal" style="margin: 10px;">
          <img :src="item.url" class="image" @click="specialPage(item.signal)">
        </el-carousel-item>
      </el-carousel>
    </div>

    <div class="special-list">
      <div class="tradition">
        <div class="tradition-title">传统技艺专题口述实录</div>
        <div class="card-content">
          <div class="card" @click="getResourceById(78)">
            <div class="card-image"><img src="@/assets/Mpic/78p.png" alt=""/></div>
            <div class="card-info">
              <el-tag>口述历史</el-tag>
              <p>“人离不开盐，我不舍晒盐”</p>
            </div>
          </div>

          <div class="card" @click="getResourceById(79)">
            <div class="card-image"><img src="@/assets/Mpic/79p.png" alt=""/></div>
            <div class="card-info">
              <el-tag>口述历史</el-tag>
              <p>把半山泥猫一代代传下去</p>
            </div>
          </div>

          <div class="card" @click="getResourceById(84)">
            <div class="card-image"><img src="@/assets/Mpic/84p.png" alt=""/></div>
            <div class="card-info">
              <el-tag>口述历史</el-tag>
              <p>我的“金银彩绣”梦</p>
            </div>
          </div>

          <div class="card" @click="getResourceById(87)">
            <div class="card-image"><img src="@/assets/Mpic/87p.png" alt=""/></div>
            <div class="card-info">
              <el-tag>口述历史</el-tag>
              <p>一针一线总关情</p>
            </div>
          </div>

          <div class="card" @click="getResourceById(88)">
            <div class="card-image"><img src="@/assets/Mpic/88p.png" alt=""/></div>
            <div class="card-info">
              <el-tag>口述历史</el-tag>
              <p>珠落玉盘声声悦</p>
            </div>
          </div>

          <div class="card" @click="getResourceById(107)">
            <div class="card-image"><img src="@/assets/Mpic/107p.png" alt=""/></div>
            <div class="card-info">
              <el-tag>口述历史</el-tag>
              <p>“老虎笙”的前世今生</p>
            </div>
          </div>
        </div>

      </div>

      <div class="media">
        <div class="tradition-title">视频与音频记忆</div>
        <div class="video" @click="getResourceById(1)"><div class="video-id">1</div>【视频】口述·抗美援朝（刘维林）</div>
        <div class="video" @click="getResourceById(6)"><div class="video-id">2</div>【视频】天津方言寻根之旅</div>
        <div class="video" @click="getResourceById(52)"><div class="video-id">3</div>【视频】红色档案·云南中共党员口述历史（王德三）</div>
        <div class="video" @click="getResourceById(117)"><div class="video-id">4</div>【视频】口述·永远跟党走（谷凤宝）</div>
        <div class="video" @click="getResourceById(127)"><div class="video-id">5</div>【视频】小账本里写家国</div>
        <div class="video" @click="getResourceById(135)"><div class="video-id">6</div>【视频】陕西民歌档案之紫阳民歌</div>
        <div class="video" @click="getResourceById(26)"><div class="video-id">7</div>【音频】纪念抗美援朝70周年‖一起聆听志愿军老兵的故事</div>
        <div class="video" @click="getResourceById(28)"><div class="video-id">8</div>【音频】“妙手回春”连云港一代名中医朱少亭</div>
      </div>
    </div>

    <div class="special-list">
      <div style="width: 25%; margin: 0 50px">
        <div class="tradition-title">新冠疫情专题口述实录</div>
        <el-carousel :interval=2000 height="400px" direction="vertical" style="background: #EAEAEA">
          <el-carousel-item v-for="item in imageBox2" :key="item.signal" style="cursor: pointer;">
            <img :src="item.url" class="image" @click="specialPage2(item.signal)">
          </el-carousel-item>
        </el-carousel>
      </div>

      <div style="width: 75%; margin: 0 50px">
        <div class="tradition-title">宣传视频</div>
        <div style="width: 75%; margin-left: 30px;">
          <videoPlayer class="video-player vjs-custom-skin"
                       ref="videoPlayer"
                       :playsinline="true"
                       :options="playerOptions">
          </videoPlayer>
        </div>
      </div>
    </div>

  </div>
</template>

<script>
import Search from "@/components/Search";
import request from "@/utils/request";
import baseUrl from "@/assets/Config";
import {videoPlayer} from 'vue-video-player/src'
import 'vue-video-player/src/custom-theme.css'
import 'video.js/dist/video-js.css'

export default {
  name: "MainPage",
  components: {
    Search,
    videoPlayer
  },
  data() {
    return {
      imageBox: [
        {signal: 0, url: require("@/assets/carousel/m1.jpg")},
        {signal: 1, url: require("@/assets/carousel/m2.jpg")},
        {signal: 2, url: require("@/assets/carousel/m3.jpg")},
        {signal: 3, url: require("@/assets/carousel/m4.jpg")}
      ],
      imageBox2: [
        {signal: 0, url: require("@/assets/carousel/30.jpg")},
        {signal: 1, url: require("@/assets/carousel/31.jpg")},
        {signal: 2, url: require("@/assets/carousel/32.jpg")},
        {signal: 3, url: require("@/assets/carousel/33.jpg")},
        {signal: 4, url: require("@/assets/carousel/34.jpg")},
        {signal: 5, url: require("@/assets/carousel/35.jpg")},
        {signal: 6, url: require("@/assets/carousel/37.jpg")},
        {signal: 7, url: require("@/assets/carousel/38.jpg")},
        {signal: 8, url: require("@/assets/carousel/39.jpg")},
        {signal: 9, url: require("@/assets/carousel/40.jpg")}
      ],
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
            src: baseUrl.BASE_URL + "1.mp4"
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
    specialPage(signal) {
      if (signal === 0) {
        this.getResourceById(105)
      } else if (signal === 1) {
        this.getResourceById(101)
      } else if (signal === 2) {
        this.getResourceById(19)
      } else if (signal === 3) {
        this.getResourceById(31)
      }
    },
    specialPage2(signal) {
      if (signal === 0) {
        this.getResourceById(30)
      } else if (signal === 1) {
        this.getResourceById(31)
      } else if (signal === 2) {
        this.getResourceById(32)
      } else if (signal === 3) {
        this.getResourceById(33)
      } else if (signal === 4) {
        this.getResourceById(34)
      } else if (signal === 5) {
        this.getResourceById(35)
      } else if (signal === 6) {
        this.getResourceById(37)
      } else if (signal === 7) {
        this.getResourceById(38)
      } else if (signal === 8) {
        this.getResourceById(39)
      } else if (signal === 9) {
        this.getResourceById(40)
      }
    },
    getResourceById(id) {
      let formData = new FormData();
      formData.append("resourceId", id);
      request.post("/resource/getbyid", formData).then(res => {
        console.log(res);
        sessionStorage.setItem("currentId", id); // 当前资源id
        sessionStorage.setItem("currentSort", "/mainPage"); // 当前路由
        sessionStorage.setItem("currentUrl", res.data.url); // 当前资源的url

        sessionStorage.setItem("currentTitle", res.data.title);
        sessionStorage.setItem("currentUpernumber", res.data.upernumber);
        sessionStorage.setItem("currentSynopsis", res.data.synopsis);
        sessionStorage.setItem("currentStatus", 1);
        sessionStorage.setItem("currentUptime", res.data.uptime);
        sessionStorage.setItem("currentProvince", res.data.province);
        sessionStorage.setItem("currentTheme", res.data.theme);

        if (res.data.type === 1) {
          this.$router.push("/articleResource");
        } else if (res.data.type === 2) {
          this.$router.push("/videoResource");
        } else if (res.data.type === 3) {
          this.$router.push("/audioResource");
        }
      })
    }
  }
}
</script>

<style scoped>
img {
  width: 100%;
  line-height: 400px;
  margin: 0;
  text-align: center;
}

.backgroundColor {
  background: #ADA996; /* fallback for old browsers */
  background: -webkit-linear-gradient(to right, #EAEAEA, #DBDBDB, #F2F2F2, #ADA996); /* Chrome 10-25, Safari 5.1-6 */
  background: linear-gradient(to right, #EAEAEA, #DBDBDB, #F2F2F2, #ADA996); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
}

.special-list {
  height: auto;
  display: flex;
}

.tradition {
  width: 60%;
  margin: 50px 50px 0;
}

.tradition-title {
  height: 50px;
  line-height: 50px;
  padding-left: 20px;
  font-weight: bolder;
  color: #000;
  border-bottom: 5px solid #4682B4;
  margin-bottom: 20px;
}

.media {
  width: 40%;
  margin: 50px;
}

.card {
  background-color: #fff;
  max-width: 250px;
  width: 250px;
  height: 80px;
  margin: 10px 20px 10px;
  padding: 10px;
  box-shadow: 0 0 2px #ccc;
  border-radius: 5px;
  /* 超出盒子的部分遮起来 */
  overflow: hidden;
  display: flex;
  align-content: center;
  cursor: pointer;
  user-select: none;
  transition: all 0.2s;
}

.card:hover {
  color: #4682B4;
  box-shadow: 0 0 5px #6E797C;
  background: #FBFBFB;
}

.card-image {
  background: #ADA996;
  width: 40%;
  margin-right: 10px;
  display: flex;
  align-content: center;
}

.card-image img {
  /* 避免图片变形 */
  width: 100%;
  height: 100%;
  object-fit: cover;
}

.card-info{
  width: 60%;
}

.card-info p {
  font-size: small;
  font-weight: bold;
}

.card-content{
  display: flex;
  flex-wrap: wrap;
}

.video{
  height: 30px;
  line-height: 30px;
  background: #fff;
  box-shadow: 0 0 2px #ccc;
  border-radius: 5px;
  display: flex;
  align-content: center;
  margin: 10px 0 10px;
  transition: all 0.2s;
  cursor: pointer;
  font-size: small;
}

.video:hover {
  color: #4682B4;
  box-shadow: 0 0 5px #6E797C;
  background: #FBFBFB;
}

.video-id{
  display: flex;
  justify-content: center;
  align-content: center;
  background: #4682B4;
  color: #F0FFFF;
  width: 30px;
  height: 30px;
  margin-right: 10px;
  border-radius: 5px;
}
</style>
