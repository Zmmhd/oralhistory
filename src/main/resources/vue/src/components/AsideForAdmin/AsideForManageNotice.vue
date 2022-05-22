<template>
  <el-menu router class="menu" text-color="#F0FFFF" active-text-color="#ADD8E6" default-active="/manageRaiseNotice">
    <el-menu-item index="/manageRaiseNotice">
      <el-icon>
        <IceCream/>
      </el-icon>
      征集公告
    </el-menu-item>
    <el-menu-item index="/manageMomentsNotice">
      <el-icon>
        <IceDrink/>
      </el-icon>
      建设进程动态
    </el-menu-item>
    <el-menu-item index="/managePrinciple">
      <el-icon>
        <GobletSquareFull/>
      </el-icon>
      口述规范
    </el-menu-item>
    <el-menu-item index="/addNotice">
      <el-icon>
        <ForkSpoon/>
      </el-icon>
      新增通知
    </el-menu-item>
  </el-menu>
</template>

<script>
import {IceCream, IceDrink, GobletSquareFull, ForkSpoon} from '@element-plus/icons-vue'
export default {
  name: "AsideForManageNotice",
  components: {
    IceCream,
    IceDrink,
    GobletSquareFull,
    ForkSpoon
  }
}
</script>

<style scoped>
.menu{
  width: 200px;
  min-height: 100vh;
  background-color: #4682B4;
  font-weight: 700;
}
.el-menu-item:hover {
  background-color: #486067 !important;
}
</style>
