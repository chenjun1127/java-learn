package com.springboot.study.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.study.entity.Book;
import com.springboot.study.service.BookService;
import com.springboot.study.utils.JsonData;

/**
 * @Description: es测试
 * @author: chenjun
 * @date: 2020年7月1日 下午4:13:20
 */
@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService bookService;

	@PostMapping
	public JsonData insertBook(@RequestBody Book book) throws Exception {
		return JsonData.buildSuccess(bookService.insertBook(book), "新增成功");
	}

	@GetMapping("/get/{id}")
	public JsonData getBookById(@PathVariable String id) {
		return JsonData.buildSuccess(bookService.getBookById(id), "查询成功");
	}

	@PutMapping("/update/{id}")
	public JsonData updateBookById(@RequestBody Book book, @PathVariable String id) {
		return JsonData.buildSuccess(bookService.updateBookById(book, id), "查询成功");
	}

	@DeleteMapping("/delete/{id}")
	public JsonData deleteBookById(@PathVariable String id) {
		bookService.deleteBookById(id);
		return JsonData.buildSuccess();
	}

	@GetMapping("/search")
	public JsonData searchBook(String title, @RequestParam(defaultValue = "1") Integer index, @RequestParam(defaultValue = "5") Integer size) {
		Map<String, Object> map = bookService.search(title, index, size);
		return JsonData.buildSuccess(map, "success");
	}
}
