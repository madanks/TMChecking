package com.cs544.mum.domain;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class Appointment {
	@Id
	@GeneratedValue
	private long id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	@Transient
	private String tempdate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

	private Date bookedDate;

	private String buildingName;

	private boolean completed;

	private int total;

	private int enrolled;

	private int roomNo;

	@ManyToMany(mappedBy = "appointmentList", cascade = CascadeType.PERSIST)
	private List<Student> studentList;

	@ManyToOne
	@JoinColumn(name = "staffId")
	private Staff staff;

	@Enumerated(EnumType.STRING)
	private AppointmentType type;

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getBookedDate() {
		return bookedDate;
	}

	public void setBookedDate(Date bookedDate) {
		this.bookedDate = bookedDate;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	public List<Student> getStudentList() {
		return Collections.unmodifiableList(studentList);
	}

	public void setStudentList(Student student) {

		if (!studentList.contains(student)) {
			studentList.add(student);
			student.setAppointmentList(this);
		}
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public AppointmentType getType() {
		return type;
	}

	public void setType(AppointmentType type) {
		this.type = type;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTempdate() {
		return tempdate;
	}

	public void setTempdate(String tempdate) {
		this.tempdate = tempdate;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getEnrolled() {
		return enrolled;
	}

	public void setEnrolled(int enrolled) {
		this.enrolled = enrolled;
	}

	public void removeStudent(Student student) {
		//student.setAppointmentList(null);
		this.studentList.remove(student);
	}

}
