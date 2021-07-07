package com.lolapiprac.demo.group.dto;

import com.lolapiprac.demo.Member.entity.Member;
import com.lolapiprac.demo.group.entity.Group;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GroupResponseDto {
    private Long id;
    private String name;
    private List<Member> members;

    public static GroupResponseDto from(Group group){
        return new GroupResponseDto(group.getId(), group.getName(), group.getMembers());
    }
}
