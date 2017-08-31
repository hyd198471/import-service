package com.wewash.services.model;

import com.google.common.base.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "poison_audit_log")
public class PoisonAuditLog {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "incoming_message", nullable = false)
    @Lob
    private String incomingMessage;

    @Column(name = "incoming_message_received", nullable = false)
    private Date incomingMessageReceived;

    @Column(name = "exception_message", nullable = false)
    @Lob
    private String exceptionMessage;

    public String getIncomingMessage() {
        return incomingMessage;
    }

    public void setIncomingMessage(String incomingMessage) {
        this.incomingMessage = incomingMessage;
    }

    public Date getIncomingMessageReceived() {
        return new Date(incomingMessageReceived.getTime());
    }

    public void setIncomingMessageReceived(Date incomingMessageReceived) {
        this.incomingMessageReceived = new Date(incomingMessageReceived.getTime());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public void setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PoisonAuditLog that = (PoisonAuditLog) o;
        return Objects.equal(incomingMessage, that.incomingMessage) &&
                Objects.equal(incomingMessageReceived, that.incomingMessageReceived) &&
                Objects.equal(exceptionMessage, that.exceptionMessage);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(incomingMessage, incomingMessageReceived, exceptionMessage);
    }
}
