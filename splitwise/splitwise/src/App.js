import React, { Component } from 'react'
import Login from './login'
import Header from './header';

export default class App extends Component {
  render() {
    return (
      <div>
        <Header />
        <Login />
      </div> 
    )
  }
}

