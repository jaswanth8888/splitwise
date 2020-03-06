import React, { Component, Fragment } from "react";
import axios from "axios";
// import Cookies from "universal-cookie";

export default class home extends Component {
  constructor(props) {
    super(props);

    this.state = {};
  }

  render() {
    return (
      <div>
        <Fragment>
          <div className="container-fluid">
            <div className="container col-md-6">
              <h3 className="mb2">Payment Status</h3>
              <div className="flex-full-center row">
                <div className="col-md-3">
                  <div
                    id="credit-box"
                    className="card text-white bg-success mb-3 "
                  >
                    <div className="card-header">Credit</div>
                    <div className="card-body flex-full-center">
                      <p className="card-text big-text">
                        &#8377;&nbsp;
                        {Math.round(this.props.credit * 100) / 100}
                      </p>
                    </div>
                  </div>
                </div>
                <div className="col-md-3">
                  <div
                    id="debit-box"
                    className="card text-white bg-danger mb-3"
                  >
                    <div
                      className="card-header"
                      style={{ textAlign: "right", paddingRight: "10px" }}
                    >
                      Debit
                    </div>
                    <div className="card-body flex-full-center">
                      <p
                        className="card-text big-text"
                        style={{ textAlign: "right", paddingRight: "10px" }}
                      >
                        &#8377;&nbsp;
                        {Math.round(this.props.debit * 100) / 100}
                      </p>
                    </div>
                  </div>
                </div>
              </div>
              <div className="col-md-6">
                <hr></hr>
              </div>
              <h3 className="mb2">Pending Transactions</h3>
              {this.props.transactionData.map(transaction => {
                console.log(transaction,
                  transaction.id,
                  transaction.fromUser,
                  transaction.toUser,
                  this.props.userId
                );
                if (transaction.fromUser == this.props.userId) {
                  return (
                    <div
                      className="toast show text-success border-success"
                      role="alert"
                      aria-live="assertive"
                      aria-atomic="true"
                    >
                      <div className="toast-body">
                        <div className="split-text">
                          <p className="content">
                            {this.props.allUsers[transaction.toUser]} needs pay you &#8377;&nbsp;
                            {transaction.amount}
                          </p>
                          <small>{transaction.description}</small>
                        </div>
                      </div>
                    </div>
                  );
                } else {
                  return (
                    <div
                      className="toast show text-danger border-danger"
                      role="alert"
                      aria-live="assertive"
                      aria-atomic="true"
                    >
                      <div className="toast-body">
                        <div className="row">
                          <div className="col-md-8">
                            <div className="split-text">
                              <p className="content">
                                You need to pay {" "}
                                {this.props.allUsers[transaction.fromUser]} {" "}
                                &#8377;&nbsp;
                                {transaction.amount}
                              </p>
                              <small>{transaction.description}</small>
                            </div>
                          </div>
                          <div className="col-md-4">
                            <button
                              className="btn btn-primary btn-sm "
                              onClick={e => this.props.settleTransaction(e)}
                              id={transaction.id}
                              style={{ align: "right" }}
                            >
                              settle
                            </button>
                          </div>
                        </div>
                      </div>
                    </div>
                  );
                }
              })}
            </div>
          </div>
        </Fragment>
      </div>
    );
  }
}
