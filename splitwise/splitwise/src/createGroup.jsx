import React, { Component } from "react";
import axios from "axios";

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
  createGroup = event => {
    const group={
      id:Math.floor(Math.random() * (90000)) + 10000,
      name:document.getElementById("createGroupName").value,
      createdBy:document.getElementById("createGroupUserId").value,
      members:[parseInt(document.getElementById("createGroupUserId").value)],
      transactions:[],
      expenditures:[]

    }
    console.log(group);
    axios.post("http://localhost:9190/create-group",group).then(res => {
      if(res.status==200){
        axios.get("http://localhost:8000/user/"+document.getElementById("createGroupUserId").value+"/group/"+group.id).then((res)=>{
          document.getElementById("modal-button1").click()
        })
      }
      
      
    })
  }

  render() {
    return (
      <div className="container">
        <div>
          <button
            type="button"
            id="modal-button1"
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
                <input type="hidden" id="createGroupUserId" value={this.props.userId} />
                  <div className="form-group">
                      <label className="control-label" htmlFor="groupName">
                        Group Name
                      </label>
                      <input
                        className="form-control"
                        id="createGroupName"
                        name="name"
                        type="text"
                        placeholder="Group Name"
                       
                      />
                  </div>
                </form>
              </div>
              <div className="modal-footer">
                <button type="button" className="btn btn-primary" onClick={this.createGroup}>
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
