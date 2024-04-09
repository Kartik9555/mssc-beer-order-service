package com.example.practice.beer.order.service.services.beerOrder;

import com.example.practice.beer.order.service.services.beerOrder.model.BeerDTO;
import java.util.Optional;
import java.util.UUID;

public interface BeerOrderServiceClient {
    Optional<BeerDTO> getBeerById(UUID beerId);
    Optional<BeerDTO> getBeerByUpc(String upc);
}
