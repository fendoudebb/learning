package com.example.demo.test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("test_dto")
public class TestDto {

    @Id
    private String id;
//    @MongoId
//    private String id;

    private String status;

    @Field("update_ts")
    private long updateTs;

    @Transient
    private String ignoreProperty;

}
