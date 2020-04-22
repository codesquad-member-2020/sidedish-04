package com.sidedish4.codesquad.sidedish.domain;

import org.springframework.data.annotation.Id;

public class DetailImage {
    @Id
    private Long id;
    private String url;


    public Long getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "DetailImage{" +
                "id=" + id +
                ", url='" + url + '\'' +
                '}';
    }
}
