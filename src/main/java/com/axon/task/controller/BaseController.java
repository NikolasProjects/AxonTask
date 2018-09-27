package com.axon.task.controller;

import com.axon.task.OperationExecution;
import com.axon.task.ParsFixLog;
import com.axon.task.domain.Message;
import com.axon.task.repository.MessageRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Nikolay on 20.09.2018.
 */
@Controller
public class BaseController {

    private final ParsFixLog parsFixLog;
    private final OperationExecution operationExecution;
    private final MessageRepository messageRepository;

    public BaseController(ParsFixLog parsFixLog, OperationExecution operationExecution, MessageRepository messageRepository) {
        this.parsFixLog = parsFixLog;
        this.operationExecution = operationExecution;
        this.messageRepository = messageRepository;
    }


    @RequestMapping("/")
    public String welcome() {
        return "home";
    }

    @RequestMapping("/ordersList")
    public String orders(Model model) {
        parsFixLog.parsAndAddToDB();
//        operationExecution.executionOperation();
        List<Message> messages = messageRepository.findAll();
        model.addAttribute(messages);
      //  orderRepository.saveAll(orders);
        model.addAttribute("messages", messages);
        return "orders";
    }


}
