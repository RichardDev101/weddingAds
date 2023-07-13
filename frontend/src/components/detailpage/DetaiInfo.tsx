import React from 'react';
import {BusinessCategory} from "../../enum/BusinessCategory";
import AvatarLoginImg from "../AvatarLoginImg";
import {Address} from "../../model/Address";
import {ContactDetail} from "../../model/ContactDetail";

type InfoProps={
    selfDescription: string;
    serviceDescription: string;
    coordinates: string;
    businessCategories: BusinessCategory[];
    locations: Address[];
    customerContacts: ContactDetail[];
}
function DetaiInfo(props: InfoProps) {
    return (
        <div className="col-span-4 flex flex-col gap-8">
            <div className="flex flex-col gap-2">
                <div className="text-xl font-semibold flex flex-row items-center gap-2">
                    <AvatarLoginImg />
                </div>
                <div className="flex flex-row items-center gap-4 font-light text-neutral-500">
                    <div>
                        <span style={{ fontWeight: 'bold' }}>Category: </span>
                        {props.businessCategories.join(', ')}
                    </div>
                </div>
            </div>
            <hr />
            <div className="text-lg font-light text-neutral-500">
                <span style={{ fontWeight: 'bold' }}>About Yourself: </span>
                {props.selfDescription}
            </div>
            <hr />
            <div className="text-lg font-light text-neutral-500">
                <span style={{ fontWeight: 'bold' }}>Service in Detail: </span>
                {props.serviceDescription}
            </div>
            <hr />
            <div className="text-lg font-light text-neutral-500">
                <span style={{ fontWeight: 'bold' }}>Locations: </span>
                {props.locations.map((location, index) => (
                    <div key={index}>
                        {location.streetName} {location.houseNo}, {location.zipCode} {location.city}, {location.country}
                    </div>
                ))}
            </div>
            <hr />
            <div className="text-lg font-light text-neutral-500">
                <span style={{ fontWeight: 'bold' }}>Customer Contacts: </span>
                {props.customerContacts.map((contact) => (
                    <div key={contact.email}>
                        Email: {contact.email}, Phone: {contact.phoneNumber}, Homepage: {contact.homePageUrl}
                    </div>
                ))}
            </div>
            <hr />
            {/* <Map center={props.coordinates} /> */}
        </div>
    );
}

export default DetaiInfo;