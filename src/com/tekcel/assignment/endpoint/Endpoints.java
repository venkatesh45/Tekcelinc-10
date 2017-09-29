package com.tekcel.assignment.endpoint;

public interface Endpoints {

	String INSERT="/rest/Book/create";
	String GetByID="/rest/Book/{id}";
	String GetAll="/rest/Books";
	String UpdateByID="/rest/Book/update";
	String DeleteByID="/rest/Book/delete/{id}";
}
