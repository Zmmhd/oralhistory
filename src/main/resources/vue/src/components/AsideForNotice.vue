<template>
  <el-menu router style="width: 200px; min-height: 100vh;" default-active="/raiseNotice">
    <el-menu-item index="/raiseNotice">
      <el-icon>
        <IceCream/>
      </el-icon>
      征集公告
    </el-menu-item>
    <el-menu-item index="/momentsNotice">
      <el-icon>
        <IceDrink/>
      </el-icon>
      建设进程动态
    </el-menu-item>
  </el-menu>
</template>

<script>
import {IceCream, IceDrink} from '@element-plus/icons-vue'

export default {
  name: "AsideForNotice",
  components: {
    IceCream,
    IceDrink
  }
}
</script>

<style scoped>

</style>