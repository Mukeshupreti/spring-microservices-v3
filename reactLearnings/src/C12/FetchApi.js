import React, { useState } from "react";
import User from "./User";
import TODO from "./Todo";
import Error from "./Error";

const FetchApi = () => {
  const [todos, setTodos] = useState([]);
  const [users, setUsers] = useState([]);
  const [toggle, setToggle] = useState(false);
  const [errorFlag, setErrorFlag] = useState(false);
  // Get ALL USER from sample web side
  const getUser = () => {
    fetch("https://jsonplaceholder.typicode.com/users")
      .then((respones) => respones.json())
      .then((json) => setUsers(json));
    setToggle(true);
  };

  const showUser = users.map((user) => {
    return <User user={user}></User>;
  });

  const showtTodos = todos.map((todo) => {
    return <TODO todo={todo}></TODO>;
  });
  // Get ALL TODOS from sample web side
  const getTodos = () => {
    fetch("https://jsonplaceholder.typicode.com/todos")
      .then((response) => response.json())
      .then((json) => setTodos(json));

    setToggle(false);
  };

  const getException = () => {
    fetch("https://jsonplaceholder.typicode.com/user") // wrong url to show error handling
      .then((response) => {
        if (response.ok) {
          return response.json();
        } else {

          /// Flow step 1
          // This code will be executed as url is wrong
          // Manually we have to throw error as Feach API dont show any error code or
          // error
          setErrorFlag(true);
          // we are making error flag true to error componet will get printed at line 62
          throw new Error();
        }
      })
      .then((json) => setUsers(json))
      .catch((error) => {
        //Flow Step 2
        console.log("error object ", error);
        // setErrorFlag(true); not require as fetch API not throw specfic error or error code
      }); ///
    setToggle(true);
  };

  console.log("error", errorFlag);
  // this will render the error page once url is wrong or any other error
  if (errorFlag) {
    return <Error></Error>;
  }
  // this return will not excecute in case of error
  return (
    <>
      <h1 className="example">Fetch API example</h1>
      <button onClick={getUser}> Users</button>
      <button onClick={getTodos}>Todos</button>
      <button onClick={getException}>TODO with Exception</button>
      {toggle ? showUser : showtTodos}
    </>
  );
};

export { FetchApi };
