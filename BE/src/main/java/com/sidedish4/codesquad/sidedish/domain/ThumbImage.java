package com.sidedish4.codesquad.sidedish.domain;

import lombok.Builder;
import org.springframework.data.annotation.Id;

public class ThumbImage {

    @Id
    private Long id;
    private String url;

    @Builder
    public ThumbImage(String url) {
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "ThumbImage{" +
                "id=" + id +
                ", url='" + url + '\'' +
                '}';
    }
}
