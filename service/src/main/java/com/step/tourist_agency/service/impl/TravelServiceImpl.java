package com.step.tourist_agency.service.impl;

import com.step.tourist_agency.converter.TravelConverter;
import com.step.tourist_agency.dto.TravelDto;
import com.step.tourist_agency.entity.Travel;
import com.step.tourist_agency.exception.EntityNotFoundException;
import com.step.tourist_agency.repository.OrderRepository;
import com.step.tourist_agency.repository.TravelRepository;
import com.step.tourist_agency.service.TravelService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TravelServiceImpl implements TravelService {

    private final TravelRepository travelRepository;
    private final OrderRepository orderRepository;
    private final TravelConverter travelConverter;

    public TravelServiceImpl(TravelRepository travelRepository,
                             OrderRepository orderRepository,
                             TravelConverter travelConverter) {
        this.travelRepository = travelRepository;
        this.orderRepository = orderRepository;
        this.travelConverter = travelConverter;
    }

//----------------------------------------------------------------------------------------------------------------

    @Override
    public TravelDto findOne(Long id) {
        return travelConverter.convert(
                travelRepository.findOneById(id).orElseThrow(
                        () -> new EntityNotFoundException("Travel not found by id: " + id)
                )
        );
    }

    @Override
    public List<TravelDto> findAll(Integer pageNumber, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));
        Page<Travel> pagedResult = travelRepository.findAll(paging);
        if (pagedResult.hasContent()) {
            return convert(pagedResult.getContent());
        } else {
            return new ArrayList<TravelDto>();
        }
    }

    @Override
    public List<TravelDto> findAllByOrder(Long orderId) {
        return convert(
                orderRepository.findOneById(orderId).orElseThrow(
                        () -> new EntityNotFoundException("Order not found by id: " + orderId)
                ).getTravelList()
        );
    }

    @Override
    public TravelDto save(TravelDto travelDto) {
        return travelConverter.convert(
                travelRepository.save(
                        travelConverter.convert(travelDto)
                )
        );
    }

    @Override
    public void remove(Long id) {
        travelRepository.deleteById(id);
    }

    //-----------------------------------------------------------------------------------------------------------------

    private List<TravelDto> convert(List<Travel> list) {
        return list.size() == 0 ?
                Collections.emptyList() :
                list.stream().map(travelConverter::convert).collect(Collectors.toList());
    }

}