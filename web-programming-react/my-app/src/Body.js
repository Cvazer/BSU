import React, { Component } from 'react';
import './Body.css'
import CountryItem from "./CountryItem";
import FontAwesome from 'react-fontawesome'
import $ from "jquery";
import 'font-awesome/css/font-awesome.min.css';
import CityItem from "./CityItem";

class Body extends Component {
    constructor(props){
        super(props);
        this.state = {
            countries: [],
            cities: [],
            page: 0,
            country: 'by',
            cityName: ''
        };
        this.displayCities = this.displayCities.bind(this);
        this.nextPage = this.nextPage.bind(this);
        this.prevPage = this.prevPage.bind(this);
        this.showCity = this.showCity.bind(this);
    }

    componentWillMount(){
        $.ajax({
            type: 'GET',
            dataType: 'json',
            url: "http://localhost:8080/country/getAll",
            success: (countries) => {
                this.setState({
                    countries: countries
                })
            }
        });
    }

    displayCities(name, code, isNew){
        if (isNew){
            this.setState({
                page: 0
            })
        }
        $.ajax({
            type: 'GET',
            dataType: 'json',
            url: "http://localhost:8080/city/get/"+code+"/"+this.state.page,
            success: (cities) => {
                this.setState({
                    cities: cities,
                    country: code
                })
            }
        });
        console.log(this.state.page)
    }

    showCity(id, name){
        this.setState({
            cityName: name
        })
    }

    nextPage(){
        this.state.page++;
        this.displayCities('', this.state.country)

    }
    prevPage(){
        if (this.state.page===0){return}
        this.state.page--;
        this.displayCities('', this.state.country)
    }

    render(){
        var arr = Array.prototype.slice.call( this.state.countries, 0 );
        var arr2 = Array.prototype.slice.call( this.state.cities, 0 );
        return(
            <table id={'table'}>
                <tbody>
                <tr id={'firstRow'}>
                    <td id={'leftCol'}>
                        {arr.map((country) => <CountryItem key={country.name} name={country.name} code={country.a2} handleClick={this.displayCities}/>)}
                    </td>
                    <td id={'centerCol'}>
                        {(arr2.length === 0 && this.state.page===0)?'':<div id={'nav'}>
                            <div className={'arrowContainer'} onClick={this.prevPage}><FontAwesome name={'arrow-left'} className={'arrow'}/></div>
                            <div className={'arrowContainer'} onClick={this.nextPage}><FontAwesome name={'arrow-right'} className={'arrow'} /></div>
                        </div>}
                        <div id={'centerContent'}>
                            {arr2.map((city) => <CityItem key={city.id} name={city.name} cityId={city.id} handleClick={this.showCity}/>)}
                        </div>
                    </td>
                    <td id={'rightCol'}>
                        {(this.state.cityName==='')?<div></div>:<div>Info about {this.state.cityName}</div>}
                    </td>
                </tr>
                </tbody>
            </table>
        )
    }
}

export default Body;