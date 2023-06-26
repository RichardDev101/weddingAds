package dev.projects.backend.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
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
                               "contacts": [
                                 {
                                   "email": "string",
                                   "phoneNumber": "string",
                                   "homepageURL": "string"
                                 }
                               ],
                               "locations": [
                                 {
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
                               "contacts": [
                                 {
                                   "email": "string",
                                   "phoneNumber": "string",
                                   "homepageURL": "string"
                                 }
                               ],
                               "locations": [
                                 {
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

}