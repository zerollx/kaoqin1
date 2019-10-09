package com.jc.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResultMap {
    private String msg;
    private Integer code;
    private Object data;
    private Integer count;
    private String src;
    private String error;

    public ResultMap ( Integer code ) {
        this.code = code;
    }

    public ResultMap ( String src ) {
        this.src = src;
    }
    public ResultMap ( String msg, Integer code ) {
        this.msg = msg;
        this.code = code;
    }

    public ResultMap ( String msg, Integer code, Object data ) {
        this.msg = msg;
        this.code = code;
        this.data = data;
    }

    public static ResultMap srcOk( String src){
        return  new ResultMap (src);
    }


    public static ResultMap ok ( Object data ) {
        return new ResultMap ( " ", 0, data );
    }

    public static ResultMap okCode () {
        return new ResultMap ( 200 );
    }

    public static ResultMap failCode () {
        return new ResultMap ( 500 );
    }


    public static ResultMap msgLayuiok ( String msg, Integer code , Object data ) {
        return new ResultMap ( msg, code, data );
    }



}
