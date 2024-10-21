package com.example.church_web.dto;

import com.example.church_web.domain.Worship;
import lombok.Getter;
import lombok.Setter;

public class WorshipDto {

    @Setter
    @Getter
    public static class CreateReqDto {
        private String title;
        private String vid;

        public Worship toEntity() {
            Worship worship = new Worship();
            worship.setTitle(title);
            worship.setVId(vid);
            return worship;
        }
    }

    @Setter
    @Getter
    public static class UpdateReqDto {
        private Long id;
        private String title;
        private String vId;
    }

    @Setter
    @Getter
    public static class CreateResDto {
        private Long id;
    }

    @Setter
    @Getter
    public static class DetailResDto {
        private Long id;
        private String title;
        private String vId;
    }
}
