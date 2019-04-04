package pri.willard.springbootvue.exception;

public enum ExceptionCode {
	INTERNAL_SERVER_ERROR(500), MOBILE_ALREADY_EXISTS(1001);

	private int code;

	public int getCode() {
		return code;
	}

	ExceptionCode(int code) {
		this.code = code;
	}
}
