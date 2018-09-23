package com.axon.task;

import com.axon.task.domain.Order;
import com.axon.task.domain.OrderType;
import lombok.extern.slf4j.Slf4j;
import quickfix.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nikolay on 20.09.2018.
 */
public class ParsFixLog {

    public static List<Order> fixOrders(String pathFile) {

        Path file = Paths.get(pathFile);
        List<String> lines = null;
        try {
            lines = Files.readAllLines(file);
            List<Order> orders = new ArrayList<>();
            for (String line : lines) {
                int indexOfStartMessage = line.indexOf("8=FIX");
                String messageWithoutLogPrefix = line.substring(indexOfStartMessage);
                int indexOfEndMessage = messageWithoutLogPrefix.indexOf(" ");
                String fixMessage = messageWithoutLogPrefix.substring(0, indexOfEndMessage);

                File initialFile = new File("C:/Users/Nikolay/Desktop/quickfixj-master/FIX44.modified.xml");
                InputStream targetStream = new FileInputStream(initialFile);
                quickfix.fix44.Message message = (quickfix.fix44.Message) MessageUtils.parse(new DefaultMessageFactory(), new DataDictionary(targetStream), fixMessage);

                LocalDateTime date = message.getHeader().getUtcTimeStamp(52);
                List<Group> groups = message.getGroups(268);
                for (Group group : groups) {
                    Order order = mapOrder(group, date);
                    if (order != null) {
                        orders.add(order);
                    }
                }
            }
            return orders;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Order mapOrder(Group group, LocalDateTime date) {
        Order order = new Order();
        try {
            order.setDate(date);
            order.setType(OrderType.getTypeById(Integer.valueOf(group.getString(269))));
            order.setOrderId(Long.valueOf(group.getString(278)));
            order.setPrice(new BigDecimal(group.getString(270)));
            order.setSize(Long.valueOf(group.getString(271)));
        } catch (FieldNotFound fieldNotFound) {
            return null;
        }
        return order;
    }
}
