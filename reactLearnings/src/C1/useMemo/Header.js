import React from "react";

 function Header() {
  console.log("Header display");
  return (
    <>
      <h1 style={{color: "blueviolet",background:"white"}}> Header Display</h1>
    </>
  );
}
//export default Header
export default React.memo(Header)
