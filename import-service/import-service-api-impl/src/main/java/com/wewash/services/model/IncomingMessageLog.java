package com.wewash.services.model;

import com.google.common.base.Objects;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "message_log")
public class IncomingMessageLog {

    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(generator = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID uuid;

    @Column(name = "fixture_id", nullable = false)
    private Long fixtureId;

    @Column(name = "incoming_message_type")
    @Enumerated(EnumType.STRING)
    private MessageType messageType;

    @Column(name = "incoming_message", nullable = false)
    @Lob
    private String incomingMessage;

    @Column(name = "incoming_message_received", nullable = false)
    private Date incomingMessageReceived;

    @Column(name = "processed_at")
    private Date processedAt;

    @Column(name = "processed", nullable = false)
    private Boolean processed;

    @Column(name = "processed_by_instance")
    private String processedByInstance;

    @Column(name = "processed_by_request")
    private Long processedByRequest;

    @Column(name = "generated_snapshot")
    @Lob
    private String generatedSnapshot;

    @Column(name = "bg_header_timestamp")
    private Date bgHeaderTimestamp;

    public Long getFixtureId() {
        return fixtureId;
    }

    public void setFixtureId(Long fixtureId) {
        this.fixtureId = fixtureId;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

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

    public Date getProcessedAt() {
        return new Date(processedAt.getTime());
    }

    public void setProcessedAt(Date processedAt) {
        this.processedAt = new Date(processedAt.getTime());
    }

    public Boolean getProcessed() {
        return processed;
    }

    public void setProcessed(Boolean processed) {
        this.processed = processed;
    }

    public String getProcessedByInstance() {
        return processedByInstance;
    }

    public void setProcessedByInstance(String processedByInstance) {
        this.processedByInstance = processedByInstance;
    }

    public Long getProcessedByRequest() {
        return processedByRequest;
    }

    public void setProcessedByRequest(Long processedByRequest) {
        this.processedByRequest = processedByRequest;
    }

    public String getGeneratedSnapshot() {
        return generatedSnapshot;
    }

    public void setGeneratedSnapshot(String generatedSnapshot) {
        this.generatedSnapshot = generatedSnapshot;
    }

    public Date getBgHeaderTimestamp() {
        return new Date(bgHeaderTimestamp.getTime());
    }

    public void setBgHeaderTimestamp(Date bgHeaderTimestamp) {
        this.bgHeaderTimestamp = new Date(bgHeaderTimestamp.getTime());
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        IncomingMessageLog that = (IncomingMessageLog) o;
        return Objects.equal(fixtureId, that.fixtureId) &&
                messageType == that.messageType &&
                Objects.equal(incomingMessage, that.incomingMessage) &&
                Objects.equal(incomingMessageReceived, that.incomingMessageReceived) &&
                Objects.equal(processedAt, that.processedAt) &&
                Objects.equal(processed, that.processed) &&
                Objects.equal(processedByInstance, that.processedByInstance) &&
                Objects.equal(processedByRequest, that.processedByRequest) &&
                Objects.equal(generatedSnapshot, that.generatedSnapshot) &&
                Objects.equal(bgHeaderTimestamp, that.bgHeaderTimestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(fixtureId, messageType, incomingMessage, incomingMessageReceived, processedAt,
                processed, processedByInstance, processedByRequest, generatedSnapshot, bgHeaderTimestamp);
    }
}
