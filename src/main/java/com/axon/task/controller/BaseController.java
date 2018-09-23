package com.axon.task.controller;

import com.axon.task.ParsFixLog;
import com.axon.task.domain.Order;
import com.axon.task.domain.OrderType;
import com.axon.task.repository.OrderRepository;
import lombok.Getter;
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

    public static String pathFile = "C:/Users/Nikolay/Desktop/Тестовое задание axonsoftware.biz/market_data/1001083-77MARKETS-PRICE_03032210025631.R0.summary";

    private final OrderRepository orderRepository;

    public BaseController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    @RequestMapping("/")
    public String welcome() {
        return "home";
    }

    @RequestMapping("/ordersList")
    public String orders(Model model) {
        List<Order> orders = ParsFixLog.fixOrders(pathFile);
        List<Order> ordersBID = new ArrayList<>();
        List<Order> ordersASK = new ArrayList<>();
        for (Order type : orders
                ) {
            if (type.getType().equals(OrderType.ASK)) {
                ordersASK.add(type);
            }else ordersBID.add(type);
        }

        orderRepository.saveAll(ordersASK);
        orderRepository.saveAll(ordersBID);
        model.addAttribute("ordersBID", ordersBID);
        model.addAttribute("ordersASK", ordersASK);
        model.addAttribute("orders", orders);
        return "orders";
    }



}
