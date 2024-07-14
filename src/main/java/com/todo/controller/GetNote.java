package com.todo.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

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
@WebServlet("/getNote")
public class GetNote extends HttpServlet {
	private static final long serialVersionUID = 1L;
    TodoService todoService;
    Gson gson;

    public void init() throws ServletException
    {
    	todoService=TodoService.getInstance();
        this.gson= new Gson();

    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		BufferedReader read= request.getReader();
		String data=read.readLine();  
		TodoNode javaObject =this.gson.fromJson(data, TodoNode.class);  

		TodoNode getSingleNote = todoService.getSingleNote(javaObject.getId());

		PrintWriter out = response.getWriter();

		String jsonString = gson.toJson(getSingleNote); // the toJson() is used to convert the java data into JSON

		System.out.println(jsonString);

		out.print(jsonString);
}
	}

