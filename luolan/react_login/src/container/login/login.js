// 登录路由组件
import React, {Component} from 'react';
import {Form, Icon, Input, Button, Alert} from "antd";
import {connect} from 'react-redux';
import {login} from "../../redux/actions";

const mapState = state  => ({
        isLoading: state.user.isLoading,
        msg:state.user.msg
})

// @connect(mapState,{login})
// @Form.create()
class Login extends Component {

    handleSubmit = e => {
        e.preventDefault();
        this.props.form.validateFields((err, values) => {
            if (!err) {
                // console.log('Received values of form: ', values);
               this.props.login(values)
            }
        });
    };

    toLogin = () => {
        this.props.history.push('./register')
    }

    render() {
        const { getFieldDecorator } = this.props.form
        const msg = this.props.msg
        return (
            <div className='wrapper'>
                {msg ? <Alert message={msg} type="success" /> : null}
                <h1 className='login-title'>Login</h1>
                <Form onSubmit={this.handleSubmit} className="login-form">
                    <Form.Item>
                        {getFieldDecorator('username', {
                            rules: [{ required: true, message: 'Please input your username!' }],
                        })(
                            <Input
                                disabled={this.props.isLoading}
                                prefix={<Icon type="user" style={{ color: 'rgba(0,0,0,.25)' }} />}
                                placeholder="Username"
                            />,
                        )}
                    </Form.Item>
                    <Form.Item>
                        {getFieldDecorator('password', {
                            rules: [{ required: true, message: 'Please input your Password!' }],
                        })(
                            <Input
                                disabled={this.props.isLoading}
                                prefix={<Icon type="lock" style={{ color: 'rgba(0,0,0,.25)' }} />}
                                type="password"
                                placeholder="Password"
                            />,
                        )}
                    </Form.Item>
                    <Form.Item>
                        <Button loading={this.props.isLoading} type="primary" htmlType="submit" className="login-form-button">
                            Log in
                        </Button>
                        Or <a onClick={this.toLogin}>register now!</a>
                    </Form.Item>
                </Form>
            </div>

        )
    }
}
export default Form.create()(connect(mapState,{login})(Login))
