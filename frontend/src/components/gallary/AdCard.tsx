import React, {useEffect, useState} from 'react';
import {Advertisement} from "../../model/Advertisement";
import axios from "axios";

type AdProps={
    ad: Advertisement,
    onClick:()=> void;
}
export default function AdCard(props: AdProps) {

    const [imageSrc, setImageSrc] = useState("/images/galleryPlaceholder.png");

    useEffect(()=> {
        axios.get("/api/photo/show/" + props.ad.photosID, { responseType: 'arraybuffer' })
            .then(response => {
                const base64Image = btoa(
                    new Uint8Array(response.data).reduce(
                        (data, byte) => data + String.fromCharCode(byte),
                        ''
                    )
                );
                setImageSrc(`data:image/jpeg;base64,${base64Image}`);
            })
            .catch((e) => console.error("Image not found to update advertisement", e));
    }, [props.ad.photosID]);


    return(
        <div className='cursor-pointer group' onClick={props.onClick}>
            <div className=' border border-gray-300 rounded-[20px] flex justify-evenly items-center flex-col overflow-hidden'>
                <img src={imageSrc}
                     alt="photo"
                     className="w-96 h-64 object-cover"
                />
            </div>
            <div className='py-2 px-4'>
                <h1 className='text-black text-[15px]  text-left'>
                    {props.ad.title}
                </h1>
                <h2 className='text-[12px] text-left text-gray-500'>
                    {props.ad.businessCategories}
                </h2>
                <h2 className='text-black text-[12px] text-left'>
                    {props.ad.locations.city}
                </h2>
            </div>

        </div>
    );
}