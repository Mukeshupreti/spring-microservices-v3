import React from "react";

const PropsEx1 = () => {
  let product = {
    pcode: 123,
    pName: "xyz",
  };
  return (
    <>
      {/* any calculation inside {} */}
      <DemoComponent xyx={1 + 4}></DemoComponent>
      {/* any funtion call can be places in {} */}
      <DemoComponent xyx={new Date().getFullYear()}></DemoComponent>
      {/* any string literal with our without {} both below exmaple same */}
      <DemoComponent xyx={"String literal version1"}></DemoComponent>
      <DemoComponent xyx="String literal version2"></DemoComponent>
      <DemoComponent xyx="String literal version 3"></DemoComponent>
      {/* if you not pass any value in props that default value will be print true. */}

      <DemoComponent xyx></DemoComponent>
      {/* passing complete object literal as props using spread attribute */}
      <DemoComponent1 {...product}></DemoComponent1>
       {/* Tag value will be passed as childers in props */}
      <DemoComponent2 value="5">TagValue</DemoComponent2>

      <DemoComponent3 value="6">
        {/* you can also pass html elements as Tag content : this is also called */}
        {/* higher order component ; a component have other component */}
        <div>
          <input type="text" />
          <button> click me </button>
        </div>
      </DemoComponent3>
    </>
  );
};

const DemoComponent = (props) => {
  return (
    <>
      This is props object :{JSON.stringify(props)} 
      <h1>value :{props.xyx} </h1>
    </>
  );
};

const DemoComponent1 = (props) => {
  return (
    <>
    DemoComponent1:  This is props object :{JSON.stringify(props)}
      <h1>
        pcode :{props.pcode} : pName {props.pName}
      </h1>
    </>
  );
};

const DemoComponent2 = (props) => {
  return (
    <>
      DemoComponent2 :This is props object :{JSON.stringify(props)}
      <h1>
        value :{props.value} DemoContent : {props.children}
      </h1>
    </>
  );
};

const DemoComponent3 = (props) => {

  return <> DemoComponent3 :{props.children}</>;
};

export default PropsEx1;
