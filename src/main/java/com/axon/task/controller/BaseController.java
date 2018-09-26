package com.axon.task.controller;

import com.axon.task.OperationExecution;
import com.axon.task.ParsFixLog;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Nikolay on 20.09.2018.
 */
@Controller
public class BaseController {

    private final ParsFixLog parsFixLog;
    private final OperationExecution operationExecution;

    public BaseController(ParsFixLog parsFixLog, OperationExecution operationExecution) {
        this.parsFixLog = parsFixLog;
        this.operationExecution = operationExecution;
    }


    @RequestMapping("/")
    public String welcome() {
        return "home";
    }

    @RequestMapping("/ordersList")
    public String orders(Model model) {
        parsFixLog.parsAndAddToDB();
//        operationExecution.executionOperation();
     /*   orderRepository.saveAll(orders);
        model.addAttribute("orders", orders);*/
        return "orders";
    }


}
