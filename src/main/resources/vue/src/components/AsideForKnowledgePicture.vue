<template>
  <el-menu router class="menu" text-color="#fff" active-text-color="#f05053"  default-active="/themeRelative">
    <el-menu-item index="/themeRelative">
      <el-icon>
        <MagicStick/>
      </el-icon>
      省级综合档案馆口述例使档案资源建设主题相关性
    </el-menu-item>
    <el-menu-item index="/WechatTypeRelative">
      <el-icon>
        <MoonNight/>
      </el-icon>
      省级综合档案馆微信公众平台口述历史档案资源类型相关性
    </el-menu-item>
    <el-menu-item index="/WebsiteTypeRelative">
      <el-icon>
        <ToiletPaper/>
      </el-icon>
      省级综合档案馆官网口述例使档案资源类型相关性
    </el-menu-item>
  </el-menu>
</template>

<script>
import {MagicStick, MoonNight, ToiletPaper} from '@element-plus/icons-vue'

export default {
  name: "AsideForKnowledgePicture",
  components: {
    MagicStick,
    MoonNight,
    ToiletPaper
  }
}
</script>

<style scoped>
.menu{
  width: 35%;
  min-height: 100vh;
  background-color: #e7ac94;
  font-weight: 700;
}
.el-menu-item:hover {
  background-color: #d1806c !important;
}
</style>