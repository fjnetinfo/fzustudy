/*
能发送ajax请求的函数封装
返回的是promise对象
 */
import axios from 'axios'

const baseUrl = ''
export default function ajax(url, data={}, type = 'GET') {
    url = baseUrl + url
    if (type === 'GET'){//发送GET请求
        //拼接请求参数串
        //data: {username:aa,password:123}
        //paramStr: username=aa&password=123
        let paramStr = ''
        Object.keys(data).forEach(key => {
            paramStr += key + '=' + data[key] + '&'
        })
        if(paramStr){
            paramStr = paramStr.substring(0,paramStr.length-1)
        }
        //使用axios发送get请求
        return axios.get(url + '?' + paramStr)
    }else {//发送post请求
        //使用axios发送post请求
        return axios.post(url,data)
    }
}

