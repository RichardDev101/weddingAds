import React, {useEffect, useState} from 'react';
import Container from "../../app/Container";
import {Advertisement} from "../../model/Advertisement";
import axios from "axios";
import AdCard from "./AdCard";
import {useNavigate, useParams} from "react-router-dom";

export default function Home() {

    const [allAds, setAllAds] = useState<Advertisement[]>([])
    const navigate = useNavigate();


    useEffect(() => {getAllAds()   }, [])
    function getAllAds() {
        axios.get("/api/ad")
            .then((response) => {
                setAllAds(response.data)
            }).catch((e) => console.log(e.message))
    }
    function handleCardClick(adId: string) {
        navigate("/ad/"+adId);
    }
    return (
        <Container>
            <div>
                <div className="flex flex-wrap justify-evenly gap-10 pt-20">
                    {allAds.map(ad => <AdCard ad={ad} key={ad.id} onClick={() => handleCardClick(ad.id)} />)}
                </div>
            </div>
        </Container>

    );
}
