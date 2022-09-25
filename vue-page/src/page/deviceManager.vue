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
      <el-table-column prop="type" label="操作类型" width="120"
        ><template slot-scope="scope">
          <el-button
            v-if="scope.row.type == 0"
            type="success"
            plain
            size="small"
            >入库</el-button
          >
          <el-button
            v-if="scope.row.type == 1"
            type="primary"
            plain
            size="small"
            >出借</el-button
          >
          <el-button
            v-if="scope.row.type == 2"
            type="info"
            plain
            size="small"
            >收回</el-button
          >
          <el-button
            v-if="scope.row.type == 3"
            type="warning"
            plain
            size="small"
            >其他</el-button
          >
          <el-button
            v-if="scope.row.type == 9"
            type="info"
            plain
            size="small"
            >审核中</el-button
          >
        </template></el-table-column
      >
      <el-table-column prop="time" label="操作时间" width="220">
      </el-table-column>
      <el-table-column
        prop="s_name"
        label="设备使用人"
        width="120"
      ></el-table-column>
      <el-table-column
        prop="m_name"
        label="操作执行管理员"
        width="120"
      ></el-table-column>
      <el-table-column
        prop="comment"
        label="备注"
        width="120"
      ></el-table-column>
    </el-table>
  </div>
</template>

<script>
import headTop from "../components/headTop";
import { selectAllDeviceMessageInfo } from "@/api/api.js";

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
      selectAllDeviceMessageInfo().then(response => {
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
