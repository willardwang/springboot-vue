package pri.willard.springbootvue.exception;

import com.alibaba.fastjson.JSONObject;

/**
 * @author wangshibao
 * Created on 2019/4/4
 */
public class CustomException extends RuntimeException {
	private ExceptionCode code;

	public CustomException(ExceptionCode code, String message) {
		super(message);
		this.code = code;
	}

	public String toJSONString() {
		JSONObject jo = new JSONObject();
		jo.put("code", this.code.getCode());
		jo.put("message", this.getMessage());
		return jo.toString();
	}
}
