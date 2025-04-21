import React from "react";
import { useSelector, useDispatch } from "react-redux";
//import { PURCHASE } from "./store/action";
import { purchase } from "./store/ProductSlice";

const Product = () => {
  // get products using useSelector from store
  const products = useSelector((state) => state.pr.products);
  // get Dipatche method reference to dispatch
  const dispatch = useDispatch();

  const loginUser=useSelector((state)=>state.lr.loggedInUser);
  console.log("loginUser-->",loginUser);
  const handleOnChange = (e) => {
    let pName = e.target.options[e.target.selectedIndex].text;
    let price = e.target.value;
    let productPayload = { pName, price };
   
   // dispatch({ type: PURCHASE, payload: productPayload });
   // productPalyload can be accessed in slice is action.payload
     dispatch(purchase(productPayload));

  };

  return (
    <div className="customDiv">
      <h2>Purchase Component</h2>
      helllo
      <select onChange={handleOnChange}>
        {products.map((product, index) => {
          return (
            <option value={product.price} key={index}>
              {product.pName}-{product.price}
            </option>
          );
        })}
      </select>

      <hr />
     hello: {loginUser}
    </div>
  );
};

export { Product };
