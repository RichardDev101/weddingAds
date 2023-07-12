import React from 'react';
import './App.css';
import Navbar from "./components/navbar/Navbar";
import {Route, Routes} from "react-router-dom";
import AdForm from "./components/gallary/AdForm";
import Home from "./components/gallary/Home";
import DetailPage from "./components/detailpage/DetailPage";


export default function App() {

    return (
        <html lang="en">
            <body>
                <Navbar />
            <div className="pb-20 pt-20">
                <Routes>
                    <Route path={"/home"} element ={<Home/>}/>
                    <Route path={"/adding"} element ={<AdForm/>}/>
                    <Route path={"ad/:id"} element={<DetailPage/>}/>
                </Routes>
            </div>
            </body>
        </html>
    );
}


