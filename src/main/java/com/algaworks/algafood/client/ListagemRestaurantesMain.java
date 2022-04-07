package com.algaworks.algafood.client;

import com.algaworks.algafood.client.api.ClientApiException;
import com.algaworks.algafood.client.api.RestauranteClient;
import org.springframework.web.client.RestTemplate;

public class ListagemRestaurantesMain {

    public static void main(String[] args) {

        try {
            RestauranteClient restauranteClient = new RestauranteClient(new RestTemplate(), "http://localhost:8080");

            restauranteClient.listar().stream()
                    .forEach(System.out::println);
        } catch (ClientApiException e) {
            if(e.getProblem() != null) {
                System.out.println(e.getProblem());
                System.out.println(e.getProblem().getUserMessage());
            } else {
                System.out.println("Erro desconhecido.");
                e.printStackTrace();
            }
        }
    }
}
