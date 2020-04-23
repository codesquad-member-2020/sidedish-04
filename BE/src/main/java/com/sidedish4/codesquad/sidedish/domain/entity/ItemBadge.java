package com.sidedish4.codesquad.sidedish.domain.entity;

import org.springframework.data.relational.core.mapping.Column;

public class ItemBadge {
    @Column("badge")
    private Long badgeId;

    public ItemBadge(Long badgeId) {
        this.badgeId = badgeId;
    }

    public Long getBadgeId() {
        return badgeId;
    }

    public void setBadgeId(Long badgeId) {
        this.badgeId = badgeId;
    }

    @Override
    public String toString() {
        return "ItemBadge{" +
                "badgeId=" + badgeId +
                '}';
    }
}
