package com.jc.entity;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CheckAll {
    private Integer id;
    private String  name;
    private String morning;
    private String afternoon;
    private Integer situation;


    public CheckAll ( String name, String morning, String afternoon, Integer situation ) {
        this.name = name;
        this.morning = morning;
        this.afternoon = afternoon;
        this.situation = situation;
    }

    public CheckAll ( String name, String morning, Integer situation ) {
        this.name = name;
        this.morning = morning;
        this.situation = situation;
    }
}



