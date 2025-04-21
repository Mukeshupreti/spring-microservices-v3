import React, { Component } from "react";

export  default  class  Header extends  Component {


    render() {

        return (

            <header className="mb-4">
                <h1 className="fw-bolder mb-1">Welcome to Blog Post!</h1>
                <div className="text-muted fst-italic mb-2">Posted on January 1, 2021 by Start
                    Bootstrap
                </div>
                <a className="badge bg-secondary text-decoration-none link-light" href="#!">Web
                    Design</a>
                <a className="badge bg-secondary text-decoration-none link-light"
                   href="#!">Freebies</a>
            </header>
        );
    }

}