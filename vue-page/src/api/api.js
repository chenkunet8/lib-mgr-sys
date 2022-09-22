import { doPostRequest, doGetRequest } from "../axios/axiosApi.js"

export function selectAllStudent(){
    return doGetRequest("/user-student/selectAll")
}