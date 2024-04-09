package com.example.practice.beer.order.service.repositories;

import com.example.practice.beer.order.service.domain.BeerOrderLine;
import java.util.UUID;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BeerOrderLineRepository extends PagingAndSortingRepository<BeerOrderLine, UUID> {
}
