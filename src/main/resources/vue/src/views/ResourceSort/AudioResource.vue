<template>
  <div>
    <el-button @click="back">返回</el-button>
  </div>
音频播放
</template>

<script>
//

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