package com.jc.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class Station {
    private Integer id;
    private String sCode; //岗位编码
    private String sName; //岗位名称
    private String sPart;//所在部门
    private String sSuper;//直接上级
    private String sType;//岗位类别
    private String sDescribe;
    private String empPositionId; //岗位ID

    public Station ( String sCode, String sName, String sPart, String sSuper, String sType, String sDescribe, String empPositionId ) {
        this.sCode = sCode;
        this.sName = sName;
        this.sPart = sPart;
        this.sSuper = sSuper;
        this.sType = sType;
        this.sDescribe = sDescribe;
        this.empPositionId = empPositionId;
    }

    public Station ( Integer id, String sCode, String sName, String sPart, String sSuper, String sType, String sDescribe ) {
        this.id = id;
        this.sCode = sCode;
        this.sName = sName;
        this.sPart = sPart;
        this.sSuper = sSuper;
        this.sType = sType;
        this.sDescribe = sDescribe;
    }
}
