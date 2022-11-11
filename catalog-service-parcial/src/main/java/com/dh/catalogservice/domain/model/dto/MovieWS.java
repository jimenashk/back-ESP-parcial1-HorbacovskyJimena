package com.dh.catalogservice.domain.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class MovieWS {
    private Integer id;
    private String name;
    private String genre;
    private String urlStream;
}
