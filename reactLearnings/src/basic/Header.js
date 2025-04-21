import Image from './Image';
import React, {Component} from "react";


export  default class Header extends Component {

    constructor(props){
        super(props);
        this.yourname = "ammy";
        this.state = {};
    }

    sayHello(name) {
        return name;
    }

    render() {
        return (

            <header className="App-header">
                <h1>hello {this.sayHello("Ravi")}</h1>
                <h2>{this.yourname}</h2>
                <h3>{6 + 7}</h3>
                <Image/>
                <h1>Hello Mukesh</h1>
                <h2>Welcome to react</h2>
                <p>
                    Edit <code>src/App.js</code> and save to reload.
                </p>

            </header>
        );
    }

}


