import React from 'react';
import Heading from "../Heading";

type Props ={
    title: string;
    subtitle: string;
    imageSrc?: string;
    id:string;
}

function DetailHead(props: Props) {
    return (
        <div>
            <Heading
                title={props.title}
                subtitle={props.subtitle}/>
            <div className="w-full h-[60vh] overflow-hidden rounded-xl relative">
                {props.imageSrc ? (
                    <img
                        src={props.imageSrc}
                        className="object-cover w-full"
                        alt="Image"
                    />
                ) : (
                    <div>Loading image...</div>
                )}
            </div>
        </div>
    );
}

export default DetailHead;