package com.example.church_web.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Application {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
        YES, NO
    }

    private MarriageType marriageType;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name ="application_id")
    private List<FamilyMember> familyMembers = new ArrayList<>();

    public void addFamilyMember(FamilyMember member) {
        if (familyMembers.size() < 6) {
            familyMembers.add(member);
        } else {
            throw new IllegalArgumentException("Cannot add more than 6 family members");
        }
    }

    @Getter
    @Setter
    @Entity
    public static class FamilyMember {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer memberId; // Unique ID for each family member
        private String name;
        private Relationship relationship;

        public enum Relationship {
            PARENT, SIBLING, CHILD, SPOUSE, GRANDPARENT, OTHER
        }
    }
}
