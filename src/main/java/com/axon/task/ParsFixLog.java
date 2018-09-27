package com.axon.task;

import com.axon.task.domain.*;
import com.axon.task.domain.Message;
import com.axon.task.repository.MessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
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
import java.util.List;

/**
 * Created by Nikolay on 20.09.2018.
 */

@Service
public class ParsFixLog {

    private static final Logger logger = LoggerFactory.getLogger(ParsFixLog.class);

    @Value("${system.file-path}")
    private String filePath;

    private final MessageRepository messageRepository;

    public ParsFixLog(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public void parsAndAddToDB() {

        Path file = Paths.get(filePath);
        List<String> lines = null;
        try {
            lines = Files.readAllLines(file);
            for (String line : lines) {

                int indexOfStartMessage = line.indexOf("8=FIX");
                String messageWithoutLogPrefix = line.substring(indexOfStartMessage);
                int indexOfEndMessage = messageWithoutLogPrefix.indexOf(" ");
                String cleanMessage = messageWithoutLogPrefix.substring(0, indexOfEndMessage);

                File initialFile = new File("C:/Users/Nikolay/Desktop/quickfixj-master/FIX44.modified.xml");
                InputStream targetStream = new FileInputStream(initialFile);
                quickfix.fix44.Message parsFixMessage = (quickfix.fix44.Message) MessageUtils.parse(new DefaultMessageFactory(), new DataDictionary(targetStream), cleanMessage);

                Message message = new Message();
                message.setMessageId(Long.valueOf(parsFixMessage.getHeader().getString(34)));
                message.setReceiveTime(parsFixMessage.getHeader().getUtcTimeStamp(52));
                List<Operation> operations = new ArrayList<>();
                List<Group> groups = parsFixMessage.getGroups(268);
                for (Group group : groups) {
                    Operation operation = mapOperation(group);
                    operations.add(operation);
                    System.out.println(operation);
                    message.addOperation(operation);
                   // System.out.println(message);
                }
                messageRepository.save(message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static Operation mapOperation(Group group) {
        Operation operation = new Operation();
        try {
            operation.setOperationType279(OperationType.getTypeById(Integer.valueOf(group.getString(279))));
            if (operation.getOperationType279() == OperationType.ADD) {
                operation.setOperationId278(Long.valueOf(group.getString(278)));
                operation.setOrderType269(OrderType.getTypeById(Integer.valueOf(group.getString(269))));
                operation.setPrice270(new BigDecimal(group.getString(270)));
                operation.setPriceSize271(Long.valueOf(group.getString(271)));
            } else {
                operation.setOperationId278(Long.valueOf(group.getString(278)));
            }

        } catch (FieldNotFound fieldNotFound) {
            //return null;
        }
        return operation;
    }
}
