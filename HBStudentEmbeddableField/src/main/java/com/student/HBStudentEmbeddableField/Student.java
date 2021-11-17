package com.student.HBStudentEmbeddableField;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student_table_embeddable")
public class Student {
	@Id
	private int id;
	private StudentName sname;
	private String Branch;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public StudentName getSname() {
		return sname;
	}
	public void setSname(StudentName sname) {
		this.sname = sname;
	}
	public String getBranch() {
		return Branch;
	}
	public void setBranch(String branch) {
		Branch = branch;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", sname=" + sname + ", Branch=" + Branch + "]";
	}

}
