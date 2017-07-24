package com.wewash.services.model;

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
public class IncomingMessage {

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
        return incomingMessageReceived;
    }

    public void setIncomingMessageReceived(Date incomingMessageReceived) {
        this.incomingMessageReceived = incomingMessageReceived;
    }

    public Date getProcessedAt() {
        return processedAt;
    }

    public void setProcessedAt(Date processedAt) {
        this.processedAt = processedAt;
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
        return bgHeaderTimestamp;
    }

    public void setBgHeaderTimestamp(Date bgHeaderTimestamp) {
        this.bgHeaderTimestamp = bgHeaderTimestamp;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}
