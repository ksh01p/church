package com.example.church_web.repository;

import com.example.church_web.domain.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ApplicationRepository extends JpaRepository<Application, String> {

}


/*

 DAO 중 2번째 Repo를 의미하는 Interface임.. 자동으로 연결하는 시스템으로 JPA 사용
 기능을 대행해주는 것이 Entity.. (getter @ setter 는 Entitu 안에서 형성됨)..

 */