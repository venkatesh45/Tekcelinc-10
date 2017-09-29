package com.tekcel.assignment.pojo;

import org.springframework.context.annotation.Scope;

@Scope(value="prototype")
public class Book {

	private int id;
	private String author;
	private String bookname;
	private String category;
	
	
	public Book(int bookId, String author, String bookName, String category) {
		super();
		this.id = bookId;
		this.author = author;
		this.bookname = bookName;
		this.category = category;
	}

	public Book() {
		super();
	}

	@Override
	public String toString() {
		return "Book [bookId=" + id + ", author=" + author + ", bookName=" + bookname + ", category=" + category
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + id;
		result = prime * result + ((bookname == null) ? 0 : bookname.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (id != other.id)
			return false;
		if (bookname == null) {
			if (other.bookname != null)
				return false;
		} else if (!bookname.equals(other.bookname))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		return true;
	}

	public int getBookId() {
		return id;
	}

	public void setBookId(int bookId) {
		this.id = bookId;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getBookName() {
		return bookname;
	}

	public void setBookName(String bookName) {
		this.bookname = bookName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
}
