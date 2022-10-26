package br.com.dh.testing03.integration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import br.com.dh.testing03.dao.AccountDAO;
import br.com.dh.testing03.model.CurrentAccount;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

@Log4j2
@SpringBootTest
@AutoConfigureMockMvc
public class CurrentAccountControllerTestIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AccountDAO accountDAO;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setup() {
        accountDAO.deleteAll();
        log.info("Accounts: " + accountDAO.getAllAccounts().size());
    }

    @Test
    void newCurrentAccount_returnsCurrentAccount_whenAccountIsCreated()
        throws Exception {
        String clientName = "Client 1";

        ResultActions response = mockMvc.perform(
            post("/current-accounts/{client}", clientName)
                .contentType(MediaType.APPLICATION_JSON)
        );

        response
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.client", CoreMatchers.is(clientName)))
            .andExpect(jsonPath("$.balance", CoreMatchers.is(0.0)));

        assertThat(accountDAO.getAllAccounts().size()).isEqualTo(1);
        assertThat(accountDAO.getAllAccounts().get(0)).isNotNull();
        log.info(accountDAO.getAllAccounts().get(0));
        log.info(
            objectMapper.readValue(
                response.andReturn().getResponse().getContentAsString(),
                CurrentAccount.class
            )
        );
    }

    @Test
    void getAccount_returnsCurrentAccount_whenAccountExists() throws Exception {
        CurrentAccount currentAccount = accountDAO.newCurrentAccount(
            "Client 1"
        );

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
    void deposit_returnsUpdatedCurrentAccount_whenDepositIsSuccessful()
        throws Exception {
        CurrentAccount currentAccount = accountDAO.newCurrentAccount(
            "Client 1"
        );
        double depositValue = 100;

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

        assertThat(
            accountDAO
                .getCurrentAccount(currentAccount.getNumber())
                .getBalance()
        )
            .isEqualTo(depositValue);
    }
}
