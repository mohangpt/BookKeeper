package com.example.demo.controllers;

import com.example.demo.models.AuthorRepository;
import com.example.demo.models.Books;
import com.example.demo.models.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/books")
public class BooksController {
    @Autowired
    private BooksRepository booksRepository;
    @Autowired
    private AuthorRepository authorRepository;

    @PostMapping // type of crud operation
    public @ResponseBody // response body takes care of json
    Books // return type
    addNewBook(@RequestParam Integer authorId,@RequestParam String bookName,@RequestParam Float price) throws Exception {
//        checking whether author exists or not
        if(!authorRepository.existsById(authorId)) {
            throw new Exception("Please add Author first!!");
        }
//        we can also do this hassle free by writing constructor in Books class
        Books book = new Books();
        book.setAuthorId(authorId);
        book.setName(bookName);
        book.setPrice(price);
        booksRepository.save(book);
        return book;
    }

    @GetMapping(value = "/")
    public @ResponseBody
    List<Books>
    getBooksList(){
        return (List<Books>)(booksRepository.findAll());
    }

    @GetMapping(value = "/{bookId}")
    public @ResponseBody
    Optional<Books> bookById(@PathVariable Integer bookId){

        return booksRepository.findById(bookId);
    }
}
