import React from "react";

const Todos = ({todo}) => {
  return (
    <>
    {console.log("todo" ,todo,todo.id)}
   
      <div   className="todo" key={todo.id}>
      userId: {todo.userId}
      title : {todo.title}
      </div>
    </>
  );
};

export default Todos;
