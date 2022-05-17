<template>
  <div style="margin: 10px;">
    <div style="border-bottom: #f05053 dashed 1px;">
      <el-button style="margin: 10px 0;" @click="back" type="info">返回</el-button>
    </div>

    <div style="margin: 10px;">
      <div style="font-weight: bolder; margin-bottom: 10px;">当前筛选条件：</div>
      <div style="margin: 2px 0;">标题：<span style="color :#494241;">{{ currentTitle }}</span></div>
      <div style="margin: 2px 0;">时间：<span style="color :#494241;">{{ currentUptime }}</span></div>
      <div style="margin: 2px 0;">省份：<span style="color :#494241;">{{ currentProvince }}</span></div>
      <div style="margin: 2px 0;">主题：<span style="color :#494241;">{{ currentTheme }}</span></div>
      <div style="margin: 2px 0;">简介：<span style="color :#494241;">{{ currentSynopsis }}</span></div>
    </div>

    <div style="margin: 20px; padding: 20px; border: 2px #e7ac94 solid; border-radius: 5px;">
      <audio :src=url controls></audio>
    </div>
  </div>
</template>

<script>
import baseUrl from "@/assets/Config"
import request from "@/utils/request";

export default {
  name: "AudioResource",
  created() {
    console.log(this.currentId);
    console.log(this.url);
  },
  data() {
    return {
      currentId: sessionStorage.getItem("currentId"),
      url: baseUrl.BASE_URL + sessionStorage.getItem("currentUrl"),

      currentTitle: sessionStorage.getItem("currentTitle"),
      currentSynopsis: sessionStorage.getItem("currentSynopsis"),
      currentUptime: sessionStorage.getItem("currentUptime"),
      currentProvince: sessionStorage.getItem("currentProvince"),
      currentTheme: sessionStorage.getItem("currentTheme"),
    }
  },
  methods: {
    back() {
      this.$router.push(sessionStorage.getItem('currentSort'));
    }
  }
}
</script>

<style scoped>

</style>
