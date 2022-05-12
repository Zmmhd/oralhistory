<template>
  <div class="search-box-outer">
    <div class="overview"></div>
    <div class="search-box">
      <input type="text" v-model="search" placeholder="请输入关键字" @keydown.enter="searchForResult">
      <button class="search-btn" type="button" @click="searchForResult">
        <i class="fa-solid fa-magnifying-glass"></i>
      </button>
    </div>
  </div>
</template>

<script>
export default {
  name: "Search",
  data() {
    return {
      search: ""
    }
  },
  methods: {
    searchForResult() {
      sessionStorage.setItem("currentSearch", this.search);
      this.$router.push("/searchResult");
    }
  }
}
</script>

<style scoped>
.search-box-outer {
  height: 50px;
  background: #ADA996; /* fallback for old browsers */
  background: -webkit-linear-gradient(to right, #EAEAEA, #DBDBDB, #F2F2F2, #ADA996); /* Chrome 10-25, Safari 5.1-6 */
  background: linear-gradient(to right, #EAEAEA, #DBDBDB, #F2F2F2, #ADA996); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
  display: flex;
  align-items: center;
}

.overview{
  width: 75%;
}

.search-box input {
  border: none;
  background: none;
  outline: none;
  padding: 0;
  color: #fff;
  font-size: 15px;
  line-height: 20px;
  width: 0;
  transition: all 0.8s;
}

.search-box:hover input, .search-box input:focus {
  width: 150px;
  padding: 0 8px;
}
</style>
