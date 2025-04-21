import React from "react";
import { Login } from "./Login";
import { Product } from "./Product";

import { Cart } from "./Cart";
import {Total} from "./Total"

const C92 = () => {
  return (
    <>
      <div >
        <Login></Login>
        <Product></Product>
        <Cart></Cart>
        <Total></Total>
      </div>
    </>
  );
};

export { C92 };