package com.lolapiprac.demo.Member.service;

import com.lolapiprac.demo.Member.dto.MemberRequestDto;
import com.lolapiprac.demo.Member.dto.MemberResponseDto;
import com.lolapiprac.demo.Member.entity.Member;
import com.lolapiprac.demo.Member.repository.MemberRepository;
import com.lolapiprac.demo.Organization.entity.Organization;
import com.lolapiprac.demo.Organization.repository.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final OrganizationRepository organizationRepository;

    public MemberResponseDto create(MemberRequestDto requestDto) {
        Organization organization = organizationRepository.getById(requestDto.getOrganizationId());
        Member member = Member.builder()
                .organizationId(organization)
                .puuid(requestDto.getPuuid())
                .note(requestDto.getNote())
                .build();
        return MemberResponseDto.from(memberRepository.save(member));
    }

    public List<MemberResponseDto> findByGroupId(Long id){
        List<Member> members = memberRepository.findByOrganizationId(id);
        return members.stream()
                .map(MemberResponseDto::from)
                .collect(Collectors.toList());
    }
}
