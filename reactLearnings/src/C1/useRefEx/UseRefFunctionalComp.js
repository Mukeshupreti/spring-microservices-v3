

import React, { useEffect, useRef } from "react";
// covert class to funtional component by commenting below test as commented for now.

//export default class UseRefClassComp extends Component {
export default function UseRefunComp()  {

    const anElement= useRef(null);
//   constructor(props) {
//     super(props);
//     this.anElement = React.createRef();  /// create Ref
//   }

    useEffect(()=>{anElement.current.focus()})

//   componentDidMount() {
//     this.anElement.current.focus(); // set focus to the element
//   }

  //render() {
    return (
      <>  
        <input type="text"></input>
          {/* assingn ref value */}
        <input type="text" ref={anElement}></input>
        {/* // set focus to the ref component */}
        <button onClick={() => anElement.focus()}>set Focus</button>
      </>
    );
  //}
}
