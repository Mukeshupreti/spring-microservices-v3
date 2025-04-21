import React, { useState } from "react";
import { Cart } from "./Cart";
import { Total } from "./Total";

const Product = () => {
  const products = [
    {pName:'Apple',price:20},
    {pName:'Banana',price:3},
    {pName:'Orange',price:10},
    {pName:'Grapes',price:8}
  ];

  const [cart, setcart] = useState([]);
  const [total, setTotal] = useState(0);
// handle the drop down change event
  const handleOnChange = (e) => {
  /*   console.log("target:", e.target);
    console.log("target value:", e.target.value);
    console.log("target selected index:", e.target.selectedIndex);
    console.log(
      "selected value:",
      e.target.options[e.target.selectedIndex].text
    ); */
    let tcart=[...cart];
    tcart.push({
      name: e.target.options[e.target.selectedIndex].text,
      price: e.target.value
    })
    setcart(tcart);

    setTotal(total+parseInt(e.target.value));
  };

  return (
    <>
      <h1 className="example">--------------Products--------------</h1>
      {/* populate the  drop down with product */}
      <select onChange={handleOnChange}>
        {products.map((product, index) => (
          <option key={index} value={product.price}>
            {product.pName} : {product.price}
          </option>
        ))}
      </select>
      {console.log("cart",cart)}
      {console.log("total",total)}
      <Cart items={cart}></Cart>
      <Total sum={total}></Total>
    </>
  );
};

export { Product };
