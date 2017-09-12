package com.wewash.services.repository;

import com.wewash.services.model.MessageProcessingLock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageProcessingLockRepository extends JpaRepository<MessageProcessingLock, Long> {
}
