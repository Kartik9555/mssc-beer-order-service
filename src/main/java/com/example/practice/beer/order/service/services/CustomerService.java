package com.example.practice.beer.order.service.services;

import com.example.practice.beer.order.service.web.model.CustomerPagedList;
import org.springframework.data.domain.Pageable;

public interface CustomerService {
    CustomerPagedList listCustomers(Pageable pageable);
}
