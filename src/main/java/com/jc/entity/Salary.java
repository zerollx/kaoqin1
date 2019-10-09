package com.jc.entity;
import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Salary {
    private Integer id;
    private String peopleCode;
    private String salaryPeople;
    private Double salary;
    private String start;
    private String end;

    public Salary ( String peopleCode, String salaryPeople, Double salary, String start, String end ) {
        this.peopleCode = peopleCode;
        this.salaryPeople = salaryPeople;
        this.salary = salary;
        this.start = start;
        this.end = end;
    }
}
