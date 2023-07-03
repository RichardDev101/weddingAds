import React from 'react';
import {Advertisement} from "../../model/Advertisement";


type AdProps={
    ad: Advertisement
}
export default function AdCard(props: AdProps) {
    return (
        <div className="col-span-1 cursor-pointer group">
            <div className="flex flex-col gap-2 w-full">
                <div className=" aspect-square w-full relative  overflow-hidden  rounded-xl">
                    <h1>{props.ad.title}</h1>
                </div>
            </div>
        </div>
    );
}