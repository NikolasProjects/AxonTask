package com.axon.task.controller;

import com.axon.task.OperationExecution;
import com.axon.task.ParsFixLog;
import com.axon.task.domain.Book;
import com.axon.task.domain.Message;
import com.axon.task.domain.Operation;
import com.axon.task.domain.OrderType;
import com.axon.task.repository.BookRepository;
import com.axon.task.repository.MessageRepository;
import org.springframework.boot.Banner;
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

    @RequestMapping(value = "/write")
    public String orders() {
        parsFixLog.parsAndAddToDB();
        return "orders";
    }

    @RequestMapping(value = "/write/save")
    public String saveToFile(Model model) {
        operationExecution.executionOperation();
        List<Book> books = bookRepository.findAll();
        List<Book> bids = new ArrayList<>();
        List<Book> asks = new ArrayList<>();
        for (Book book : books) {
            if (book.getType().equals(OrderType.BID)) {
                bids.add(book);
            } else {
                asks.add(book);
            }
        }
        model.addAttribute("bids", bids);
        model.addAttribute("asks", asks);



        return "end";
    }
}


