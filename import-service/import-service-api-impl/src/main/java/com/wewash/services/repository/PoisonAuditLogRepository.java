package com.wewash.services.repository;

import com.wewash.services.model.PoisonAuditLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PoisonAuditLogRepository extends JpaRepository<PoisonAuditLog, UUID> {
}
