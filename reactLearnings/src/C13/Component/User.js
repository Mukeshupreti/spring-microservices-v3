import React from "react";
import useFetchApi from "./useFetchApi";

const User = () => {
  const [users] = useFetchApi("https://jsonplaceholder.typicode.com/users");

  return (
    <>
      {users &&
        users.map((user) => {
          return (
            <div className="user" key={user.index}>
              user: {user.name}
              email : {user.email}
            </div>
          );
        })}
    </>
  );
};

export default User;
