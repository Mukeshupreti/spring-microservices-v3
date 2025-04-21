import React, { useState } from "react";
// show fruits as list
//
const StringRenderV1 = () => {
  const temp = ["Apple", "Banana", "Grapes", "Oranges"];
  const [fruits, setFruits] = useState(temp);

  return (
    <>
      {/* // here we return html
 // but if you want to execute java script content execute it "{}"" */}

      <h1>{fruits}</h1>
      {fruits.map((fruit, index) => {
        return (
          <li key={index}>
            {/* // key is required as it require for 
          rendering and idenitfying element in dom tree */}
            {/* //inside html if you want to print js content use "{}" */}
            {fruit}
          </li>
        );
      })}
    </>
  );
};

const StringRenderV2 = () => {
  const temp = ["Apple", "Banana", "Grapes", "Oranges"];
  const [fruits, setFruits] = useState(temp);

  return (
    <>
      {/* here I have mad separte List component to reder it to look better */}
      {fruits.map((fruit, index) => {
        return <ListItem key={index} x={fruit}></ListItem>;
      })}
    </>
  );
};

const ListItem = (props) => {
  return <li>{props.x}</li>;
};

const StringRenderV3 = () => {
    const temp = ["Apple", "Banana", "Grapes", "Oranges"];
    const [fruits, setFruits] = useState(temp);
    // take complet jsx out and print in render
    let fruitList=(fruits.map((fruit, index) => {
        return <ListItem key={index} x={fruit}></ListItem>;
      }))
    return (
      <>
        {/* here I have made separte List component to reder it to look better */}
        {fruitList}
      </>
    );
  };



export { StringRenderV1, StringRenderV2 ,StringRenderV3};
