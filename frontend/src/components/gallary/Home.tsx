import React, {useEffect, useState} from 'react';
import Container from "../../app/Container";
import {Advertisement} from "../../model/Advertisement";
import axios from "axios";
import AdCard from "./AdCard";

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
            <div className="border-solid border-gray-500 rounded-md bg-green-400 w-48 h-12">
                <div className="">
                    {allAds.map(ad => <AdCard ad={ad} key={ad.id} />)}
                </div>
            </div>
        </Container>

    );
}
