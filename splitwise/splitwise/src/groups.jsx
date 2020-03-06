import React, { Component } from "react";
import CreateGroup from "./createGroup";
import axios from "axios";
import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";

export default class groups extends Component {
  constructor(props) {
    super(props);
    console.log(props);
    this.state = {
        userId:'',
      groups:{}
    };
  }

  render() {
    return (
      <div>
        <CreateGroup  userId={this.props.userId} getGroups={this.props.getGroups}/>
        <div className="col-md-6">
        <div className="list-group">
            {console.log('from groups:',this.props.groups)}
            {Object.keys(this.props.groups).map((key) => {
                return <Link to={"group/"+key}>
                <li className="list-group-item list-group-item-action" key={key}>
                {this.props.groups[key]} 
              </li> 
              </Link>
            })}         
        </div>
        </div>  
      </div>
    );
  }
}
