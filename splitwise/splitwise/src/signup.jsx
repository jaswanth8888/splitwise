import React, { Component } from "react";
import axios from "axios";
import Cookies from "universal-cookie";
import { Redirect } from "react-router-dom";
import md5 from 'crypto-js';
import sha256 from 'crypto-js/sha256';
import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";

export default class signup extends Component {
  constructor(props) {
    var cookie = new Cookies();
    
    super(props);

    this.state = {
      login: false,
      token:cookie.get('email')
    };
  }
  submitVerify = event => {
    //   event.preventdefault();
     const user ={
        id:Math.floor(Math.random() * (90000)) + 10000,
        credit:0,
        debit:0,
        name:{
            firstName:document.getElementById('firstname').value,
            lastName:document.getElementById('lastName').value,
        },
        dob:'06/05/1999',
        phoneNumber:8787878,
        password:document.getElementById('password').value,
        email:document.getElementById('email').value,
        address:{
            hno:'1',
            street:'12',
            city:'sd',
            pincode:2323,
            landmark:'sd',
            state:'sd',
            country:'india'
        },
        friends:[],
        groups:[]

      }
    const headers = {
      "Content-Type": "application/json"
    };

    axios.post('http://localhost:8000/user', user, { headers: headers })
        .then(res => {
            console.log(res.data.id);
            
        })
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
            <div className="card-header">Signup</div>
            <div className="card-body">
              <form>
                <div className="form-group">
                  <label htmlFor="username">Email address</label>
                  <input
                    type="email"
                    className="form-control"
                    id="email"
                    name="username"
                    placeholder="Enter email"
                    required
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
                    required
                  />
                </div>
                <div className="form-group">
                  <label htmlFor="firstName">First Name</label>
                  <input
                    type="text"
                    className="form-control"
                    id="firstname"
                    name="firstName"
                    placeholder="FirstName"
                    required
                  />
                </div>
                <div className="form-group">
                  <label htmlFor="lastName">Last Name</label>
                  <input
                    type="text"
                    className="form-control"
                    id="lastName"
                    name="lastName"
                    placeholder="lastName"
                    required
                  />
                </div>
                <button
                  type="button"
                  className="btn btn-primary"
                  onClick={this.submitVerify}
                >
                  sign up
                </button><br/>
                Already a member ? <Link to="/">Login</Link>
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
