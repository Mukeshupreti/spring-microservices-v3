import React from "react";

const User = ({user}) => {
  return (
    <>
      <div  className="user" key={user.index}>
       
        user: {user.name}
        email : {user.email}
      </div>
    </>
  );
};

export default User;
