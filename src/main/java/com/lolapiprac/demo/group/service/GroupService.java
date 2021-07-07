package com.lolapiprac.demo.group.service;

import com.lolapiprac.demo.group.dto.GroupRequestDto;
import com.lolapiprac.demo.group.dto.GroupResponseDto;
import com.lolapiprac.demo.group.entity.Group;
import com.lolapiprac.demo.group.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GroupService {
    private final GroupRepository groupRepository;

    public GroupResponseDto create(GroupRequestDto requestDto){
        Group group = new Group(requestDto);
        return GroupResponseDto.from(groupRepository.save(group));
    }

    public GroupResponseDto findByName(String name){
        Group group = groupRepository.findByName(name).orElseThrow(()->
                new IllegalArgumentException("없음"));
        return GroupResponseDto.from(group);
    }
}
