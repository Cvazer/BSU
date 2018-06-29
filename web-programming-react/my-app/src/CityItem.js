import React, { Component } from 'react';
import './CityItem.css'

class CityItem extends Component{
    constructor(props){
        super(props);
        this.state = {
            name: props.name,
            cityId: props.cityId,
            handleClick: props.handleClick
        };
        this.handleClick = this.handleClick.bind(this)
    }

    handleClick(){
        this.state.handleClick(this.state.cityId, this.state.name);
    }

    render(){
        return (
            <div className={'cityItem'} onClick={this.handleClick}>{this.state.name}</div>
        )
    }
}

export default CityItem;