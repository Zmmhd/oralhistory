<template>
  <div>
    <el-button @click="back">返回</el-button>
    <audio src="http://localhost:8888/uploadFile/26.mp3" controls autoplay></audio>
  </div>
音频播放
</template>

<script>


export default {
  name: "AudioResource",
  data(){
    return{

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