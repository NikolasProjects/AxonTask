package com.axon.task.repository;

import com.axon.task.domain.Book;
import com.axon.task.domain.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Nikolay on 26.09.2018.
 */
public interface BookRepository extends JpaRepository<Book, Long> {
    void deleteByOperationId(Long id);
    void deleteAllByOperationId(List<Long> ids);
}
