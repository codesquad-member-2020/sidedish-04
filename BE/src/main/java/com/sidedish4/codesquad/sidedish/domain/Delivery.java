package com.sidedish4.codesquad.sidedish.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@Getter
@NoArgsConstructor
@ToString
public class Delivery {

    @Id
    private Long id;
    private String type;

    public Delivery(String type) {
        this.type = type;
    }
}
