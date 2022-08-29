package com.itc.main.vo;
public class Department {

	private Long departmentId;
	private String departmentName;
	private String departmentLocation;
	public Department() {
		super();
	}
	public Department(Long departmentId, String departmentName, String departmentLocation) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.departmentLocation = departmentLocation;
	}
	
	
	public Long getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getDepartmentLocation() {
		return departmentLocation;
	}
	public void setDepartmentLocation(String departmentLocation) {
		this.departmentLocation = departmentLocation;
	}
	@Override
	public String toString() {
		return "Department [depatmentId=" + departmentId + ", departmentName=" + departmentName + ", departmentLocation="
				+ departmentLocation + "]";
	}
	
	
}
