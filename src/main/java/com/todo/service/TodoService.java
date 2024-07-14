package com.todo.service;
import java.util.*;

import com.todo.models.TodoNode;

public class TodoService {
	
	static TodoService singleTonObject;
    List<TodoNode>  list ;
    Integer id;
    
    private  TodoService(){
    	this.list= new ArrayList<>();
    	this.id=1;
    	
    }
    
   public  static TodoService getInstance() {
	   System.out.println("Sending Object");
    	if(singleTonObject==null) {
    	singleTonObject = new TodoService();
    	}
    	return singleTonObject;
    	
    }
    
  public  void addNote(String note ){
	   
	   TodoNode newNote = new TodoNode();
	   newNote.setId(id);
	   newNote.setNote(note);
	   this.list.add(newNote);

	   this.id++;
	   
    	
    }
   
  public  void update( TodoNode obj ) {
	   
	   for (TodoNode data : this.list) {
		  if(data.getId().equals(obj.getId())) {
			  data.setNote(obj.getNote());
			  System.out.println(data);
		  }
		   
	   }
	   
	   
   }
   
   
  public  void deleteNote(Integer id) {
	   
	   TodoNode ref=null;
	   
	   for (TodoNode data : this.list) {
			  if(data.getId().equals(id)) {
				  ref=data;
				  break;
			  }
			   
		   }
	   
	   if(ref!=null)
		   this.list.remove(ref);
   }
   
 public List<TodoNode>  getAllTodos() {
	   
	   return this.list;
	   
   }


public TodoNode getSingleNote(Integer id) {
	// TODO Auto-generated method stub
	
	for (TodoNode data : this.list) {
		  if(data.getId().equals(id)) {
			  return data;
		  }
		   
	   }
	return null;
}
	
	

}