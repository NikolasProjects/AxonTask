package com.axon.task;

import com.axon.task.domain.BodyFixMessage;
import com.axon.task.domain.HeadFixMessage;
import com.axon.task.domain.Order;
import com.axon.task.domain.OrderType;
import quickfix.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Nikolay on 20.09.2018.
 */
public class ParsFixLog {

    public static /*List<Order> fixOrders*/ Map<Integer, List<Order>> mapMsg(String pathFile) {

        Path file = Paths.get(pathFile);
        List<String> lines = null;
        try {
            lines = Files.readAllLines(file);
            List<Order> orders = new ArrayList<>();

            List<HeadFixMessage> headFixMessages = new ArrayList<>();
            List<BodyFixMessage> bodyFixMessages = new ArrayList<>();

            Map<Integer, List<Order>> ordersMap = new HashMap<>();
            for (String line : lines) {
                int indexOfStartMessage = line.indexOf("8=FIX");
                String messageWithoutLogPrefix = line.substring(indexOfStartMessage);
                int indexOfEndMessage = messageWithoutLogPrefix.indexOf(" ");
                String fixMessage = messageWithoutLogPrefix.substring(0, indexOfEndMessage);

                File initialFile = new File("C:/Users/Nikolay/Desktop/quickfixj-master/FIX44.modified.xml");
                InputStream targetStream = new FileInputStream(initialFile);
                quickfix.fix44.Message message = (quickfix.fix44.Message) MessageUtils.parse(new DefaultMessageFactory(), new DataDictionary(targetStream), fixMessage);

                LocalDateTime date = message.getHeader().getUtcTimeStamp(52);
                int idMsg = message.getHeader().getInt(34);
                Integer idKey = new Integer(idMsg);
                //List<Haeder> haeders = message.getHeader();
                List<Group> groups = message.getGroups(268);
                for (Group group : groups) {
                    Order order = mapOrder(group, date, idMsg);

                    if (order != null) {
                        orders.add(order);
                    }
                }
                ordersMap.put(idKey, orders);
            }
            return ordersMap;
//            return orders;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Order mapOrder(Group group, LocalDateTime date, int idMsg) {
        Order order = new Order();
        try {
            order.setDate(date);
            order.setMsgId(idMsg);
            order.setType(OrderType.getTypeById(Integer.valueOf(group.getString(269))));
            order.setOrderId(Long.valueOf(group.getString(278)));
            order.setPrice(new BigDecimal(group.getString(270)));
            order.setSize(Long.valueOf(group.getString(271)));
            order.setOrderAction(Long.valueOf(group.getString(279)));
        } catch (FieldNotFound fieldNotFound) {
            return null;
        }
        return order;
    }

    private static HeadFixMessage mapHeadFixMessage() {
        HeadFixMessage headFixMessage = new HeadFixMessage();
        return headFixMessage;
    }

    private static BodyFixMessage mapBodyFixMessage(Group group) {
        BodyFixMessage bodyFixMessage = new BodyFixMessage();
        try {
            bodyFixMessage.setIdOperation278(Long.valueOf(group.getString(278)));
            bodyFixMessage.setTypeOrder269(Integer.valueOf(group.getString(269)));
            bodyFixMessage.setTypeOperation279(Integer.valueOf(group.getString(279)));
            bodyFixMessage.setPrice270(new BigDecimal(group.getString(270)));
            bodyFixMessage.setSizePrice271(Long.valueOf(group.getString(271)));
        }catch (FieldNotFound fieldNotFound){
            return null;
        }
        return bodyFixMessage;
    }
}
