import React, { Component } from 'react';
import './App.css';
import Header from "./Header";
import { Switch, Route } from 'react-router-dom'
import Body from "./Body";
import EventView from "./EventView";

class App extends Component {
    constructor(props){
        super(props);
        this.state = {
            loggedIn: false,
            user: {}
        };
        this.setLoggedIn = this.setLoggedIn.bind(this);
    }

    setLoggedIn(loggedIn, user){
        this.setState({
            loggedIn: loggedIn,
            user: user
        })
    }

    render() {
      return (
          <div>
              <Header loggedIn={this.state.loggedIn} setLoggedIn={this.setLoggedIn} user={this.state.user}/>
              <Switch>
                  <Route exact path='/' component={() => (<Body type={'ALL'} loggedIn={this.state.loggedIn} user={this.state.user}/>)}/>
                  <Route exact path='/movies' component={() => (<Body type={'MOVIE'} loggedIn={this.state.loggedIn} user={this.state.user}/>)}/>
                  <Route exact path='/concerts' component={() => (<Body type={'CONCERT'} loggedIn={this.state.loggedIn} user={this.state.user}/>)}/>
                  <Route exact path='/plays' component={() => (<Body type={'PLAY'} loggedIn={this.state.loggedIn} user={this.state.user}/>)}/>
                  <Route path='/event/:type/:id' component={(props) => <EventView match={props.match} user={this.state.user}/>}/>
              </Switch>
          </div>
      )
    }
}

export default App;
