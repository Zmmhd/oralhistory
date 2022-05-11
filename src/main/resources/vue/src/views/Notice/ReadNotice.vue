<template>
  <div style="margin: 10px;">
    <div style="border-bottom: #f05053 dashed 1px;">
      <el-button style="margin: 10px 0;" @click="back" type="info">返回</el-button>
    </div>
    <div style="margin: 20px; padding: 20px; border: 2px #e7ac94 solid; border-radius: 5px;">
      <iframe :src=url frameborder="0" style="width: 100%; min-height: 250vh;"></iframe>
    </div>
  </div>
</template>

<script>
import baseUrl from "@/assets/Config";
import request from "@/utils/request";

export default {
  name: "ReadNotice",
  created() {
    console.log(typeof this.currentId);
    console.log(this.currentId);
    console.log(this.url);
  },
  data(){
    return{
      currentId: sessionStorage.getItem("currentId"),
      url: baseUrl.BASE_URL + sessionStorage.getItem("currentUrl")
    }
  },
  methods: {
    back(){
      this.$router.push(sessionStorage.getItem('currentSort'));
    }
  }
}
</script>

<style scoped>

</style>
