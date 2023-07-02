import React from 'react';
import './App.css';
import Navbar from "./components/navbar/Navbar";
import {Route, Routes} from "react-router-dom";
import Gallery from "./components/gallary/Home";
import AdForm from "./components/gallary/AdForm";
import Home from "./app/page";

export default function App() {

    return (
        <html lang="en">
            <body>
                <Navbar />
            <div className="pb-20 pt-28">
                <Routes>
                    <Route path={"/home"} element ={<Home/>}/>
                    <Route path={"/adding"} element ={<AdForm/>}/>
                </Routes>
            </div>
            </body>
        </html>
    );
}


