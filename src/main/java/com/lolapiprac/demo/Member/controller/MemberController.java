package com.lolapiprac.demo.Member.controller;

import com.lolapiprac.demo.Member.dto.MemberRequestDto;
import com.lolapiprac.demo.Member.dto.MemberResponseDto;
import com.lolapiprac.demo.Member.entity.Member;
import com.lolapiprac.demo.Member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<String> createMember(@RequestBody MemberRequestDto requestDto) {
        MemberResponseDto member = memberService.create(requestDto);
        return ResponseEntity.created(URI.create("/" + member.getId())).build();
    }

    @GetMapping("/list/{organizationId}")
    public ResponseEntity<List<MemberResponseDto>> getMembers(@PathVariable Long organizationId) {
        List<MemberResponseDto> members = memberService.findByGroupId(organizationId);
        return new ResponseEntity(members, HttpStatus.OK);
    }
}