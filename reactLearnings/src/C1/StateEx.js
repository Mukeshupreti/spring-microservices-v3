import React, { useState } from "react";
//Normay way
const StateEx = () => {
  //Note : use state is useful for funtional component only.
  //it hook
  const [counter, setCounter] = useState(0);
  //use state return array value (any value and its setter funtion)
  return (
    <>
      <h1>{counter}</h1>
      
      <button onClick={() => setCounter(counter + 1)}>increment counter</button>
    </>
  );
};




// Lazy initilization

const StateExV2 =() =>{

  //Expensive process
  const initialState =() =>{
    console.log("Expensive process",Date.now());
    return 0;
   }

  const [counter, setCounter] = useState(()=>initialState());
  // for primitive type   const [counter, setCounter] = useState(0); lazy initilization is not needed
//  useState(initialState())// useState is called everytime render so expesive funtion initialState() will call everytime load of page
//load

//  useState(()=>initialState()) //lazy initilization. only first time
// expesive proccess called not on every render when we change state

  return (
    <>
      <h2 style={{background:"green"}}>Lazy initilization</h2>
      <h1>{counter}</h1>
      <button onClick={() => setCounter(counter + 1)}>increment counter</button>
    </>
  );

}

// Function with parameter 


const StateExV3 = () => {
  
  const [counter, setCounter] = useState(0);
  const changeCounter =(operation)=>{
    console.log("funtion called");
    if(operation==='+'){
     setCounter(counter+1);
    }else{
     setCounter(counter-1);
    }

  }
/// ()=>changeCounter('+') ==>funtional expression : instead of
//  calling function return the funtion


  // NOte : funtion should parameter will be called like with
  // arrow funtion ; return statement not needed for single line
  // correct way onClick={()=>changeCounter('+')}==:

  // will not work : onClick={changeCounter('+')} // because '()' are
  // there on load of page this funtion is executed so instead of
  // calling function you should return the function

  // onClick == camel case in react  ; java script plane case : onclick
  return (
    <>
     <h2 style={{background:"green"}}>Function with Parameter</h2>
      <h1>{counter}</h1>
      
      <button onClick={()=>changeCounter('+')}>increment counter</button>
      <button onClick={() => changeCounter('-')}>decrement counter</button>
    </>
  );

};

// State with object litrals
// use of spreading operator and then update the value


const StateExV4 = () => {
  
  const [obj, setCounter] = useState(
    //object literal
    {
     counter:0,
     mFlag:true
    });
  const changeCounter =(operation)=>{
    let tc=obj.counter;
    console.log("funtion called");
    if(operation==='+'){
      tc++;
     // to change value inside object literal first use spread operator
     // the update value with ',' inside '{}' to get object value 
     setCounter({...obj,counter:tc});
    }else{
      tc--;
     setCounter({...obj,counter:tc});
    }

  }
  const handleToggle= ()=>{
    let flag=obj.mFlag;

    setCounter({...obj,mFlag:!flag});

  }

  return (
    <>
     <h2 style={{background:"green"}}>State with object literal</h2>
      <h1>{obj.counter}</h1>
      
      <button onClick={()=>changeCounter('+')}>increment counter</button>
      
      <button onClick={() => changeCounter('-')}>decrement counter</button>
       {/* this will not print due to Boolen */}
      <h2>Boolen value  : {obj.mFlag}</h2> 
      {/* to print Boolen use toString() */}
      <h2>Boolen value with to string :{obj.mFlag.toString()}</h2>
      <button onClick={handleToggle}>Toggle Function between increment and decrement</button>
    </>
  );

};


export  {StateEx,StateExV2,StateExV3,StateExV4}
