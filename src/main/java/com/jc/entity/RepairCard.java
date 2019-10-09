package com.jc.entity;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RepairCard {

    private Integer id;
    private String repairPeople;
    private String repairDate;
    private String repairReason;

    public RepairCard ( String repairPeople, String repairDate, String repairReason ) {
        this.repairPeople = repairPeople;
        this.repairDate = repairDate;
        this.repairReason = repairReason;
    }
}
