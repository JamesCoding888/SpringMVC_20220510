package com.mvc.exception;
import java.util.Date;
public class AuthException extends RuntimeException  {
	/*
	RuntimeException 在 Java 虛擬機正常運行期間拋出的異常的超類。編譯器不會檢查 RuntimeException 異常。
	當程序中可能出現這類異常時，倘若既沒有通過 throws 聲明拋出它，也沒有用 try catch 語句捕獲它，程序還是會編譯通過。
	*/
	private static final long serialVersionUID = 1L;
	
	private Date date;
	private String message;

	// 建議一定要加上有參建構子，因為當錯誤發生，若用無參建構子，例外發生但沒有任何錯誤訊息，會很奇怪
	public AuthException(Date date, String message) {
		super();
		this.date = date;
		this.message = message;
	}
	
	/* 序列化 ID 不需要封裝，請勿執行 getter and setter 封裝。因為序列化 ID 是後續要做序列化處理有關係
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	*/
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
