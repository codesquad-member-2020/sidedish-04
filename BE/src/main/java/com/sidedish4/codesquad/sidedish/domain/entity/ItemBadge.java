package com.sidedish4.codesquad.sidedish.domain.entity;

import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("item_badge")
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
