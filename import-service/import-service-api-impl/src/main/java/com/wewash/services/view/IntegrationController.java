package com.wewash.services.view;


import com.wewash.services.audit.FileAuditor;
import com.wewash.services.messageloggers.MessageLoggerDispatcher;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping(IntegrationController.IMPORT_SERVICE_INTEGRATION_ENDPOINT)
public class IntegrationController {
    private static final Logger LOGGER = LoggerFactory.getLogger(IntegrationController.class);

    static final String IMPORT_SERVICE_INTEGRATION_ENDPOINT = "/v1/import-service/integration";

    private final FileAuditor fileAuditor;

    private final MessageLoggerDispatcher messageLoggerDispatcher;

    @Value("${debug-options.processing-enabled}")
    private boolean processingEnabled;

    @Autowired
    public IntegrationController(FileAuditor fileAuditor, MessageLoggerDispatcher messageLoggerDispatcher) {
        this.fileAuditor = fileAuditor;
        this.messageLoggerDispatcher = messageLoggerDispatcher;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void receiveRequest(HttpServletRequest request) throws IOException{
        try(ServletInputStream inputStream = request.getInputStream()) {
            String incomingJson = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
            fileAuditor.auditMessage(incomingJson);

            if(!processingEnabled) {
                return;
            }
            messageLoggerDispatcher.process(incomingJson);
        }




    }

}
