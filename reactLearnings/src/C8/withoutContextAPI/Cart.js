import React from "react";

const Cart = ({items}) => {
  return (
    <>
      <h1>cart component</h1>
      {console.log(items)}
      {items.map((item, index) => {
        //you must return from map othersise notthing will printed
       return (<li key={index}>
          {item.name}
        </li>)
      })}
    </>
  );
};

export { Cart };
