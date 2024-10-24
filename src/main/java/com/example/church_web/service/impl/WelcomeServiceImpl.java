package com.example.church_web.service.impl;

import com.example.church_web.domain.Welcome;
import com.example.church_web.repository.WelcomeRepository;
import com.example.church_web.service.WelcomeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WelcomeServiceImpl implements WelcomeService {

    private final WelcomeRepository welcomeRepository;

    public WelcomeServiceImpl(WelcomeRepository welcomeRepository) {
        this.welcomeRepository = welcomeRepository;
    }

    @Transactional
    @Override
    public Map<String, Object> createWelcome(Map<String, Object> params) {
        System.out.println("createWelcome");
        Welcome welcome = new Welcome();
        welcome.setId(Integer.parseInt(params.get("id").toString()));
        welcome.setName(params.get("name").toString());
        welcome.setGender(params.get("gender").toString());
        welcome.setEmail(params.get("email").toString());
        welcome.setPhone(params.get("phone").toString());
        welcome.setAddress(params.get("address").toString());
        welcome.setBaptismType(Welcome.BaptismType.valueOf(params.get("baptismType").toString()));
        welcome.setMarriageType(Welcome.MarriageType.valueOf(params.get("marriageType").toString()));

        List<Welcome.w_FamilyMember> familyMembers = new ArrayList<>();
        List<Map<String, String>> membersParams = (List<Map<String, String>>) params.get("w_familyMembers");
        if (membersParams != null) {
            for (Map<String, String> memberParams : membersParams) {
                Welcome.w_FamilyMember familyMember = new Welcome.w_FamilyMember();
                familyMember.setName(memberParams.get("name"));
                familyMember.setRelationship(Welcome.w_FamilyMember.Relationship.valueOf(memberParams.get("relationship")));
                familyMembers.add(familyMember);
            }
        }
        welcome.setFamilyMembers(familyMembers);

        welcomeRepository.save(welcome);
        return new HashMap<>() {{
            put("status", "success");
            put("message", "Welcome created successfully.");
        }};
    }

}
