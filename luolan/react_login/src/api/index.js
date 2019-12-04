/*
包含了n个接口请求的函数的模块
函数的返回值为：promise
 */

import ajax from "./ajax";

//登录接口
export const reqLogin = ({username,password}) => ajax('/login',{username,password},'POST')
