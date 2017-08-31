package com.wewash.services.repository;

import com.wewash.services.model.IncomingMessageLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MessageLogRepository extends JpaRepository<IncomingMessageLog, UUID> {
}
