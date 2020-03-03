import React, { Component } from 'react'

export default class home extends Component {
    constructor(props) {
        super(props)
    
        this.state = {
             
        }
    }
    componentDidUpdate(prevProps,prevState){
        console.log(prevProps,prevState);
        
    }
    
    render() {
        return (
            <div>
                <h1>hi</h1>
            </div>
        )
    }
}
