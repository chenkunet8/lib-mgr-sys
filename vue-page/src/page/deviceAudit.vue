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
      <el-table-column prop="id" label="id" width="50"> </el-table-column>
      <el-table-column prop="name" label="设备名称" width="120">
      </el-table-column>
      <el-table-column
        prop="type"
        label="设备类型"
        width="120"
      ></el-table-column>
      <el-table-column prop="owner" label="设备所有者" width="120">
      </el-table-column>
      <el-table-column
        prop="time"
        label="入库时间"
        width="220"
      ></el-table-column>
      <el-table-column label="状态" width="120">
        <template slot-scope="scope">
          <el-button
            v-if="scope.row.status == 0"
            type="success"
            plain
            size="small"
            >在库</el-button
          >
          <el-button v-if="scope.row.status == 1" type="warning" plain size="small">已出借</el-button>
        </template>
      </el-table-column>
      <el-table-column
        prop="model"
        label="设备型号"
        width="120"
      ></el-table-column>
    </el-table>
  </div>
</template>

<script>
import headTop from "../components/headTop";
import { selectAllDeviceInfo } from "@/api/api.js";

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
      selectAllDeviceInfo().then(response => {
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
