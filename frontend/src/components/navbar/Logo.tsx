"use client"
import React from 'react';
import {useNavigate} from "react-router-dom";
export default function Logo() {

    const navigate = useNavigate();
    function goToHomePage() {
        navigate("/home")
    }

    return (
        <img  alt="Logo"
                className="hidden md:block cursor-pointer"
                height="60"
                width="150"
                src="/images/logo.png"
                onClick={goToHomePage}>
        </img>
    );
}