package pri.willard.springbootvue.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author wangshibao
 * Created on 2019/4/4
 */
@ControllerAdvice
public class GlobalControllerExceptionHandler {

	@ExceptionHandler(CustomException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public Object customHandler(CustomException e) {
		e.printStackTrace();
		return e.toJSONString();
	}

	@ExceptionHandler(Exception.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public Object exceptionHandler(Exception e) {
		e.printStackTrace();
		CustomException customException = new CustomException(ExceptionCode.INTERNAL_SERVER_ERROR, "error");
		return customException.toJSONString();
	}
}
