import React, {Component} from "react";
import "./TimerApp.css";

export default class TimerApp extends Component {

    componentDidMount() {
        setInterval(this.ticker, 1000);
    }

    constructor(props) {
        super(props);
        this.state = {

            clock: 0
        };
        this.ticker = this.ticker.bind(this);

    }

    ticker() {

        this.setState({
                clock:
                    Math.round((Date.now() - this.props.start) / 1000)
            }
        )
    }

    render() {
        return (
            <div>
                <h1>Time Ticker in seconds</h1>
                <br/>
                <br/>

                <span>  {this.state.clock}
                    <br/>
     </span>

            </div>

        );


    }


}