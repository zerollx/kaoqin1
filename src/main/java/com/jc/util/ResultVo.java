package com.jc.util;

public class ResultVo {
		private Integer code;
	private String msg;
	private Integer count=0;
	private Object data;
		public Integer getCode() {
		return code;
	}
		public void setCode(Integer code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public long getCount() {
		return count;
	}
	public void setCount(Integer l) {
		this.count = l;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
}

