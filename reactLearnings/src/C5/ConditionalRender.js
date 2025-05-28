import React, { useState } from "react";
import { ProductList, ProductList2 ,ProductList3,ProductList4, ProductList5} from "./ProductList";
// if it is admin then show product list else show not product
const IfElseRendering = () => {
  const [admin, setAdmin] = useState(false);
  const handleAdmin = (e) => setAdmin(e.target.checked);
  return (
    <>
      <h1 className="example">Example 1 : If else redering example</h1>
      <div className="heading">
        {/* two way to covert into string */}
        <input type="checkbox" onChange={handleAdmin}></input>
        is Admin {admin.toString()} // {JSON.stringify(admin)}
        <hr></hr>
      </div>

      <ProductList isAdmin={admin}></ProductList>
    </>
  );
};

const TernaryOpRendering = () => {
  const [admin, setAdmin] = useState(false);
  const handleAdmin = (e) => setAdmin(e.target.checked);
  return (
    <>
      <h1 className="example">Example 2 : Ternary Operator redering example</h1>
      <div className="heading">
        <input type="checkbox" onChange={handleAdmin}></input>
        is Admin {admin.toString()}
        <hr></hr>
      </div>

      <ProductList2 isAdmin={admin}></ProductList2>
    </>
  );
};
// JSX element
const JSXElementRendering = () => {
  const [admin, setAdmin] = useState(false);
  const handleAdmin = (e) => setAdmin(e.target.checked);
  return (
    <>
      <h1 className="example">Example 3 : JSX Operator redering example</h1>
      <div className="heading">
        <input type="checkbox" onChange={handleAdmin}></input>
        is Admin {admin.toString()}
        <hr></hr>
      </div>

      <ProductList3 isAdmin={admin}></ProductList3>
    </>
  );
};


const SwitchCaseRendering = () => {
  const [admin, setAdmin] = useState(false);
  const handleAdmin = (e) => setAdmin(e.target.checked);
  return (
    <>
      <h1 className="example">Example 4 : Switch case redering example</h1>
      <div className="heading">
        <input type="checkbox" onChange={handleAdmin}></input>
        is Admin {admin.toString()}
        <hr></hr>
      </div>

      <ProductList4 isAdmin={admin}></ProductList4>
    </>
  );
};


const LogicalOperatorRendering = () => {
  const [admin, setAdmin] = useState(false);
  const handleAdmin = (e) => setAdmin(e.target.checked);
  return (
    <>
      <h1 className="example">Example 5 : Logical opearator redering example</h1>
      <div className="heading">
        <input type="checkbox" onChange={handleAdmin}></input>
        is Admin {admin.toString()}
        <hr></hr>
      </div>

      <ProductList5 isAdmin={admin}></ProductList5>
    </>
  );
};





export { LogicalOperatorRendering,SwitchCaseRendering,JSXElementRendering, TernaryOpRendering, IfElseRendering };
