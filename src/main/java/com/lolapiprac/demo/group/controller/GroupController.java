package com.lolapiprac.demo.group.controller;

import com.lolapiprac.demo.group.dto.GroupRequestDto;
import com.lolapiprac.demo.group.dto.GroupResponseDto;
import com.lolapiprac.demo.group.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/groups")
public class GroupController {
    private final GroupService groupService;

    @PostMapping
    public ResponseEntity<String> createGroup(@RequestBody GroupRequestDto requestDto){
        GroupResponseDto responseDto = groupService.create(requestDto);
        return ResponseEntity
                .created(URI.create("/" + responseDto.getId()))
                .build();
    }

    @GetMapping("/{name}")
    public ResponseEntity<GroupResponseDto> getGroup(@PathVariable String name){
        return new ResponseEntity(groupService.findByName(name), HttpStatus.OK);
    }
}
