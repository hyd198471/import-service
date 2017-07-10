package com.wewash.services.messageloggers;

import com.wewash.services.repository.PoisonAuditLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.stereotype.Service;

@Service
public class MessageLoggerDispatcher {

    @Autowired
    private PoisonAuditLogRepository poisonAuditLogRepository;

    @Autowired
    private CounterService counterService;




}
