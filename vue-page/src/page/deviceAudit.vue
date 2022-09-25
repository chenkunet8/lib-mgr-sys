<template>
  <div>
    <head-top></head-top>
    <el-button
      v-if="role == 3"
      type="primary"
      class="submit_btn"
      style="margin: 10px;"
      @click="showAddPage"
      >+ 设备录入</el-button
    >
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
        <template slot-scope="scope">
          <el-button
            v-if="scope.row.owner == 1"
            type="success"
            plain
            size="small"
            >学院</el-button
          >
          <el-button
            v-if="scope.row.owner == 2"
            type="warning"
            plain
            size="small"
            >学校</el-button
          >
        </template>
      </el-table-column>
      <el-table-column label="状态" width="120">
        <template slot-scope="scope">
          <el-button
            v-if="scope.row.status == 0"
            type="success"
            plain
            size="small"
            >在库</el-button
          >
          <el-button
            v-if="scope.row.status == 1"
            type="warning"
            plain
            size="small"
            >已出借</el-button
          >
          <el-button
            v-if="scope.row.status == 2"
            type="warning"
            plain
            size="small"
            >废弃</el-button
          >
          <el-button
            v-if="scope.row.status == 9"
            type="warning"
            plain
            size="small"
            >待审批</el-button
          >
        </template>
      </el-table-column>
      <el-table-column
        prop="model"
        label="设备型号"
        width="120"
      ></el-table-column>
      <el-table-column label="操作" width="220">
        <template slot-scope="scope">
          <el-popconfirm
            title="是否确认归还？"
            @confirm="auditConfirm(scope.row, 1)"
            v-if="scope.row.status == 1 && role == 1"
          >
            <el-button type="success" plain size="small" slot="reference"
              >归还</el-button
            >
          </el-popconfirm>
          <el-popconfirm
            title="是否确认借出？"
            @confirm="auditConfirm(scope.row, 2)"
            v-if="scope.row.status == 0 && role == 1"
          >
            <el-button type="warning" plain size="small" slot="reference"
              >借出</el-button
            >
          </el-popconfirm>
          <el-popconfirm
            title="是否确认废弃？"
            @confirm="auditConfirm(scope.row, 3)"
            v-if="scope.row.status == 0 && role == 3"
          >
            <el-button type="danger" plain size="small" slot="reference"
              >废弃</el-button
            >
          </el-popconfirm>
          <el-popconfirm
            title="是否确认审核通过？"
            @confirm="auditConfirm(scope.row, 4)"
            v-if="scope.row.status == 9 && role == 3"
          >
            <el-button type="success" plain size="small" slot="reference"
              >审核通过</el-button
            >
          </el-popconfirm>
          <el-popconfirm
            title="是否驳回申请？"
            @confirm="auditConfirm(scope.row, 5)"
            v-if="scope.row.status == 9 && role == 3"
          >
            <el-button type="danger" plain size="small" slot="reference"
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
import {
  selectAllDeviceInfo,
  updateDeviceById,
  addDeviceMessage,
  selectOneByDeviceId
} from "@/api/api.js";

export default {
  data() {
    return {
      tableData: [],
      role: this.$store.getters.role,
      user: this.$store.getters.user
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
    },
    auditConfirm(row, type) {
      let param = {
        id: row.id,
        status: "0"
      };
      switch (type) {
        // 设备归还
        case 1:
          param.status = "0";
          this.updateDeviceById(param);
          this.selectOneByDeviceId(row.id, 2, "设备已归还", this.user.id);
          break;
        // 设备借出
        case 2:
          param.status = "9";
          this.updateDeviceById(param);
          this.selectOneByDeviceId(row.id, 9, "设备借出审核", this.user.id);
          break;
        // 设备废弃
        case 3:
          param.status = "2";
          this.updateDeviceById(param);
          this.selectOneByDeviceId(row.id, 3, "设备已废弃", "");
          break;
        // 借用通过
        case 4:
          param.status = "1";
          this.updateDeviceById(param);
          this.selectOneByDeviceId(row.id, 1, "设备已出库", "");
          break;
        // 驳回申请
        case 5:
          param.status = "0";
          this.updateDeviceById(param);
          this.selectOneByDeviceId(row.id, 2, "设备已回收", "");
          break;
      }
      this.getTableData();
    },
    updateDeviceById(param) {
      updateDeviceById(param).then(response => {
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
    showAddPage() {
      this.$router.push("/addDevice");
    },
    addDeviceMessage(param) {
      addDeviceMessage(param).then(response => {
        if (response.status == "200") {
        } else {
          this.$message({
            showClose: true,
            message: "系统异常！",
            type: "error"
          });
        }
      });
    },
    selectOneByDeviceId(deviceId, type, comment, userId) {
      selectOneByDeviceId(deviceId).then(response => {
        if (response.status == "200") {
          let param = response.data;
          param.type = type;
          param.comment = comment;
          userId ? (param.userId = userId) : "";
          param.time = this.formatDate();
          this.addDeviceMessage(param);
        } else {
          this.$message({
            showClose: true,
            message: "系统异常！",
            type: "error"
          });
        }
      });
    },
    formatDate() {
      var now = new Date();
      var year = now.getFullYear();
      var month = now.getMonth() + 1;
      if (month.toString().length < 2) {
        month = "0" + month;
      }
      var date = now.getDate();
      if (date.toString().length < 2) {
        date = "0" + date;
      }
      var hour = now.getHours();
      if (hour.toString().length < 2) {
        hour = "0" + hour;
      }
      var minute = now.getMinutes();
      if (minute.toString().length < 2) {
        minute = "0" + minute;
      }
      var second = now.getSeconds();
      if (second.toString().length < 2) {
        second = "0" + second;
      }
      return (
        year +
        "-" +
        month +
        "-" +
        date +
        " " +
        hour +
        ":" +
        minute +
        ":" +
        second
      );
    }
  }
};
</script>
