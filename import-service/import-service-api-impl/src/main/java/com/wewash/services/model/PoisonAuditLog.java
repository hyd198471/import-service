package com.wewash.services.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "poison_audit_log")
public class PoisonAuditLog {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "incoming_message", nullable = false)
    @Lob
    private String incomingMessage;

    @Column(name = "incoming_message_received", nullable = false)
    private Date incomingMessageReceived;

    @Column(name = "exception_message", nullable = false)
    @Lob
    private String exceptionMessage;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getIncomingMessage() {
        return incomingMessage;
    }

    public void setIncomingMessage(String incomingMessage) {
        this.incomingMessage = incomingMessage;
    }

    public Date getIncomingMessageReceived() {
        return incomingMessageReceived;
    }

    public void setIncomingMessageReceived(Date incomingMessageReceived) {
        this.incomingMessageReceived = incomingMessageReceived;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public void setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }
}
