/*
包含n个reducer函数：根据旧的state和指定的action，返回新的state
*/
import {START_LOGIN,LOGIN_SUCCESS,LOGIN_FAILED} from "./action-types";
import {combineReducers} from "redux";

const initState = {
    isLoading:false,
    msg:'',
}
function user(state = initState,action) {
    switch (action.type) {
        case START_LOGIN:
            return {
                ...state,
                isLoading: true,
            }

        case LOGIN_SUCCESS:
            return {
                ...state,
                ...action.data.userInfo,
                isLoading: false,
                msg: action.data.msg
            }

        case LOGIN_FAILED:
            return {
                ...state,
                isLoading: false,
                msg: action.data
            }

        default:
            return state
    }
}


export default combineReducers({
    user
})
