import React, { Component } from "react";
import "./css/bootstrap.min.css";

// import "./groupDetails.css";
import { withRouter } from "react-router";
import axios from "axios";

class groupDetails extends Component {
  constructor(props) {
    super(props);
    this.state = {
      groupId: this.props.match.params.pathparam,
      transactions: [],
      users: {},
      addedTransaction:false
    };
    this.getGrouptransaction();
    this.getGroupUsers();
  }

  submitVerify = event => {
    const formData = {
      id: Math.floor(Math.random() * (90000)) + 10000,
      fromUser: document.getElementById("userId").value,
      toUser: document.getElementById("toUser").value,
      description: document.getElementById("description").value,
      groupId: this.state.groupId,
      amount: document.getElementById("transactionAmount").value,
      issettled:false
      
    };
    const headers = {
      "Content-Type": "application/json"
    };

    axios.post('http://localhost:8100/group/transaction', formData, { headers: headers })
        .then(res => {
            console.log(res.data.id);
            axios.post('http://localhost:9190/add-transaction/'+this.state.groupId+"/"+res.data.id).then(
                res =>{
                    this.setState({addedTransaction:true})
                    document.getElementById("modal-button").click()

                    this.getGrouptransaction();
                    document.getElementById("myForm").reset();
                }
            )
        })
  };
  addUser = event => {
    

    axios.post('http://localhost:9190/group/'+document.getElementById('addGroupId').value+'/add-user/'+document.getElementById('addUserId').value)
        .then(res => {
            document.getElementById("modal-button1").click()
            this.getGroupUsers();
            this.getGrouptransaction();
            document.getElementById("myForm").reset();
        })
        
  };

  getGrouptransaction() {
    axios
      .get("http://localhost:9190/group/get-transactions/" + this.state.groupId)
      .then(res => {
        console.log(res.data);
        this.setState({ transactions: res.data });
      });
  }
  getGroupUsers() {
    axios
      .get("http://localhost:9190/group/users/" + this.state.groupId)
      .then(res => {
        console.log(res.data);
        var users = {};
        res.data.map(user => {
          Object.keys(user).map(key => {
            users[key] = user[key];
          });
        });
        this.setState({ users });
      });
  }
  render() {
    return (
      <div>
          <br/>
        <div className="container-fluid">
          <div className="container">
            <div
              className="card border-primary mb-3 h-100"
              style={{ maxWidth: "500px" }}
            >
              <div className="card-header text-center">
                  {console.log("from froup detals",this.props.allUsers)}
                {this.props.groups[this.state.groupId]}
              </div>
              <div className="card-body" style={{ height: "450px" ,overflowY:"scroll"}}>
                <div className="list-group">
                    {/* {console.log(this.state.transactions.length)} */}
                  {this.state.transactions.map(transaction => {
                    return (
                      <li className="list-group-item list-group-item-action">
                        {this.state.users[transaction.fromUser]} paid{" "}
                        {transaction.amount} to{" "}
                        {this.state.users[transaction.toUser]} <br />
                        {transaction.description}
                      </li>
                    );
                  })}
                </div>
              </div>
              <div className="card-footer">
                <div className="container">
                  <div>
                    <button
                        id="modal-button"
                      type="button"
                      className="btn btn-info btn-lg"
                      data-toggle="modal"
                      data-target="#makeTransaction"
                    >
                      Make Transaction
                    </button>
                    <button
                        id="modal-button1"
                      type="button"
                      className="btn btn-info btn-lg"
                      data-toggle="modal"
                      data-target="#addUsers"
                    >
                      AddUsers
                    </button>
                  </div>
                </div>
              </div>
            </div>
          </div>

          <div className="modal fade" id="makeTransaction">
            <div className="modal-dialog modal-dialog-centered" role="document">
              <div className="modal-content">
                <div className="modal-header">
                  <h5 className="modal-title">Make Transaction</h5>
                  <button
                    type="button"
                    className="close"
                    data-dismiss="modal"
                    aria-label="Close"
                  >
                    <span aria-hidden="true">&times;</span>
                  </button>
                </div>
                <div className="modal-body">
                  <form id="myForm">
                    <input
                      type="hidden"
                      id="userId"
                      value={this.props.userId}
                    />
                    <input
                      type="hidden"
                      id="groupId"
                      value={this.state.groupId}
                    />
                    <div className="form-group">
                      <label className="control-label" htmlFor="toUsers">
                        To
                      </label>
                      <select id="toUser" className="form-control">
                        {Object.keys(this.state.users).map(key => {
                          return (
                            <option value={key} key={key}>
                              {this.state.users[key]}
                            </option>
                          );
                        })}
                      </select>
                    </div>
                    <div className="form-group">
                      <label
                        className="control-label"
                        htmlFor="transactionAmount"
                      >
                        Amount
                      </label>
                      <input
                        className="form-control"
                        id="transactionAmount"
                        name="amount"
                        type="number"
                        placeholder="Transaction Amount"
                      />
                    </div>
                    <div className="form-group">
                      <label className="control-label" htmlFor="description">
                        Description
                      </label>
                      <input
                        className="form-control"
                        id="description"
                        name="description"
                        type="text"
                        placeholder="Description"
                      />
                    </div>
                    <div className="align-right">
                      <button type="button" style={{visibility:"hidden"}} onClick={this}></button>
                      <button
                        type="button"
                        className="btn btn-primary"
                        onClick={this.submitVerify}
                      >
                        Create
                      </button>
                      <button
                        type="button"
                        className="btn btn-secondary"
                        data-dismiss="modal"
                      >
                        Close
                      </button>
                    </div>
                  </form>
                </div>
                <div className="modal-footer"></div>
              </div>
            </div>
          </div>
          <div className="modal fade" id="addUsers">
            <div className="modal-dialog modal-dialog-centered" role="document">
              <div className="modal-content">
                <div className="modal-header">
                  <h5 className="modal-title">Add User</h5>
                  <button
                    type="button"
                    className="close"
                    data-dismiss="modal"
                    aria-label="Close"
                  >
                    <span aria-hidden="true">&times;</span>
                  </button>
                </div>
                <div className="modal-body">
                  <form id="myForm">
                    <div className="form-group">
                    <input
                      type="hidden"
                      id="addGroupId"
                      value={this.state.groupId}
                    />
                    
                      <label className="control-label" htmlFor="toUsers">
                        To
                      </label>
                      <select id="addUserId" className="form-control">
                        {Object.keys(this.props.allUsers).map(key => {
                          return (
                            <option value={key} key={key}>
                              {this.props.allUsers[key]}
                            </option>
                          );
                        })}
                      </select>
                    </div>
                    
                    <div className="align-right">
                      <button
                        type="button"
                        className="btn btn-primary"
                        onClick={this.addUser}
                      >
                        Add User
                      </button>
                      <button
                        type="button"
                        className="btn btn-secondary"
                        data-dismiss="modal"
                      >
                        Close
                      </button>
                      <button type="button" id="getuserId" style={{visibility:"hidden"}} onClick={this.props.getUserId}></button>
                    </div>
                  </form>
                </div>
                <div className="modal-footer"></div>
              </div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default withRouter(groupDetails);
