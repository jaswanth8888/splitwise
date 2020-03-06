import React, { Component, Fragment } from "react";
import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";
import Home from "./home";
import Groups from "./groups";
import Cookies from "universal-cookie";
import { Redirect } from "react-router-dom";
import axios from "axios";
import GroupDetails from "./groupDetails";


export default class header extends Component {
  constructor(props) {
    super(props)
    var cookie = new Cookies();
    this.state = {
       logout:false,
      //  token:cookie.get('token'),
       email:cookie.get('email'),
       userId:'',
       userName:'',
       groups:{},
       credit:0,
       debit:0,
       transactionData:[],
       allUsers:{}

       
    }
    this.getUserId();
    this.getAllUsers();
  }
  getUserId(){    
    axios.get("http://localhost:8000/get-userId-by-username/"+this.state.email,{
      headers: { 'Authorization': + 'Bearer '+this.state.token },
    }).then(res=>{
      if(res.status===200){
        this.setState({userId:res.data.id})
        this.setState({userName:res.data.name})
        this.getGroups(res.data.id)
        this.getTransactions(res.data.id)
        // this.getCreditDebit(res.data.id)
      }
    })
  }
  getAllUsers(){    
    axios.get("http://localhost:8000/get-all-users",{
      headers: { 'Authorization': + 'Bearer '+this.state.token },
    }).then(res=>{
      if(res.status===200){
        this.setState({allUsers:res.data})
        // console.log(res.data);
      }
    })
  }
  getGroups=(userId)=>{   
    axios.get("http://localhost:8000/get-groups/"+userId,{
        headers: { 'Authorization': + 'Bearer '+this.state.token },
      }).then(res=>{
        if(res.status===200){
          this.setState({groups:res.data})

          
        }
      })
  }
  getTransactions=(userId)=>{   
    axios.get("http://localhost:8100/user/"+userId,{
        headers: { 'Authorization': + 'Bearer '+this.state.token },
      }).then(res=>{
        if(res.status===200){
          let credit=0;
          let debit=0;
          res.data.map((transaction)=>{
            if(true){
              if(transaction.fromUser==userId){
                credit=credit+transaction.amount;
              }
              else{
                debit=debit+transaction.amount;
              }
            }
          })
          // console.log(res.data);  
          this.setState({transactionData:res.data,credit:credit,debit:debit})
        }
      })
  }
  // getCreditDebit=(userId)=>{   
  //   axios.get("http://localhost:8000/get-user-transactions/"+userId,{
  //       headers: { 'Authorization': + 'Bearer '+this.state.token },
  //     }).then(res=>{
  //       if(res.status===200){
  //         this.setState({credit:res.data.credit,debit:res.data.debit})
  //         console.log(this.state);
  //       }
  //     })
  // }
  isAuthenticated() {
    var cookie = new Cookies();
    var token = cookie.get("email");
    return token && token.length>0;
  }
  logout=()=>{
    var cookie = new Cookies();
    cookie.remove('email');
    this.setState({logout:true})
  }
  settleTransaction=(e)=>{
    // console.log(e.target.id);
    axios.get("http://localhost:8100/settle-transaction/"+e.target.id).then(
      (res)=>{
        this.getUserId();
      })
  }
 

  render() {
    const isAlreayAuthenticated = this.isAuthenticated();
    
    return (
    <div>{isAlreayAuthenticated ? (<Fragment>
      <Router>
        <div>
          <nav className="navbar navbar-expand-lg navbar-dark bg-primary">
            <a className="navbar-brand" href="/home">
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
            
            <Home userId={this.state.userId} allUsers={this.state.allUsers} settleTransaction={this.settleTransaction} credit={this.state.credit} debit={this.state.debit} transactionData={this.state.transactionData}/>
          </Route>
          <Route path="/groups">
            <Groups userId={this.state.userId} groups={this.state.groups}/>
          </Route>
          <Route path="/group/:pathparam">
            <GroupDetails userId={this.state.userId} allUsers={this.state.allUsers} groups={this.state.groups} />
          </Route>
          
        </Switch>
      </Router>
    </Fragment>) : (<Redirect to={{ pathname: "/" }} />)}</div>
      
    );
  }
}
