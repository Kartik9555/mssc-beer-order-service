package com.example.practice.beer.order.service.services.beerOrder.impl;

import com.example.practice.beer.order.service.services.beerOrder.BeerOrderServiceClient;
import com.example.practice.beer.order.service.services.beerOrder.model.BeerDTO;
import java.util.Optional;
import java.util.UUID;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

@ConfigurationProperties(value = "brewery.beer")
public class BeerOrderServiceClientImpl implements BeerOrderServiceClient {

    @Setter
    private String apiHost;

    private final RestTemplate restTemplate;
    private final String BEER_SERVICE_GET_BY_ID_PATH = "/api/v1/beer/{beerId}";
    private final String BEER_SERVICE_GET_BY_UPC_PATH = "/api/v1/beerUpc/{upc}";

    @Autowired
    public BeerOrderServiceClientImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public Optional<BeerDTO> getBeerById(UUID beerId) {
        BeerDTO beerDTO = restTemplate.exchange(
            apiHost + BEER_SERVICE_GET_BY_ID_PATH,
            HttpMethod.GET,
            null,
            BeerDTO.class,
            new ParameterizedTypeReference<BeerDTO>() {
            },
            beerId
        ).getBody();
        return Optional.ofNullable(beerDTO);
    }


    @Override
    public Optional<BeerDTO> getBeerByUpc(String upc) {
        BeerDTO beerDTO = restTemplate.exchange(
            apiHost + BEER_SERVICE_GET_BY_UPC_PATH,
            HttpMethod.GET,
            null,
            BeerDTO.class,
            new ParameterizedTypeReference<BeerDTO>() {
            },
            upc
        ).getBody();
        return Optional.ofNullable(beerDTO);
    }
}
