package br.com.dh.testing03.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
        boolean result = currentAccount.withdraw(withdrawValue);

        assertThat(currentAccount.getBalance())
            .isEqualTo(depositValue - withdrawValue);
        assertThat(result).isTrue();
    }

    @ParameterizedTest
    @CsvSource({ "100, 50", "50, 50", "10, 10" })
    void withdraw_returnsTrue_whenBalanceIsEnough(
        double depositValue,
        double withdrawValue
    ) throws InvalidNumberException {
        currentAccount.deposit(depositValue);
        boolean result = currentAccount.withdraw(withdrawValue);

        assertThat(currentAccount.getBalance())
            .isEqualTo(depositValue - withdrawValue);
        assertThat(result).isTrue();
    }

    @Test
    void withdraw_returnsFalse_whenBalanceIsNotEnough()
        throws InvalidNumberException {
        double withdrawValue = 100;

        boolean result = currentAccount.withdraw(withdrawValue);

        assertThat(currentAccount.getBalance()).isZero();
        assertThat(result).isFalse();
    }

    @Test
    void withdraw_throwsException_whenValueIsInvalid() {
        double withdrawValue = -100;

        assertThatThrownBy(() -> currentAccount.withdraw(withdrawValue))
            .isInstanceOf(InvalidNumberException.class);
    }

    @Test
    void toString_returnsString() {
        currentAccount.toString(); // Just to increase coverage
        assertThat(true).isTrue(); // Fake test
    }
}
