<template>
  <div class="header_container">
    <el-breadcrumb separator="/">
      <el-breadcrumb-item :to="{ path: '/manage' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item v-for="(item, index) in $route.meta" :key="index">{{
        item
      }}</el-breadcrumb-item>
    </el-breadcrumb>
    <el-tag>在线人数：{{count}}</el-tag>
    <el-dropdown @command="handleCommand" menu-align="start">
      <img src="../../images/head.png" class="avator" />
      <el-dropdown-menu slot="dropdown">
        <el-dropdown-item @click="homePage" command="homePage"
          >首页</el-dropdown-item
        >
        <el-dropdown-item @click="logout" command="logout"
          >退出</el-dropdown-item
        >
      </el-dropdown-menu>
    </el-dropdown>
  </div>
</template>

<script>
export default {
  data() {
    return {
      count : 0
    };
  },
  created() {},
  computed: {},
  mounted() {
    let ws = new WebSocket("ws://127.0.0.1:8088/api/websocket/stats");
    ws.onopen = e => {
      console.log(e);
    };
    ws.onmessage = e => {
      this.count = e.data
      console.log(e.data);
    };
    ws.onclose = e => {
      console.log("close");
    };
    ws.onerror = e => {
      console.log("error");
    };
  },
  methods: {
    handleCommand(command) {
      command == "homePage" ? this.homePage() : "";
      command == "logout" ? this.logout() : "";
    },
    homePage() {
      this.$router.push("/manage");
    },
    logout() {
      this.$store.dispatch("logout");
      this.$router.push("/");
    }
  }
};
</script>

<style lang="less">
@import "../style/mixin";
.header_container {
  background-color: #eff2f7;
  height: 60px;
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding-left: 20px;
}
.avator {
  .wh(36px, 36px);
  border-radius: 50%;
  margin-right: 37px;
}
.el-dropdown-menu__item {
  text-align: center;
}
</style>
