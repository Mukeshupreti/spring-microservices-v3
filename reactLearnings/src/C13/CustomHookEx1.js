import React, { useEffect, useState } from "react";
// Here there is three component which have some common
// funtionality for eg: here counter state and counter ++
// funtionality is common.
//instead of doing it in the three component
//make some custom hook (global function ) and do this work */
const ContainerEx1 = () => {
  return (
    <>
      <hr />
      <h1 className="example">CustomHook Example1 </h1>

      <Component1></Component1>
      <Component2></Component2>
      <Component3></Component3>
    </>
  );
};
// this custom hook return  increment function which is used in button button click
const useCustomHook = (initialValue, ComponentName) => {
  const [count, setCount] = useState(initialValue);

  const increment = () => {
    setCount(count + 1);
  };
  useEffect(() => {
    console.log(ComponentName + "'s Click Count : " + count);
  }, [count, ComponentName]); // this will called when Counter or componentName changes

  return increment;
};

const Component1 = () => {
  const buttonClick = useCustomHook(0, "component1");

  return (
    <>
      <button onClick={buttonClick}>Component1</button>
    </>
  );
};

const Component2 = () => {
  const buttonClick = useCustomHook(0, "component2");

  return (
    <>
      <button onClick={buttonClick}>Component2</button>
    </>
  );
};
const Component3 = () => {
  const buttonClick = useCustomHook(0, "component3");

  return (
    <>
      <button onClick={buttonClick}>Component3</button>
    </>
  );
};

export { ContainerEx1 };
