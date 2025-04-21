import React, { Component } from "react";
import "./App.css";
import Header from "./basic/Header";
import Test from "./basic/Test";
import Parent from "./aboutProps/Parent";
import logo from "./logo.svg";
import Parent_state from "./aboutProps/Parent_state";
import LifeCycle1 from "./aboutProps/LifeCycle1";
import Blog from "./blogCopy/Blog";
import TimerApp from "./Timer/TimerApp";
import StateEx from "./C1/StateEx";
import C1 from "./C1/C1";
import C2 from "./C2/C2";
import C3 from "./C3/C3";
import C4 from "./C4/C4";
import C5 from "./C5/C5";
import C6 from "./C6/C6";
import C8 from "./C8/C8";
import C12 from "./C12/C12";
import C13 from "./C13/C13";
import { C9 } from "./C9/C9";

import { C10 } from "./C10/C10";
import { C11 } from "./C11/C11";
import { C92 } from "./C9/CombineReducer&ActionConst/component/C92";
import { Provider } from "react-redux";
import { fruitStore } from "./C9/ReduxWIthFunctionalComp/component/store/Productstore";
import { combineStore } from "./C9/CombineReducer&ActionConst/component/store/CombineReducer";
import { reduxStore } from "./C11/CombineReducer&ActionConst/component/store/CombineReducer";
import Memo from "./C1/useMemo/Memo";

class App extends Component {
  render() {
    var course = [
      { name: "Hadoop", price: 199 },
      { name: "Java", price: 150 },
      { name: "React", price: 100 },
    ];
    return (
      <div>
        <div className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <h2>Welcome to React</h2>
        </div>
        {/*<Header></Header>
        <Test></Test>*/}
        {/*1. prop Example*/}


         {/* <C1></C1> */}
         {/* <Memo></Memo> */}
        {/* <C2></C2> */}
        {/* <C3></C3> */}
        {/* <C4></C4> */}
        {/* <C5></C5> */}
        {/* <C6></C6> */}
        {/* <C8></C8> */}
          {/* without combined  */}
        {/* <Provider store={fruitStore}>
        <C9></C9>
        </Provider> */}

        {/* withCombinder  and Action */}
        <Provider store={combineStore}>
        <C92></C92>
        </Provider>

         {/* <Provider store={combineStore}>
          <C10></C10>
        </Provider>  */}

        {/* <Provider store={reduxStore}>
          <C11></C11>
        </Provider> */}

        {/* <C12></C12> */}
         {/* <C13></C13> */}

        {/* <Parent></Parent> */}

        {/*2. State Example*/}

        {/* <Parent_state></Parent_state>*/}

        {/*3. Lifecycle*/}
        {/*<LifeCycle1></LifeCycle1>*/}

        {/*4. Blog example integration*/}

        {/*<Blog></Blog>*/}

        {/* 5. Timer App*/}

        {/* <TimerApp start= {Date.now()}/>*/}

        {/*6. Course sales*/}
        {/*  <CourseSales mycourse={course}/>*/}
      </div>
    );
  }
}

export default App;
