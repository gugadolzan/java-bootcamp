package br.com.dh.testing03.model;

import static org.assertj.core.api.Assertions.assertThat;

import br.com.dh.testing03.exception.InvalidNumberException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
        double withdrawValue = depositValue / 2;

        currentAccount.deposit(depositValue);
        currentAccount.withdraw(withdrawValue);

        assertThat(currentAccount.getBalance())
            .isEqualTo(depositValue - withdrawValue);
    }

    @ParameterizedTest
    @CsvSource({ "100, 50", "50, 50", "10, 10" })
    void withdraw_returnsTrue_whenBalanceIsEnough(
        double depositValue,
        double withdrawValue
    ) throws InvalidNumberException {
        currentAccount.deposit(depositValue);
        currentAccount.withdraw(withdrawValue);

        assertThat(currentAccount.getBalance())
            .isEqualTo(depositValue - withdrawValue);
    }
}
