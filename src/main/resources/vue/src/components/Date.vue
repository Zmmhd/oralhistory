<template>
  <div class="timeAndLogin">
    <div class="time">
      {{ time }}
    </div>
  </div>
</template>

<script>
export default {
  name: "Date",
  data() {
    return {
      time: "",
      weekInChinese: ["星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"]
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
  background: #C6FFDD; /* fallback for old browsers */
  background: -webkit-linear-gradient(to right, #f7797d, #FBD786, #C6FFDD); /* Chrome 10-25, Safari 5.1-6 */
  background: linear-gradient(to right, #f7797d, #FBD786, #C6FFDD); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
  line-height: 30px;
  color: #fff;
  display: flex;
}

.time {
  margin: auto 0 auto 20px;
  user-select: none;
}
</style>
