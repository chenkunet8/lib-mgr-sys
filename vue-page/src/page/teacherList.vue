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
      <el-table-column prop="post" label="级别" width="120"> </el-table-column>
      <el-table-column
        prop="academy"
        label="学院"
        width="120"
      ></el-table-column>
      <el-table-column label="状态" width="120">
        <template slot-scope="scope">
          <el-button
            v-if="scope.row.status == 1"
            type="success"
            plain
            size="small"
            >正常</el-button
          >
          <el-button v-else type="warning" plain size="small">待审核</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
import headTop from "../components/headTop";
import { selectAllTeacher } from "@/api/api.js";

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
      selectAllTeacher().then(response => {
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
