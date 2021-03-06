package com.bms.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bms.book.domain.Book;
import com.bms.book.service.IBookService;

@Controller
@RequestMapping(value="/book/bookList")
public class BookListController {

	@Autowired
	private IBookService bookService;
	
	@RequestMapping(value="list")
	@ResponseBody
	public List<Book> list() {
		List<Book> list = bookService.findList();
		return list;
	}
}