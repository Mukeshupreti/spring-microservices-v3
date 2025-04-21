import React from "react";
import { Login } from "./CombineReducer&ActionConst/component/Login";
import { Product } from "./CombineReducer&ActionConst/component/Product";

import { Cart } from "./CombineReducer&ActionConst/component/Cart";
import {Total} from "./CombineReducer&ActionConst/component/Total"

const C11 = () => {
  return (
    <>
      <div className="example">Chapter 11 : Redux toolkit(RTK) :Mordern redux </div>
      <>
      <div >
        <Login></Login>
        <Product></Product>
        <Cart></Cart>
        <Total></Total>
      </div>
    </>
    </>
  );
};

export { C11 };
