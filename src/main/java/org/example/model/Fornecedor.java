package org.example.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Fornecedor extends Pessoa {
    private String cnpj;
    private String inscricaoEstadual;
}
