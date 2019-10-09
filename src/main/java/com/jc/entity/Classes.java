package com.jc.entity;


import lombok.*;

@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Classes {
    private Integer id;
    private String cCode;
    private String cName;
    private String cMorning;
    private String cAfternoon;

    public Classes ( String cCode, String cName, String cMorning, String cAfternoon ) {
        this.cCode = cCode;
        this.cName = cName;
        this.cMorning = cMorning;
        this.cAfternoon = cAfternoon;
    }
}
