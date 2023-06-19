package de.neuefische.backend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import de.neuefische.backend.collection.Advertisement;
import de.neuefische.backend.collection.Person;
import de.neuefische.backend.enums.BusinessCategory;
import de.neuefische.backend.enums.LoginRole;
import de.neuefische.backend.enums.PaymentCategory;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class PersonControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DirtiesContext
    @WithMockUser
    void testCheckAndCreateMasterAdmin() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/person/master-admin")
                        .with(csrf()))
                .andExpect(status().is(201));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/person/role")
                .param("role", LoginRole.ADMIN.toString()))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                        [
                        {
                                "userName": "${ENV_UN_Admin}",
                                "passWord": "${ENV_PW_Admin}",
                                "loginRole": "ADMIN"
                              }
                             ]
                        """))
                .andExpect(jsonPath("$[0].personId").isNotEmpty());
    }

    @Test
    @DirtiesContext
    @WithMockUser
    void testSaveAdmin() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/person/admin")
                        .contentType("application/json")
                        .content("""
                             {
                                "userName": "TesAdmin",
                                "passWord": "123",
                                "firstName": "Test",
                                "lastName": "Mueller",
                                "loginRole": "ADMIN"
                              }
                                """)
                        .with(csrf()))
                .andExpect(status().is(200));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/person"))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                        [
                        {
                                "userName": "TesAdmin",
                                "passWord": "123",
                                "firstName": "Test",
                                "lastName": "Mueller",
                                "loginRole": "ADMIN"
                              }
                             ]
                        """))
                .andExpect(jsonPath("$[0].personId").isNotEmpty());
    }

    @Test
    @DirtiesContext
    @WithMockUser
    void testSaveEditor() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/person/editor")
                        .contentType("application/json")
                        .content("""
                             {
                                "userName": "TestEditor",
                                "passWord": "123",
                                "firstName": "Test",
                                "lastName": "Mueller"
                              }
                                """)
                        .with(csrf()))
                .andExpect(status().is(200));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/person/all"))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                        [
                        {
                                "userName": "TestEditor",
                                "passWord": "123",
                                "firstName": "Test",
                                "lastName": "Mueller",
                                "loginRole": "EDITOR"
                              }
                             ]
                        """))
                .andExpect(jsonPath("$[0].personId").isNotEmpty());
    }

    @Test
    @DirtiesContext
    @WithMockUser
    void testSaveUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/person/user")
                        .contentType("application/json")
                        .content("""
                             {
                                "userName": "TestUser",
                                "passWord": "123",
                                "firstName": "Test",
                                "lastName": "Mueller"
                              }
                                """)
                        .with(csrf()))
                .andExpect(status().is(200));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/person/all"))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                        [
                        {
                                "userName": "TestUser",
                                "passWord": "123",
                                "firstName": "Test",
                                "lastName": "Mueller",
                                "loginRole": "USER"
                              }
                             ]
                        """))
                .andExpect(jsonPath("$[0].personId").isNotEmpty());
    }

    @Test
    @DirtiesContext
    @WithMockUser
    void getPersonsByRole() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/api/person/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                "userName": "TestUser",
                                "passWord": "123",
                                "firstName": "Test",
                                "lastName": "Mueller"
                              }
                                """)
                        .with(csrf()))
                .andExpect(status().is(200))
                .andReturn();

        mockMvc.perform(MockMvcRequestBuilders.get("/api/person/role")
                        .param("role", LoginRole.USER.toString()))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                        [{
                                "userName": "TestUser",
                                "passWord": "123",
                                "firstName": "Test",
                                "lastName": "Mueller",
                                "loginRole": "USER"
                              }]
                        """));
    }

    @Test
    @DirtiesContext
    @WithMockUser
    void testGetPersonWithId() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/api/person/admin")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                                                {
                                "userName": "TestUser",
                                "passWord": "123",
                                "firstName": "Test",
                                "lastName": "Mueller"
                              }
                                """).with(csrf()))
                .andExpect(status().is(200))
                .andReturn();

        String content = result.getResponse().getContentAsString();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        Person addedPerson = objectMapper.readValue(content, Person.class);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/person/" + addedPerson.getPersonId()))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                                                        {
                                "userName": "TestUser",
                                "passWord": "123",
                                "firstName": "Test",
                                "lastName": "Mueller"
                              }
                                                """)).andExpect(jsonPath("$.personId").value(addedPerson.getPersonId()));
    }

    @Test
    @DirtiesContext
    @WithMockUser
    void testUpdate() throws Exception {
            MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/api/person/admin")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content("""
                              {
                                "userName": "TestUser",
                                "passWord": "123",
                                "firstName": "Test",
                                "lastName": "Mueller"
                              }
                                """)
                            .with(csrf()))
                    .andExpect(status().isOk())
                    .andReturn();

            String content = result.getResponse().getContentAsString();

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            Person addedPerson = objectMapper.readValue(content, Person.class);

            mockMvc.perform(MockMvcRequestBuilders.put("/api/person/" + addedPerson.getPersonId())
                            .contentType(MediaType.APPLICATION_JSON)
                            .content("""
                                {
                                "userName": "BestUser",
                                "passWord": "987",
                                "firstName": "Best",
                                "lastName": "Schmidt"
                              }
                                """)
                            .with(csrf()))
                    .andExpect(status().isOk());

            mockMvc.perform(MockMvcRequestBuilders.get("/api/person/" + addedPerson.getPersonId()))
                    .andExpect(status().isOk())
                    .andExpect(content().json("""
                        {
                                "userName": "BestUser",
                                "passWord": "987",
                                "firstName": "Best",
                                "lastName": "Schmidt",
                              }
                        """));

        }

    @Test
    @DirtiesContext
    @WithMockUser
    void delete() {
    }
}