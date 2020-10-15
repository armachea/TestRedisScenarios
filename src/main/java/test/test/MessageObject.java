package test.test;

import java.io.Serializable;

public class MessageObject implements Serializable {

	private static final long serialVersionUID = 1L;
	private String senderId;
	private String message;
	private String status;
	private String gt;
	private String code;
	
	public MessageObject(String senderId, String message, String status, String gt, String code) {
		super();
		this.senderId = senderId;
		this.message = message;
		this.status = status;
		this.gt = gt;
		this.code = code;
	}

	public String getSenderId() {
		return senderId;
	}

	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getGt() {
		return gt;
	}

	public void setGt(String gt) {
		this.gt = gt;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "MessageObject [senderId=" + senderId + ", message=" + message + ", status=" + status + ", gt=" + gt
				+ ", code="+ code + "]";
	}
	
}
	