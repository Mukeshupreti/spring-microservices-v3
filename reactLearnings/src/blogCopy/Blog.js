import React, {Component} from "react";
import Navbar from "./Navbar";
import Footer from "./Footer";
import ContainerComponent from "./ContainerComponent";




export default class Blog extends Component {

    render() {

        return(
           <div>
               {/*<h1>Here is blog site</h1>*/}
               {/* break down code to Navbar*/}
               <Navbar></Navbar>

               {/* break down code to ContainerComponent*/}
               <ContainerComponent/>

               {/*Break down to footer*/}
               <Footer/>


           </div>

        );
    }


}