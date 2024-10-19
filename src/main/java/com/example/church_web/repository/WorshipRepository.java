package com.example.church_web.repository;
import com.example.church_web.domain.Worship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface WorshipRepository extends JpaRepository<Worship, String>  {
}
