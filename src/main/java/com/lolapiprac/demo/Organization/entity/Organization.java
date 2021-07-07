package com.lolapiprac.demo.Organization.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.lolapiprac.demo.Member.entity.Member;
import com.lolapiprac.demo.common.timestamp.Timestamped;
import com.lolapiprac.demo.Organization.dto.OrganizationRequestDto;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Organization extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "그룹명을 입력하세요.")
    @Length(min = 2, max = 10)
    private String name;

    @NotBlank(message = "그룹 접근 비밀번호를 입력하세요.")
    private String password;

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JoinColumn(name = "organization_id", referencedColumnName = "id")
    @JsonManagedReference(value = "organization-member")
    private List<Member> members;

    public Organization(OrganizationRequestDto requestDto){
        this.name = requestDto.getName();
        this.password = requestDto.getPassword();
    }
}
