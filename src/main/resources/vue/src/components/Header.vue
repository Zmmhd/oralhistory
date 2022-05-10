<template>
  <div class="timeAndLogin">
    <div class="time">
      {{ time }}
    </div>
  </div>
  <div style="height: 95px;"><img src="@/assets/plum2.0.jpg" alt=""></div>
  <div>
    <el-menu router
             default-active="/mainPage"
             mode="horizontal"
             background-color="#e7ac94"
             text-color="#fff"
             active-text-color="#f05053"
             style="font-weight: 900;"
    >
      <el-menu-item index="/mainPage">主页</el-menu-item>
      <el-sub-menu index="/resourceSort">
        <template #title>资源分类</template>
        <el-menu-item index="/sortByType">资源类型</el-menu-item>
        <el-menu-item index="/sortByProvince">省份</el-menu-item>
        <el-menu-item index="/sortByTheme">主题曲</el-menu-item>
      </el-sub-menu>
      <el-sub-menu index="/notice">
        <template #title>口述动态</template>
        <el-menu-item index="/raiseNotice">征集公告</el-menu-item>
        <el-menu-item index="/momentsNotice">建设进程动态</el-menu-item>
      </el-sub-menu>
      <el-menu-item index="/principle">口述规范</el-menu-item>
      <el-sub-menu index="/themeRelative">
        <template #title>知识图谱</template>
        <el-menu-item index="/themeRelative">省级综合档案馆口述例使档案资源建设主题相关性</el-menu-item>
        <el-menu-item index="/WechatTypeRelative">省级综合档案馆微信公众平台口述历史档案资源类型相关性</el-menu-item>
        <el-menu-item index="/WebsiteTypeRelative">省级综合档案馆官网口述例使档案资源类型相关性</el-menu-item>
      </el-sub-menu>
      <el-sub-menu index="/onlineSubmit">
        <template #title>在线提交</template>
        <el-menu-item index="/submit">在线提交</el-menu-item>
        <el-menu-item index="/review">审核查询</el-menu-item>
      </el-sub-menu>
      <el-menu-item index="/oralMap">口述地图</el-menu-item>
      <el-menu-item index="/about">联系我们</el-menu-item>
      <!--    <div style="height: 35px; margin: auto 0 auto 250px;">-->
      <!--      <el-input v-model="search" placeholder="请输入关键字" style="width: 150px;"/>-->
      <!--      <el-button type="info" style="margin-left: 5px;">查询</el-button>-->
      <!--    </div>-->
    </el-menu>
  </div>


</template>

<script>
export default {
  name: "Header",
  data() {
    return {
      time: "",
      weekInChinese: ["星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"],

      // search: ""
    }
  },
  created() {
    setInterval(() => {
      let time = new Date();
      let week = time.getDay();
      this.time = time.toLocaleString() + " " + this.weekInChinese[week];
    }, 1000)
  }
}
</script>

<style scoped>
.timeAndLogin {
  margin: 0;
  height: 30px;
  /*background-color: #f05053;*/
  background: #e1eec3; /* fallback for old browsers */
  background: -webkit-linear-gradient(to right, #e7ac94, #e1eec3); /* Chrome 10-25, Safari 5.1-6 */
  background: linear-gradient(to right, #e7ac94, #e1eec3); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
  line-height: 30px;
  color: #fff;
}

.time {
  margin: auto 0 auto 20px;
  user-select: none;
}

.el-menu-item:hover {
  background-color: #d1806c !important;
}

img {
  width: 100%;
  overflow: hidden;
}
</style>