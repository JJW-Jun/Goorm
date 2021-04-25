package com.example.jpawebapplication.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;
import java.util.ArrayList;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded // 내장타입
    private Address address;

    @OneToMany(mappedBy = "member") // foreign 키 하나만 변경하면되고 이걸 주인으로 정한다.
    // orderTable의 멤버엥 의해서. 나는 쟤에 의해서 맵핑될 뿐...
    private List<Order> orders = new ArrayList<>();




}