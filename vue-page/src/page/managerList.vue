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
      <el-table-column label="状态" width="120">
        <template slot-scope="scope">
          <el-button
            v-if="scope.row.status == 1"
            type="success"
            plain
            size="small"
            >正常</el-button
          >
          <el-button v-else type="warning" plain size="small">异常</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
import headTop from "../components/headTop";
import { selectAllManager } from "@/api/api.js";

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
      selectAllManager().then(response => {
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
