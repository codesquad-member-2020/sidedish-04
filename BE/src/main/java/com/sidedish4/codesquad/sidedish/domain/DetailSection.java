package com.sidedish4.codesquad.sidedish.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@ToString
public class DetailSection {

    @Id
    private Long id;
    private String url;
}
