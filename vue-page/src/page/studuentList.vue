<template>
  <div>
    <head-top></head-top>
    <el-table
      ref="multipleTable"
      :data="tableData"
      tooltip-effect="dark"
      style="width: 100%"
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" width="55"> </el-table-column>
      <el-table-column prop="id" label="id" width="120"> </el-table-column>
      <el-table-column prop="name" label="姓名" width="120"> </el-table-column>
      <el-table-column prop="phone" label="账号" width="120"></el-table-column>
      <el-table-column prop="sid" label="学号" width="120"> </el-table-column>
      <el-table-column
        prop="academy"
        label="学院"
        width="120"
      ></el-table-column>
    </el-table>
  </div>
</template>

<script>
import headTop from "../components/headTop";
import { selectAllStudent } from "@/api/api.js";

export default {
  data() {
    return {
      tableData: []
    };
  },
  components: {
    headTop
  },
  mounted() {
    this.getTableData();
  },
  computed: {},
  methods: {
    handleSelectionChange() {},
    getTableData() {
      selectAllStudent().then(response => {
        if (response.status == "200") {
          //获取成功
          this.tableData = response.data;
          this.$message({
            showClose: true,
            message: "查询成功",
            type: "success"
          });
        } else {
          this.$message({
            showClose: true,
            message: "系统异常！",
            type: "error"
          });
        }
      });
    }
  }
};
</script>
