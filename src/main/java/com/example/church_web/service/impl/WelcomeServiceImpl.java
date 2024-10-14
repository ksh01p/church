package com.example.church_web.service.impl;

import com.example.church_web.domain.Welcome;
import com.example.church_web.repository.WelcomeRepository;
import com.example.church_web.service.WelcomeService;
import org.springframework.stereotype.Service;

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

        // Handling family members
        List<Welcome.FamilyMember> familyMembers = new ArrayList<>();
        List<Map<String, String>> membersParams = (List<Map<String, String>>) params.get("familyMembers");
        if (membersParams != null) {
            for (Map<String, String> memberParams : membersParams) {
                Welcome.FamilyMember familyMember = new Welcome.FamilyMember();
                familyMember.setName(memberParams.get("name"));
                familyMember.setRelationship(Welcome.FamilyMember.Relationship.valueOf(memberParams.get("relationship")));
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

    @Override
    public Map<String, Object> updateWelcome(Map<String, Object> params) {
        System.out.println("updateWelcome");
        Welcome welcome = welcomeRepository.findById(params.get("id").toString())
                .orElseThrow(() -> new RuntimeException("Welcome not found"));

        welcome.setName(params.get("name").toString());
        welcome.setGender(params.get("gender").toString());
        welcome.setEmail(params.get("email").toString());
        welcome.setPhone(params.get("phone").toString());
        welcome.setAddress(params.get("address").toString());
        welcome.setBaptismType(Welcome.BaptismType.valueOf(params.get("baptismType").toString()));
        welcome.setMarriageType(Welcome.MarriageType.valueOf(params.get("marriageType").toString()));

        // Update family members
        List<Welcome.FamilyMember> familyMembers = new ArrayList<>();
        List<Map<String, String>> membersParams = (List<Map<String, String>>) params.get("familyMembers");
        if (membersParams != null) {
            for (Map<String, String> memberParams : membersParams) {
                Welcome.FamilyMember familyMember = new Welcome.FamilyMember();
                familyMember.setName(memberParams.get("name"));
                familyMember.setRelationship(Welcome.FamilyMember.Relationship.valueOf(memberParams.get("relationship")));
                familyMembers.add(familyMember);
            }
        }
        welcome.setFamilyMembers(familyMembers);

        welcomeRepository.save(welcome);
        return new HashMap<>() {{
            put("status", "success");
            put("message", "Welcome updated successfully.");
        }};
    }

    @Override
    public List<Welcome> listWelcome() {
        return welcomeRepository.findAll();
    }

    @Override
    public Welcome detailWelcome(Integer id) {
        return welcomeRepository.findById(id + "").orElseThrow(() -> new RuntimeException("Welcome not found"));
    }

    @Override
    public Map<String, Object> deleteWelcome(Integer id) {
        Welcome welcome = welcomeRepository.findById(id + "").orElseThrow(() -> new RuntimeException("Welcome not found"));
        welcomeRepository.delete(welcome);
        return new HashMap<>() {{
            put("status", "success");
            put("message", "Welcome deleted successfully.");
        }};
    }
}
