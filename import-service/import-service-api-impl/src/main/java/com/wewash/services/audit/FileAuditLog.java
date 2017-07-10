package com.wewash.services.audit;

import java.util.Date;

public class FileAuditLog {
    private Date messageDate;
    private String messageString;

    public FileAuditLog(Date messageDate, String messageString) {
        this.messageDate = new Date(messageDate.getTime());
        this.messageString = messageString;
    }

    public FileAuditLog() { /* for Jackson */ }

    public Date getMessageDate() {
        return new Date(messageDate.getTime());
    }

    public void setMessageDate(Date messageDate) {
        this.messageDate = new Date(messageDate.getTime());
    }

    public String getMessageString() {
        return messageString;
    }

    public void setMessageString(String messageString) {
        this.messageString = messageString;
    }
}
