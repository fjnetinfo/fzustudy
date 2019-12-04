/*
包含n个action creator
同步action
异步action
 */
import {START_LOGIN, LOGIN_SUCCESS, LOGIN_FAILED} from "./action-types";
import {reqLogin} from '../api'
//开始登陆的同步action
const startLogin = () => {
    // console.log('开始登录....')
    return {type:START_LOGIN}
}

const loginSuccess = (userInfo,msg) => {
    // console.log('登录成功....')
    return {
        type:LOGIN_SUCCESS,
        data:{userInfo,msg}
    }
}

const loginFailed = (msg) => {
    // console.log('登录失败....')
    return {
        type:LOGIN_FAILED,
        data:msg
    }
}

export const login = (userInfo) => {
    return dispatch => {
        dispatch(startLogin())
        reqLogin(userInfo)
            .then(res => {
                // console.log(res)
                const result = res.data//获取返回的json数据
                console.log(result)
                if(result.code===200){//登陆成功
                    dispatch(loginSuccess(result.data,result.msg))
                }else{//登陆失败
                    dispatch(loginFailed(result.msg))
                }
            })
    }

}
