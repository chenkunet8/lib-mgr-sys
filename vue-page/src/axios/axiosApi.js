import axios from "axios";
import store from "@/store/index";
import router from "@/router";
import { message } from "ant-design-vue";

axios.defaults.baseURL = "http://127.0.0.1:8088"
axios.defaults.timeout = 15000;
axios.defaults.withCredentials = true;
axios.defaults.headers.post["Content-Type"] =
  "application/x-www-form-urlencoded;charset=UTF-8";

// 请求拦截器
axios.interceptors.request.use(
  (config) => {
    // 每次发送请求之前判断vuex中是否存在token
    // 如果存在，则统一在http请求的header都加上token，这样后台根据token判断你的登录情况
    // 即使本地存在token，也有可能token是过期的，所以在响应拦截器中要对返回状态进行判断
    const token = store.state.auth.token;
    // token && (config.headers.Authorization = token);
    token && (config.headers['X-Authorization'] = token);
    return config;
  },
  (error) => {
    return Promise.reject(error);
  }
);

// http response 拦截器
axios.interceptors.response.use(
  (response) => {
    if (response.status === 200) {
      return Promise.resolve(response);
    } else {
      return Promise.reject(response);
    }
  },
  (error) => {
    //断网处理或者请求超时
    if (!error.response) {
      if (error.message.includes("timeout")) {
        message.error("请求超时,请检查互联网连接");
      } else {
        message.error("请检查网络是否已连接");
      }
      return Promise.reject();
    }
    //处理异常响应
    let status = error.response.status;
    if (status == 403) {
      window.localStorage.clear();
      message.error("无权限访问，请联系管理员");
      return Promise.reject();
    } else if (status == 404) {
      message.error("无法找到服务器，请联系管理员");
      return Promise.reject();
    } else if (status == 408) {
      message.error("请求超时，请稍后再试");
      return Promise.reject();
    } else if (status == 401) {
      store.dispatch("logout").then(() => {
        router.push("/login");
      });
      return new Promise(() => { });
    } else if (status == 500) {
      message.error("服务端错误，请联系管理员");
      return Promise.reject();
    }
    return Promise.reject(error);
  }
);

/**
 * post方法，对应post请求
 * @param {String} url [请求的url地址]
 * @param {Object} params [请求时携带的参数]
 * @param {Object} config [请求时的其他配置]
 */
export function doPostRequest(url, params, config = "") {
  return new Promise((resolve, reject) => {
    axios
      .post(url, params, config)
      .then((res) => {
        resolve(res.data);
      })
      .catch((err) => {
        reject(err);
      });
  });
}

/**
 * get方法，对应get请求
 * @param {String} url [请求的url地址]
 * @param {Object} params [请求时携带的参数]
 */
export function doGetRequest(url, params) {
  return new Promise((resolve, reject) => {
    axios
      .get(url, {
        params: params,
      })
      .then((res) => {
        resolve(res.data);
      })
      .catch((err) => {
        reject(err);
      });
  });
}

/**
 * delete方法，对应delete请求
 * @param {String} url [请求的url地址]
 * @param {Object} params [请求时携带的参数]
 */
export function doDeleteRequest(url, params) {
  return new Promise((resolve, reject) => {
    axios
      .delete(url, {
        params: params,
      })
      .then((res) => {
        resolve(res.data);
      })
      .catch((err) => {
        reject(err);
      });
  });
}

/**
 * put方法，对应put请求
 * @param {String} url [请求的url地址]
 * @param {Object} params [请求时携带的参数]
 */
export function doPutRequest(url, params) {
  return new Promise((resolve, reject) => {
    axios
      .put(url, params)
      .then((res) => {
        resolve(res.data);
      })
      .catch((err) => {
        reject(err);
      });
  });
}

/**
 * patch方法，对应patch请求
 * @param {String} url [请求的url地址]
 * @param {Object} params [请求时携带的参数]
 */
export function doPatchRequest(url, params) {
  return new Promise((resolve, reject) => {
    axios
      .patch(url, params)
      .then((res) => {
        resolve(res.data);
      })
      .catch((err) => {
        reject(err);
      });
  });
}

export function axiosAll(config) {
  return new Promise((resolve, reject) => {
    axios(config)
      .then((res) => {
        resolve(res);
      })
      .catch((err) => {
        reject(err);
      });
  });
}
export const _axios = axios;
