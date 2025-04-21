import React from "react";
import { Login } from "./CombineReducer&ActionConst/component/Login";
import { Product } from "./CombineReducer&ActionConst/component/Product";

import { Cart } from "./CombineReducer&ActionConst/component/Cart";
import {Total} from "./CombineReducer&ActionConst/component/Total"


const C10 = () => {
  return (<><div className="chapter"> chapter 11-Asynchronous Redux</div>
   <div >
        <Login></Login>
        <Product></Product>
        <Cart></Cart>
        <Total></Total>
      </div>
  
  </>
  );
};

export { C10 };



