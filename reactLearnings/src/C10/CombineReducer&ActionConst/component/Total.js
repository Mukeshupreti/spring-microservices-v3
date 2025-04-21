import React from "react";
import { useSelector } from "react-redux";
const Total = () => {
  const total=useSelector(state=>state.pr.total);
  const loginUser=useSelector((state)=>state.lr.loggedInUser);
  return(
      <div className="customDiv">
           <h3>Total Component</h3>
           <hr/>
           <h2>Total : {total}</h2>
           {loginUser}
      </div>
  )
};

export { Total };
