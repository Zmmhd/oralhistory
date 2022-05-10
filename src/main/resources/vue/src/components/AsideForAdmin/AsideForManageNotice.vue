<template>
  <el-menu router class="menu" text-color="#fff" active-text-color="#f05053" default-active="/manageRaiseNotice">
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
  </el-menu>
</template>

<script>
export default {
  name: "AsideForManageNotice"
}
</script>

<style scoped>
.menu {
  width: 200px;
  min-height: 100vh;
  background-color: #e7ac94;
  font-weight: 700;
}

.el-menu-item:hover {
  background-color: #d1806c !important;
}
</style>