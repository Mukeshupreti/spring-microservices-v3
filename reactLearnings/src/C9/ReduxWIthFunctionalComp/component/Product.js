import React from "react";
import { useSelector, useDispatch } from "react-redux";

const Product = () => {
  // get products using useSelector from store
  const products = useSelector((store) => store.products);
  // get Dipatche method reference to dispatch
  const dispatch = useDispatch();
  const handleOnChange = (e) => {
    let pName = e.target.options[e.target.selectedIndex].text;
    let price = e.target.value;
    let productPayload = { pName, price };
    console.log("productname", pName, price);
    // it take json with two parameter
    // 1st-action to be callled in reducer defined in product store
    //2nd- payload to pass when action happened
    dispatch({ type: 'PURCHASE', payload: productPayload });
  };

  return (
    <div className="customDiv">
      <h2>Purchase Component</h2>
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
    </div>
  );
};

export { Product };
