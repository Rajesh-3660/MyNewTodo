package com.todo.models;

public class TodoNode {
	
  public TodoNode(){
		
	}
	
	Integer id;
	
	String note;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "TodoNode [id=" + id + ", note=" + note + "]";
	}
	
	
	
	

}