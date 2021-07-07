package com.lolapiprac.demo.Member.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.lolapiprac.demo.Member.dto.MemberRequestDto;
import com.lolapiprac.demo.common.timestamp.Timestamped;
import com.lolapiprac.demo.group.entity.Group;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@NoArgsConstructor
@Getter
@Builder
public class Member extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "group_id")
    @NotBlank(message = "group is Null")
    @JsonBackReference(value="group-member")
    private Group group;

    @Column
    @NotBlank(message = "puuid is Null")
    private String puuid;

    @Column
    @Length(max = 20)
    private String note;
}