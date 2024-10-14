package com.example.church_web.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Welcome {
    @Id
    Integer id;
    String name;
    String gender;
    String email;
    String phone;
    String address;
    public enum BaptismType {
        INFANT, ADULT
    }

    private BaptismType baptismType; // 결혼 종류
    public enum MarriageType {
        YES,NO
    }

    private MarriageType marriageType;

    public enum Relationship {
        PARENT, SIBLING, CHILD, SPOUSE, GRANDPARENT, OTHER
    }

    private Relationship relationship;









}

/*
DAO 의 종류

Repo / Mapper 2가지가 존재함.
Repo 는 자동_ Entity class 사용 , Mapper 는 수동
PK 를 위한 annotation은 @Id ..

*/

