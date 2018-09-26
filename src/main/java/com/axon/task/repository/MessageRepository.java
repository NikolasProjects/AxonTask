package com.axon.task.repository;

import com.axon.task.domain.Message;
import com.axon.task.domain.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Map;

/**
 * Created by Nikolay on 26.09.2018.
 */
public interface MessageRepository extends JpaRepository<Message, Long> {
}
