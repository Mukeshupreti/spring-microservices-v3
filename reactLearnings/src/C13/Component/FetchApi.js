import React, { useState } from "react";
import User from "./User";
import Todo from "./Todo";

const FetchApiWithCustomHook = () => {
  const [flag, setFlag] = useState(false);

  return (
    <>
      <h1 className="example">Fetch API example with Custom hook</h1>
      <button onClick={() => setFlag(true)}> Users</button>
      <button onClick={() => setFlag(false)}>Todos</button>
      {flag ? <User /> :<Todo />}
    </>
  );
};

export { FetchApiWithCustomHook };
