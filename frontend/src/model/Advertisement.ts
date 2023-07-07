import React from 'react';
import {Company} from "./Company";
import {PaymentCategory} from "../enum/PaymentCategory";
import {AdvetisementSatus} from "../enum/AdvetisementSatus";
import {BusinessCategory} from "../enum/BusinessCategory";
import {PriceCategory} from "../enum/PriceCategory";
import {ContactDetail} from "./ContactDetail";
import {Address} from "./Address";



export type Advertisement={
    id: string;
    advertisementStatus: AdvetisementSatus;
    paymentCategory: PaymentCategory;
    company: Company;
    businessCategories: BusinessCategory;
    photosID: string;
    title: string;
    aboutYourself: string;
    detailInformationForService: string;
    averagePrice: number;
    priceCategories: PriceCategory;
    customerContacts: ContactDetail;
    locations: Address;
    personsID: string;
}