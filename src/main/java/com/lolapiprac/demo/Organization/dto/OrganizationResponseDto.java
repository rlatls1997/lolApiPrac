package com.lolapiprac.demo.Organization.dto;

import com.lolapiprac.demo.Member.entity.Member;
import com.lolapiprac.demo.Organization.entity.Organization;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationResponseDto {
    private Long id;
    private String name;
    private List<Member> members;

    public static OrganizationResponseDto from(Organization organization){
        return new OrganizationResponseDto(organization.getId(), organization.getName(), organization.getMembers());
    }
}
