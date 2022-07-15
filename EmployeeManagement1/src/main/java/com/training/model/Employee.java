package com.training.model;

public class Employee 
{
	private String employeeId;
	private String firstName;
	private String lastName;
	private String gender;
	private int age;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String country;
	private int pinCode;
	private long phoneNumber;
	private String email;
	private String password;
	private String roleType;
	private String managerId;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	/**
	 * @param employeeId
	 * @param firstName
	 * @param lastName
	 * @param gender
	 * @param age
	 * @param address1
	 * @param address2
	 * @param city
	 * @param state
	 * @param country
	 * @param pinCode
	 * @param phoneNumber
	 * @param email
	 * @param password
	 * @param roleType
	 * @param managerId
	 */
	public Employee(String employeeId, String firstName, String lastName, String gender, int age, String address1,
			String address2, String city, String state, String country, int pinCode, long phoneNumber, String email,
			String password, String roleType, String managerId) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.age = age;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pinCode = pinCode;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.password = password;
		this.roleType = roleType;
		this.managerId = managerId;
	}


	public Employee(String employeeId, String password, String roleType) {
		super();
		this.employeeId = employeeId;
		this.password = password;
		this.roleType = roleType;
	}
	
	public Employee(String employeeId) {
		super();
		this.employeeId = employeeId;
	}

	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getPinCode() {
		return pinCode;
	}
	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRoleType() {
		return roleType;
	}
	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}
	public String getManagerId() {
		return managerId;
	}
	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", gender=" + gender + ", age=" + age + ", address1=" + address1 + ", address2=" + address2
				+ ", city=" + city + ", state=" + state + ", country=" + country + ", pinCode=" + pinCode
				+ ", phoneNumber=" + phoneNumber + ", email=" + email + ", password=" + password + ", rollType="
				+ roleType + ", managerId=" + managerId + "]";
	}
}
