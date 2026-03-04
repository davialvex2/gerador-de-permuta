package com.daviaugusto.criador_permuta.Infrastructure.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Dados {

    private String nomeSubstituto;
    private String nomeEscalado;
    private String secaoSubstituto;
    private String secaoEscalado;
    private String postoServico;
    private String dataServico;


}
