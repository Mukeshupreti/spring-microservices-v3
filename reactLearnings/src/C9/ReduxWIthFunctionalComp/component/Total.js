import React from "react";
import { useSelector } from "react-redux";
const Total = () => {
  const total=useSelector(state=>state.total);
  return(
      <div className="customDiv">
           <h3>Total Component</h3>
           <hr/>
           <h2>Total : {total}</h2>
      </div>
  )
};

export { Total };
