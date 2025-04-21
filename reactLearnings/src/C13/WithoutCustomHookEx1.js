import React, { useState } from "react";
// Here there is three component which have some common
// funtionality for eg: here counter state and counter ++ 
// funtionality is common. 
//instead of doing it in the three component 
//make some custom hook (global function ) and do this work */
const WithOutCustomHook = () => {
  return (
    <>
      <Component1></Component1>
      <Component2></Component2>
      <Component3></Component3>
    </>
  );
};



const Component1 = () => {
  const [count, setCount] = useState(0);
  const buttonClick = () => {
    setCount(count + 1);
    console.log("Component 1 ", count);
  };

  return (
    <>
      <button onClick={buttonClick}>Component1</button>
    </>
  );
};

const Component2 = () => {
  const [count, setCount] = useState(0);
  const buttonClick = () => {
    setCount(count + 1);
    console.log("Component 2 ", count);
  };

  return (
    <>
      <button onClick={buttonClick}>Component2</button>
    </>
  );
};

const Component3 = () => {
  const [count, setCount] = useState(0);
  const buttonClick = () => {
    setCount(count + 1);
    console.log("Component3 ", count);
  };

  return (
    <>
      <button onClick={buttonClick}>Component3</button>
    </>
  );
};

export { WithOutCustomHook };
