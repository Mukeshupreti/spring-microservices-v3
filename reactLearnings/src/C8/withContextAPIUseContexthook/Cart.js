import React from "react";
import { TotalContext } from "./store/TotalContext";

const Cart = ({ items }) => {
  return (
    <>
      <TotalContext.Consumer>
        {(total) => {
          return (
            <>
              <h1>cart component</h1>
              {console.log(items)}
              {items.map((item, index) => {
               
                return <li key={index}>{item.name}</li>
              })}
              Total :{total}
            </>
          );
        }}
      </TotalContext.Consumer>
    </>
  );
};

export { Cart };
