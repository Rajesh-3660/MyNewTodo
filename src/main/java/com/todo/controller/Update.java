package com.todo.controller;
import com.todo.models.TodoNode;
import com.todo.service.TodoService;

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

/**
 * Servlet implementation class UpdateNote
 */
@WebServlet("/update")
public class Update extends HttpServlet {
	TodoService todoService; 

	Gson gson;
	private static final long serialVersionUID = 1L;
       @Override
    	public void init() throws ServletException {
    		
   		todoService= TodoService.getInstance();

       this.gson= new Gson();
       }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   // FORM - you try 
		// i read from the buffer 
		BufferedReader read= request.getReader();
		// read completely 
		String data=read.readLine();
		
		// converting the json string format to our java object of type TodoNode 
		TodoNode javaObject =this.gson.fromJson(data, TodoNode.class);
		
		// triggering update logic  

		this.todoService.update(javaObject);
		
		List<TodoNode> allNotes = todoService.getAllTodos();

		PrintWriter out = response.getWriter();

		String jsonString = gson.toJson(allNotes); // the toJson() is used to convert the java data into JSON

		System.out.println(jsonString);

		out.print(jsonString);
		out.flush();

}

}