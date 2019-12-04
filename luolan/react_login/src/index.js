import React from 'react';
import ReactDOM from 'react-dom';

import {Provider} from "react-redux";
import {HashRouter as Router,
    Route,
    Switch
} from 'react-router-dom';

import store from "./redux/store";
import Register from './container/register/register';
import Login from './container/login/login';

import 'antd/dist/antd.css';
import './index.css';

ReactDOM.render(
    <Provider store={store}>
        <Router>
            <Switch>
                <Route path='/login' component={Login}></Route>
                <Route path='/register' component={Register}></Route>
            </Switch>
        </Router>
    </Provider>
    , document.getElementById('root'));


