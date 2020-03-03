import React, { Component, Fragment } from "react";
import Login from "./login";
import Header from "./header";
import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";
import { Redirect } from "react-router-dom";

export default class App extends Component {
  render() {
    return (
      <Fragment>
        <Router>
          <Switch>
            <Route path="/" exact={true} component={Login}/>
            <Route path="/home" eaxct={true} component={Header}/>
          </Switch>
        </Router>
      </Fragment>
    );
  }
}
