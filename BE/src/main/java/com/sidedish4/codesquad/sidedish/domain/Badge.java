package com.sidedish4.codesquad.sidedish.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@Getter
@NoArgsConstructor
@ToString
public class Badge {

    @Id
    private Long id;
    private String name;

    public Badge(String name) {
        this.name = name;
    }
}
