

import React from "react";

const Card = () => {
return (
<>  ## react fragment no parent div is required
<h1> hello this is card application</h1>
<button>Add task </button>
</>
);
};

export default Card;
---------------------------
**Java script Basic**

Section 2 JavaScript ES6 Summary
Section 2 - JavaScript ES6 Summary


Var vs Let vs Const
Var, Let and Const these three keywords are used to define variables in JavaScript. Let and const are the ES6 features which JavaScript introduce lately.

Var is the functional scope variable - which means we can use variable that declare with var is accessible in whole function.

But let and const are the block scope variables - which means we can only use them in that particular code block, in which they are defined.



Arrow Function
Arrow function is the another way to define function. By using arrow function syntax we can define JavaScript functions more easily.

// Defining function using function keyword
function sayHello() {
console.log("Hello JavaScript World!");
}

// Defining function using arrow function
const sayHello = () => {
console.log("Hello JavaScript World!");
}


Accessing the objects
First of all, object is collection of similar type of data and storing them in key value pair.

There are two ways to access the objects properties:

const user = {
name: "Harley",
email: "harley07@gmail.com",
};

console.log(user.email); // Output: harley07@gmail.com
console.log(user["email"]); // Output: harley07@gmail.com


Object Destructuring
By using object destructuring, we can get properties as variables in just one line.\

const user = {
name: "Sam",
email: "samEmail@gmail.com",
country: "US",
};

// const name = user.name;
// const email = user.email;
// const country = user.country;

const { name: userName, email, country } = user;

console.log(userName, email, country);


Array .map method
In react, .map method is used to display elements in our web-page and It will always returns a new array. So here is the example for that. We have list of products and we want to display them on our web-page.

In map method, we have to pass callback function which runs for each item and we can get that each item value in first parameter.

Now whatever we return from our call back function, it will add in new array.

const products = ["Product1", "Product2", "Product3"];

const displayItems = products.map((product) => `<li>${product}</li>`);

console.log(displayItems); // Output: ["<li>Product1</li>", "<li>Product2</li>", "<li>Product3</li>"]


Array .filter method
Filter method is used to filter data from array and also it will return a new array.

In filter method we pass function as argument and in that function we have to pass condition. Now which element pass that condition only that element will added in the new array.

const ages = [5, 23, 14, 30, 21];

console.log(ages); // Output: [5, 23, 14, 30, 21]

const adults = ages.filter((age) => age >= 18);

console.log(adults); // Output: [23, 30, 21]


Spread operator (…)
Spread operator is used to get all items from array/object. Let’s see with example.

const arr1 = [1, 2, 3, 4];
const arr2 = [7, 8, 9, 10];
const arr3 = [5, 6];

const numbers = [...arr1, 5, 6, ...arr2];
console.log(numbers); // Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
In this example, we get all arr1 and arr2 items using spread operator and add them in our new array which is numbers array.

In simple words, …arr1 means we get 1, 2, 3, 4

We can also use this spread operator in objects for getting the objects values.



Ternary Operator
Ternary operator also known as conditional operator which is the shortcut way to write if else condition.

const marks = 30;
const result = marks > 35 ? "Pass" : "Fail";

console.log(result); // Output: "Fail"

//syntax - condition ? trueExpression : falseExpression


Modules
Module is a file that contains code to perform specific task. It can contain variables, objects, functions and so on.

Imagine we have 5 features in single file, then we can divide each feature in single file called as module and then use them where we need it.

Now to use function in other modules, we need to export that function from that module with export keyword.

// post.jsx
export function post() {
console.log("This is post");
}

// feed.jsx
import { post } from "./post";

export function feed() {
console.log("This is feed");
post();
post();
post();
}

// main.jsx
import { feed } from "./feed";

feed();
Now we have another method to export function or variable from our module which is by using export default

Mostly, we will use export our main function of our module as default export. The difference is only in import statement.




**Reaact basic concepts**


Section 3 Summary - React Basics Concepts
Creating component
Component is Reusable piece of code that used to define certain part of user interface.

Think of a React component as a small, self-contained piece of code that describes how a part of a website or application should look and behave.

Here is the basic structure of react component:

import React from "react";

const Card = () => {
return <div>Card Component</div>;
};

export default Card;


JSX and Babel
JSX stands for “JavaScript XML” and it is code in which we can write HTML and JavaScript code together. This code looks very similar to the HTML markup.

import React from "react";

const Card = () => {
const name = "Code Bless You!";
return <h1>Name: {name}</h1>;  // This is jsx code
};

export default Card;
Now this JSX code, browser can not understand, so we have to covert this code into vanilla JavaScript code and for that React use babel library.

You can paste this code in to babel.io website and you can see it’s vanilla JavaScript code.

So we can easily write JSX code in our file and babel will convert that code in to JavaScript code that browsers can understand.

Article - https://reactjs.org/blog/2020/09/22/introducing-the-new-jsx-transform.html



Adding multiple elements
So for adding multiple elements in react component, we have to wrap them with one parent element. Because we know in babel our code convert in React JSX function and that function only add one element in its first argument.

There are 2 solutions for that:

We can wrap our elements with any one parent element.

import React from "react";

const Card = () => {
return (
<div>
<h1>This is Card Component</h1>
<button>Add new task</button>
</div>
);
};

export default Card;
We can use React.Fragement component for wrapping them.

import React from "react";

const Card = () => {
return (
<React.Fragment>
<h1>This is Card Component</h1>
<button>Add new task</button>
</React.Fragment>
);
};

export default Card;
or we can use this also

import React from "react";

const Card = () => {
return (
<>
<h1>This is Card Component</h1>
<button>Add new task</button>
</>
);
};

export default Card;
Adding JavaScript expression in to JSX
Now to add JavaScript expression in to JSX, we just need to add curly brackets and inside this we can add JavaScript expression.

import React from "react";

const Card = () => {
const tasks = 5;
return (
<>
<h1>Total Tasks: {tasks}</h1>
<button>Add new task</button>
</>
);
};

export default Card;


Adding attributes and events in JSX
In JSX, we can add attribute/events same as we add attributes/events in HTML. But some attributes are different.

For example, for adding class to our element, we have to use className attribute and also for defining inline style, we have to pass style object in style attribute.



State
When we change our normal variable value, that value change will not happen on our web page. So for reflecting that change on our DOM, we have to make our variable as state variable.

In simple words, if we define our variable as state variable, then react will watch that variable and if its value change, then react will reflect that change immediately.

So for defining state variable we have to use useState hook.



What are hooks?
hooks in React are functions that allow us to add state and other React features to functional components.

Before hooks were introduced, state and other features could only be used in class components. However, with hooks, you can use these features directly in functional components, making them more powerful and versatile.



useState Hook
useState is used to create state variables in functional components. So to use the useState hook we need to first import that and use it inside the function component.

We pass any type of data - Like Boolean, number, text, object, array anything. This useState hook returns array with two items. The first one is its current value and the second one is the function for updating that value.

import React, { useState } from "react";

const Card = () => {
const [count, setCount] = useState(5);
const handleClick = () => {
setCount(count + 1);
};
return (
<>
<h1>Total Counts: {count}</h1>
<button onClick={handleClick}>Add new task</button>
</>
);
};

export default Card;
We can also use useState hook, for handling inputs. Just we have to pass our set function in onChange event.

import React, { useState } from "react";

const Card = () => {
const [input, setInput] = useState("");
const handleChange = (e) => {
setInput(e.target.value);
};
return (
<>
<input type='text' onChange={handleChange} />
<h1>Input: {input}</h1>
</>
);
};

export default Card;


Mapping list items
As we see in Section 2, we will use map method to display the list of items in react. This map method is very useful.

Always remember to add key attribute for returning element and pass unique value in it. That will help react to quickly identified which element gets changed.

import React from "react";

const Card = () => {
const products = ["Product1", "Product2", "Product3"];
return (
<>
<ul>
{products.map((product) => (
<li key={product}>{product}</li>
))}
</ul>
</>
);
};

export default Card;



