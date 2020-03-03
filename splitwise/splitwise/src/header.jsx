import React, { Component, Fragment } from "react";
import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";
import Home from "./home";
import Groups from "./groups";
import Cookies from "universal-cookie";
import Login from "./login";
import { Redirect } from "react-router-dom";

export default class header extends Component {
  constructor(props) {
    super(props)
  
    this.state = {
       logout:false
    }
  }
  
  isAuthenticated() {
    var cookie = new Cookies();
    var token = cookie.get("token");
    console.log(token);

    return token && token.length > 10;
  }
  logout=()=>{
    var cookie = new Cookies();
    cookie.remove('token');
    this.setState({logout:true})
  }

  render() {
    const isAlreayAuthenticated = this.isAuthenticated();
    return (
    <div>{isAlreayAuthenticated ? (<Fragment>
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

                  <li className="nav-item dropdown">
                    <a
                      class="nav-link dropdown-toggle"
                      data-toggle="dropdown"
                      href="#"
                      aria-expanded="false"
                    >
                    <span class="caret"></span>
                    </a>
                    <div class="dropdown-menu">
                      
                      {/* <div class="dropdown-divider"></div> //to keep divider in ropdown */}
                      <button
                        class="dropdown-item" onClick={this.logout}
                      >
                       Logout
                      </button>
                     
                    </div>
                  </li>
                </ul>
            </div>
          </nav>
        </div>
        <Switch>
          <Route path="/home">
            <Home />
          </Route>
          <Route path="/groups">
            <Groups />
          </Route>
          
        </Switch>
      </Router>
    </Fragment>) : (<Redirect to={{ pathname: "/" }} />)}</div>
      
    );
  }
}
