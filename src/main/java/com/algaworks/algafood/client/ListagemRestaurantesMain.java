package com.algaworks.algafood.client;

import com.algaworks.algafood.client.api.RestaurantClient;
import org.springframework.web.client.RestTemplate;

public class ListagemRestaurantesMain {

    public static void main(String[] args) {

        RestaurantClient restaurantClient = new RestaurantClient(new RestTemplate(), "http://localhost:8080");

        restaurantClient.listar().stream()
                .forEach(System.out::println);
    }
}
