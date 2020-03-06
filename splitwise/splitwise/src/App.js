import React, { Component, Fragment } from "react";
import Login from "./login";
import Header from "./header";
import Signup from "./signup";

import { BrowserRouter as Router, Switch, Route } from "react-router-dom";

export default class App extends Component {
  render() {
    return (
      <Fragment>
        <Router>
          <Switch>
            
            <Route path="/" exact={true} component={Login}/>
            <Route path="/signup" exact={true} component={Signup}/>
            <Route path="/home" exact={true} component={Header}/>
            <Route path="/groups" exact={true} component={Header}/>
            <Route path="/group/:pathname">
            <Header />
          </Route>
          </Switch>
        </Router>
      </Fragment>
    );
  }
}
