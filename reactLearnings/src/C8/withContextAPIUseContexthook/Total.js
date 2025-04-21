import React, { useContext } from "react";
import { TotalContext } from "./store/TotalContext";

///improvment from withcontextAPI

// old approch from reading data from consumer
/* const Total = () => {
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
}; */

// new Approch with context hook
const TotalUseContext = () => {
  const total = useContext(TotalContext);
  return <><h1> Total component</h1>Total : {total}</>;
};

export { TotalUseContext };
