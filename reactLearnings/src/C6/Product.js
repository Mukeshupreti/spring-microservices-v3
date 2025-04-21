import React, { useState } from "react";
import { Link, Outlet } from "react-router-dom";

const Product = () => {
  return <>I am home Product</>;
};

const ProductV1 = () => {
  return (
    <>
      <ul>
        <li>
          <Link to="/productV1/1">apple</Link>
        </li>
        <li>
          <Link to="/productV1/2">bananna</Link>
        </li>
        <li>
          <Link to="/productV1/3">grapes</Link>
        </li>
        <li>
          <Link to="/productV1/4">Oranges</Link>
        </li>
      </ul>
      I am home ProductV1
    </>
  );
};

const ProductV2 = () => {
  return (
    <>
      <ul>
        <li>
          <Link to="/productV2/1">apple</Link>
        </li>
        <li>
          <Link to="/productV2/2">bananna</Link>
        </li>
        <li>
          <Link to="/productV2/3">grapes</Link>
        </li>
        <li>
          <Link to="/productV2/4">Oranges</Link>
        </li>
      </ul>
      I am home ProductV2
      <Outlet /> 
      {/* using outlet will not disapper fruit menu which was problem in productV1.
      and outlet will replace by productDetail component */}
    </>
  );
};

const InvalidProduct = () => {
  return (
    <>
      <h1 className="heading"> Invalid URL :404</h1>
    </>
  );
};

const ProductV3 = () => {
  const [products, setProducts] = useState([
    { id: "1", name: "apple", price: "50" },
    { id: "2", name: "banana", price: "50" },
    { id: "3", name: "oragnes", price: "50" },
    { id: "4", name: "kiwi", price: "50" },
  ]);
  return (
    <>
      <ul>
        {products.map((prod, index) => {
          return (
            <li key={index}>
              {/* "`` keyboard beside 1 are required to execute dynamic expression" */}
              <Link to={`/productV3/${prod.id}`}>{prod.name}</Link>
            </li>
          )
        })}
      </ul>
      I am home ProductV2
      <Outlet />
    </>
  );
};

export { ProductV3, ProductV2, ProductV1, Product, InvalidProduct };
