package com.syn.service;

import java.math.BigInteger;

public class Incident_Details {
	
	private String Assigned_to;
	private String Assignment_group;
	private String Category;
	private BigInteger Priority;
	private String Description;
	private String Caller_id;
	private BigInteger Incident_state;
	private String Comments_and_work_notes;
	public String getAssigned_to() {
		return Assigned_to;
	}
	public void setAssigned_to(String assigned_to) {
		Assigned_to = assigned_to;
	}
	public String getAssignment_group() {
		return Assignment_group;
	}
	public void setAssignment_group(String assignment_group) {
		Assignment_group = assignment_group;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getCaller_id() {
		return Caller_id;
	}
	public void setCaller_id(String caller_id) {
		Caller_id = caller_id;
	}
	
	public BigInteger getPriority() {
		return Priority;
	}
	public void setPriority(BigInteger priority) {
		Priority = priority;
	}
	public BigInteger getIncident_state() {
		return Incident_state;
	}
	public void setIncident_state(BigInteger incident_state) {
		Incident_state = incident_state;
	}
	public String getComments_and_work_notes() {
		return Comments_and_work_notes;
	}
	public void setComments_and_work_notes(String comments_and_work_notes) {
		Comments_and_work_notes = comments_and_work_notes;
	}
		   
	  

}
