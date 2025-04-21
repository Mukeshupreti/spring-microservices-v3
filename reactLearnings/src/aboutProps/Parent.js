import  {Component} from "react";
import React from "react";
import PropTypes from 'prop-types';



class Parent extends Component {

    render() {

        return (
            <div>
                <h1> I am  Car store [(Parent) component]</h1>
                <h2>{this.props.propString} </h2>
                <h2>{this.props.propNumber} </h2>
                <h2>{this.props.propObject.obj1} </h2>

                <Car msg="Msg from Parent : Hi my cars" showCars={this.props.cars}/>

            </div>

        );
    }


}


Parent.propTypes ={

propObject : PropTypes.object,
propString : PropTypes.string,
propNumber : PropTypes.number

}


Parent.defaultProps = {
    cars: ["Baleno", "WagonR", "Honda", "Mahindra"],
    propString :"Excellent Motors",
    propNumber : "Rating : Number one",
    propObject :{
        obj1 : "I am obj1",
        obj2 : "I am obj2"
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
                <h1> Car in my Store</h1>
                <p>{this.props.showCars.map(
                    (item, i) => {
                        return <p>  {i + 1} . {item} </p>
                    }
                )
                } </p>

            </div>
        );
    }

}

export default Parent;