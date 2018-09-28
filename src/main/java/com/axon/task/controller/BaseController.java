package com.axon.task.controller;

import com.axon.task.OperationExecution;
import com.axon.task.ParsFixLog;
import com.axon.task.domain.Book;
import com.axon.task.domain.Message;
import com.axon.task.domain.Operation;
import com.axon.task.repository.BookRepository;
import com.axon.task.repository.MessageRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nikolay on 20.09.2018.
 */
@Controller
public class BaseController {

    private final ParsFixLog parsFixLog;
    private final OperationExecution operationExecution;
    private final MessageRepository messageRepository;
    private final BookRepository bookRepository;

    public BaseController(ParsFixLog parsFixLog, OperationExecution operationExecution, MessageRepository messageRepository, BookRepository bookRepository) {
        this.parsFixLog = parsFixLog;
        this.operationExecution = operationExecution;
        this.messageRepository = messageRepository;
        this.bookRepository = bookRepository;
    }


    @RequestMapping("/")
    public String welcome() {
        return "home";
    }

    @RequestMapping(value = "/ordersList", method = RequestMethod.GET)
    public String orders(Model model) {
        parsFixLog.parsAndAddToDB();
        operationExecution.executionOperation();

        List<Message> messages = messageRepository.findAll();
        model.addAttribute(messages);

        List<Operation> operations = new ArrayList<>();

        for (Message msg : messages) {
            for (Operation operation : msg.getOperations()) {
                operations.add(operation);
            }
        }
        List<Book> books = bookRepository.findAll();
        model.addAttribute("operations", operations);
        model.addAttribute("messages", messages);
        model.addAttribute("books", books);
        return "orders";
    }
}


