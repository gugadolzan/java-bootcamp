package br.com.dh.testing03.controller;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import br.com.dh.testing03.dto.AccountDTO;
import br.com.dh.testing03.model.CurrentAccount;
import br.com.dh.testing03.service.CurrentAccountService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

@WebMvcTest(CurrentAccountController.class)
class CurrentAccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CurrentAccountService service;

    private CurrentAccount currentAccount;

    @BeforeEach
    void setup() {
        currentAccount = new CurrentAccount(1, "Client 1");
    }

    @Test
    void getAccount_returnsCurrentAccount_whenAccountExists() throws Exception {
        BDDMockito
            .when(service.getAccount(anyInt()))
            .thenReturn(currentAccount);

        ResultActions response = mockMvc.perform(
            get("/current-accounts/{number}", currentAccount.getNumber())
                .contentType(MediaType.APPLICATION_JSON)
        );

        response
            .andExpect(status().isOk())
            .andExpect(
                jsonPath(
                    "$.client",
                    CoreMatchers.is(currentAccount.getClient())
                )
            )
            .andExpect(
                jsonPath(
                    "$.number",
                    CoreMatchers.is(currentAccount.getNumber())
                )
            );
    }

    @Test
    void newCurrentAccount_returnsCurrentAccount_whenAccountIsCreated()
        throws Exception {
        BDDMockito
            .when(service.newCurrentAccount(anyString()))
            .thenReturn(currentAccount);

        ResultActions response = mockMvc.perform(
            post("/current-accounts/{client}", currentAccount.getClient())
                .contentType(MediaType.APPLICATION_JSON)
        );

        response
            .andExpect(status().isCreated())
            .andExpect(
                jsonPath(
                    "$.client",
                    CoreMatchers.is(currentAccount.getClient())
                )
            )
            .andExpect(
                jsonPath(
                    "$.balance",
                    CoreMatchers.is(currentAccount.getBalance())
                )
            );
    }

    @Test
    void newCurrentAccountBody_returnsCurrentAccount_whenAccountIsCreated()
        throws Exception {
        BDDMockito
            .when(service.newCurrentAccount(anyString()))
            .thenReturn(currentAccount);

        ResultActions response = mockMvc.perform(
            post("/current-accounts/new")
                .content(
                    objectMapper.writeValueAsString(
                        new AccountDTO(currentAccount.getClient())
                    )
                )
                .contentType(MediaType.APPLICATION_JSON)
        );

        response
            .andExpect(status().isCreated())
            .andExpect(
                jsonPath(
                    "$.client",
                    CoreMatchers.is(currentAccount.getClient())
                )
            )
            .andExpect(
                jsonPath(
                    "$.balance",
                    CoreMatchers.is(currentAccount.getBalance())
                )
            );
    }

    @Test
    void deposit_returnsUpdatedCurrentAccount_whenDepositIsSuccessful()
        throws Exception {
        double depositValue = 100;

        BDDMockito
            .when(service.getAccount(anyInt()))
            .thenReturn(currentAccount);
        BDDMockito
            .doAnswer(invocation -> {
                currentAccount.deposit(depositValue);
                return null;
            })
            .when(service)
            .deposit(currentAccount.getNumber(), depositValue);

        ResultActions response = mockMvc.perform(
            patch(
                "/current-accounts/dep/{number}/{value}",
                currentAccount.getNumber(),
                depositValue
            )
                .contentType(MediaType.APPLICATION_JSON)
        );

        response
            .andExpect(status().isOk())
            .andExpect(
                jsonPath(
                    "$.client",
                    CoreMatchers.is(currentAccount.getClient())
                )
            )
            .andExpect(jsonPath("$.balance", CoreMatchers.is(depositValue)));
    }

    @Test
    void withdraw() {}

    @Test
    void newCurrentAccountBody() {}
}
