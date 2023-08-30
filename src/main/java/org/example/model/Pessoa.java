package org.example.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Pessoa extends EntityId {
    private String nome;
    private String telefone;
    private String endereco;
    private String email;

    public abstract String getDocumentoPrincipal();
}
