package org.example.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cliente extends Pessoa {
    private String cpf;
    private String rg;

    @Override
    public String getDocumentoPrincipal() {
        return getCpf();
    }
}
