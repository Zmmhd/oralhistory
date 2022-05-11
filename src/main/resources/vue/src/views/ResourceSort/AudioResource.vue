<template>
  <div style="margin: 10px;">
    <div style="border-bottom: #f05053 dashed 1px;">
      <el-button style="margin: 10px 0;" @click="back" type="info">返回</el-button>
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
    // request.get("", {
    //   params: {
    //     id: this.currentId
    //   }
    // }).then(res => {
    //   this.url = baseUrl.BASE_URL + res;
    // })
  },
  data() {
    return {
      currentResource: sessionStorage.getItem("currentResource"),
      currentId: sessionStorage.getItem("currentId"),
      url: baseUrl.BASE_URL + "26.mp3"
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
