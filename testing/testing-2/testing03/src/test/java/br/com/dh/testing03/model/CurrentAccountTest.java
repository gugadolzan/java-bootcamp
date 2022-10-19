package br.com.dh.testing03.model;

import static org.assertj.core.api.Assertions.assertThat;

import br.com.dh.testing03.exception.InvalidNumberException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CurrentAccountTest {

    private CurrentAccount currentAccount;

    @BeforeEach
    void setup() {
        currentAccount = new CurrentAccount(1, "Client 1");
    }

    @Test
    void withdraw_returnsTrue_whenBalanceIsEnough()
        throws InvalidNumberException {
        double depositValue = 100;
        double withdrawValue = 50;

        currentAccount.deposit(depositValue);
        currentAccount.withdraw(50);

        assertThat(currentAccount.getBalance())
            .isEqualTo(depositValue - withdrawValue);
    }
}
