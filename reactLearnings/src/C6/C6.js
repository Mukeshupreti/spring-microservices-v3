import React from "react";
import  { DynamicStateEx, IndexForParent, NestedRouterEx,RouterEx1,RouterUseParamEx } from "./RouterEx";

const C6 = () => {
  return (
    <>
      <h1 className="chapter"> Chapter 6 React Router ,SPA version 6 </h1>
      <RouterEx1></RouterEx1> 
      <RouterUseParamEx></RouterUseParamEx>
      <NestedRouterEx></NestedRouterEx>
      <IndexForParent></IndexForParent>
      <DynamicStateEx></DynamicStateEx>
    </>
  );
};

export default C6;
