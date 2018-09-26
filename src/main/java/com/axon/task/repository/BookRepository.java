package com.axon.task.repository;

import com.axon.task.domain.Book;
import com.axon.task.domain.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Nikolay on 26.09.2018.
 */
public interface BookRepository extends JpaRepository<Book, Long> {
    Book deleteProductById(Long operationId);
    Book addProduct(Operation operation);
}
