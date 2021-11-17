package com.student.HBMappingOneToMany;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Laptop {
	@Id
	private int lid;
	private String lName;
	@ManyToOne
	private Student studen;
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public Student getStuden() {
		return studen;
	}
	public void setStudent(Student student) {
		this.studen = student;
	}
	@Override
	public String toString() {
		return "Laptop [lid=" + lid + ", lName=" + lName + ", student=" + studen + "]";
	}
	

	

}
