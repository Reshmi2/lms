package com.pack.SpringBootRoleBasedSecurity.model;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="leave_table")
public class Leave {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private long id;
private String username;
private Date fromDate;
private Date toDate;
private String leaveType;
private Boolean acceptRejectFlag;
private String status;
public Leave() {
	super();
	// TODO Auto-generated constructor stub
}
public Leave(long id, String username, Date fromDate, Date toDate, String leaveType, Boolean acceptRejectFlag,
		String status) {
	super();
	this.id = id;
	this.username = username;
	this.fromDate = fromDate;
	this.toDate = toDate;
	this.leaveType = leaveType;
	this.acceptRejectFlag = acceptRejectFlag;
	this.status = status;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public Date getFromDate() {
	return fromDate;
}
public void setFromDate(Date fromDate) {
	this.fromDate = fromDate;
}
public Date getToDate() {
	return toDate;
}
public void setToDate(Date toDate) {
	this.toDate = toDate;
}
public String getLeaveType() {
	return leaveType;
}
public void setLeaveType(String leaveType) {
	this.leaveType = leaveType;
}
public Boolean getAcceptRejectFlag() {
	return acceptRejectFlag;
}
public void setAcceptRejectFlag(Boolean acceptRejectFlag) {
	this.acceptRejectFlag = acceptRejectFlag;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
@Override
public String toString() {
	return "Leave [id=" + id + ", username=" + username + ", fromDate=" + fromDate + ", toDate=" + toDate
			+ ", leaveType=" + leaveType + ", acceptRejectFlag=" + acceptRejectFlag + ", status=" + status + "]";
}


}