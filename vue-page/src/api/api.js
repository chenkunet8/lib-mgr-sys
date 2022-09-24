import { doPostRequest, doGetRequest } from "../axios/axiosApi.js";

export function selectAllStudent() {
  return doGetRequest("/api/user-student/selectAll");
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
