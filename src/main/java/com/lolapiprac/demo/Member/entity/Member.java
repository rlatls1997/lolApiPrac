package com.lolapiprac.demo.Member.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.lolapiprac.demo.common.timestamp.Timestamped;
import com.lolapiprac.demo.Organization.entity.Organization;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Builder
public class Member extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "organization_id")
    @NotBlank(message = "organization is Null")
    @JsonBackReference(value="organization-member")
    private Organization organizationId;

    @Column
    @NotBlank(message = "puuid is Null")
    private String puuid;

    @Column
    @Length(max = 20)
    private String note;
}