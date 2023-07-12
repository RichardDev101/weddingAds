package dev.projects.backend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import dev.projects.backend.collection.Advertisement;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
class AdControllerTest {

    @Autowired
    MockMvc mockMvc;


    @Test
    @DirtiesContext
    @WithMockUser
    void testSaveAd_whenSaveAd_returnAdvertisement__andStatusCode200() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/ad")
                        .contentType("application/json")
                        .content("""
                             {
                               "advertisementStatus": "NEW",
                               "paymentCategory": "BASIC",
                               "company": {
                                 "name": "Picture Limited",
                                 "address": {
                                   "streetName": "Main Street",
                                   "houseNo": "10",
                                   "apartment": "",
                                   "zipCode": "12345",
                                   "city": "Cityville",
                                   "country": "Countryland",
                                   "geoData": ""
                                 },
                                 "contacts": {
                                   "email": "",
                                   "phoneNumber": "",
                                   "homepageURL": ""
                                 }
                               },
                               "businessCategories": [
                                 "PHOTOGRAPHER"
                               ],
                               "photosID": [
                                 "string"
                               ],
                               "title": "Best picture on earth",
                               "aboutYourself": "I am he/she/it",
                               "detailInformationForService": "This is our Service in Detail",
                               "averagePrice": 100,
                               "priceCategories": [
                                 "PER_HOUR"
                               ],
                               "customerContacts": [
                                 {
                                   "email": "string",
                                   "phoneNumber": "string",
                                   "homepageURL": "string"
                                 }
                               ],
                               "locations": [
                                 {
                                   "streetName": "Main Street",
                                   "houseNo": "10",
                                   "zipCode": "12345",
                                   "city": "Cityville",
                                   "country": "Countryland"
                                 }
                               ],
                                "personsID": "123456"
                             }
                                """)
                                .with(csrf()))
                        .andExpect(status().is(200));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/ad"))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                        [
                            {
                               "advertisementStatus": "NEW",
                               "paymentCategory": "BASIC",
                               "company": {
                                 "name": "Picture Limited",
                                 "address": {
                                   "streetName": "Main Street",
                                   "houseNo": "10",
                                   "apartment": "",
                                   "zipCode": "12345",
                                   "city": "Cityville",
                                   "country": "Countryland",
                                   "geoData": ""
                                 },
                                 "contacts": {
                                   "email": "",
                                   "phoneNumber": "",
                                   "homepageURL": ""
                                 }
                               },
                               "businessCategories": [
                                 "PHOTOGRAPHER"
                               ],
                               "photosID": [
                                 "string"
                               ],
                               "title": "Best picture on earth",
                               "aboutYourself": "I am he/she/it",
                               "detailInformationForService": "This is our Service in Detail",
                               "averagePrice": 100,
                               "priceCategories": [
                                 "PER_HOUR"
                               ],
                               "customerContacts": [
                                 {
                                   "email": "string",
                                   "phoneNumber": "string",
                                   "homepageURL": "string"
                                 }
                               ],
                               "locations": [
                                 {
                                   "streetName": "Main Street",
                                   "houseNo": "10",
                                   "zipCode": "12345",
                                   "city": "Cityville",
                                   "country": "Countryland"
                                 }
                               ],
                              "personsID": "123456"
                             }
                             ]
                        """))
                .andExpect(jsonPath("$[0].id").isNotEmpty());
    }

    @Test
    @DirtiesContext
    @WithMockUser
    void testGetAllAds_whenGetAllAds_returnEmptyAdsList_andStatusCode200() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/ad"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }

    @Test
    @DirtiesContext
    @WithMockUser
    void testGetAdWithId_whenGetAdWithId_returnCorrectAd_andStatusCode200() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/api/ad")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                            {
                               "advertisementStatus": "NEW",
                               "paymentCategory": "BASIC",
                               "company": {
                                 "name": "Picture Limited",
                                 "address": {
                                   "streetName": "",
                                   "houseNo": "",
                                   "apartment": "",
                                   "zipCode": "",
                                   "city": "",
                                   "country": "",
                                   "geoData": ""
                                 },
                                 "contacts": {
                                   "email": "",
                                   "phoneNumber": "",
                                   "homepageURL": ""
                                 }
                               },
                               "businessCategories": [
                                 "PHOTOGRAPHER"
                               ],
                               "photosID": [
                                 "string"
                               ],
                               "title": "Best picture on earth",
                               "aboutYourself": "I am he/she/it",
                               "detailInformationForService": "This is our Service in Detail",
                               "averagePrice": 110,
                               "priceCategories": [
                                 "PER_HOUR"
                               ],
                               "customerContacts": [
                                 {
                                   "email": "",
                                   "phoneNumber": "",
                                   "homepageURL": ""
                                 }
                               ],
                               "locations": [
                                 {
                                   "streetName": "",
                                   "houseNo": "",
                                   "apartment": "",
                                   "zipCode": "",
                                   "city": "",
                                   "country": "",
                                   "geoData": ""
                                 }
                               ],
                               "personsID": "123456"
                             }
                            """)
                        .with(csrf()))
                .andExpect(status().isOk())
                .andReturn();

        String content = result.getResponse().getContentAsString();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        Advertisement ad = objectMapper.readValue(content, Advertisement.class);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/ad/" + ad.getId()))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                    {
                       "advertisementStatus": "NEW",
                       "paymentCategory": "BASIC",
                       "company": {
                         "name": "Picture Limited",
                         "address": {
                           "streetName": "",
                           "houseNo": "",
                           "apartment": "",
                           "zipCode": "",
                           "city": "",
                           "country": "",
                           "geoData": ""
                         },
                         "contacts": {
                           "email": "",
                           "phoneNumber": "",
                           "homepageURL": ""
                         }
                       },
                       "businessCategories": [
                         "PHOTOGRAPHER"
                       ],
                       "photosID": [
                         "string"
                       ],
                       "title": "Best picture on earth",
                       "aboutYourself": "I am he/she/it",
                       "detailInformationForService": "This is our Service in Detail",
                       "averagePrice": 110,
                       "priceCategories": [
                         "PER_HOUR"
                       ],
                       "customerContacts": [
                         {
                           "email": "",
                           "phoneNumber": "",
                           "homepageURL": ""
                         }
                       ],
                       "locations": [
                         {
                           "streetName": "",
                           "houseNo": "",
                           "apartment": "",
                           "zipCode": "",
                           "city": "",
                           "country": "",
                           "geoData": ""
                         }
                       ],
                       "personsID": "123456"
                     }
                """)).andExpect(jsonPath("$.id").value(ad.getId()));
    }


    @Test
    @DirtiesContext
    @WithMockUser
    void testUpdateAd_whenUpdateAd_returnUpdatedAd_andStatusCode200() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/api/ad")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                            {
                               "advertisementStatus": "NEW",
                               "paymentCategory": "BASIC",
                               "company": {
                                 "name": "Picture Limited",
                                 "address": {
                                   "streetName": "",
                                   "houseNo": "",
                                   "apartment": "",
                                   "zipCode": "",
                                   "city": "",
                                   "country": "",
                                   "geoData": ""
                                 },
                                 "contacts": {
                                   "email": "",
                                   "phoneNumber": "",
                                   "homepageURL": ""
                                 }
                               },
                               "businessCategories": [
                                 "PHOTOGRAPHER"
                               ],
                               "photosID": [
                                 "string"
                               ],
                               "title": "Best picture on earth",
                               "aboutYourself": "I am he/she/it",
                               "detailInformationForService": "This is our Service in Detail",
                               "averagePrice": 300,
                               "priceCategories": [
                                 "PER_HOUR"
                               ],
                               "customerContacts": [
                                 {
                                   "email": "",
                                   "phoneNumber": "",
                                   "homepageURL": ""
                                 }
                               ],
                               "locations": [
                                 {
                                   "streetName": "",
                                   "houseNo": "",
                                   "apartment": "",
                                   "zipCode": "",
                                   "city": "",
                                   "country": "",
                                   "geoData": ""
                                 }
                               ],
                               "personsID": "123456"
                             }
                            """)
                        .with(csrf()))
                .andExpect(status().isOk())
                .andReturn();

        String content = result.getResponse().getContentAsString();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        Advertisement ad = objectMapper.readValue(content, Advertisement.class);

        mockMvc.perform(MockMvcRequestBuilders.put("/api/ad/" + ad.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                            {
                               "advertisementStatus": "APPROVED",
                               "paymentCategory": "PREMIUM",
                               "company": {
                                 "name": "Picture Limited",
                                 "address": {
                                   "streetName": "",
                                   "houseNo": "",
                                   "apartment": "",
                                   "zipCode": "",
                                   "city": "",
                                   "country": "",
                                   "geoData": ""
                                 },
                                 "contacts": {
                                   "email": "",
                                   "phoneNumber": "",
                                   "homepageURL": ""
                                 }
                               },
                               "businessCategories": [
                                 "HAIR_DRESSER"
                               ],
                               "photosID": [
                                 "string"
                               ],
                               "title": "Best picture on earth",
                               "aboutYourself": "I am the best hair dresser updated",
                               "detailInformationForService": "This is our Service in Detail",
                               "averagePrice": 400,
                               "priceCategories": [
                                 "PER_SERVICE"
                               ],
                               "customerContacts": [
                                 {
                                   "email": "Hair@dress.com",
                                   "phoneNumber": "+49(0)17613565648",
                                   "homepageURL": ""
                                 }
                               ],
                               "locations": [
                                 {
                                   "streetName": "",
                                   "houseNo": "",
                                   "apartment": "",
                                   "zipCode": "",
                                   "city": "",
                                   "country": "",
                                   "geoData": ""
                                 }
                               ],
                               "personsID": "987"
                             }
                            """)
                        .with(csrf()))
                .andExpect(status().isOk());

        mockMvc.perform(MockMvcRequestBuilders.get("/api/ad/" + ad.getId()))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                    {
                               "advertisementStatus": "APPROVED",
                               "paymentCategory": "PREMIUM",
                               "company": {
                                 "name": "Picture Limited",
                                 "address": {
                                   "streetName": "",
                                   "houseNo": "",
                                   "apartment": "",
                                   "zipCode": "",
                                   "city": "",
                                   "country": "",
                                   "geoData": ""
                                 },
                                 "contacts": {
                                   "email": "",
                                   "phoneNumber": "",
                                   "homepageURL": ""
                                 }
                               },
                               "businessCategories": [
                                 "HAIR_DRESSER"
                               ],
                               "photosID": [
                                 "string"
                               ],
                               "title": "Best picture on earth",
                               "aboutYourself": "I am the best hair dresser updated",
                               "detailInformationForService": "This is our Service in Detail",
                               "averagePrice": 400,
                               "priceCategories": [
                                 "PER_SERVICE"
                               ],
                               "customerContacts": [
                                 {
                                   "email": "Hair@dress.com",
                                   "phoneNumber": "+49(0)17613565648",
                                   "homepageURL": ""
                                 }
                               ],
                               "locations": [
                                 {
                                   "streetName": "",
                                   "houseNo": "",
                                   "apartment": "",
                                   "zipCode": "",
                                   "city": "",
                                   "country": "",
                                   "geoData": ""
                                 }
                               ],
                               "personsID": "987"
                             }
                            """));

    }
}