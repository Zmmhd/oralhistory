<template>
  <div>
    <el-carousel interval="2000" type="card" height="400px" style="background-color: #FFF9EF;">
      <el-carousel-item v-for="item in imageBox" :key="item.signal" style="margin: 10px;">
        <img :src="item.url" class="image" @click="specialPage(item.signal)">
      </el-carousel-item>
    </el-carousel>
  </div>
</template>

<script>
export default {
  name: "MainPage",
  data() {
    return {
      imageBox: [
        {signal: 0, url: require("@/assets/carousel/city.jpg")},
        {signal: 1, url: require("@/assets/carousel/doctor.jpg")},
        {signal: 2, url: require("@/assets/carousel/kite.jpg")},
        {signal: 3, url: require("@/assets/carousel/march.jpg")},
        {signal: 4, url: require("@/assets/carousel/memory.jpg")}
      ]
    }
  },
  methods: {
    specialPage(signal) {
      sessionStorage.setItem("currentSort", "/mainPage"); // 当前路由
      if (signal === 0) {
        sessionStorage.setItem("currentId", "20"); // 当前资源id
        sessionStorage.setItem("currentUrl", "20.html"); // 当前资源的url
      } else if (signal === 1) {
        sessionStorage.setItem("currentId", "31"); // 当前资源id
        sessionStorage.setItem("currentUrl", "31.html"); // 当前资源的url
      } else if (signal === 2) {
        sessionStorage.setItem("currentId", "10"); // 当前资源id
        sessionStorage.setItem("currentUrl", "10.html"); // 当前资源的url
      } else if (signal === 3) {
        sessionStorage.setItem("currentId", "24"); // 当前资源id
        sessionStorage.setItem("currentUrl", "24.html"); // 当前资源的url
      } else if (signal === 4) {
        // 以下内容需要往下一个路由传
        sessionStorage.setItem("currentId", "102"); // 当前资源id
        sessionStorage.setItem("currentUrl", "102.html"); // 当前资源的url
      }
      this.$router.push("/articleResource");
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
</style>
