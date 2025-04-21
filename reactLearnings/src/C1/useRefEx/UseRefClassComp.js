import React, { Component } from "react";

export default class UseRefClassComp extends Component {
  constructor(props) {
    super(props);
    this.anElement = React.createRef();  /// create Ref
  }

  componentDidMount() {
    this.anElement.current.focus(); // set focus to the element
  }

  render() {
    return (
      <>
        <input type="text"></input>
          {/* assingn ref value */}
        <input type="text" ref={this.anElement}></input>
        {/* // set focus to the ref component */}
        <button onClick={() => this.anElement.current.focus()}>set Focus</button>
      </>
    );
  }
}
