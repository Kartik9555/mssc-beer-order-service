package com.example.practice.beer.order.service.web.mappers;

import com.example.practice.beer.order.service.domain.BeerOrderLine;
import com.example.practice.beer.order.service.web.model.BeerOrderLineDto;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
@DecoratedWith(BeerOrderLineMapperDecorator.class)
public interface BeerOrderLineMapper {
    BeerOrderLineDto beerOrderLineToDto(BeerOrderLine line);

    BeerOrderLine dtoToBeerOrderLine(BeerOrderLineDto dto);
}
