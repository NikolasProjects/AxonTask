package com.axon.task.repository;

import com.axon.task.domain.Operation;
import com.axon.task.domain.OperationType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Nikolay on 26.09.2018.
 */
public interface OperationRepository extends JpaRepository<Operation, Long> {
    Operation findAllByType(OperationType operationType);
    List<Operation> findAllByMsgId(Long messageId);
}
