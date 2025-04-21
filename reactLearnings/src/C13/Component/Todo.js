import React from "react";
import useFetchApi from "./useFetchApi";

const Todos = () => {
  const [todos] = useFetchApi("https://jsonplaceholder.typicode.com/todos");

  return (
    <>
      {todos &&
        todos.map((todo) => {
          return (
            <div className="todo" key={todo.id}>
              userId: {todo.userId}
              title : {todo.title}
            </div>
          );
        })}
    </>
  );
};

export default Todos;
