import React from "react";

function ChangeState(props) {
  console.log("-----------------------");
  //VV Important to print props outside of tender method you dont need {} unlike in jSx
  console.log(props.log);
  console.log("----------END-------------");

  return (
    <>
      <button onClick={props.click}>{props.caption}</button>
    </>
  );
}

//export default ChangeState
export default React.memo(ChangeState);
