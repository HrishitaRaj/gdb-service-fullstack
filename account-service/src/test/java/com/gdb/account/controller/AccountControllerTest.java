package com.gdb.account.controller;

import com.gdb.account.client.AuthClient;
import com.gdb.account.service.AccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


// TODO: MOD9-CR-01: MockMvc Integration Tests.
// Trainee task: Write integration tests for AccountController using @WebMvcTest.
// Write tests for GET /api/v1/accounts/{accountNumber} and POST /api/v1/accounts/savings.
// Verify status codes (200, 201, 400, 422) and response body payloads.
@WebMvcTest(AccountController.class)
class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccountService accountService;

    @MockBean
    private AuthClient authClient;

    @Test
    void contextLoads() {
    }

    @Test
    void getAccount_Unauthorized_WhenNoContext() throws Exception {

        mockMvc.perform(
                get("/api/v1/accounts/12345")
        )
        .andExpect(status().isUnauthorized());
    }
} 
//public class AccountControllerTest {

    //@Autowired
    //private MockMvc mockMvc;

    //@Test
    //public void testGetAccountByNumber_NotFound() throws Exception {
        // Trainee: Write a test case here that mocks the service and asserts 404 response
    //}}
