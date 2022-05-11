<template>
  <div>
    <el-button @click="back">返回</el-button>
  </div>
  <iframe  frameborder="0"
           src="http://localhost:8888/uploadFile/10.docx" width='100%'>
  </iframe>
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
