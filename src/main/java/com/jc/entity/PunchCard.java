package com.jc.entity;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PunchCard {

    private Integer id;
    private String punchPeople;
    private String punchDate;
    private Integer punchRemarks;

    public PunchCard ( String punchPeople, String punchDate, Integer punchRemarks ) {
        this.punchPeople = punchPeople;
        this.punchDate = punchDate;
        this.punchRemarks = punchRemarks;
    }
}
