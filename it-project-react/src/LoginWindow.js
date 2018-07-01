import React, { Component } from 'react';
import './LoginWindow.css'
import FontAwsome from 'react-fontawesome'

class LoginWindow extends Component{
    constructor(props){
        super(props);
        this.state = {
            cancelHandler: props.cancelHandler,
            confirmHandler: props.confirmHandler,
            username: '',
            password: ''
        };
        this.conf = this.conf.bind(this);
        this.handlePasswordChange = this.handlePasswordChange.bind(this);
        this.handleUsernameChange = this.handleUsernameChange.bind(this);
    }

    conf(){
        this.state.confirmHandler(this.state.username, this.state.password);
        this.state.cancelHandler();
    }

    handleUsernameChange(event){
        this.setState({
            username: event.target.value
        });
    }

    handlePasswordChange(event){
        this.setState({
            password: event.target.value
        })
    }

    render(){
        return (
            <div id='loginWindow'>
                <div id='loginPane'>
                    <input id='usernameInput' type='text' placeholder='Имя пользователя' value={this.state.username} onChange={this.handleUsernameChange}/><br/>
                    <input id='passwordInput' type='password' placeholder='Пароль' value={this.state.password} onChange={this.handlePasswordChange}/><br/>
                    <input id='confirmBtn' type='button' value='Войти' onClick={this.conf}/><br/>
                    <div id='cancel' onClick={this.state.cancelHandler}><FontAwsome name='times-circle'/></div>
                </div>
            </div>
        )
    }
}

export default LoginWindow;