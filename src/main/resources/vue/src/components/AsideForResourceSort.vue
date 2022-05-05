<template>
  <el-menu router style="width: 200px; min-height: 100vh; font-weight: 700" default-active="/sortByType">
    <el-menu-item index="/sortByType">
      <el-icon>
        <Lollipop/>
      </el-icon>
      资源类型
    </el-menu-item>
    <el-menu-item index="/sortByProvince">
      <el-icon>
        <Cherry/>
      </el-icon>
      省份
    </el-menu-item>
    <el-menu-item index="/sortByTheme">
      <el-icon>
        <Chicken/>
      </el-icon>
      主题曲
    </el-menu-item>
  </el-menu>
</template>

<script>
import {Lollipop, Cherry, Chicken} from '@element-plus/icons-vue'

export default {
  name: "AsideForResourceSort",
  components: {
    Lollipop,
    Cherry,
    Chicken
  }
}
</script>

<style scoped>

</style>