package com.axon.task.controller;

import com.axon.task.ParsFixLog;
import com.axon.task.domain.Order;
import com.axon.task.repository.OrderRepository;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Nikolay on 20.09.2018.
 */
@RestController
public class BaseController {

    public static String pathFile = "C:/Users/Nikolay/Desktop/Тестовое задание axonsoftware.biz/market_data/1001083-77MARKETS-PRICE_03032210025631.R0.summary";

    private final OrderRepository orderRepository;

    public BaseController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping
    public String home(){
        return "Hello";
    }

    @GetMapping("orders")
    public List<Order> home(Model model) {
        List<Order> orders = ParsFixLog.fixOrders(pathFile);
       return orderRepository.saveAll(orders);
    }

    @PostMapping("orders")
    public Order create(@RequestBody Order order) {
        return orderRepository.save(order);
    }


    /*@DeleteMapping("orders/{id}")
    public void delete(@PartVariable Long id) {
        orderRepository.delete(id);
    }*/
}
