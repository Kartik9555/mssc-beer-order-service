package com.example.practice.beer.order.service.services;

import com.example.practice.beer.order.service.domain.Customer;
import com.example.practice.beer.order.service.repositories.CustomerRepository;
import com.example.practice.beer.order.service.web.mappers.CustomerMapper;
import com.example.practice.beer.order.service.web.model.CustomerPagedList;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public CustomerPagedList listCustomers(Pageable pageable) {
        Page<Customer> customers = customerRepository.findAll(pageable);

            return new CustomerPagedList(customers
                .stream()
                .map(customerMapper::customerToCustomerDto)
                .collect(Collectors.toList()), PageRequest.of(
                customers.getPageable().getPageNumber(),
                customers.getPageable().getPageSize()),
                customers.getTotalElements());
    }
}
