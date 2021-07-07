package com.lolapiprac.demo.Member.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.lolapiprac.demo.group.entity.Group;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Getter
@NoArgsConstructor
public class MemberRequestDto {
    @Positive(message = "group is Null")
    private Long groupId;

    @NotBlank(message = "puuid is Null")
    private String puuid;

    @Length(max = 20)
    private String note;
}
