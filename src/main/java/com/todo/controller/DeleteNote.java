package com.todo.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.todo.models.TodoNode;
import com.todo.service.TodoService;

/**
 * Servlet implementation class DeleteNote
 */
@WebServlet("/delete")
public class DeleteNote extends HttpServlet {
	private static final long serialVersionUID = 1L;
    TodoService todoService;
    Gson gson;

    public void init() throws ServletException
    {
    	todoService=TodoService.getInstance();
        this.gson= new Gson();

    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BufferedReader read= request.getReader();
		// read completely 
		String data=read.readLine();  // consists of json string - now it updated 
		TodoNode javaObject =this.gson.fromJson(data, TodoNode.class);  // this bean / object consists of id

		
	
		
		// converting the json string format to our java object of type TodoNode 
		// when you reach here click on - that is the issue you are not sending the id to this route so issue in js 
	     this.todoService.deleteNote(javaObject.getId());
	     List<TodoNode> allNotes = todoService.getAllTodos();

		 PrintWriter out = response.getWriter();

		 String jsonString = gson.toJson(allNotes); // the toJson() is used to convert the java data into JSON

		 System.out.println(jsonString);

		 out.print(jsonString);
		 out.flush();

		// now deleted - ok ?
}
	}

