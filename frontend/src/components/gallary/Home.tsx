import React, {useEffect, useState} from 'react';
import Container from "../../app/Container";
import {Advertisement} from "../../model/Advertisement";
import axios from "axios";
import AdvertisementCard from "./AdvertisementCard";

export default function Home() {

    const [allAds, setAllAds] = useState<Advertisement[]>([])

    useEffect(() => {getAllAds()   }, [])
    function getAllAds() {
        axios.get("/api/ad")
            .then((response) => {
                setAllAds(response.data)
            }).catch((e) => console.log(e.message))
    }

    return (
        <Container>
            <div className="pb-20 pt-28 pt-24g rid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 xl:grid-cols-5 2xl:grid-cols-6 gap-8">
                <div>
                    {allAds.map(ad => <AdvertisementCard key={ad.id} ad={ad}/>)}
                </div>
            </div>
        </Container>

    );
}
