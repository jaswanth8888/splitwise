import React, { Component } from "react";
import axios from "axios";
import Cookies from "universal-cookie";
import { BrowserRouter as Router, Switch, Route, Link , Redirect  } from "react-router-dom";
import md5 from 'crypto-js';
import sha256 from 'crypto-js/sha256';
export default class login extends Component {
  constructor(props) {
    var cookie = new Cookies();
    
    super(props);

    this.state = {
      user: {
        username: "",
        password: ""
      },
      login: false,
      token:cookie.get('token')
    };
    this.submitForm = this.submitForm.bind(this);
  }

  handleChange = e => {
    let user = Object.assign({}, this.state.user);
    user[e.target.name] = e.target.value;
    this.setState({ user });
  };
  submitForm = () => {
    axios
      .post("http://localhost:8000/authenticate", this.state.user)
      .then(res => {
        if ((res.status = 200)) {
          if(res.data.authentication==="true"){  
          var cookie = new Cookies();
          
          cookie.set("email",this.state.user.username);
          
          this.setState({ login: true });
        }
      }
      });
  };
  isAuthenticated() {
    var cookie = new Cookies();
    var token = cookie.get("email");

    return token && token.length > 10;
  }
  render() {
    const isAlreayAuthenticated = this.isAuthenticated();
    return (
      <div id="pageDiv">
        {isAlreayAuthenticated ? (
          <Redirect to={{ pathname: "/home" }} />
        ) : (
          <div style={{position:"absolute",top:"0px",left:"0px",right:"0px",bottom:"0px",width:"100%",height:"90%"}}>
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
          </nav>
            <div style={{ display:"flex",justifyContent:"center",alignItems:"center",height:"100%"}}>
          <div
            className="card border-primary mb-3"
            style={{ maxWidth: "500px"}}
          >
            <div className="card-header">Login</div>
            <div className="card-body">
              <form>
                <div className="form-group">
                  <label htmlFor="username">Email address</label>
                  <input
                    type="email"
                    className="form-control"
                    id="username"
                    name="username"
                    placeholder="Enter email"
                    value={this.state.user.username}
                    onChange={e => {
                      this.handleChange(e);
                    }}
                  />
                </div>
                <div className="form-group">
                  <label htmlFor="password">Password</label>
                  <input
                    type="password"
                    className="form-control"
                    id="password"
                    name="password"
                    placeholder="Password"
                    value={this.state.user.password}
                    onChange={e => {
                      this.handleChange(e);
                    }}
                  />
                </div>
                <button
                  type="button"
                  className="btn btn-primary"
                  onClick={this.submitForm}
                >
                  Login
                </button><br/>
                Not  a member ? <Link to="/signup">Signup</Link>
              </form>
            </div>
          </div>
          </div>
         
          </div>
        
        )}
      </div>
    );
  }
}
