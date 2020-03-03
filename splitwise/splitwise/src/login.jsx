import React, { Component } from "react";
import axios from "axios";
import Cookies from 'universal-cookie';
import {Redirect} from 'react-router-dom';

export default class login extends Component {
  constructor(props) {
    super(props);

    this.state = {
      user: {
        username: "",
        password: ""
      }
    };
    this.submitForm = this.submitForm.bind(this);
  }
  

  handleChange = e => {
    let user = Object.assign({}, this.state.user);
    user[e.target.name] = e.target.value;
    this.setState({ user });
  };
  validatEmail = () => {
    let mailFormat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    if (this.state.user.username.match(mailFormat)) {
      return true;
    } else {
      return false;
    }
  };
  validateForm = () => {
    if (this.validatEmail()) {
      this.submitForm();
    }
  };  
  submitForm = () => {
    axios
      .post("http://localhost:8765/authenticate", this.state.user)
      .then(res => {
        if ((res.status = 200)) {
            var cookie = new Cookies();
          let d = new Date();
          let minutes = 10;
          d.setTime(d.getTime() + minutes * 60 * 1000);
          console.log(res);
          cookie.set("token", res.data.token);
          cookie.set("email",this.state.user.username);
          
        }
      });
  };
  isAuthenticated(){
    
    var cookie=new Cookies();
    var token=cookie.get('token');
    return token && token.length >10;
}

  render() {
    const isAlreayAuthenticated = this.isAuthenticated();
   return (
    <div>
       {isAlreayAuthenticated ? (<Redirect to={{pathname:'/'}}/> ) : ( 
<div className="card border-primary mb-3" style={{ maxWidth: "20rem" }}>
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
            </button>
          </form>
        </div>
      </div>
         ) 
              }
        
      
    </div>
    );
  }
}