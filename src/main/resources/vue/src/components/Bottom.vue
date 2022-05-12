<template>
  <div class="bottom">
    <div class="second-bottom">
      <div class="teleportTitle">传送门</div>
      <div class="teleports">
        <div class="teleport">
          <li @click="$router.push('/mainPage')">主页</li>
          <li @click="$router.push('/themeRelative')">知识图谱</li>
        </div>
        <div class="teleport">
          <li @click="$router.push('/sortByType')">资源分类</li>
          <li @click="$router.push('/submit')">在线提交</li>
        </div>
        <div class="teleport">
          <li @click="$router.push('/raiseNotice')">口述动态</li>
          <li @click="$router.push('/oralMap')">口述地图</li>
        </div>
        <div class="teleport">
          <li @click="$router.push('/principle')">口述规范</li>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "Bottom"
}
</script>

<style scoped>
.bottom {
  background-color: #FBD786;
  width: 100%;
  height: 120px;
  box-shadow: 0 0px 10px 5px #FBD786;
  display: flex;
  justify-content: center;
  align-items: center;
  color: #fff;
}

.second-bottom {
  width: 80%;
  height: 80px;
}

.teleportTitle {
  font-size: small;
  margin-left: 20px;
  margin-bottom: 5px;
  font-weight: 700;
  user-select: none;
}

.teleports {
  display: flex;
}

.teleport li {
  margin: 5px 30px 5px;
  font-size: smaller;
  list-style: none;
  user-select: none;
  transition: all 0.3s;
}

.teleport li:hover{
  color: #f05053;
  cursor: pointer;
}
</style>
