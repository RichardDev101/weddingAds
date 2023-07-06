import React, {ChangeEvent, useState} from 'react';
import axios from "axios";
import {businessCategories} from "../../enum/BusinessCategory";

export default function AdForm() {

    const [companyNameInput, setCompanyNameInput]=useState<string>("")

    const [companyAddressStreetNameInput, setCompanyAddressStreetNameInput]=useState<string>("")
    const [companyAddressStreetNoInput, setCompanyAddressStreetNoInput]=useState<string>("")
    const [companyAddressCompartmentInput, setCompanyAddressCompartmentInput]=useState<string>("")
    const [companyAddressZipCodeInput, setCompanyAddressZipCodeInput]=useState<string>("")
    const [companyAddressCityInput, setCompanyAddressCityInput]=useState<string>("")
    const [companyAddressStateInput, setCompanyAddressStateInput]=useState<string>("")
    const [companyAddressCountryInput, setCompanyAddressCountryInput]=useState<string>("")

    const [contactsEmailInput, setContactsEmailInput]=useState<string>("")
    const [contactsPhoneNumberInput, setContactsPhoneNumberInput]=useState<string>("")
    const [contactsHomePageURLInput, setContactsHomePageURLInput]=useState<string>("")

    const [businessCategoryInput, setBusinessCategoryInput]=useState<string>("")
    const [titleInput, setTitleInput]=useState<string>("")
    const [aboutYourselfInput, setAboutYourselfInputInput]=useState<string>("")
    const [detailInformationForServiceInput, setDetailInformationForServiceInput]=useState<string>("")

    const [customerContactsEmailInput, setCustomerContactsEmailInput]=useState<string>("")
    const [customerContactsPhoneNumberInput, setCustomerContactsPhoneNumberInput]=useState<string>("")
    const [customerContactsHomePageURLInput, setCustomerContactsHomePageURLInput]=useState<string>("")

    const [shopLocationStreetNameInput, setShopLocationStreetNameInput]=useState<string>("")
    const [shopLocationStreetNoInput, setShopLocationStreetNoInput]=useState<string>("")
    const [shopLocationZipCodeInput, setShopLocationZipCodeInput]=useState<string>("")
    const [shopLocationCityInput, setShopLocationCityInput]=useState<string>("")
    const [shopLocationStateInput, setShopLocationStateInput]=useState<string>("")
    const [shopLocationCountryInput, setShopLocationCountryInput]=useState<string>("")

    const [selectedImage, setSelectedImage]=useState<File | null> (null)

    function adAdvertisement() {
        const advertisementData = {
            company: {
                name: companyNameInput,
                address: {
                    streetName: companyAddressStreetNameInput,
                    houseNo: companyAddressStreetNoInput,
                    apartment: companyAddressCompartmentInput,
                    zipCode: companyAddressZipCodeInput,
                    city: companyAddressCityInput,
                    country: companyAddressStateInput,
                    geoData: companyAddressCountryInput
                },
                contacts: {
                    email: contactsEmailInput,
                    phoneNumber: contactsPhoneNumberInput,
                    homepageURL: contactsHomePageURLInput
                }
            },
            businessCategories: [
                businessCategoryInput
            ],
            title: titleInput,
            aboutYourself: aboutYourselfInput,
            detailInformationForService: detailInformationForServiceInput,
            customerContacts: [
                {
                    email: customerContactsEmailInput,
                    phoneNumber: customerContactsPhoneNumberInput,
                    homepageURL: customerContactsHomePageURLInput
                }
            ],
            locations: [
                {
                    streetName: shopLocationStreetNameInput,
                    houseNo: shopLocationStreetNoInput,
                    zipCode: shopLocationZipCodeInput,
                    city: shopLocationCityInput,
                    country: shopLocationCountryInput
                }
            ]
        };

        axios.post("/api/ad", advertisementData)
            .then(response => console.log(response.data))
            .catch(error => console.error(error));
    }

    function companyNameHandler(event: ChangeEvent<HTMLInputElement>){
        setCompanyNameInput(event.target.value)
    }
    function companyAddressStreetNameHandler(event: ChangeEvent<HTMLInputElement>){
            setCompanyAddressStreetNameInput(event.target.value)
        }
    function companyAddressStreetNoHandler(event: ChangeEvent<HTMLInputElement>){
            setCompanyAddressStreetNoInput(event.target.value)
        }
    function companyAddressCompartmentHandler(event: ChangeEvent<HTMLInputElement>) {
        setCompanyAddressCompartmentInput(event.target.value)
    }
    function companyAddressZipCodeHandler(event: ChangeEvent<HTMLInputElement>) {
        setCompanyAddressZipCodeInput(event.target.value)
    }
    function companyAddressCityHandler(event: ChangeEvent<HTMLInputElement>) {
        setCompanyAddressCityInput(event.target.value)
    }
    function companyAddressStateHandler(event: ChangeEvent<HTMLInputElement>) {
        setCompanyAddressStateInput(event.target.value)
    }
    function companyAddressCountryHandler(event: ChangeEvent<HTMLInputElement>) {
        setCompanyAddressCountryInput(event.target.value)
    }

    function contactsEmailHandler(event: ChangeEvent<HTMLInputElement>) {
        setContactsEmailInput(event.target.value)
    }
    function contactsPhoneNumberHandler(event: ChangeEvent<HTMLInputElement>) {
        setContactsPhoneNumberInput(event.target.value)
    }
    function contactsHomePageURLHandler(event: ChangeEvent<HTMLInputElement>) {
        setContactsHomePageURLInput(event.target.value)
    }




    function businessCategoryHandler(event: ChangeEvent<HTMLSelectElement>) {
        setBusinessCategoryInput(event.target.value)
    }
    function titleHandler(event: ChangeEvent<HTMLInputElement>) {
        setTitleInput(event.target.value)
    }
    function aboutYourselfHandler(event: ChangeEvent<HTMLTextAreaElement>) {
        setAboutYourselfInputInput(event.target.value)
    }
    function detailInformationForServiceHandler(event: ChangeEvent<HTMLTextAreaElement>) {
        setDetailInformationForServiceInput(event.target.value)
    }

    function customerContactsEmailHandler(event: ChangeEvent<HTMLInputElement>) {
        setCustomerContactsEmailInput(event.target.value)
    }
    function customerContactsPhoneNumberHandler(event: ChangeEvent<HTMLInputElement>) {
        setCustomerContactsPhoneNumberInput(event.target.value)
    }
    function customerContactsHomePageURLHandler(event: ChangeEvent<HTMLInputElement>) {
        setCustomerContactsHomePageURLInput(event.target.value)
    }


    function shopLocationStreetNameHandler(event: ChangeEvent<HTMLInputElement>){
        setShopLocationStreetNameInput(event.target.value)
    };
    function shopLocationStreetNoHandler(event: ChangeEvent<HTMLInputElement>){
        setShopLocationStreetNoInput(event.target.value)
    };
    function shopLocationZipCodeHandler(event: ChangeEvent<HTMLInputElement>) {
        setShopLocationZipCodeInput(event.target.value)
    };
    function shopLocationCityHandler(event: ChangeEvent<HTMLInputElement>) {
        setShopLocationCityInput(event.target.value)
    };
    function shopLocationStateHandler(event: ChangeEvent<HTMLInputElement>) {
        setShopLocationStateInput(event.target.value)
    };
    function shopLocationCountryHandler(event: ChangeEvent<HTMLInputElement>) {
        setShopLocationCountryInput(event.target.value)
    };

    function imageUploadHandler (event: React.ChangeEvent<HTMLInputElement>) {
        const file = event.target.files?.[0];
        if (file) {
            setSelectedImage(file);
        }
    }

    return (
        <>
            <div className=" min-h-fit p-6 bg-gray-100 flex items-center justify-center">
                <div className="container max-w-screen-lg mx-auto">
                    <div>
                        <h2 className="pt-20 font-semibold text-xl text-gray-600">Private Information</h2>
                        <p className="text-gray-500 mb-6">Followoing Information will be stay private and are necessary for our accounting.</p>

                        <div className="bg-white rounded shadow-lg p-4 px-4 md:p-8 mb-6">
                            <div className="grid gap-4 gap-y-2 text-sm grid-cols-1 lg:grid-cols-3">
                                <div className="text-gray-600">
                                    <p className="font-medium text-lg">Company Details</p>
                                    <p>Please fill out all the fields.</p>
                                </div>
                                <div className="lg:col-span-2">
                                    <div className="grid gap-4 gap-y-2 text-sm grid-cols-1 md:grid-cols-6">

                                        <div className="md:col-span-6">
                                            <label htmlFor="company_name">Company Name or full Name of Contractor</label>
                                            <input type="text" name="company_name" id="company_name"
                                                   className="h-10 border mt-1 rounded px-4 w-full bg-gray-50"
                                                   onChange={companyNameHandler}
                                                   value={companyNameInput}/>
                                        </div>

                                        <div className="md:col-span-4">
                                            <label htmlFor="addressStreet">Street</label>
                                            <input type="text" name="addressStreet" id="addressStreet"
                                                   className="h-10 border mt-1 rounded px-4 w-full bg-gray-50"
                                                   onChange={companyAddressStreetNameHandler}
                                                   value={companyAddressStreetNameInput}
                                                   placeholder=""/>
                                        </div>
                                        <div className="md:col-span-1">
                                            <label htmlFor="addressStreetNo">No.</label>
                                            <input type="text" name="addressStreetNo" id="addressStreetNo"
                                                   className="h-10 border mt-1 rounded px-4 w-full bg-gray-50"
                                                   onChange={companyAddressStreetNoHandler}
                                                   value={companyAddressStreetNoInput}
                                                   placeholder=""/>
                                        </div>
                                        <div className="md:col-span-1">
                                            <label htmlFor="addressCompartment">Compartment</label>
                                            <input type="text" name="addressCompartment" id="addressCompartment"
                                                   className="h-10 border mt-1 rounded px-4 w-full bg-gray-50"
                                                   onChange={companyAddressCompartmentHandler}
                                                   value={companyAddressCompartmentInput}
                                                   placeholder=""/>
                                        </div>
                                        <div className="md:col-span-1">
                                            <label htmlFor="zipcode">Zip Code</label>
                                            <input type="text" name="zipcode" id="zipcode"
                                                   className="transition-all flex items-center h-10 border mt-1 rounded px-4 w-full bg-gray-50"
                                                   placeholder=""
                                                   onChange={companyAddressZipCodeHandler}
                                                   value={companyAddressZipCodeInput}/>
                                        </div>
                                        <div className="md:col-span-2">
                                            <label htmlFor="city">City</label>
                                            <input type="text" name="city" id="city"
                                                   className="h-10 border mt-1 rounded px-4 w-full bg-gray-50"
                                                   onChange={companyAddressCityHandler}
                                                   value={companyAddressCityInput}
                                                   placeholder=""/>
                                        </div>
                                        <div className="md:col-span-3">
                                            <label htmlFor="state">State / Province</label>
                                            <div
                                                className="h-10 bg-gray-50 flex border border-gray-200 rounded items-center mt-1">
                                                <input name="state" id="state" placeholder="State"
                                                       className="px-4 appearance-none outline-none text-gray-800 w-full bg-transparent"
                                                       onChange={companyAddressStateHandler}
                                                       value={companyAddressStateInput}
                                                />

                                            </div>
                                        </div>
                                        <div className="md:col-span-3">
                                            <label htmlFor="country">Country / region</label>
                                            <div
                                                className="h-10 bg-gray-50 flex border border-gray-200 rounded items-center mt-1">
                                                <input name="country" id="country" placeholder="Country"
                                                       className="px-4 appearance-none outline-none text-gray-800 w-full bg-transparent"
                                                       onChange={companyAddressCountryHandler}
                                                       value={companyAddressCountryInput}
                                                />
                                            </div>
                                        </div>


                                    </div>
                                </div>

                                <div className="pt-7 text-gray-600">
                                    <p className="font-medium text-lg">Contact Details</p>
                                </div>
                                <div className="pt-7 lg:col-span-2">
                                    <div className="grid gap-4 gap-y-2 text-sm grid-cols-1 md:grid-cols-6">

                                        <div className="md:col-span-3">
                                            <label htmlFor="email">Email Address</label>
                                            <input type="email" id="email"
                                                   className="h-10 border mt-1 rounded px-4 w-full bg-gray-50"
                                                   placeholder="max.example@company.com" required
                                                   onChange={contactsEmailHandler}
                                                   value={contactsEmailInput}
                                            />
                                        </div>
                                        <div className="md:col-span-3">
                                            <label htmlFor="phone" >Phone Number</label>
                                            <input type="tel" id="phone"
                                                   className="h-10 border mt-1 rounded px-4 w-full bg-gray-50"
                                                   placeholder="123-45-678"
                                                   pattern="[0-9]{3}-[0-9]{2}-[0-9]{3}"
                                                   onChange={contactsPhoneNumberHandler}
                                                   value={contactsPhoneNumberInput}
                                            />
                                        </div>
                                        <div className="md:col-span-6">
                                            <label htmlFor="website">Website URL</label>
                                            <input type="url" id="website"
                                                   className="h-10 border mt-1 rounded px-4 w-full bg-gray-50"
                                                   placeholder="url.com"
                                                   onChange={contactsHomePageURLHandler}
                                                   value={contactsHomePageURLInput}
                                            />
                                        </div>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div className="bg-gray-100 flex items-center justify-center">
                <div className="container max-w-screen-lg mx-auto">
                    <div>
                        <h2 className="font-semibold text-xl text-gray-700">Officail Information</h2>
                        <p className="text-gray-600 mb-6">Followoing information will be seen on your advertisement page.</p>

                        <div className="bg-white rounded shadow-lg p-4 px-4 md:p-8 mb-6">
                            <div className="grid gap-4 gap-y-2 text-sm grid-cols-1 lg:grid-cols-3">
                                <div className="text-gray-600">
                                    <p className="font-medium text-lg">Information for Advertisement</p>
                                    <p>Please describe your service.</p>
                                </div>
                                <div className="lg:col-span-2">
                                    <div className="grid gap-4 gap-y-2 text-sm grid-cols-1 md:grid-cols-6">

                                        <div className="md:col-span-2">
                                            <label htmlFor="business_category">Business Category</label>
                                            <select
                                                id="business_category"
                                                className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
                                                required
                                                onChange={businessCategoryHandler}
                                                value={businessCategoryInput}
                                            >
                                                <option value="">Select a category</option>
                                                {businessCategories.map((category) => (
                                                    <option key={category.label} value={category.label}>
                                                        {category.label}
                                                    </option>
                                                ))}
                                            </select>
                                        </div>

                                        <div className="md:col-span-4">
                                            <label htmlFor="title_ad">Title for your Advertisement</label>
                                            <input type="text" id="title_ad"
                                                   className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
                                                   aria-describedby="helper-text-explanation"
                                                   placeholder="Choose a short titel for your advertisement"
                                                   onChange={titleHandler}
                                                   value={titleInput}

                                            />
                                        </div>
                                        <div className="md:col-span-6">
                                            <label htmlFor="about_yourself">About Yourself</label>
                                            <textarea id="about_yourself"
                                                      rows={4}
                                                      className="block p-2.5 w-full text-sm text-gray-900 bg-gray-50 rounded-lg border border-gray-300 focus:ring-blue-500 focus:border-blue-500 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
                                                      placeholder="Write something about yourself"
                                                      onChange={aboutYourselfHandler}
                                                      value={aboutYourselfInput}
                                            />
                                        </div>

                                        <div className="md:col-span-6">
                                            <label htmlFor="service_information">Service Information in Detail</label>
                                            <textarea id="service_information"
                                                      rows={6}
                                                      className="block p-2.5 w-full text-sm text-gray-900 bg-gray-50 rounded-lg border border-gray-300 focus:ring-blue-500 focus:border-blue-500 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
                                                      placeholder="Write something about your service"
                                                      onChange={detailInformationForServiceHandler}
                                                      value={detailInformationForServiceInput}
                                            />
                                        </div>

                                        <div className="md:col-span-6">
                                            <p>Add a Image to your Advertisement</p>
                                            <div className="flex items-center justify-center w-full">
                                                <label htmlFor="dropzone-file"
                                                       className="flex flex-col items-center justify-center w-full h-64 border-2 border-gray-300 border-dashed rounded-lg cursor-pointer bg-gray-50 dark:hover:bg-bray-400 dark:bg-gray-700 hover:bg-gray-100 dark:border-gray-600 dark:hover:border-gray-500 dark:hover:bg-gray-600">
                                                    <div className="flex flex-col items-center justify-center pt-5 pb-6">
                                                        <svg aria-hidden="true"
                                                             className="w-10 h-10 mb-3 text-gray-400" fill="none"
                                                             stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
                                                            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                                                                  d="M7 16a4 4 0 01-.88-7.903A5 5 0 1115.9 6L16 6a5 5 0 011 9.9M15 13l-3-3m0 0l-3 3m3-3v12"></path>
                                                        </svg>
                                                        <p className="mb-2 text-sm text-gray-500 dark:text-gray-400"><span className="font-semibold">Click to upload</span> or
                                                            drag and drop</p>
                                                        <p className="text-xs text-gray-500 dark:text-gray-400">SVG, PNG, JPG or GIF (MAX. 800x400px)</p>
                                                        {selectedImage && (
                                                            <div className="flex items-center justify-center">
                                                                <img
                                                                    src={URL.createObjectURL(selectedImage)}
                                                                    alt="Selected Image"
                                                                    className="max-w-auto max-h-32"
                                                                />
                                                            </div>
                                                        )}
                                                    </div>
                                                    <input  id="dropzone-file" type="file" className="hidden"
                                                            onChange={imageUploadHandler}
                                                    />

                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div className="text-gray-600">
                                    <p className="font-medium text-lg">Contact for Customer</p>
                                    <p>Please fill out all the fields.</p>
                                </div>
                                <div className="lg:col-span-2">
                                    <div className="grid gap-4 gap-y-2 text-sm grid-cols-1 md:grid-cols-6">

                                        <div className="md:col-span-3">
                                            <label htmlFor="customer_contact_email">Email Address</label>
                                            <input type="email" id="customer_contact_email"
                                                   className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
                                                   placeholder="max.example@company.com"
                                                   onChange={customerContactsEmailHandler}
                                                   value={customerContactsEmailInput}
                                            />
                                        </div>
                                        <div className="md:col-span-3">
                                            <label htmlFor="customer_contact_phone" >Phone Number</label>
                                            <input type="tel" id="customer_contact_phone"
                                                   className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
                                                   placeholder="123-45-678" pattern="[0-9]{3}-[0-9]{2}-[0-9]{3}"
                                                   onChange={customerContactsPhoneNumberHandler}
                                                   value={customerContactsPhoneNumberInput}
                                            />
                                        </div>
                                        <div className="md:col-span-6">
                                            <label htmlFor="customer_contact_website">Website URL</label>
                                            <input type="url" id="customer_contact_website"
                                                   className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
                                                   placeholder="url.com"
                                                   onChange={customerContactsHomePageURLHandler}
                                                   value={customerContactsHomePageURLInput}
                                            />
                                        </div>

                                    </div>
                                </div>
                                <div className="pt-7 text-gray-600">
                                    <p className="font-medium text-lg">Shop Location</p>
                                </div>
                                <div className="pt-7 lg:col-span-2">
                                    <div className="grid gap-4 gap-y-2 text-sm grid-cols-1 md:grid-cols-6">

                                        <div className="md:col-span-4">
                                            <label htmlFor="shopLocationAddress">Street</label>
                                            <input type="text" name="shopLocationAddress" id="shopLocationAddress"
                                                   className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
                                                   placeholder=""
                                                   onChange={shopLocationStreetNameHandler}
                                                   value={shopLocationStreetNameInput}
                                            />
                                        </div>
                                        <div className="md:col-span-2">
                                            <label htmlFor="shopLocationAddressNo"> No.</label>
                                            <input type="text" name="shopLocationAddressNo" id="shopLocationAddressNo"
                                                   className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
                                                   placeholder=""
                                                   onChange={shopLocationStreetNoHandler}
                                                   value={shopLocationStreetNoInput}
                                            />
                                        </div>

                                        <div className="md:col-span-1">
                                            <label htmlFor="shopLocationZipcode">Zip Code </label>
                                            <input type="text" name="shopLocationZipcode" id="shopLocationZipcode"
                                                   className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
                                                   placeholder=""
                                                   onChange={shopLocationZipCodeHandler}
                                                   value={shopLocationZipCodeInput}
                                            />
                                        </div>
                                        <div className="md:col-span-2">
                                            <label htmlFor="shopLocationCity">City</label>
                                            <input type="text" name="shopLocationCity" id="shopLocationCity"
                                                   className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
                                                   onChange={shopLocationCityHandler}
                                                   value={shopLocationCityInput}
                                                   placeholder=""/>
                                        </div>
                                        <div className="md:col-span-3">
                                            <label htmlFor="shopLocationState">State / Province</label>
                                            <div className=" flex bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
                                            >
                                                <input name="shopLocationState" id="shopLocationState" placeholder="State"
                                                       className="px-4 appearance-none outline-none text-white w-full bg-transparent"
                                                       onChange={shopLocationStateHandler}
                                                       value={shopLocationStateInput}
                                                />
                                            </div>
                                        </div>
                                        <div className="md:col-span-3">
                                            <label htmlFor="shopLocationCountry">Country / region</label>
                                            <div
                                                className="flex bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
                                            >
                                                <input name="shopLocationCountry" id="shopLocationCountry" placeholder="Country"
                                                       className="px-4 appearance-none outline-none text-white w-full bg-transparent"
                                                       onChange={shopLocationCountryHandler}
                                                       value={shopLocationCountryInput}
                                                />

                                            </div>
                                        </div>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div className="min-h-fit p-6 bg-gray-100 flex items-center justify-center">
                <div className="container max-w-screen-lg mx-auto">
                    <div>
                        <h2 className="font-semibold text-xl text-gray-600">Submit Advertisement</h2>
                        <p className="text-gray-500 mb-6"></p>

                        <div className="bg-white rounded shadow-lg p-4 px-4 md:p-8 mb-6">
                            <div className="grid gap-4 gap-y-2 text-sm grid-cols-1 lg:grid-cols-3">
                                <div className="text-gray-600">
                                    <p className="font-medium text-lg">Terms and Conditions</p>
                                    <p>Please confirm.</p>
                                </div>
                                <div className="lg:col-span-2">
                                    <div className="grid gap-4 gap-y-2 text-sm grid-cols-1 md:grid-cols-6">

                                        <div className="md:col-span-4">
                                            <label htmlFor="password">Password</label>
                                            <input type="password" id="password"
                                                   className="h-10 border mt-1 rounded px-4 w-full bg-gray-50"
                                                   placeholder="•••••••••" required/>
                                        </div>
                                        <div className="pt-4 flex md:col-span-4">
                                            <div>
                                                <input id="remember"
                                                       type="checkbox"
                                                       value=""
                                                       required/>
                                            </div>
                                            <label htmlFor="remember"
                                                   className="ml-2 text-sm font-medium text-gray-900 dark:text-gray-500"
                                                >I agree with the <a href="#" className="text-blue-600 hover:underline dark:text-blue-500">terms
                                                    and conditions</a>.</label>
                                        </div>

                                        <button type="submit"
                                                onClick={adAdvertisement}
                                                className="md:col-span-4 text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm w-full sm:w-auto px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">Submit
                                        </button>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </>
    );
}