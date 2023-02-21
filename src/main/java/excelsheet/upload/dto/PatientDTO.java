package excelsheet.upload.dto;



import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientDTO {

	@Column(name = "firstName")
	private String firstName;

	@Column(name = "lastName")
	private String lastName;

	@Column(name = "phoneNumber")
	private String phoneNumber;

	@Column(name = "fees")
	private Double fees;

	@Column(name = "email")
	private String email;

//	public PatientDTO() {
//	}
//
//	public PatientDTO(String firstName, String lastName, String phoneNumber, Double fees, String email) {
//		super();
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.phoneNumber = phoneNumber;
//		this.fees = fees;
//		this.email = email;
//	}
//
//	public String getFirstName() {
//		return firstName;
//	}
//
//	public void setFirstName(String firstName) {
//		this.firstName = firstName;
//	}
//
//	public String getLastName() {
//		return lastName;
//	}
//
//	public void setLastName(String lastName) {
//		this.lastName = lastName;
//	}
//
//	public String getPhoneNumber() {
//		return phoneNumber;
//	}
//
//	public void setPhoneNumber(String phoneNumber) {
//		this.phoneNumber = phoneNumber;
//	}
//
//	public Double getFees() {
//		return fees;
//	}
//
//	public void setFees(Double fees) {
//		this.fees = fees;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	@Override
//	public String toString() {
//		return "PatientDTO [firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber=" + phoneNumber
//				+ ", fees=" + fees + ", email=" + email + "]";
//	}

	

}
