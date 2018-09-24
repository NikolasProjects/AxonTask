package com.axon.task.repository;

import com.axon.task.domain.BodyFixMessage;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Nikolay on 24.09.2018.
 */
public interface BodyFixMessageRepository extends JpaRepository<BodyFixMessage, Long> {
}
