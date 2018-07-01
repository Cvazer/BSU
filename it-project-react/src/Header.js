import React, { Component } from 'react';
import { Link } from 'react-router-dom'
import './Header.css'
import FontAwsome from 'react-fontawesome'
import LoginWindow from "./LoginWindow";
import $ from "jquery";

class Header extends Component{
    constructor(props){
        super(props);
        this.state = {
            showLogin: false,
            setLoggedIn: props.setLoggedIn,
            user: props.user
        };
        this.loginHandler = this.loginHandler.bind(this);
        this.logoutHandler = this.logoutHandler.bind(this);
        this.loginCancelHandler = this.loginCancelHandler.bind(this);
        this.loginConfirmHandler = this.loginConfirmHandler.bind(this);
    }

    loginHandler(){
        this.setState({showLogin: true});
    }

    logoutHandler(){
        this.state.setLoggedIn(false);
    }

    loginCancelHandler(){
        this.setState({showLogin: false});
    }

    loginConfirmHandler(username, password){
        $.ajax({
            type: 'GET',
            dataType: 'json',
            url: 'http://localhost:8080/user/login?username='+username+'&pass='+password,
            success: (user) => {this.state.setLoggedIn(true, user);}
        });
    }

    render(){
        return (
            <div className='header'>
                {(this.state.showLogin)?<LoginWindow cancelHandler={this.loginCancelHandler} confirmHandler={this.loginConfirmHandler}/>:''}
                <div className='navItem'><Link to='/movies'>Кино</Link></div>
                <div className='navItem'><Link to='/concerts'>Концерты</Link></div>
                <div className='navItem'><Link to='/plays'>Пьесы</Link></div>
                <div className='navItem'><Link to='/'>Все</Link></div>
                {(this.props.loggedIn)?
                    <div id='logoutBtn' onClick={this.logoutHandler}><div id='userId'>{this.props.user.username}</div><FontAwsome name='sign-out-alt'/></div>
                    :
                    <div id='loginBtn' onClick={this.loginHandler}><FontAwsome name='sign-in-alt'/></div>
                }
            </div>
        )
    }
}

export default Header;