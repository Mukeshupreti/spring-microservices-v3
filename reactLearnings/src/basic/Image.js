import logo from "../logo.svg";
import React, { Component }  from 'react';



class  Image extends Component {
    render() {
        return (
            <img src={logo} className="App-logo" alt="logo" />
        );
    }

}

export  default Image;