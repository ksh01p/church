package com.example.church_web.domain;
import com.example.church_web.dto.WorshipDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
public class Worship {

    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Getter
    private String title;

    @Setter
    @Getter
    private String vId;

    @Setter
    @Getter
    private LocalDateTime uploadDate;

    public Worship() {}


}