<template>
  <el-upload
      drag
      action="http://localhost:8888/review/upload"
      multiple
  >
    <el-icon class="el-icon--upload"><UploadFilled /></el-icon>
    <div class="el-upload__text">
      Drop file here or <em>click to upload</em>
    </div>
    <template #tip>
      <div class="el-upload__tip">
        jpg/png files with a size less than 500kb
      </div>
    </template>
  </el-upload>
</template>

<script>
import { UploadFilled } from '@element-plus/icons-vue'

export default {
  name: "Submit",
  components: {
    UploadFilled
  }
}
</script>

<style scoped>

</style>
