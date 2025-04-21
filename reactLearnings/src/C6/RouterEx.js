import React, { useState } from "react";
import { Routes, Route, Link } from "react-router-dom";
import { InvalidProduct, Product, ProductV1, ProductV2, ProductV3 } from "./Product";
import Home from "./Home";
import About from "./About";
import { ProductDetails } from "./ProductDetails";

const RouterEx1 = () => {
  return (
    <>
      <h1 className="example"> Example 1: React router v1</h1>
      <ul>
        {/* 
            Link keep track of browser if url change it will
            call routes to render that url. This happens
            because of BrowerRouter which keep on trace of Navigation */}
        <li>
          {/* 
          to make home page as default page change 
          to="/home" ==> to="/"
          and in route change
          path="/home"  ==>  path="/" */}

          <Link to="/">Home</Link>
        </li>
        <li>
          <Link to="/about">About</Link>
        </li>
        <li>
          <Link to="/product">Product</Link>
        </li>
      </ul>
      <hr></hr>

      <Routes>
        <Route path="/" element={<Home />}></Route>
        <Route path="/about" element={<About />}></Route>
        <Route path="/product" element={<Product />}></Route>
      </Routes>
    </>
  );
};
// Added product submenu (with apple /bannaa,orgagnes etc) in ProudctV1
// in ProductV1 version when you click on submennu item eg :banna submenu disappear
// to fix this use subrouts which tell product have submenu (apple/bannan etc)
//<outlet> tag in ProductV2 to show product details appers when clicked on submenu
//item
const RouterUseParamEx = () => {
  return (
    <>
      <h1 className="example"> Example 2: React router with UseParam v1</h1>
      <ul>
        <li>
          <Link to="/">Home</Link>
        </li>
        <li>
          <Link to="/about">About</Link>
        </li>
        <li>
          <Link to="/productV1">ProductV1</Link>
        </li>
      </ul>
      <hr></hr>

      <Routes>
        <Route path="/" element={<Home />}></Route>
        <Route path="/about" element={<About />}></Route>
        <Route path="/productV1" element={<ProductV1 />}></Route>
        <Route path="/productV1/:id" element={<ProductDetails />} />
      </Routes>
    </>
  );
};

// in ProductV1 version when you click on submennu item eg :banna submenu disappear
// to fix this use subrouts which tell product have submenu (apple/bannan etc)
//<outlet> tag in ProductV2 to show product details appers when clicked on submenu
//item

const NestedRouterEx = () => {
  return (
    <>
      <h1 className="example">
        Example 3: Product have nested route like apple/bananna
      </h1>
      <ul>
        <li>
          <Link to="/">Home</Link>
        </li>
        <li>
          <Link to="/about">About</Link>
        </li>
        <li>
          <Link to="/productV2">Productv2</Link>
        </li>
      </ul>
      <hr></hr>

      <Routes>
        <Route path="/" element={<Home />}></Route>
        <Route path="/about" element={<About />}></Route>
        <Route path="/productV2" element={<ProductV2 />}>
          <Route path=":id" element={<ProductDetails />} />
          {/* //Nested routes for submenu */}
          {/*  for submenu of product put submenu(apple) route under parent(proudct) and change /productV2/:id => :id 
         and use outlet in productV2 where to display submenu item details */}
        </Route>
        {/* for any other path it is will show Invalid path url  */}
        <Route path="*" element={<InvalidProduct />} />
      </Routes>
    </>
  );
};

/// Ideally all the URL should be child of Base/Home Page to implement it index and indent all routes to
// base page/homepage
const IndexForParent = () => {
  return (
    <>
      <h1 className="example">
        Example 4: Indent and index to make all the routes as child of base url
      </h1>
      <ul>
        <li>
          <Link to="/">Home</Link>
        </li>
        <li>
          <Link to="/about">About</Link>
        </li>
        <li>
          <Link to="/productV2">Productv2</Link>
        </li>
      </ul>
      <hr></hr>

      <Routes>
       <Route path="/"> 
         {/* indent all the component including home as subroutes / child of one route 
         by default index property true mean Home Route will get path from parent 
         i.e it will get patth ="/" from parent */}
          <Route index element={<Home />}></Route>
          <Route path="/about" element={<About />}></Route>
          <Route path="/productV2" element={<ProductV2 />}>
            <Route path=":id" element={<ProductDetails />} />
          </Route>
          <Route path="*" element={<InvalidProduct/>} />
        </Route>
      </Routes>
    </>
  );
};
// created new Product3 Version to get price dynamically (like you get from api calls)
const DynamicStateEx = () => {

  return (
    <>
      <h1 className="example">
        Example 5: Dynamic state with useState in ProductV3
      </h1>
      <ul>
        <li>
          <Link to="/">Home</Link>
        </li>
        <li>
          <Link to="/about">About</Link>
        </li>
        <li>
          <Link to="/productV3">Productv3</Link>
        </li>
      </ul>
      <hr></hr>

      <Routes>
       <Route path="/"> 
          <Route index element={<Home />}></Route>
          <Route path="/about" element={<About />}></Route>
          <Route path="/productV3" element={<ProductV3/>}>
            <Route path=":id" element={<ProductDetails />} />
          </Route>
          <Route path="*" element={<InvalidProduct/>} />
        </Route>
      </Routes>
    </>
  );
};

export {DynamicStateEx, IndexForParent, RouterEx1, RouterUseParamEx, NestedRouterEx };
