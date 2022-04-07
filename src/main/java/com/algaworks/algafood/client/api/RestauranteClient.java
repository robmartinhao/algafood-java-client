package com.algaworks.algafood.client.api;

import com.algaworks.algafood.client.model.RestauranteOutput;
import com.algaworks.algafood.client.model.RestauranteResumoOutput;
import com.algaworks.algafood.client.model.input.RestauranteInput;
import lombok.AllArgsConstructor;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
public class RestauranteClient {

    private static final String RESOURCE_PATH = "/restaurantes";

    private RestTemplate restTemplate;
    private String url;

    public List<RestauranteResumoOutput> listar() {
        try {
            URI resourceUri = URI.create(url + RESOURCE_PATH);

            RestauranteResumoOutput[] restaurantes = restTemplate
                    .getForObject(resourceUri, RestauranteResumoOutput[].class);

            return Arrays.asList(restaurantes);
        } catch (RestClientResponseException e) {
            throw new ClientApiException(e.getMessage(), e);
        }
    }

    public RestauranteOutput adicionar(RestauranteInput restaurante) {
        var resourceUri = URI.create(url + RESOURCE_PATH);

        try {
            return restTemplate
                    .postForObject(resourceUri, restaurante, RestauranteOutput.class);
        } catch (HttpClientErrorException e) {
            throw new ClientApiException(e.getMessage(), e);
        }
    }
}
