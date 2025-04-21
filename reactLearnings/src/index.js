import React from 'react';
import ReactDOM from 'react-dom';
import Home from "./router/Home";
import Contact from "./router/Contact";
import App from './App';
import './index.css';
import {BrowserRouter} from "react-router-dom"
/*
for below project uncomment below line
aboutProps
basic
blogCopy
courseSales
Timer
*/




ReactDOM.render(
 <BrowserRouter>
  <App />
  </BrowserRouter>,
  document.getElementById('root')
);





/*for Router */
/*


import  {
    BrowserRouter as Router,
    Route,
    Routes,
    Link
} from 'react-router-dom'


ReactDOM.render(<Router>
<div>
<ul>
<li><Link to ="/">Home</Link></li>
<li><Link to ="/contact">Contact</Link></li>

</ul>
    <hr/>
    <Routes>
        <Route exact path ="/" element={<Home></Home>}/>
        <Route  path ="/contact" element={<Contact></Contact>}/>
    </Routes>

</div>
</Router>
    ,
    document.getElementById('root'));
*/
