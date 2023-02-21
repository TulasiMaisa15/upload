package excelsheet.upload.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {

	private int statusCode;

	private String successMessage;

	private String errorMessage;

	private Object data;

//	public Result() {
//	}
//
//	public Result(Object data) {
//		this.data = data;
//	}
//
//	public int getStatusCode() {
//		return statusCode;
//	}
//
//	public void setStatusCode(int statusCode) {
//		this.statusCode = statusCode;
//	}
//
//	public String getSuccessMessage() {
//		return successMessage;
//	}
//
//	public void setSuccessMessage(String successMessage) {
//		this.successMessage = successMessage;
//	}
//
//	public String getErrorMessage() {
//		return errorMessage;
//	}
//
//	public void setErrorMessage(String errorMessage) {
//		this.errorMessage = errorMessage;
//	}
//
//	public Object getData() {
//		return data;
//	}
//
//	public void setData(Object data) {
//		this.data = data;
//	}
//
//	@Override
//	public String toString() {
//		return "Result [statusCode=" + statusCode + ", successMessage=" + successMessage + ", errorMessage="
//				+ errorMessage + ", data=" + data + "]";
//	}

}
