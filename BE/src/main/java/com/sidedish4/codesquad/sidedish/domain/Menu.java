package com.sidedish4.codesquad.sidedish.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.util.List;


@ToString
@NoArgsConstructor
@Getter
public class Menu {

    @Id
    private Long id;
    private String name;
    private List<Item> items;

}
