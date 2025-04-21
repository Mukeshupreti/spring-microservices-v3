import React from "react";
import { Product } from "./ReduxWIthFunctionalComp/component/Product";
import { Cart } from "./ReduxWIthFunctionalComp/component/Cart";
import { Total } from "./ReduxWIthFunctionalComp/component/Total";
import {Login} from "./CombineReducer&ActionConst/component/Login"
import ProductCl from "./ReduxwithClassComp/component/ProductCl";

const C9 = () => {
  return (
    <>
      <div >
        <Login></Login>
        <Product></Product>
        <ProductCl></ProductCl>
        <Cart></Cart>
        <Total></Total>
      </div>
    </>
  );
};

export { C9 };
