import React from 'react';
import {AiOutlineMenu} from "react-icons/ai";
import AvatarLoginImg from "../AvatarLoginImg";
import {useNavigate} from "react-router-dom";


export default function UserMenu() {
    const navigate = useNavigate();
    function goToAdFormPage() {
        navigate("/adding")
    }

    return (
        <div className="relative">
            <div className="flex flex-row items-center gap-3">
                <div className="hidden md:block text-sm font-semibold py-3 px-4 rounded-full hover:bg-neutral-100 transition cursor-pointer"
                onClick={goToAdFormPage}>
                    Offer your Service
                </div>
                <div
                    className=" p-4 md:py-1 md:px-2 border-[1px] border-neutral-200 flex flex-row items-center gap-3 rounded-full cursor-pointer hover:shadow-md transition">
                    <AiOutlineMenu />
                    <div className="hidden md:block">
                        <AvatarLoginImg />
                    </div>
                </div>
            </div>
        </div>
    );
}
