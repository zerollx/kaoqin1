package com.jc.entity;

import lombok.*;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Employee {
    private Integer id;
    @NotEmpty(message = "员工编码不能为空")
    @Size(min = 4,max = 20,message = "姓名长度必须在{min}-{max}之间")
    private String empCode; //员工编码
    private String empName;
    private String empSex;
    @Min( value = 0,message = "年龄不能小于{value}")
    @Max( value = 60,message = "年龄不能大于{value}")
    private Integer empAge;
    private String empNation;//员工名族
    private String empCard; //员工身份证
    private Double empSalary;//员工薪水
    @Pattern( regexp = "^1([38][0-9]|4[579]|5[0-3,5-9]|6[6]|7[0135678]|9[89])\\d{8}$",message = "手机号不正确")
    private String empPhone;
    private String empEmergencyContact;//紧急联系人
    private String empEmergencyPhone;//紧急电话
    private String empDescribe; //个人描述
    private String empPositionId;
    private String empImg;//员工头像
    private Station station;

    public Employee ( String empCode, String empName, String empSex, Integer empAge, String empNation, String empCard, Double empSalary, String empPhone, String empEmergencyContact, String empEmergencyPhone, String empDescribe, String empPositionId, String empImg ) {
        this.empCode = empCode;
        this.empName = empName;
        this.empSex = empSex;
        this.empAge = empAge;
        this.empNation = empNation;
        this.empCard = empCard;
        this.empSalary = empSalary;
        this.empPhone = empPhone;
        this.empEmergencyContact = empEmergencyContact;
        this.empEmergencyPhone = empEmergencyPhone;
        this.empDescribe = empDescribe;
        this.empPositionId = empPositionId;
        this.empImg = empImg;
    }


    public Employee ( Integer id,String empName, String empSex, Integer empAge, String empNation, String empCard, Double empSalary,  String empPhone, String empEmergencyContact, String empEmergencyPhone, String empPositionId, String empDescribe ) {
        this.id = id;
        this.empName = empName;
        this.empSex = empSex;
        this.empAge = empAge;
        this.empNation = empNation;
        this.empCard = empCard;
        this.empSalary = empSalary;
        this.empPhone = empPhone;
        this.empEmergencyContact = empEmergencyContact;
        this.empEmergencyPhone = empEmergencyPhone;
        this.empPositionId = empPositionId;
        this.empDescribe = empDescribe;
    }
}
