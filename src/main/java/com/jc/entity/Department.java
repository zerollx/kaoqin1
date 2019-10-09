package com.jc.entity;


import lombok.*;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@Data
public class Department {
    private Integer id;
    private String departCode;
    private String departName;
    private String departLeading; //负责人
    private String departDuty; //部门职责
    private String departSuperDepart;//上级部门


    public Department ( String departCode, String departName, String departLeading, String departDuty, String departSuperDepart ) {
        this.departCode = departCode;
        this.departName = departName;
        this.departLeading = departLeading;
        this.departDuty = departDuty;
        this.departSuperDepart = departSuperDepart;
    }
}
