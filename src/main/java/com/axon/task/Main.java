package com.axon.task;

import com.axon.task.domain.Book;
import com.axon.task.domain.Message;
import com.axon.task.domain.Operation;
import com.axon.task.repository.BookRepository;
import com.axon.task.repository.MessageRepository;
import com.axon.task.repository.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Nikolay on 26.09.2018.
 */
public class Main {
    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private OperationRepository operationRepository;

    @Autowired
    private BookRepository bookRepository;

    public static void executionOperation(){

        Map<Message,List<Operation>> messageMap = new HashMap<>();

    }
}
