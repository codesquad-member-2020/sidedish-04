package com.sidedish4.codesquad.sidedish.domain;

import lombok.*;
import org.springframework.data.annotation.Id;

@NoArgsConstructor
public class DetailSection {

    @Id
    private Long id;
    private String url;

    @Builder
    public DetailSection(String url) {
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
        return "DetailSection{" +
                "id=" + id +
                ", url='" + url + '\'' +
                '}';
    }
}
