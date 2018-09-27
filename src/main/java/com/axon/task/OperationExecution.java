package com.axon.task;

import com.axon.task.domain.*;
import com.axon.task.repository.BookRepository;
import com.axon.task.repository.MessageRepository;
import com.axon.task.repository.OperationRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nikolay on 26.09.2018.
 */
@Service
public class OperationExecution {

    private final MessageRepository messageRepository;
    private final OperationRepository operationRepository;
    private final BookRepository bookRepository;
    private final ParsFixLog parsFixLog;

    public OperationExecution(MessageRepository messageRepository, OperationRepository operationRepository, BookRepository bookRepository, ParsFixLog parsFixLog) {
        this.messageRepository = messageRepository;
        this.operationRepository = operationRepository;
        this.bookRepository = bookRepository;
        this.parsFixLog = parsFixLog;
    }

    public void executionOperation() {

        List<Message> messages = messageRepository.findAll();
        for (Message message : messages) {
            List<Long> deleteOperationsById = new ArrayList<>();
            List<Operation> addOperations = new ArrayList<>();
            for (Operation operation : message.getOperations()) {
                if (operation.getOperationType279().equals(OperationType.DELETE)) {
                    deleteOperationsById.add(operation.getOperationId278());
                } else {
                    addOperations.add(operation);
                }
                bookRepository.deleteAllByOperationId(deleteOperationsById);
                operationRepository.saveAll(addOperations);

            }
        }

    }

}
