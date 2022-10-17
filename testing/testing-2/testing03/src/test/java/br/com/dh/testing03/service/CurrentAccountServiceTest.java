package br.com.dh.testing03.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import br.com.dh.testing03.dao.AccountDAO;
import br.com.dh.testing03.exception.InvalidNumberException;
import br.com.dh.testing03.exception.NonExistentAccountException;
import br.com.dh.testing03.model.CurrentAccount;
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

    @Test
    @DisplayName("Should create a new current account")
    void newCurrentAccount_returnsCurrentAccount() {
        String clientName = "Client 1";
        int accountNumber = 1;
        CurrentAccount newAccount = new CurrentAccount(
            accountNumber,
            clientName
        );

        Mockito
            .when(dao.newCurrentAccount(ArgumentMatchers.anyString()))
            .thenReturn(newAccount);

        CurrentAccount currentAccount = service.newCurrentAccount(clientName);

        assertThat(currentAccount).isNotNull();
        assertThat(currentAccount.getNumber()).isPositive();
        assertThat(currentAccount.getClient()).isEqualTo(clientName);
    }

    @Test
    void getAccount_returnsCurrentAccount_whenAccountExists()
        throws NonExistentAccountException {
        String clientName = "Client 1";
        int accountNumber = 1;
        CurrentAccount newAccount = new CurrentAccount(
            accountNumber,
            clientName
        );

        Mockito
            .when(dao.getCurrentAccount(ArgumentMatchers.anyInt()))
            .thenReturn(newAccount);

        CurrentAccount currentAccount = service.getAccount(accountNumber);

        assertThat(currentAccount).isNotNull();
        assertThat(currentAccount.getNumber()).isEqualTo(accountNumber);
        assertThat(currentAccount.getBalance()).isZero();
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
        String clientName = "Client 1";
        int accountNumber = 1;
        double value = 100;
        CurrentAccount newAccount = new CurrentAccount(
            accountNumber,
            clientName
        );
        newAccount.deposit(value);

        Mockito
            .when(dao.getCurrentAccount(ArgumentMatchers.anyInt()))
            .thenReturn(newAccount);

        Mockito
            .when(dao.updateAccount(ArgumentMatchers.any(CurrentAccount.class)))
            .thenReturn(true);

        boolean result = service.withdraw(accountNumber, value);

        assertThat(result).isTrue();
        assertThat(newAccount.getBalance()).isZero();
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
        String clientName = "Client 1";
        int accountNumber = 1;
        double value = -100;

        CurrentAccount newAccount = new CurrentAccount(
            accountNumber,
            clientName
        );

        Mockito
            .when(dao.getCurrentAccount(ArgumentMatchers.anyInt()))
            .thenReturn(newAccount);

        assertThrows(
            InvalidNumberException.class,
            () -> service.withdraw(accountNumber, value)
        );
        verify(dao, never())
            .updateAccount(ArgumentMatchers.any(CurrentAccount.class));
    }

    @Test
    void deposit() {}
}
