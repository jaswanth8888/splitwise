import React, { Component, Fragment } from "react";
import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";
import Home from "./home";
import Groups from "./groups";
import Cookies from "universal-cookie";
import Login from "./login";
import {Redirect} from 'react-router-dom';

export default class header extends Component {
  isAuthenticated() {
    var cookie = new Cookies();
    var token = cookie.get("token");
    console.log(token);
    
    return token && token.length > 10;
    
  }

  render() {
    const isAlreayAuthenticated = this.isAuthenticated();
    return (
      <Fragment>
        <Router>
          <div>
            <nav className="navbar navbar-expand-lg navbar-dark bg-primary">
              <a className="navbar-brand" href="#">
                Splitwise
              </a>
              <button
                className="navbar-toggler"
                type="button"
                data-toggle="collapse"
                data-target="#navbarColor01"
                aria-controls="navbarColor01"
                aria-expanded="false"
                aria-label="Toggle navigation"
              >
                <span className="navbar-toggler-icon"></span>
              </button>

              <div className="collapse navbar-collapse" id="navbarColor01">
                {isAlreayAuthenticated ? (
                  <ul className="navbar-nav mr-auto">
                    <li className="nav-item active">
                      <Link to="/" className="nav-link">
                        Home <span className="sr-only">(current)</span>
                      </Link>
                    </li>
                    <li className="nav-item">
                      <Link to="/groups" className="nav-link">
                        Groups
                      </Link>
                    </li>
                    <li className="nav-item">
                      <Link to="/profile" className="nav-link">
                        Profile
                      </Link>
                    </li>
                    <Link to="/transactions" className="nav-link">
                      Transactions
                    </Link>
                    <li className="nav-item">
                      <a className="nav-link" href="#">
                        About
                      </a>
                    </li>
                  </ul>
                ) : (
                  <Redirect to={{pathname:'/login'}}/> 
                )}
              </div>
            </nav>
          </div>
          <Switch>
            <Route exact path="/">
              <Home />
            </Route>
            <Route path="/groups">
              <Groups />
            </Route>
            <Route exact path="/login">
              {isAlreayAuthenticated ?(<Redirect to={{pathname:'/'}}/> ):(
                <Login />
              )}              
            </Route>
          </Switch>
        </Router>
      </Fragment>
    );
  }
}
