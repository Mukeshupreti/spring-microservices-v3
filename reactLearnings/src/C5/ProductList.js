import React, { useState } from "react";

const ProductList = (props) => {
  const [products, setProducts] = useState([
    { name: "apple", pcode: "1" },
    { name: "banana", pcode: "2" },
    { name: "oranage", pcode: "3" },
    { name: "grapes", pcode: "4" },
  ]);
  // This is other way of rendering unlike funtional component where you
  // have only one return as you can't use if else inside return jsx.

  // alternate solution use ternary opreator in jsx.
  if (props.isAdmin) {
    return products.map((element, index) => (
      <li key={index}>{element.name}</li>
    ));
  } else {
    return <h1 style={{color:"blue", background:"yellow"}}>no product available</h1>;
  }
};
// Ternary opeator
const ProductList2 = (props) => {
  const [products, setProducts] = useState([
    { name: "apple", pcode: "1" },
    { name: "banana", pcode: "2" },
    { name: "oranage", pcode: "3" },
    { name: "grapes", pcode: "4" },
  ]);
  return props.isAdmin ? (
    products.map((element, index) => <li key={index}>{element.name}</li>)
  ) : (
    <h1>no product available</h1>
  );
};
// JSX element
const ProductList3 = (props) => {
  const [products, setProducts] = useState([
    { name: "apple", pcode: "1" },
    { name: "banana", pcode: "2" },
    { name: "oranage", pcode: "3" },
    { name: "grapes", pcode: "4" },
  ]);
  // take jsx as element
  const prod = products.map((element, index) => (
    <li key={index}>{element.name}</li>
  ));

  return props.isAdmin ? prod : <h1>no product available</h1>;
};

const ProductList4 = (props) => {
  const [products, setProducts] = useState([
    { name: "apple", pcode: "1" },
    { name: "banana", pcode: "2" },
    { name: "oranage", pcode: "3" },
    { name: "grapes", pcode: "4" },
  ]);
  // take jsx as element
  const prod = products.map((element, index) => (
    <li key={index}>{element.name}</li>
  ));

  switch (props.isAdmin) {
    case true:
      return prod;
      break;
    case false:
      return <h1>No data found</h1>;
  }
};

const ProductList5 = (props) => {
  const [products, setProducts] = useState([
    { name: "apple", pcode: "1" },
    { name: "banana", pcode: "2" },
    { name: "oranage", pcode: "3" },
    { name: "grapes", pcode: "4" },
  ]);
  // take jsx as element
  const prod = products.map((element, index) => (
    <li key={index}>{element.name}</li>
  ));

  return (<>{props.isAdmin && prod}</>);
};

export { ProductList, ProductList2, ProductList3, ProductList4,ProductList5 };
