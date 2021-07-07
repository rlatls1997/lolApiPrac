package com.lolapiprac.demo.Organization.controller;

import com.lolapiprac.demo.Organization.dto.OrganizationRequestDto;
import com.lolapiprac.demo.Organization.dto.OrganizationResponseDto;
import com.lolapiprac.demo.Organization.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/organizations")
public class OrganizationController {
    private final OrganizationService organizationService;

    @PostMapping
    public ResponseEntity<String> createGroup(@RequestBody OrganizationRequestDto requestDto){
        OrganizationResponseDto responseDto = organizationService.create(requestDto);
        return ResponseEntity
                .created(URI.create("/" + responseDto.getId()))
                .build();
    }

    @GetMapping("/{name}")
    public ResponseEntity<OrganizationResponseDto> getGroup(@PathVariable String name){
        return new ResponseEntity(organizationService.findByName(name), HttpStatus.OK);
    }
}
