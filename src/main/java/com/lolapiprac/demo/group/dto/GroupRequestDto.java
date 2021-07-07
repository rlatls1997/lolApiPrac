package com.lolapiprac.demo.group.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@Getter
public class GroupRequestDto {
    @NotBlank(message = "그룹명을 입력하세요.")
    @Length(min = 2, max = 10)
    private String name;

    @NotBlank(message = "그룹 접근 비밀번호를 입력하세요.")
    private String password;
}
