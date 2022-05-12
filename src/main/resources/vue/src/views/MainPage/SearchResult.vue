<template>
  <div class="search-box-outer">
    <div class="overview"><h3>资源总览</h3></div>
    <div class="search-box">
      <input type="text" v-model="search" placeholder="请输入关键字" @keydown.enter="load">
      <button class="search-btn" type="button" @click="load">
        <i class="fa-solid fa-magnifying-glass"></i>
      </button>
    </div>
  </div>

  <div class="search-content">
    <div style="margin: 5px 0;">
      <el-tag style="margin: 5px; cursor: pointer;" v-for="t in allType" @click="changeType(t);">
        {{ t }}
      </el-tag>
    </div>

    <div style="margin: 5px 0;">
      <el-tag style="margin: 5px; cursor: pointer;" type="success" @click="changeProvince('');">全部省份</el-tag>
      <el-tag style="margin: 5px; cursor: pointer;" v-for="p in allProvince" type="success" @click="changeProvince(p);">
        {{ p }}
      </el-tag>
    </div>

    <div style="margin: 5px 0;">
      <el-tag style="margin: 5px; cursor: pointer;" type="warning" @click="changeTheme('');">全部主题曲</el-tag>
      <el-tag style="margin: 5px; cursor: pointer;" v-for="t in allTheme" type="warning" @click="changeTheme(t);">
        {{ t }}
      </el-tag>
    </div>

    <div class="condition"><span style="font-weight: bolder;">当前筛选条件：</span>
      类型：<span style="color :#ccc;">{{ allType[type] }}&nbsp;&nbsp;</span>
      省份：<span style="color :#ccc;">{{ province }}&nbsp;&nbsp;</span>
      主题曲：<span style="color :#ccc;">{{ theme }}&nbsp;&nbsp;</span>
    </div>

    <div v-if="isNone === true" class="nothingFound">
      <i class="fa-solid fa-people-pulling pulling"></i>
      <div>别找啦，啥都没有。</div>
    </div>

    <div v-if="isNone === false" class="somethingFound">
      <el-table :data="tableData" style="width: 100%; cursor: pointer;" @row-click="">
        <el-table-column prop="title" label="标题"/>
        <el-table-column label="类型">
          <template #default="scope">
            <el-tag>{{ scope.row.type }}</el-tag>
          </template>
        </el-table-column>
        <el-table-column label="省份">
          <template #default="scope">
            <el-tag type="success">{{ scope.row.province }}</el-tag>
          </template>
        </el-table-column>
        <el-table-column label="主题曲">
          <template #default="scope">
            <el-tag type="warning">{{ scope.row.theme }}</el-tag>
          </template>
        </el-table-column>
        <el-table-column prop="synopsis" label="简介"/>
      </el-table>

      <el-pagination
          style="margin-top: 30px; margin-left: 50px;"
          :currentPage="pageNum"
          :page-size="pageSize"
          :page-sizes="[5, 10, 20]"
          layout="total, sizes, prev, pager, next, jumper"
          :total="total"
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
      />
    </div>
  </div>
</template>

<script>
import Search from "@/components/Search";
import request from "@/utils/request";

export default {
  name: "SearchResult",
  components: {
    Search
  },
  data() {
    return {
      search: sessionStorage.getItem("currentSearch"),
      allType: ["全部类型", "文章", "视频", "音频"],
      allProvince: [],
      allTheme: [],
      tableData: [],
      pageNum: 1,
      pageSize: 10,
      total: 0,
      type: 0,
      province: "",
      theme: "",
      isNone: true
    }
  },
  created() {
    this.getAllProvince();
    this.getAllTheme();
    this.load();
  },
  methods: {
    load() {
      if (this.theme === "全部主题曲") {
        this.theme = "";
      }
      if (this.province === "全部省份") {
        this.province = "";
      }
      request.get("/resource/query", {
        params: {
          title: this.search,
          type: this.type,
          province: this.province,
          theme: this.theme,
          pageNum: this.pageNum,
          pageSize: this.pageSize
        }
      }).then(res => {
        console.log(res);
        for (let i of res.list) {
          if (i.type === 1) {
            i.type = "文章"
          } else if (i.type === 2) {
            i.type = "视频"
          } else {
            i.type = "音频"
          }
        }
        this.tableData = res.list;
        this.total = res.total;
        this.pageNum = res.pageNum;
        this.pageSize = res.pageSize;
        this.isNone = this.total === 0 ? true : false;
        this.province = this.province === "" ? "全部省份" : this.province;
        this.theme = this.theme === "" ? "全部主题曲" : this.theme;
      })
    },
    getAllProvince() {
      request.get("/resource/getClassification/" + "province").then(res => {
        console.log(res);
        this.allProvince = res;
      })
    },
    getAllTheme() {
      request.get("/resource/getClassification/" + "theme").then(res => {
        console.log(res);
        this.allTheme = res;
      })
    },
    handleSizeChange(pageSize) {
      this.pageSize = pageSize
      this.load()
    },
    handleCurrentChange(pageNum) {
      this.pageNum = pageNum
      this.load()
    },
    changeType(t) {
      if (t === "全部类型") this.type = 0;
      else if (t === "文章") this.type = 1;
      else if (t === "视频") this.type = 2;
      else if (t === "音频") this.type = 3;
      this.load();
    },
    changeProvince(p) {
      this.province = p;
      this.load();
    },
    changeTheme(t) {
      this.theme = t;
      this.load();
    },
  }
}
</script>

<style scoped>
.search-content {
  margin: 10px 50px;
  border-top: 1px dashed #ccc;
  padding-top: 10px;
}

.search-box-outer {
  height: 50px;
  display: flex;
  align-items: center;
}

.overview {
  width: 75%;
  margin-left: 50px;
}

.search-box input {
  border: none;
  background: none;
  outline: none;
  color: #fff;
  font-size: 15px;
  line-height: 20px;
  width: 150px;
  padding: 0 8px;
}

.nothingFound {
  min-height: 50vh;
  width: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 50px;
  flex-direction: column;
  color: #ccc;
  user-select: none;
}

.pulling {
  margin: 30px 0;
}

.somethingFound {
  min-height: 120vh;
  width: 100%;
}

.condition {
  user-select: none;
  margin: 20px 0;
}
</style>
