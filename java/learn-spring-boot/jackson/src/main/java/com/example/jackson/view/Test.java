package com.example.jackson.view;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import java.util.Date;

@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
//@JsonPropertyOrder(value = {"date", "a-username"})
@JsonPropertyOrder(alphabetic = true)
public class Test {

    @JsonIgnore
    private String id;

    @JsonProperty("a-username")
    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="Asia/Shanghai")
    private Date date;

    private String nil;

}
