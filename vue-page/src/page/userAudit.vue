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
      <el-table-column label="操作" width="220">
        <template slot-scope="scope">
          <el-popconfirm
            title="是否通过该用户请求？"
            @confirm="auditConfirm(scope.row)"
          >
            <el-button type="success" plain size="small" slot="reference"
              >审核通过</el-button
            >
          </el-popconfirm>
          <el-popconfirm
            title="确认阻止该用户吗？"
            @confirm="auditRefuse(scope.row)"
          >
            <el-button type="warning" plain size="small" slot="reference"
              >审核不通过</el-button
            >
          </el-popconfirm>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
import headTop from "../components/headTop";
import { selectAllTeacher, updateTeacherById } from "@/api/api.js";

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
          this.tableData = response.data.filter(item => {
            return item.status == 0;
          });
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
    },
    auditConfirm(row) {
      console.log(row);
      let param = {
        id: row.id,
        status: "1"
      };
      updateTeacherById(param).then(response => {
        if (response.status == "200") {
          this.$message({
            showClose: true,
            message: "操作成功",
            type: "success"
          });
          this.getTableData();
        } else {
          this.$message({
            showClose: true,
            message: "系统异常！",
            type: "error"
          });
        }
      });
    },
    auditRefuse(row) {
      let param = {
        id: row.id,
        status: "2"
      };
      updateTeacherById(param).then(response => {
        if (response.status == "200") {
          this.$message({
            showClose: true,
            message: "操作成功",
            type: "success"
          });
          this.getTableData();
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
