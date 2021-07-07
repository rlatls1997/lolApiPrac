package com.lolapiprac.demo.group.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.lolapiprac.demo.Member.entity.Member;
import com.lolapiprac.demo.common.timestamp.Timestamped;
import com.lolapiprac.demo.group.dto.GroupRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Group extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "그룹명을 입력하세요.")
    @Length(min = 2, max = 10)
    @Column(unique = true)
    private String name;

    @NotBlank(message = "그룹 접근 비밀번호를 입력하세요.")
    private String password;

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    @JsonManagedReference(value = "group-member")
    private List<Member> members;

    public Group(GroupRequestDto requestDto){
        this.name = requestDto.getName();
        this.password = requestDto.getPassword();
    }
}
