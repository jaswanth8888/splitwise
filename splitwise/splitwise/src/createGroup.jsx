import React, { Component } from "react";

export default class createGroup extends Component {
  constructor(props) {
    super(props);

    this.state = {
      group: {
        name: "",
        friends: [],
        createdBy: 1
      }
    };
  }

  render() {
    return (
      <div className="container">
        <div>
          <button
            type="button"
            className="btn btn-info btn-lg"
            data-toggle="modal"
            data-target="#createGroup"
          >
            Create Group
          </button>
        </div>
        <div className="modal fade" id="createGroup">
          <div className="modal-dialog modal-dialog-centered" role="document">
            <div className="modal-content">
              <div className="modal-header">
                <h5 className="modal-title">Create Group</h5>
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
                <form>
                  <div className="form-group">
                      <label className="control-label" htmlFor="groupName">
                        Group Name
                      </label>
                      <input
                        className="form-control"
                        id="groupName"
                        name="name"
                        type="text"
                        placeholder="Group Name"
                       
                      />
                  </div>
                </form>
              </div>
              <div className="modal-footer">
                <button type="button" className="btn btn-primary">
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
            </div>
          </div>
        </div>
      </div>
    );
  }
}
