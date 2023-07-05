import React from 'react';

type HeadingProps = {
    title: string;
    subtitle?: string;
    center?: boolean;
}
export default function Heading(props: HeadingProps) {
    return (
        <div>
            <div className={props.center ? 'text-center' : 'text-start'}>
                <div className="text-2xl font-bold">
                    {props.title}
                </div>
                <div className="font-light text-neutral-500 mt-2">
                    {props.subtitle}
                </div>
            </div>
        </div>
    );
}
