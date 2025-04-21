import React, { useState } from "react";

const EventHandleV1 = () => {
  const getData = () => {
    console.log("EventHandleV1 :Function called");
  };
  return (
    <>
      <h1 className="example">Example 1: function call with parenthisis</h1>
      {/* this get data will call every time when page is refresh or load
        */}
      {/* this will not get called on click due to '()' as this getData not take any 
      arugument  */}
      <button onClick={getData()}> Get Data wrong way</button>
      {/* both below way is correct when you use '()' in funtion call */}
      <button onClick={getData}> Get Data correct way version1</button>
      {/* // this called function expression get {()=>getData()}*/}
      <button onClick={() => getData()}> Get Data correct way version2</button>
    </>
  );
};
// Synthetic Event is cross browser wrapper arround browser Native event so
// you dont need to worry about cross browser native event
// its automatically passed to every function for example in print function
// we are not paasing and event but print function accpeting event (sythetic event)
const SyntheticEvent = () => {
  const print = (e) => {
    console.log("SyntheticEvent :", e);
    console.log("SyntheticEvent target:", e.target);
    console.log("SyntheticEvent target HTML:", e.target.innerHTML);
  };
  return (
    <>
      <h1 className="example">Example 2: Synthetic Event</h1>
      <button onClick={print}>Print</button>
    </>
  );
};

const TextBoxEvent = () => {
  const [content, setContent] = useState();

  // assume getData not passing any paramenter
  // means getData(e) and getData() are same
  // i.e onChange Function we can see {getData}
  // not {getData()}
  const getData = (e) => {
    console.log("TextBoxEvent: ", e);
    console.log("TextBoxEvent:", e.target.value);
    setContent(e.target.value);
  };
  return (
    <>
      <h1 className="example">Example 3: Text box event</h1>
      <h1 className="heading">content : {content}</h1>
      <input type="text" onChange={getData}></input>
    </>
  );
};

const PreventDefaultEx = () => {
  // Default Behavior of form whenever you click submit your text box will be empty.
  // to prevent this you will call preventDeault on synthectic event
  // after prevent behavior text box value remain in text box after submit
  const getData = (e) => {
    e.preventDefault();
    console.log("form subbmission");
  };

  return (
    <>
      <h1 className="example"> Example 4: prevent default behaviour of form</h1>
      <form onSubmit={getData}>
        <input type="text"></input>
        <input type="text"></input>
        <button type="submit">Submit</button>
      </form>
    </>
  );
};
// handle all the state in different state object
const MultistateWay1 = () => {
  const [firstName, setFirstName] = useState();
  const [lastName, setLastName] = useState();
  const [mobile, setMobile] = useState();
  const [data, setData] = useState();

  const handleFirstname = (e) => {
    setFirstName(e.target.value);
  };

  const handleLastname = (e) => {
    setLastName(e.target.value);
  };

  const handleMobile = (e) => {
    setMobile(e.target.value);
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    setData(firstName + "," + lastName + " ," + mobile);
  };
  return (
    <>
      <h1 className="example">Example 4 :Form MultistateWay1 </h1>
      <form onSubmit={handleSubmit}>
        <input
          type="input"
          onChange={handleFirstname}
          placeholder="Firstname"
        ></input>
        <input
          type="input"
          onChange={handleLastname}
          placeholder="LastName"
        ></input>
        <input
          type="input"
          onChange={handleMobile}
          placeholder="Mobile"
        ></input>
        <button type="submit">submit</button>
        <h1 className="heading">submitted data :{data}</h1>
      </form>
    </>
  );
};

// handle all the states in one object
const MultistateWayManageInOneObject = () => {
  const [personalInfo, setpersonalInfo] = useState({
    firstName: "",
    lastName: "",
    mobile: "",
  });

  const setFirstname = (e) => {
    // setPersonalInfo(firstName:e.target.value) wrong way
    // correct way below :
    //why ? when you try to update an object litral,
    // you have to make sure the previouse values is there
    // and then update
    setpersonalInfo({ ...personalInfo, firstName: e.target.value });
  };
  const setLastName = (e) => {
    setpersonalInfo({ ...personalInfo, lastName: e.target.value });
  };

  const setMobile = (e) => {
    setpersonalInfo({ ...personalInfo, mobile: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log(JSON.stringify(personalInfo));
  };
  return (
    <>
      <h1 className="example">Example 5 :Form MultistateWay2 </h1>
      <form onSubmit={handleSubmit}>
        <input
          type="input"
          onChange={setFirstname}
          placeholder="Firstname"
        ></input>
        <input
          type="input"
          onChange={setLastName}
          placeholder="LastName"
        ></input>
        <input type="input" onChange={setMobile} placeholder="Mobile"></input>
        <button type="submit">submit</button>
        <h1 className="heading">
          submitted data :{JSON.stringify(personalInfo)}
        </h1>
      </form>
    </>
  );
};

// handle all the states in one object with dynamic key with one handlers
// for all the input key
const OneHandlerForMultiState = () => {
  const [personalInfo, setpersonalInfo] = useState({
    firstName: "",
    lastName: "",
    mobile: "",
  });
  // add dynamic key e.target.name and create one handler method
  const setOneHandler = (e) => {
    setpersonalInfo({ ...personalInfo, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log(JSON.stringify(personalInfo));
  };
  return (
    <>
      <h1 className="example">
        Example 6 :Form MultistateWay3 with dynamic key one handlers for all
        input{" "}
      </h1>
      <form onSubmit={handleSubmit}>
        <input
          type="input"
          //add Name field same as object key like firstName
          name="firstName"
          onChange={setOneHandler}
          placeholder="Firstname"
        ></input>
        <input
          type="input"
          //   add Name field same as object key like lastName
          name="lastName"
          onChange={setOneHandler}
          placeholder="LastName"
        ></input>
        <input
          type="input"
          onChange={setOneHandler}
          placeholder="Mobile"
          //   //add Name field same as object key like mobile
          name="mobile"
        ></input>
        <button type="submit">submit</button>
        <h1 className="heading">
          submitted data :{JSON.stringify(personalInfo)}
        </h1>
      </form>
    </>
  );
};

const OneHandlerwithFunctionalUpdateBestway = () => {
  const [personalInfo, setpersonalInfo] = useState({
    firstName: "",
    lastName: "",
    mobile: "",
  });
  // add dynamic key e.target.name and create one handler method
  const setOneHandler = (e) => {
    //use set State
    setpersonalInfo((prevState) => {
      return {
        ...prevState,
        [e.target.name]: e.target.value,
      };
    });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log(JSON.stringify(personalInfo));
  };
  return (
    <>
      <h1 className="example">
        Example 7 :use state Form MultistateWay3 with dynamic key one handlers
        for all input{" "}
      </h1>
      <form onSubmit={handleSubmit}>
        <input
          type="input"
          //add Name field same as object key like firstName
          name="firstName"
          onChange={setOneHandler}
          placeholder="Firstname"
        ></input>
        <input
          type="input"
          //   add Name field same as object key like lastName
          name="lastName"
          onChange={setOneHandler}
          placeholder="LastName"
        ></input>
        <input
          type="input"
          onChange={setOneHandler}
          placeholder="Mobile"
          //   //add Name field same as object key like mobile
          name="mobile"
        ></input>
        <button type="submit">submit</button>
        <h1 className="heading">
          submitted data :{JSON.stringify(personalInfo)}
        </h1>
      </form>
    </>
  );
};

export {
  OneHandlerwithFunctionalUpdateBestway,
  OneHandlerForMultiState,
  MultistateWayManageInOneObject,
  MultistateWay1,
  EventHandleV1,
  SyntheticEvent,
  TextBoxEvent,
  PreventDefaultEx,
};
