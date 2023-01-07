package com.microservices.demo.elastic.query.service.model;

import lombok.*;

import java.time.ZonedDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ElasticQueryServiceResponseModel {
    private String id;
    private Long userId;
    private String text;
    private ZonedDateTime createdAt;
}

