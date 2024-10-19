package com.example.church_web.dto;

import com.example.church_web.domain.Worship;
import lombok.Getter;
import lombok.Setter;

public class WorshipDto {

    @Setter
    @Getter
    public static class CreateReqDto {
        private String title;
        private String url;

        // Request DTO를 Entity로 변환
        public Worship toEntity() {
            Worship worship = new Worship();
            worship.setTitle(title);
            worship.setUrl(url);
            return worship;
        }
    }

    @Setter
    @Getter
    public static class UpdateReqDto {
        private Long id;
        private String title;
        private String url;
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
        private String url;
        private String uploadDate;

        // Entity를 DTO로 변환
        public DetailResDto(Worship worship) {
            this.id = worship.getId();
            this.title = worship.getTitle();
            this.url = worship.getUrl();
            this.uploadDate = worship.getUploadDate().toString();  // Date를 String으로 변환
        }
    }
}
