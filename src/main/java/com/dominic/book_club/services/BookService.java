package com.dominic.book_club.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dominic.book_club.models.Book;
import com.dominic.book_club.repositories.BookRepository;

@Service
public class BookService {
  
  @Autowired BookRepository bookRepository;

  public void addBook(Book book) {
    bookRepository.save(book);
  }

}
