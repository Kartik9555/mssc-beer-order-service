package com.example.practice.beer.order.service.web.mappers;

import com.example.practice.beer.order.service.domain.BeerOrderLine;
import com.example.practice.beer.order.service.services.beerOrder.BeerOrderServiceClient;
import com.example.practice.beer.order.service.web.model.BeerOrderLineDto;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BeerOrderLineMapperDecorator implements BeerOrderLineMapper {

    private BeerOrderServiceClient beerOrderServiceClient;
    private BeerOrderLineMapper beerOrderLineMapper;


    @Autowired
    public void setBeerOrderServiceClient(BeerOrderServiceClient beerOrderServiceClient) {
        this.beerOrderServiceClient = beerOrderServiceClient;
    }


    @Autowired
    public void setBeerOrderLineMapper(BeerOrderLineMapper beerOrderLineMapper) {
        this.beerOrderLineMapper = beerOrderLineMapper;
    }


    @Override
    public BeerOrderLineDto beerOrderLineToDto(BeerOrderLine line) {
        BeerOrderLineDto beerOrderLineDto = beerOrderLineMapper.beerOrderLineToDto(line);
        beerOrderServiceClient.getBeerByUpc(beerOrderLineDto.getUpc()).ifPresent(beerDTO -> {
                beerOrderLineDto.setBeerName(beerDTO.getBeerName());
                beerOrderLineDto.setPrice(beerDTO.getPrice());
                beerOrderLineDto.setBeerStyle(beerDTO.getBeerStyle());
                beerOrderLineDto.setBeerId(beerDTO.getId());
            }
        );
        return beerOrderLineDto;
    }


    @Override
    public BeerOrderLine dtoToBeerOrderLine(BeerOrderLineDto dto) {
        return beerOrderLineMapper.dtoToBeerOrderLine(dto);
    }
}
