import React, { Component } from 'react';
import Header from "./Header";
import Body from "./Body";

class App extends Component {
  render() {
    return (
        <div id={'content'}>
            <Header/>
            <Body />
        </div>
    )
  }
}

export default App;
