import React, { Component, Fragment } from "react";
import Login from "./login";
import Header from "./header";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";

export default class App extends Component {
  render() {
    return (
      <Fragment>
        <Router>
          <Switch>
            <Route path="/" exact={true} component={Login}/>
            <Route path="/home" exact={true} component={Header}/>
          </Switch>
        </Router>
      </Fragment>
    );
  }
}
