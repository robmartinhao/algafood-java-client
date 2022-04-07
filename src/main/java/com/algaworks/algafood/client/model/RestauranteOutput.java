package com.algaworks.algafood.client.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RestauranteOutput {

    private Long id;
    private String nome;
    private BigDecimal taxaFrete;
    private Boolean ativo;
    private Boolean aberto;

    private CozinhaOutput cozinha;
    private EnderecoOutput endereco;
}
