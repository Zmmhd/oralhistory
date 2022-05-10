<template>
  <div>
    <el-button @click="back">返回</el-button>
  </div>
文章
</template>

<script>
export default {
  name: "ArticleResource",
  methods: {
    back(){
      this.$router.push(sessionStorage.getItem('currentSort'));
    }
  }
}
</script>

<style scoped>

</style>