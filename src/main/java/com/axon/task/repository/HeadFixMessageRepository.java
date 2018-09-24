package com.axon.task.repository;

import com.axon.task.domain.HeadFixMessage;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Nikolay on 24.09.2018.
 */
public interface HeadFixMessageRepository extends JpaRepository<HeadFixMessage, Long> {
}
