package com.wewash.services.repository;

import com.wewash.services.model.IncomingMessage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MessageLogRepository extends JpaRepository<IncomingMessage, UUID> {
}
