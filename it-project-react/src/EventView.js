import React, { Component } from 'react';
import $ from "jquery";
import './EventView.css'
import DOMPurify from 'dompurify'


class EventView extends Component{
    constructor(props){
        super(props);
        this.state = {
            id: props.match.params.id,
            type: props.match.params.type,
            event: {tags: [], name: '', imgUrl: '', heldings: []},
            user: props.user
        };
        this.willAttendHandler = this.willAttendHandler.bind(this);
    }

    componentDidMount(){
        $.ajax({
            type: 'GET',
            dataType: 'json',
            url: 'http://localhost:8080/event/getById/'+this.state.id,
            success: (event) => {this.setState({event: event});}
        });
    }

    willAttendHandler(){
        const user = this.props.user;
        if (user.username===undefined){return;}
        $.ajax({
            type: 'GET',
            dataType: 'json',
            url: 'http://localhost:8080/user/willAttend/'+this.state.event.id+'/'+user.username
        });
    }

    render(){
        const event = this.state.event;
        const username = (this.props.user===undefined)?undefined:this.props.user.username;
        return (
            <div>
                <table>
                    <tbody>
                    <tr>
                        <td id='leftCol'/>
                        <td id='centerCol'>
                            <div id='eventHead'>
                                <div id='eventImg'><img src={event.imgUrl}/>{(username===undefined)?'':<div id='willAttendBtn' onClick={this.willAttendHandler}><b>Хочу пойти</b></div>}</div>
                                <div id='title'><b>{event.name}</b></div>
                                <div id='tagsContainer'>
                                    {event.tags.map(
                                        (tag) => {
                                            return <div className='tag' key={tag.id}>{tag.name}</div>
                                        }
                                    )}
                                </div>
                                {(event.type==='MOVIE')?'':
                                    <div id='heldingsContainer'>
                                        <table id='heldingsTable'>
                                            <tbody>
                                            <tr className='tableRow'><td><b>Расписание</b></td></tr>
                                            {event.heldings.map(
                                                (helding) => {
                                                    return <tr key={helding.id} className='tableRow'>
                                                        <td className='heldingDate'>{helding.day+" "+helding.month}</td>
                                                        <td className='heldingTime'>{(helding.hours<10)?'0':''}{helding.hours+":"}{(helding.minuets<10)?'0':''}{helding.minuets}</td>
                                                    </tr>
                                                }
                                            )}
                                            </tbody>
                                        </table>
                                    </div>}
                            </div>
                        </td>
                        <td id='rightCol'/>
                    </tr>
                    <tr>
                        <td/>
                        <td>
                            <div dangerouslySetInnerHTML={{__html: DOMPurify.sanitize(event.descr)}}/>
                        </td>
                        <td/>
                    </tr>
                    </tbody>
                </table>
            </div>
        )
    }
}

export default EventView;