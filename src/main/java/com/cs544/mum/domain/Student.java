package com.cs544.mum.domain;

import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.mapping.Collection;

@Entity
public class Student extends Person implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2788653423807310354L;

	@GeneratedValue
	@Column(unique = true)
	private int studentId;

	private Date entryDate;

	private int count;

	private String stream;

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "Students_Appointments", joinColumns = @JoinColumn(name = "username") , inverseJoinColumns = @JoinColumn(name = "appointmentId") )
	private List<Appointment> appointmentList;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public String getStream() {
		return stream;
	}

	public void setStream(String stream) {
		this.stream = stream;
	}

	public List<Appointment> getAppointmentList() {
		return Collections.unmodifiableList(appointmentList);
	}

	public void setAppointmentList(Appointment app) {
		if (!appointmentList.contains(app)) {
			appointmentList.add(app);
			app.setStudentList(this);
		}

	} 

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void removeAppointment(Appointment app) {
		//app.setStudentList(null);
		this.appointmentList.remove(app);
	}

}
