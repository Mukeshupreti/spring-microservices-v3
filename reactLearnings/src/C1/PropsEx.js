import React from "react";

/* export default function PropsEx(props){

return(
<>
<h1 >name :{props.name}</h1>
<h2>salary:{props.salary}</h2>

</>


);

}
 */
// normal props access
const PropsExV1 = (props) => {
  
  return (
    <>
      <h1>PropsExV1 : Normal way</h1>
      <h1>name :{props.name}</h1>
      <h2>salary:{props.salary}</h2>
    </>
  );
};



//Destructruing props

const PropsExV2 = ({ name, salary }) => {
  return (
    <>
      <h1>PropsExV2 : object destruturing</h1>
      <h1>name :{name}</h1>
      <h2>salary:{salary}</h2>
    </>
  );
};
//Destructruing props
const PropsExV3 = (props) => {
  let {name,salary}=props;
  return (
    <>
      <h1>PropsExV1 : Normal way</h1>
      <h1>name :{name}</h1>
      <h2>salary:{salary}</h2>
    </>
  );
};


export { PropsExV1, PropsExV2,PropsExV3 };
