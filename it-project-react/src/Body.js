import React, { Component } from 'react';
import './Body.css'
import $ from 'jquery'
import Event from "./Event";

class Body extends Component{
    constructor(props){
        super(props);
        this.state = {
            type: props.type,
            events: [],
            loggedIn: props.loggedIn,
            user: props.user,
            prefared: []
        };
        this.catClickHandler = this.catClickHandler.bind(this);
    }

    componentDidMount(){
        $.ajax({
            type: 'GET',
            dataType: 'json',
            url: 'http://localhost:8080/event/get/'+this.state.type,
            success: (events) => {this.setState({events: events});}
        });
        const username = (this.props.user===undefined)?undefined:this.props.user.username;
        if (username===undefined){return;}
        $.ajax({
            type: 'GET',
            dataType: 'json',
            url: 'http://localhost:8080/user/prefared/get/'+username,
            success: (prefared) => {this.setState({prefared: prefared});}
        });
    }

    catClickHandler(event){
        const tag = event.target.innerHTML;
        $.ajax({
            type: 'GET',
            dataType: 'json',
            url: 'http://localhost:8080/event/get/'+this.state.type+'/'+tag,
            success: (events) => {this.setState({events: events});}
        });
    }

    render(){
        return (
            <div>
                {(this.state.loggedIn)?
                    <div id='filters'>
                        <div className='cat'>Для вас</div>
                        {this.state.prefared.map((pref) => <div key={pref.id} className='cat' onClick={this.catClickHandler}>{pref.name}</div>)}
                    </div>
                :''}
                <table>
                    <tbody>
                    <tr>
                        <td id='leftCol'/>
                        <td id='centerCol'>
                            {this.state.events.map((event) => <Event key={event.id} event={event}/>)}
                        </td>
                        <td id='rightCol'/>
                    </tr>
                    </tbody>
                </table>
            </div>
        )
    }
}

export default Body;