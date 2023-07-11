import React, {useEffect, useState} from 'react';
import Container from '../../app/Container';
import DetailHead from "./DetailHead";
import DetaiInfo from "./DetaiInfo";
import {Advertisement} from "../../model/Advertisement";
import {useParams} from "react-router-dom";
import axios from "axios";
import * as string_decoder from "string_decoder";

function DetailPage() {
    const [ad, setAd] = useState<Advertisement | null>(null);
    const params  = useParams()
    const id: string|undefined = params.id

    useEffect(()=>{
        if (id) {
            axios.get("api/ad/" + id)
                .then((response) => {
                    console.log(response.data);
                    setAd(response.data);
                })
                .catch((e) => console.error("Failed to update advertisement", e));
        }
    }, [id]);

    if (!ad) {
        return <div>Loading...</div>;
    }


    return (
        <div className="pt-20 ">
            <Container>
                <div className="max-w-screen-lg mx-auto">
                    <div className="flex flex-col gap-6">
                        <DetailHead title={ad.title}
                                    subtitle={ad.locations.city}
                                    imageSrc={"image"}
                                     id={ad.id}
                        />
                        <div className="grid grid-cols-1 md:grid-cols-7 md:gap-10 mt-6">
                            <DetaiInfo
                                selfDescription={ad.aboutYourself}
                                serviceDescription={ad.aboutYourself}
                                coordinates={"coordinates"}
                                businessCategories={"ad.businessCategories"}
                            />
                        </div>
                    </div>
                </div>
            </Container>
        </div>
    );
}

export default DetailPage;