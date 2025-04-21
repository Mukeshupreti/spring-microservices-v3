import React from "react";

import { PropsExV1, PropsExV2 } from "./PropsEx";
import { StateEx, StateExV2, StateExV3, StateExV4 } from "./StateEx";
import { ExternalStyle, InlineStyle } from "./StylingEx";
import ClassComp from "./ClassComp";
import { UseEffectNormal } from "./UseEffectTimer";
import { UseEffectWithDepedency } from "./UseEffectWithDependecy";
import UseRefClassComp from "./useRefEx/UseRefClassComp";
import UseRefunComp from "./useRefEx/UseRefFunctionalComp";



export default function C1() {
  return (
    <>
      <h1>Chepter one</h1>

      <h2>Notes : </h2>
      <ol>
        <li>Component name should be upper case</li>
      </ol>

      {/* <propsExV1 name="Atul" salary="3000$"></PropsEx> */}
      <h1 style={{ color: "blue", background: "yellow" }}>Property example </h1>
      <PropsExV1 name="Atul" salary="3000$"></PropsExV1>
      <PropsExV2 name="Rajesh" salary="3000$"></PropsExV2>
      <PropsExV2 name="Ravi" salary="3000$"></PropsExV2>
      <h1 style={{ color: "blue", background: "yellow" }}>State Example</h1>
      <StateEx></StateEx>
      <StateExV2></StateExV2>
      <StateExV3></StateExV3>
      <StateExV4></StateExV4>

      <h1 style={{ color: "blue", background: "yellow" }}>style example</h1>
      <InlineStyle></InlineStyle>
      <ExternalStyle></ExternalStyle>

      <h1 style={{ color: "blue", background: "yellow" }}>Class example</h1>

      <ClassComp></ClassComp>
      <h1 style={{ color: "blue", background: "yellow" }}>
        Use Effect Lifecycle hook for Funtional component
      </h1>
      <UseEffectNormal></UseEffectNormal>


      <h1 style={{ color: "blue", background: "yellow" }}>
      UseEffectWithDepedency
      </h1>
      <UseEffectWithDepedency></UseEffectWithDepedency>

      <h1 style={{ color: "blue", background: "yellow" }}>
      useRef with Class component
      </h1>
     <UseRefClassComp></UseRefClassComp>


     <h1 style={{ color: "blue", background: "yellow" }}>
      useRef with functional component
      </h1>
     <UseRefunComp></UseRefunComp>

    </>
  );
}
