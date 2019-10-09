package com.jc.entity;

import lombok.*;

import java.util.ArrayList;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class StationPageBean<T> {
    private Integer pageSize;
    private Integer pageCount;
    private Integer countTotal;
    private Integer currentPage;
    private String sName;
    private ArrayList<T> list;


}
