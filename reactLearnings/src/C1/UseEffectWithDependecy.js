import React, { useEffect, useState } from "react";

/*  useCase 1 :Dependency Array []: You can also provide a dependency array as 
the second argument to useEffect. 
.This array specifies values that the effect depends on. 
If any of these values change between renders, the effect will run again. */

/* Use case 2 []
If the array is empty, the effect only runs once after the initial render. */

const UseEffectWithDepedency = () => {
  const [counter, setCounter] = useState(0);
  const [counter1, setCounter1] = useState(0);
 
  /****  Use case 2 */ // called only when page is initilize  
 /*  useEffect(() => {
    console.log("counter ", counter);
  }, []); */ 

    /****  Use case 1 */ // called when counter State change not Counter1
 /*  useEffect(() => {
    console.log("counter ", counter);
  }, [counter]);
 */
// useCase 3 // this will get called on initilization or state change
  useEffect(() => {
    console.log("counter ", counter);
  });

  return (
    <>
      <button onClick={() => setCounter(counter + 1)}> click conter</button>
      <button onClick={() => setCounter1(counter1 + 1)}> click counter1</button>
    </>
  );
};

export { UseEffectWithDepedency };
