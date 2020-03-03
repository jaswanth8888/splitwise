import React, { Component } from 'react'
import CreateGroup from './createGroup'

export default class groups extends Component {
    constructor(props) {
        
        super(props)
    
        this.state = {
             email:""
        }
    }
    
    render() {
        return (
            <div>
                <CreateGroup />
            </div>
        )
    }
}
