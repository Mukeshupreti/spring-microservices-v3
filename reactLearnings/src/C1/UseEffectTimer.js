import React, { useEffect, useState } from "react";

// useEffect is used in funtional component
// it is called when component is render or re-render
// it take and function as argument
// it is good for when we should not call logging , mutation in funtional component
//render method
``;
const UseEffectNormal = () => {
  const [timer, setTimer] = useState(new Date().toLocaleString());

  useEffect(() => {
    console.log("useEffect called");
    setInterval(() => {
      setTimer(new Date().toLocaleString());
    }, 1000);
  });

  return (
    <>
      <h1> current Time is : {timer}</h1>
    </>
  );
};

export { UseEffectNormal };
