import { doPostRequest, doGetRequest } from "../axios/axiosApi.js";

export function selectAllStudent() {
  return doGetRequest("/api/user-student/selectAll");
}
export function selectAllTeacher() {
  return doGetRequest("/api/user-teacher/selectAll");
}
export function selectAllManager() {
  return doGetRequest("/api/user-manager/selectAll");
}
export function selectAllDeviceInfo() {
  return doGetRequest("/api/device/selectAllDeviceInfo");
}
export function selectAllDeviceMessageInfo() {
  return doGetRequest("/api/device-message/selectAllDeviceMessageInfo");
}
export function selectAllRoom() {
  return doGetRequest("/api/room/selectAll");
}

export function updateTeacherById(parame) {
  return doPostRequest("/api/user-teacher/updateById", parame);
}

export function login(parame, type) {
  switch (type) {
    case 1:
      return doPostRequest("/api/user-student/login", parame);
    case 2:
      return doPostRequest("/api/user-teacher/login", parame);
    case 3:
      return doPostRequest("/api/user-manager/login", parame);
  }
}

export function register(parame, type) {
  switch (type) {
    case 1:
      return doPostRequest("/api/user-student/register", parame);
    case 2:
      return doPostRequest("/api/user-teacher/register", parame);
    case 3:
      return doPostRequest("/api/user-manager/register", parame);
  }
}
