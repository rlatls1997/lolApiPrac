package com.lolapiprac.demo.Member.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Getter
@NoArgsConstructor
public class MemberRequestDto {
    @Positive(message = "organizationId is Null")
    private Long organizationId;

    @NotBlank(message = "puuid is Null")
    private String puuid;

    @Length(max = 20)
    private String note;
}
