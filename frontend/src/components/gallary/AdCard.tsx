import React, {useEffect} from 'react';
import {Advertisement} from "../../model/Advertisement";
import {Address} from "../../model/Address";
import axios from "axios";

type AdProps={
    ad: Advertisement,
}
export default function AdCard(props: AdProps) {

    useEffect(()=> {
        axios.get("/api/photo/show/"+props.ad.photosID)
            .then(response => {
                console.log(response.data);
            })
            .catch((e) => console.error("Image not found to update advertisement",e))
    })

    return(
        <div className='felx border border-gray-300 xs:w-[250px] w-full' >
            <div className='bg-tertiary rounded-[40px] py-5 px-12 min-h-[280px] flex justify-evenly items-center flex-col'>
                <img
                    src={"img"}
                    alt='Image'
                    className='w-32 h-32 object-contain'
                />
                <h1 className='text-black text-[20px] font-bold text-center'>
                    {props.ad.title}
                </h1>
                <h2 className='text-black text-[15px] text-center'>
                    {props.ad.businessCategories}
                </h2>
                <h2 className='text-black text-[15px] text-center'>

                </h2>
            </div>
        </div>
    );
}