package br.com.dh.testing03.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import br.com.dh.testing03.dao.AccountDAO;
import br.com.dh.testing03.exception.InvalidNumberException;
import br.com.dh.testing03.exception.NonExistentAccountException;
import br.com.dh.testing03.model.CurrentAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CurrentAccountServiceTest {

    @InjectMocks
    private CurrentAccountService service;

    @Mock
    private AccountDAO dao;

    private CurrentAccount currentAccount;

    @BeforeEach
    void setup() {
        currentAccount = new CurrentAccount(1, "Client 1");
    }

    @Test
    @DisplayName("Should create a new current account")
    void newCurrentAccount_returnsCurrentAccount() {
        Mockito
            .when(dao.newCurrentAccount(ArgumentMatchers.anyString()))
            .thenReturn(currentAccount);

        CurrentAccount result = service.newCurrentAccount(
            currentAccount.getClient()
        );

        assertThat(result).isNotNull();
        assertThat(result.getNumber()).isPositive();
        assertThat(result.getClient()).isEqualTo(currentAccount.getClient());
    }

    @Test
    void getAccount_returnsCurrentAccount_whenAccountExists()
        throws NonExistentAccountException {
        Mockito
            .when(dao.getCurrentAccount(ArgumentMatchers.anyInt()))
            .thenReturn(currentAccount);

        CurrentAccount result = service.getAccount(currentAccount.getNumber());

        assertThat(result).isNotNull();
        assertThat(result.getNumber()).isEqualTo(currentAccount.getNumber());
        assertThat(result.getBalance()).isZero();
    }

    @Test
    void getAccount_throwsNonExistentAccountException_whenAccountDoesNotExist()
        throws NonExistentAccountException {
        int accountNumber = 999;

        BDDMockito
            .given(dao.getCurrentAccount(ArgumentMatchers.anyInt()))
            .willThrow(
                new NonExistentAccountException("Account does not exist")
            );

        assertThrows(
            NonExistentAccountException.class,
            () -> service.getAccount(accountNumber)
        );
    }

    @Test
    void withdraw_returnsTrue_whenAccountExistsAndValueIsValidAndHasEnoughBalance()
        throws NonExistentAccountException, InvalidNumberException {
        double value = 100;

        currentAccount.deposit(value);

        Mockito
            .when(dao.getCurrentAccount(ArgumentMatchers.anyInt()))
            .thenReturn(currentAccount);

        Mockito
            .when(dao.updateAccount(ArgumentMatchers.any(CurrentAccount.class)))
            .thenReturn(true);

        boolean result = service.withdraw(currentAccount.getNumber(), value);

        assertThat(result).isTrue();
        assertThat(currentAccount.getBalance()).isZero();
    }

    @Test
    void withdraw_throwsNonExistentAccountException_whenAccountDoesNotExist()
        throws NonExistentAccountException {
        int accountNumber = 999;
        double value = 100;

        BDDMockito
            .given(dao.getCurrentAccount(ArgumentMatchers.anyInt()))
            .willThrow(
                new NonExistentAccountException("Account does not exist")
            );

        assertThrows(
            NonExistentAccountException.class,
            () -> service.withdraw(accountNumber, value)
        );
        verify(dao, never())
            .updateAccount(ArgumentMatchers.any(CurrentAccount.class));
    }

    @Test
    void withdraw_throwsInvalidNumberException_whenValueIsInvalid()
        throws NonExistentAccountException {
        double value = -100;

        Mockito
            .when(dao.getCurrentAccount(ArgumentMatchers.anyInt()))
            .thenReturn(currentAccount);

        assertThrows(
            InvalidNumberException.class,
            () -> service.withdraw(currentAccount.getNumber(), value)
        );
        verify(dao, never())
            .updateAccount(ArgumentMatchers.any(CurrentAccount.class));
    }

    @Test
    void deposit() {}
}
