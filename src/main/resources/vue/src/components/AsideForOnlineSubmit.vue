<template>
  <el-menu router style="width: 200px; min-height: 100vh; font-weight: 700" default-active="/submit">
    <el-menu-item index="/submit">
      <el-icon>
        <Coffee/>
      </el-icon>
      在线提交
    </el-menu-item>
    <el-menu-item index="/review">
      <el-icon>
        <ColdDrink/>
      </el-icon>
      审核查询
    </el-menu-item>
  </el-menu>
</template>

<script>
import {Coffee, ColdDrink} from '@element-plus/icons-vue'
export default {
  name: "AsideForOnlineSubmit",
  components: {
    Coffee,
    ColdDrink
  }
}
</script>

<style scoped>

</style>