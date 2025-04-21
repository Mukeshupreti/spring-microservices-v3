import React from "react";
import { StringRenderV1,StringRenderV2,StringRenderV3} from "./StringRendering";

const C2 = () => {
  return (
  <>
   <h1 style={{background: "green"}}>Example1</h1>
  <StringRenderV1></StringRenderV1> 
  
  <h1 style={{background: "green"}}>Example2</h1>
  <StringRenderV2></StringRenderV2>

  <h1 style={{background: "green"}}>Example3</h1>
  <StringRenderV3></StringRenderV3>

  </>
  
  );
};

export default C2;
