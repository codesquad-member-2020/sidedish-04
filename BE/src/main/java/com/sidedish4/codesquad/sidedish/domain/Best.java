package com.sidedish4.codesquad.sidedish.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.util.List;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@ToString
public class Best {

    @Id
    private Long id;
    private String name;
    private List<Item> items;
}
