package com.jc.entity;

import lombok.*;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Leave {
    private static int LEAVE_STATUS_WAIT=0; //等待审核
    private static int LEAVE_STATUS_AGREE=1; //审核通过
    private static int LEAVE_STATUS_DISAGREE=-1;//审核未通过
    private Integer id;
    private String leavePeople;
    private String start;
    private String end;
    private String reason;
    private Integer status = LEAVE_STATUS_WAIT;

    public Leave ( String leavePeople, String start, String end, String reason, Integer status ) {
        this.leavePeople = leavePeople;
        this.start = start;
        this.end = end;
        this.reason = reason;
        this.status = status;
    }

    public Leave ( String leavePeople, String start, String end, String reason ) {
        this.leavePeople = leavePeople;
        this.start = start;
        this.end = end;
        this.reason = reason;
    }

    public Leave ( Integer id,Integer status ) {
        this.id=id;
        this.status = status;
    }
}
