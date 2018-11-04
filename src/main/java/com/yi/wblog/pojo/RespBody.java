package com.yi.wblog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 响应信息体
 * @author wjy
 *
 */
@Data
public class RespBody {
	private String code;
	private String msg;
	
	public RespBody(String code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}
}
