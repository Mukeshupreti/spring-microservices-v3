import React from "react";
import { Product } from "./withoutContextAPI/Product";
import { ProductWithContextAPI } from "./withContextAPI/Product";
import { ProductWithContextAPIUseconsumerHook } from "./withContextAPIUseContexthook/Product";

const C8 = () => {
  return (
    <>
      <h1 className="chapter"> Chapter 8 context API </h1>
      <Product></Product>
       <h1 className="example"> with Context API</h1>
      <ProductWithContextAPI></ProductWithContextAPI>
      <h1 className="example"> with Context API only change is useContext Hook for reading total</h1>
      <ProductWithContextAPIUseconsumerHook></ProductWithContextAPIUseconsumerHook> 
    </>
  );
};

export default C8;
