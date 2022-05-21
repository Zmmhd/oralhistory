<template>
  <Date></Date>

  <div class="header-pic">
    <img src="@/assets/h1.jpg" alt="">
  </div>

  <div>
    <el-menu router
             default-active="/mainPage"
             mode="horizontal"
             background-color="#4682B4"
             text-color="#F0FFFF"
             active-text-color="#ADD8E6"
             style="font-weight: 900;"
    >
      <el-menu-item index="/mainPage">主页</el-menu-item>
      <el-sub-menu index="/resourceSort">
        <template #title>资源分类</template>
        <el-menu-item index="/sortByType">资源类型</el-menu-item>
        <el-menu-item index="/sortByProvince">省份</el-menu-item>
        <el-menu-item index="/sortByTheme">主题</el-menu-item>
      </el-sub-menu>
      <el-sub-menu index="/notice">
        <template #title>口述动态</template>
        <el-menu-item index="/raiseNotice">征集公告</el-menu-item>
        <el-menu-item index="/momentsNotice">建设进程动态</el-menu-item>
      </el-sub-menu>
      <el-sub-menu index="/principle">
        <template #title>口述规范</template>
        <el-menu-item index="/principleList">口述规范</el-menu-item>
      </el-sub-menu>
      <el-sub-menu index="/knowledgePicture">
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
    </el-menu>
  </div>

</template>

<script>
import Date from "@/components/Date"

export default {
  name: "Header",
  components: {
    Date
  }
}
</script>

<style scoped>

img {
  width: 100%;
  overflow: hidden;
}

.header-pic {
  /*background: #C6FFDD; !* fallback for old browsers *!*/
  /*background: -webkit-linear-gradient(to right, #FBD786, #f7797d, #C6FFDD); !* Chrome 10-25, Safari 5.1-6 *!*/
  /*background: linear-gradient(to right, #FBD786, #f7797d, #C6FFDD); !* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ *!*/
  background: #4682B4;
}

</style>
