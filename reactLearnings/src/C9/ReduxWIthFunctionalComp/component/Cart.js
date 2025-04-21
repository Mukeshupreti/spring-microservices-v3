import React from "react";
import { useSelector,useDispatch } from "react-redux";

const Cart = () => {
  const selectedProducts = useSelector((state) => state.cart);
  const dispatch = useDispatch();
  const handleDelete = (index,price)=>{
    dispatch({type:'DELETE',payLoad:{index,price}});
  }

  return (
    <div className="customDiv">
      <h2>Cart Component</h2>
      <hr />
      <ul>
        {selectedProducts.map((product, index) => {
          return (
            // DELETE functionalality call dispatch action thorugh handle Delete
            <li key={index} onClick={()=>handleDelete(index,product.price)}>{product.pName} </li>
          );
        })}
      </ul>
    </div>
  );
};

export { Cart };
