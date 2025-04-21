import React from "react";

function Footer() {
  console.log("Footer display");
  return (
    <>
      <h1 style={{ color: "blueviolet", background: "white" }}>
        Footer Display
      </h1>
    </>
  );
}

//export default Footer
export default React.memo(Footer);
