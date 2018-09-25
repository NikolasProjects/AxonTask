package com.axon.task.controller;

import com.axon.task.ParsFixLog;
import com.axon.task.repository.MessageRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Nikolay on 20.09.2018.
 */
@Controller
public class BaseController {

    public static String pathFile = "C:/Users/Nikolay/Desktop/Тестовое задание axonsoftware.biz/market_data/1001083-77MARKETS-PRICE_03032210025631.R0.summary";

    private final MessageRepository messageRepository;

    public BaseController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }


    @RequestMapping("/")
    public String welcome() {
        return "home";
    }

    @RequestMapping("/ordersList")
    public String orders(Model model) {
        ParsFixLog.parsAndAddToDB(pathFile);
        /*orderRepository.saveAll(orders);
        model.addAttribute("orders", orders);*/
        return "orders";
    }


}
