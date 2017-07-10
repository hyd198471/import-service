package com.wewash.services.repository;

import com.wewash.services.model.MessageLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MessageLogRepository extends JpaRepository<MessageLog, UUID> {
}
