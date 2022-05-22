<template>
  <Date></Date>

  <div class="header-pic">
    <img src="@/assets/h1.jpg" alt="">
  </div>

  <div>
    <el-menu router
             default-active="/manageResource"
             mode="horizontal"
             background-color="#4682B4"
             text-color="#F0FFFF"
             active-text-color="#ADD8E6"
             style="font-weight: 900;"
    >
      <el-menu-item index="/manageResource">审核管理</el-menu-item>
      <el-sub-menu index="/manageNotice">
        <template #title>通知管理</template>
        <el-menu-item index="/manageRaiseNotice">征集公告</el-menu-item>
        <el-menu-item index="/manageMomentsNotice">建设进程动态</el-menu-item>
        <el-menu-item index="/managePrinciple">口述规范</el-menu-item>
        <el-menu-item index="/addNotice">新增通知</el-menu-item>
      </el-sub-menu>

      <div style="margin: auto 20px auto 800px;">
        <el-popconfirm title="确定退出吗？" @confirm="$router.push('/')">
          <template #reference>
            <el-button>退出登录</el-button>
          </template>
        </el-popconfirm>
      </div>
    </el-menu>
  </div>
</template>

<script>
import Date from "@/components/Date"

export default {
  name: "HeaderForAdmin",
  components: {
    Date
  },
  data() {
    return {
      dialogVisible: false
    }
  },
  created() {

  },
}
</script>

<style scoped>
img {
  width: 100%;
  overflow: hidden;
}

.header-pic{
  /*background: #C6FFDD;  !* fallback for old browsers *!*/
  /*background: -webkit-linear-gradient(to right, #FBD786, #f7797d, #C6FFDD);  !* Chrome 10-25, Safari 5.1-6 *!*/
  /*background: linear-gradient(to right, #FBD786, #f7797d, #C6FFDD); !* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ *!*/
  background: #4682B4;
}
</style>
