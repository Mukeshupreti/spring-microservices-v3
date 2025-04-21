import React from "react";
import { useParams } from "react-router-dom";

const ProductDetails = () => {
   // useParam contains {key:value}
   // to extract value use destructure
   //  for eg {id} willl give value of the key passed
    const x= useParams();
    console.log("use Param" , x);
    const {id} =useParams();
  return (
    <>
      <h1 className="heading">ProductDetails Component :{id}</h1>
    </>
  );
};

export { ProductDetails };
