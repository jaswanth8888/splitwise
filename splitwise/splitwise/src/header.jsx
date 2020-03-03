import React, { Component, Fragment } from "react";
import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";
import Home from "./home";
import Groups from "./groups";
import Cookies from "universal-cookie";
import { Redirect } from "react-router-dom";
import axios from "axios";


export default class header extends Component {
  constructor(props) {
    super(props)
    var cookie = new Cookies();
    this.state = {
       logout:false,
       token:cookie.get('token'),
       email:cookie.get('email'),
       userId:'',
       userName:''

       
    }
    this.getUserId();
  }
  getUserId(){
    console.log('invoked');
    
    let config = {
      headers: {
        'Authorization': 'Bearer ' + this.state.token
      }
    }
    axios.get("http://localhost:8000/get-userId-by-username/"+this.state.email,{
      headers: { 'Authorization': + 'Bearer '+this.state.token },
    }).then(res=>{
      console.log(res);
      if(res.status==200){
        this.setState({userId:res.data.id})
        this.setState({userName:res.data.name})
      }
    })
  }
  isAuthenticated() {
    var cookie = new Cookies();
    var token = cookie.get("token");
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
            <a className="navbar-brand" href="/home">
              Splitwise {this.props.location.id}
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
                    <Link to="/home" className="nav-link">
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
                      className="nav-link dropdown-toggle"
                      data-toggle="dropdown"
                      aria-expanded="false"
                    >{this.state.userName}
                    <span className="caret"></span>
                    </a>
                    <div className="dropdown-menu">
                    <li className="dropdown-item">
                      
                  </li>
                      {/* <div className="dropdown-divider"></div> */}
                      <button
                        className="dropdown-item" onClick={this.logout}
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
            <Home userId={this.state.userId} />
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
