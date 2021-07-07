package com.lolapiprac.demo.Organization.service;

import com.lolapiprac.demo.Organization.dto.OrganizationRequestDto;
import com.lolapiprac.demo.Organization.dto.OrganizationResponseDto;
import com.lolapiprac.demo.Organization.entity.Organization;
import com.lolapiprac.demo.Organization.repository.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrganizationService {
    private final OrganizationRepository organizationRepository;

    public OrganizationResponseDto create(OrganizationRequestDto requestDto){
        Organization organization = new Organization(requestDto);
        return OrganizationResponseDto.from(organizationRepository.save(organization));
    }

    public OrganizationResponseDto findByName(String name){
        Organization organization = organizationRepository.findByName(name).orElseThrow(()->
                new IllegalArgumentException("없음"));
        return OrganizationResponseDto.from(organization);
    }
}
