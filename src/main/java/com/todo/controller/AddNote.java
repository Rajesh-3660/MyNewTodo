package com.todo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.todo.models.TodoNode;
import com.todo.service.TodoService;

@WebServlet("/addNote")
public class AddNote extends HttpServlet {

	TodoService todoService;
	Gson gson;

	@Override
	public void init() throws ServletException {
		this.todoService = TodoService.getInstance();
		this.gson = new Gson();

	}

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String note = request.getParameter("newNote");
		System.out.println("Newnote" + note);
		todoService.addNote(note);
		List<TodoNode> allNotes = todoService.getAllTodos();

		PrintWriter out = response.getWriter();

		String jsonString = gson.toJson(allNotes); // the toJson() is used to convert the java data into JSON

		System.out.println(jsonString);

		out.print(jsonString);
		out.flush();

	}

}