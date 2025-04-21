import React, { useState } from "react";
import { Cart } from "./Cart";
import { TotalUseContext } from "./Total";
import { TotalContext } from "./store/TotalContext";

const ProductWithContextAPIUseconsumerHook = () => {
  const products = [
    { pName: "Apple", price: 20 },
    { pName: "Banana", price: 3 },
    { pName: "Orange", price: 10 },
    { pName: "Grapes", price: 8 },
  ];

  const [cart, setcart] = useState([]);
  const [total, setTotal] = useState(0);

  const handleOnChange = (e) => {
    /*   console.log("target:", e.target);
    console.log("target value:", e.target.value);
    console.log("target selected index:", e.target.selectedIndex);
    console.log(
      "selected value:",
      e.target.options[e.target.selectedIndex].text
    ); */
    let tcart = [...cart];
    tcart.push({
      name: e.target.options[e.target.selectedIndex].text,
      price: e.target.value,
    });
    setcart(tcart);

    setTotal(total + parseInt(e.target.value));
  };

  return (
    <>
      <h1 className="example">--------------Products--------------</h1>
      <select onChange={handleOnChange}>
        {products.map((product, index) => (
          <option key={index} value={product.price}>
            {product.pName} : {product.price}
          </option>
        ))}
      </select>
      {console.log("cart", cart)}
      {console.log("total", total)}
     {/*  //Step 2 : put inside all the component who need total  */}
      <TotalContext.Provider value={total}> 

        <Cart items={cart}></Cart>
        <TotalUseContext></TotalUseContext>
      </TotalContext.Provider>
    </>
  );
};

export { ProductWithContextAPIUseconsumerHook };
