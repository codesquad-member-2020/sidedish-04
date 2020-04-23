package com.sidedish4.codesquad.sidedish.domain.entity;

import org.springframework.data.annotation.Id;

public class Badge {
    @Id
    private Long id;
    private String badgeName;

    public Badge(String badgeName) {
        this.badgeName = badgeName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBadgeName() {
        return badgeName;
    }

    public void setBadgeName(String badgeName) {
        this.badgeName = badgeName;
    }

    @Override
    public String toString() {
        return "Badge{" +
                "id=" + id +
                ", badgeName='" + badgeName + '\'' +
                '}';
    }
}
