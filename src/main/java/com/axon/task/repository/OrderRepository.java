package com.axon.task.repository;

import com.axon.task.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Nikolay on 20.09.2018.
 */
public interface OrderRepository extends JpaRepository<Order, Long> {

}
