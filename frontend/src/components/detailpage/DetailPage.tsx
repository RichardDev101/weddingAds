import React from 'react';
import Container from '../../app/Container';
import DetailHead from "./DetailHead";
import DetaiInfo from "./DetaiInfo";
import {Advertisement} from "../../model/Advertisement";
import {useParams} from "react-router-dom";
import axios from "axios";

function DetailPage() {

    const params  = useParams()
    const id: string|undefined = params.id

    axios("")

    return (
        <div className="pt-20 ">
            <Container>
                <div className="max-w-screen-lg mx-auto">
                    <div className="flex flex-col gap-6">
                        <DetailHead title={"title"}
                                    subtitle={"location"}
                                    imageSrc={"imageSrc"}
                                     id={"id"}
                        />
                        <div className="grid grid-cols-1 md:grid-cols-7 md:gap-10 mt-6">
                            <DetaiInfo
                                selfDescription={"selfDescription"}
                                serviceDescription={"serviceDescription"}
                                coordinates={"coordinates"}
                                businessCategories={"businessCategories"}
                            />
                        </div>
                    </div>
                </div>
            </Container>
        </div>
    );
}

export default DetailPage;