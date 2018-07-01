import React, { Component } from 'react';
import './Event.css'
import EventHelper from "./EventHelper";
import { Link } from 'react-router-dom'

class Event extends Component{
    constructor(props){
        super(props);
        this.state = {
            event: props.event
        };
    }

    render(){
        const event = this.state.event;
        let localType = EventHelper.getLocalType(event.type);
        let tagsString = EventHelper.getTagsString(event.tags);
        let color = EventHelper.getColor(event.type);
        return (
            <Link to={'/event/'+this.state.event.type.toLowerCase()+"/"+this.state.event.id}>
                <div className='rootEventContainer'>
                    <img src={event.imgUrlSmall}/>
                    <div className='type' style={ {backgroundColor: color}}><b>{localType}</b></div>
                    <div className='title'><b>{event.name}</b></div>
                    <div className='tags'>{tagsString}</div>
                </div>
            </Link>
        )
    }
}

export default Event;