import {Component} from "react";
import React from "react";
import PropTypes from 'prop-types';



class Parent_state extends Component {


    constructor(props) {
        super(props);
        this.flag=true;
        this.state = {
            cars:this.props.carsS
        };
        this.removeState= this.removeState.bind(this);
    }


    render() {

        return (
            <div>
                <h1> I am Car store [(Parent) component]</h1>
                <h2>{this.props.propString} </h2>
                <h2>{this.props.propNumber} </h2>
                <h2>{this.props.propObject.obj1} </h2>
                <h2 onClick={this.removeState} className="App" >click to remove state s</h2>

                <Car msg="Msg from Parent : Hi my cars" showCars={this.state.cars}/>

            </div>

        );
    }

    removeState() {
        if(this.flag){
        this.setState({cars:this.props.cars});
        }else {
            this.setState({cars:this.props.carsS});
        }
        this.flag= !this.flag;
    }


}


Parent_state.propTypes = {

    propObject: PropTypes.object,
    propString: PropTypes.string,
    propNumber: PropTypes.number

}

// Properties are defined just as it is json
Parent_state.defaultProps = {
    cars: ["Baleno", "WagonR", "Honda", "Mahindra"],
    carsS: ["S-Baleno", "S-WagonR", "S-Honda", "S-Mahindra"],
    propString: "Excellent Motors",
    propNumber: 3,
    propObject: {
        obj1: "I am obj1",
        obj2: "I am obj2"
    }
}

class Car extends Component {

    render() {
        console.log(this.props.showCars);
        console.log(this.props.msg);



        return (
            <div>
                <h1> I am Car component </h1>
                <p> {this.props.msg}</p>
                <h1 > Car in my Store</h1>
                <div className="App">{this.props.showCars.map(
                    (item, i) => {
                        return <p key={i}>  {i + 1} . {item} </p>
                    }
                )
                } </div>

            </div>
        );
    }

}

export default Parent_state;