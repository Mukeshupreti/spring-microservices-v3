import React from "react";
import {
  IfElseRendering,
  JSXElementRendering,
  LogicalOperatorRendering,
  SwitchCaseRendering,
  TernaryOpRendering,
} from "./ConditionalRender";
const C5 = () => {
  return (
    <>
      <h1 className="chapter"> Chapter 5 Conditional Rendering</h1>
      <IfElseRendering></IfElseRendering>
      <TernaryOpRendering></TernaryOpRendering>
      <JSXElementRendering></JSXElementRendering>
      <SwitchCaseRendering></SwitchCaseRendering>
      <LogicalOperatorRendering></LogicalOperatorRendering>

    </>
  );
};

export default C5;
