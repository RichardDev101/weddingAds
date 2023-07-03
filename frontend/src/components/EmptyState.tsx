import React from 'react';
import Heading from "./Heading";
import {useNavigate} from "react-router-dom";

type PropsEmptyState={
    title?: string;
    subtitle?: string;
    showReset?: boolean;
}
function EmptyState(props: PropsEmptyState) {
    props.title = "No exact matches";
    props.subtitle = "Try changing or removing some of your filters.";


    const navigate = useNavigate();
    function goToHomePage() {
        navigate("/home")
    }

    return (
        <div
            className=" h-[60vh] flex flex-col gap-2 justify-center items-center"
        >
            <Heading
                center
                title={props.title}
                subtitle={props.subtitle}
            />
            <div className="w-48 mt-4">
                {props.showReset && (
                    <button title={"Remove all filters"} onClick={goToHomePage}>
                    </button>
                )}
            </div>
        </div>
    );
}

export default EmptyState;