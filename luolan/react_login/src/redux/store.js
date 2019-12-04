/*
redux最核心的管理对象模块
 */
import {applyMiddleware, createStore} from "redux";// 引入redux createStore、中间件及compose
import thunk from "redux-thunk";// redux 作者开发的异步处理方案 可以在action 里传入 dispatch getState
import {createLogger} from 'redux-logger';// 利用redux-logger打印日志
import {composeWithDevTools} from "redux-devtools-extension";//引入redux-devtools-extension的可视化工具

import reducers from "./reducers";// 引入reducers集合

// 调用日志打印方法，collapsed是让action折叠
const loggerMiddleware = createLogger({collapsed:true})

// 创建一个中间件合集(当多个中间件时，logger就一定要放在最后)
const middleWare  = [thunk,loggerMiddleware]

export default createStore(reducers,composeWithDevTools(applyMiddleware(...middleWare)))
