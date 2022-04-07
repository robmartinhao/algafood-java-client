package com.algaworks.algafood.client.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RestauranteResumoOutput {

    private Long id;
    private String nome;
    private BigDecimal taxaFrete;
    private CozinhaOutput cozinha;

}
