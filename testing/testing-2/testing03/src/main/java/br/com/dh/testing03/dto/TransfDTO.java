package br.com.dh.testing03.dto;

import br.com.dh.testing03.model.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransfDTO {

    private Account origin;
    private Account destination;
}
