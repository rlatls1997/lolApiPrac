package com.lolapiprac.demo.Member.service;

import com.lolapiprac.demo.Member.dto.MemberRequestDto;
import com.lolapiprac.demo.Member.dto.MemberResponseDto;
import com.lolapiprac.demo.Member.entity.Member;
import com.lolapiprac.demo.Member.repository.MemberRepository;
import com.lolapiprac.demo.group.dto.GroupResponseDto;
import com.lolapiprac.demo.group.entity.Group;
import com.lolapiprac.demo.group.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final GroupRepository groupRepository;

    public MemberResponseDto create(MemberRequestDto requestDto) {
        Group group = groupRepository.getById(requestDto.getGroupId());
        Member member = Member.builder()
                .group(group)
                .puuid(requestDto.getPuuid())
                .note(requestDto.getNote())
                .build();
        return MemberResponseDto.from(memberRepository.save(member));
    }

    public List<MemberResponseDto> findByGroupId(Long id){
        List<Member> members = memberRepository.findByGroupId(id);
        return members.stream()
                .map(MemberResponseDto::from)
                .collect(Collectors.toList());
    }
}
