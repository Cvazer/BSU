import React, { Component } from 'react';
import './CountryItem.css'

class CountryItem extends Component {
    constructor(props){
        super(props)
        this.state = {
            countryName: props.name,
            code: props.code
        };
        this.handleClick = this.handleClick.bind(this)
    }

    handleClick(){
        this.props.handleClick(this.state.countryName, this.state.code, true)
    }

    render(){
        return (
            <div className={'countryItem'} onClick={this.handleClick}>{this.state.countryName}</div>
        )
    }
}

export default CountryItem;