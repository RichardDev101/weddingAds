import React from 'react';
import {BusinessCategory} from "../../enum/BusinessCategory";
import AvatarLoginImg from "../AvatarLoginImg";

type InfoProps={
    selfDescription: string;
    serviceDescription: string;
    coordinates: string;
    businessCategories: BusinessCategory[];

}
function DetaiInfo(props: InfoProps) {
    return (
        <div className="col-span-4 flex flex-col gap-8">
            <div className="flex flex-col gap-2">
                <div className="text-xl font-semibold flex flex-row items-center gap-2">

                    <AvatarLoginImg/>
                </div>
                <div className=" flex flex-row items-center gap-4 font-light text-neutral-500">
                    <div>
                        Category: {props.businessCategories}
                    </div>
                </div>
            </div>
            <hr />
            <hr />
            <div className="text-lg font-light text-neutral-500">
                About Yourself: {props.selfDescription}
            </div>
            <hr />
            <div className="text-lg font-light text-neutral-500">
                About Yourself: {props.serviceDescription}
            </div>
            <hr />
{/*            <Map center={props.coordinates} />*/}
        </div>
    );
}

export default DetaiInfo;