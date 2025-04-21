import React, {Component} from "react";


class LifeCycle1 extends Component {


    render() {
        return (
            <div>
                <h1> Lifecycle of Component</h1>
                <Body></Body>
            </div>
        );

    }


}


class Body extends Component {

    constructor(props) {
        super(props);
        this.state = {
            data: 0
        }
        this.generateRandom = this.generateRandom.bind(this);

    }

    generateRandom() {
        // console.log("inside generateRandom");
        this.setState({data: Math.floor(Math.random() * 10)});
    }

    render() {

        return (
            <div>
                <button onClick={this.generateRandom}> Random number</button>
                <Random printNumber={this.state.data}> </Random>
            </div>

        );
    }


}


class Random extends Component {

    //Lifecycle Methods
    componentWillMount() {
        console.log("componentWillMount")
    }

    componentDidMount() {
        console.log("componentDidMount")
    }

    componentWillReceiveProps(nextProps, nextContext) {
        console.log("componentWillReceiveProps")

    }

    componentWillReceiveProps(nextProps) {
        console.log("componentWillReceiveProps")

    }

    shouldComponentUpdate(nextProps, nextState, nextContext) {
        console.log("shouldComponentUpdate with state changed")

    }

    componentWillUpdate(nextProps, nextState, nextContext) {
        console.log("componentWillUpdate")

    }

    componentDidUpdate(prevProps, prevState, snapshot) {
        console.log("componentDidUpdate")
    }

    componentWillUnmount() {
        console.log("componentWillUnmount")
    }


    render() {
        return <div className="App-header"> {this.props.printNumber}</div>;
    }
}

export default LifeCycle1;