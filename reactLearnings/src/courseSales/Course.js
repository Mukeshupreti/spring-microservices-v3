import React, {Component} from "react";
import "../App.css";

export default class Course extends Component {

    constructor(props) {
        super(props);
        this.state =
            {active: true}

        this.calculate = this.calculate.bind(this);
    }

    render() {
        return (

                <h3 onClick={this.calculate}> name : {this.props.name} price: {this.props.price}</h3>

        );
    }

    calculate() {
        console.log("calculate is called");
        var active = this.state.active;

        this.props.calculatePrice(active ? this.props.price : -this.props.price);
        this.setState({active: !active});

    }
}
