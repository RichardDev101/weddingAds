import React, {useEffect, useState} from 'react';
import Container from '../../app/Container';
import DetailHead from "./DetailHead";
import DetaiInfo from "./DetaiInfo";
import {Advertisement} from "../../model/Advertisement";
import {useParams} from "react-router-dom";
import axios from "axios";


function DetailPage() {

    const params  = useParams()
    const id: string|undefined = params.id

    const [ad, setAd] = useState<Advertisement | null>(null);
    const [imageSrc, setImageSrc] = useState("/images/galleryPlaceholder.png");

    useEffect(()=>{
        if (id) {
            axios.get("/api/ad/" + id)
                .then((response) => {
                    console.log(response.data);
                    setAd(response.data);
                })
                .catch((e) => console.error("Failed to update advertisement", e));
        }
    }, [id]);

    useEffect(()=> {
        axios.get("/api/photo/show/" + ad?.photosID, { responseType: 'arraybuffer' })
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
    }, [ad?.photosID]);


    if (!ad) {
        return <div className="pt-20">
            Loading...</div>;
    }


    return (
        <div className="pt-20 ">
            <Container>
                <div className="max-w-screen-lg mx-auto">
                    <div className="flex flex-col gap-6">
                        <DetailHead title={ad.title}
                                    subtitle={ad.locations[0].city}
                                    imageSrc={imageSrc}
                                     id={ad.id}
                        />
                        <div className="grid grid-cols-1 md:grid-cols-7 md:gap-10 mt-6">
                            <DetaiInfo
                                selfDescription={ad.aboutYourself}
                                serviceDescription={ad.aboutYourself}
                                coordinates={"coordinates"}
                                businessCategories={ad.businessCategories}
                            />
                        </div>
                    </div>
                </div>
            </Container>
        </div>
    );
}

export default DetailPage;