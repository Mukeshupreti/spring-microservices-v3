import React, { Component } from "react";



// Class and funtional component both have state from react 16.8 version.
// class component  have additional life cycle methods
// it extent React.Component
// it have render method which have inside return JSX
// JSX is html content inside .js file
// state is always access with "this" eg : this.state.""
// two way to update state
//1 . setState(updaterfunction,[callback])
//2.  setStatte(changeObject,[callback])
/// here callback method is optional


/// Two phases of class
// Mounting phase : when component loaded render() is executed
//updating phase : when any state is updated render()/shouldCompoentUpdate() is called

//Life cycle method
// 1.componentDidMount ==> excuted when component is loaded/mounted/added in dom
//tree. // used for one time intilization/API calls called only once 

//2. ComponentWillUnmount --> called once component is unload/unmount/remove
// from the dom tree 


export default class App extends Component {
  /// like use State
  state = {
    counter: 0,
  };
  // funtion name will always start from lower case.
  handldeClickWithUpdaterMethod = () => {
    let cnt = this.state.counter;
    cnt++;
    // set state takes two parameter state, props
    // first funtion is updater function and console logs priting we are using
    // callback method
    //way one
     // setState(updaterfunction,[callback])
    this.setState(


      (state, props) => {
        return { counter: cnt };
      },
      // callback function : optional
      () => {
        console.log("handle click is called");
        // callback function will get called after state update and render get called
      }
    );
   
  };
// way 2 
////setState(changeObject,[callback])
  handldeClickWithChangeObject = () => {
    // gettting the state use this.state.{key in object literal}
    let cnt = this.state.counter;
    cnt++;
    
    // directly pass change object in this.setState
    this.setState({ counter: cnt });
  };
// kind of constructor used for initilization of component only once
// get called once component is inizilized first time /first time render
  componentDidMount=() =>{
 
    console.log("CDM");
  }
  /// kind of distrcutor
  componentWillUnmount(){
    console.log("componentWillUnmount");
  }

  shouldComponentUpdate(){
   // return false; // in case of false render method will not called  once update state.
     return true;// render method is called in case of update state
  }

  render() {
    console.log("rendered !!")
    return (
      <>
        <h1>counter value in class component {this.state.counter}</h1>
        <button onClick={this.handldeClickWithUpdaterMethod}>
          increment with updater
        </button>
        <button onClick={this.handldeClickWithChangeObject}>
          increment with changeObject
        </button>
      </>
    );
  }
}
