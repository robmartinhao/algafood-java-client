package com.algaworks.algafood.client.api;

import com.algaworks.algafood.client.model.RestauranteResumoOutput;
import lombok.AllArgsConstructor;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
public class RestaurantClient {

    private static final String RESOURCE_PATH = "/restaurantes";

    private RestTemplate restTemplate;
    private String url;

    public List<RestauranteResumoOutput> listar() {

        URI resourceUri = URI.create(url + RESOURCE_PATH);

        RestauranteResumoOutput[] restaurantes = restTemplate
                .getForObject(resourceUri, RestauranteResumoOutput[].class);

        return Arrays.asList(restaurantes);
    }
}
