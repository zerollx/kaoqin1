package com.jc.entity;


import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Login {
    private Integer id;
    private String userName;
    private String password;
    private String identity;
}
