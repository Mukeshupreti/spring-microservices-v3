import React from "react";
import { TotalContext } from "./store/TotalContext";


  // STEP 3: consume value from store 
  //  inside   <TotalContext.Consumer> use function  (total)=>{return jxs}
const Total = () => {
  return (
    <>
      <h1> Total component</h1>
      <TotalContext.Consumer>
        {(total) => {
          return <h1>Total : {total}</h1>;
        }}
      </TotalContext.Consumer>
    </>
  );
};

export { Total };
