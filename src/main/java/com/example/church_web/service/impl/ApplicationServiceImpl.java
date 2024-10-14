package com.example.church_web.service.impl;

import com.example.church_web.domain.Application;
import com.example.church_web.repository.ApplicationRepository;
import com.example.church_web.service.ApplicationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;

    public ApplicationServiceImpl(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    @Transactional
    @Override
    public Map<String, Object> createApplication(Map<String, Object> params) {
        System.out.println("createApplication");
        Application application = new Application();
        application.setId(Integer.parseInt(params.get("id").toString()));
        application.setName(params.get("name").toString());
        application.setGender(params.get("gender").toString());
        application.setEmail(params.get("email").toString());
        application.setPhone(params.get("phone").toString());
        application.setAddress(params.get("address").toString());
        application.setBaptismType(Application.BaptismType.valueOf(params.get("baptismType").toString()));
        application.setMarriageType(Application.MarriageType.valueOf(params.get("marriageType").toString()));

        List<Application.FamilyMember> familyMembers = new ArrayList<>();
        List<Map<String, String>> membersParams = (List<Map<String, String>>) params.get("familyMembers");
        if (membersParams != null) {
            for (Map<String, String> memberParams : membersParams) {
                Application.FamilyMember familyMember = new Application.FamilyMember();
                familyMember.setName(memberParams.get("name"));
                familyMember.setRelationship(Application.FamilyMember.Relationship.valueOf(memberParams.get("relationship")));
                familyMembers.add(familyMember);
            }
        }
        application.setFamilyMembers(familyMembers);

        applicationRepository.save(application);
        return new HashMap<>() {{
            put("status", "success");
            put("message", "Welcome created successfully.");
        }};
    }

}
