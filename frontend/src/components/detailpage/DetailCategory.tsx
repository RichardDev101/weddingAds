import React from 'react';
import {IconType} from "react-icons";

type CategoryViewProps = {
    icon: IconType,
    label: string,
    description: string
}

function DetailCategory(props: CategoryViewProps) {
    return (
        <div className="flex flex-col gap-6">
            <div className="flex flex-row items-center gap-4">

                <div className="flex flex-col">
                    <div className="text-lg font-semibold">
                        {props.label}
                    </div>
                    <div className="text-neutral-500 font-light">
                        {props.description}
                    </div>
                </div>
            </div>
        </div>
    );
}

export default DetailCategory;