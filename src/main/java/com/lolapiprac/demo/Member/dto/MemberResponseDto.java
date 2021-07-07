package com.lolapiprac.demo.Member.dto;

import com.lolapiprac.demo.Member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberResponseDto {
    private Long id;
    private String puuid;
    private String note;

    public static MemberResponseDto from(Member member){
        return new MemberResponseDto(member.getId(), member.getPuuid(), member.getNote());
    }
}
