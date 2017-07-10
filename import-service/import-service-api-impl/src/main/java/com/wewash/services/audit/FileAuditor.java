package com.wewash.services.audit;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
public class FileAuditor {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileAuditor.class);
    private static final String FILE_NAME = "/import-messages.log";
    private Environment environment;

    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Autowired
    private FileAuditor (Environment environment) {
        this.environment = environment;
    }

    public void auditMessage(String message) {
        if(environment.getProperty("message-audit.audit-enabled", Boolean.TYPE, false)) {
            File logFile = new File(environment.getRequiredProperty("message-audit.audit-dir") + FILE_NAME);

            FileAuditLog log = new FileAuditLog(new Date(), message);

            try {
                FileUtils.forceMkdirParent(logFile);
                FileUtils.write(logFile,MAPPER.writeValueAsString(log)+ System.lineSeparator(), StandardCharsets.UTF_8,true);
            } catch (IOException e) {
                LOGGER.warn("Cannot log message audit", e);
            }

        }
    }
}
