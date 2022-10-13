package com.nt.model;

public class Student {

	private Integer sno;
	private String sname;
	private Float salary;
	private Boolean vaccinated;
	
	public Integer getSno() {
		return sno;
	}
	public void setSno(Integer sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public Float getSalary() {
		return salary;
	}
	public void setSalary(Float salary) {
		this.salary = salary;
	}
	public Boolean getVaccinated() {
		return vaccinated;
	}
	public void setVaccinated(Boolean vaccinated) {
		this.vaccinated = vaccinated;
	}
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public Student(Integer sno, String sname, Float salary, Boolean vaccinated) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.salary = salary;
		this.vaccinated = vaccinated;
	}
	
}
