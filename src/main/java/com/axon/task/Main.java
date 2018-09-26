package com.axon.task;

import com.axon.task.domain.*;
import com.axon.task.repository.BookRepository;
import com.axon.task.repository.MessageRepository;
import com.axon.task.repository.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import quickfix.FieldNotFound;
import quickfix.Group;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Nikolay on 26.09.2018.
 */
public class Main {
    @Autowired
    private static MessageRepository messageRepository;

    @Autowired
    private static OperationRepository operationRepository;

    @Autowired
    private static BookRepository bookRepository;

    public static void executionOperation() {

        List<Message> messages = new ArrayList<>();
        messageRepository.saveAll(messages);
        for (Message message : messages) {
            List<Operation> operations = operationRepository.findAllByMsgId(message.getMessageId());


            for (Operation operation : operations) {
                //пройтись по всему списку
                if (operation.getOperationType279().equals(OperationType.DELETE)) {
                    bookRepository.deleteProductById(operation.getOperationId278());
                } else {
                    bookRepository.addProduct(operation);
                }
            }
        }

    }

}
