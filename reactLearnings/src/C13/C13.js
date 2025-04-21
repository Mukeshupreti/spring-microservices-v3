import React from "react";
import { WithOutCustomHook } from "./WithoutCustomHookEx1";
import {ContainerEx1} from "./CustomHookEx1"
import { FetchApiWithCustomHook } from "./Component/FetchApi";
const C13 = () => {
  return (
    <>
    <h1 className="chapter">
      Chapter 13 Custom hook : called Global Function
    </h1>
    <WithOutCustomHook/>
    <ContainerEx1></ContainerEx1>
    <FetchApiWithCustomHook></FetchApiWithCustomHook>
    </>
  )

    
};

export default C13;
