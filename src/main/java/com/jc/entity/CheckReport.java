package com.jc.entity;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CheckReport {
    private Integer id;
    private String name;
    private String morning;
    private String afternoon;
    private Integer situation;
    private String type;


    public CheckReport ( String name, String morning, String afternoon, Integer situation ) {
        this.name = name;
        this.morning = morning;
        this.afternoon = afternoon;
        this.situation = situation;
    }

    public CheckReport ( String name, String morning, Integer situation, String type ) {
        this.type = type;
        this.name = name;
        this.morning = morning;
        this.situation = situation;
    }
}



