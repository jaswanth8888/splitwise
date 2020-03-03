import React,{ Component, Fragment } from "react";
// import Cookies from "universal-cookie";

export default class home extends Component {
  constructor(props) {
    super(props);

    this.state = {};
  }
  componentDidUpdate(prevProps, prevState) {
    console.log(prevProps, prevState);
  }

  render() {
    return (
      <div>
        {this.props.userId}

        <Fragment>
          <div className="container-fluid">
            <div className="container">
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
                      {Math.round(200* 100) / 100}
                    </p>
                  </div>
                </div>
                </div>
                <div className="col-md-3">
                <div id="debit-box" className="card text-white bg-danger mb-3">
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
                      {Math.round(500 * 100) / 100}
                    </p>
                  </div>
                  </div>
                </div>
              </div>
              <div className="col-md-6">
              <hr></hr>
              </div>
              <h3 className="mb2">Recent Transactions</h3>
              <div
                className="toast show text-success border-success"
                role="alert"
                aria-live="assertive"
                aria-atomic="true"
              >
                <div className="toast-body">
                  <div className="split-text">
                    <p className="content">Xyz paid you 10,000</p>
                    <small>11 mins ago</small>
                  </div>
                </div>
              </div>
              <div
                className="toast show text-danger border-danger"
                role="alert"
                aria-live="assertive"
                aria-atomic="true"
              >
                <div className="toast-body">
                  <div className="split-text">
                    <p className="content">You paid Xyz 10,000</p>
                    <small>12 mins ago</small>
                  </div>
                </div>
              </div>
            </div>
            <div className="container">
              <button className="btn btn-danger">Load more</button>
            </div>
          </div>
        </Fragment>
      </div>
    );
  }
}
