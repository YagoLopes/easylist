import axios from "axios";
const api = axios.create({
  baseURL: "http://10.42.0.1:8080/EasyListRest"
});
export default api;
