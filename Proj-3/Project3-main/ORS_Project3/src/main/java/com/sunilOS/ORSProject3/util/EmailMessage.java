package com.sunilOS.ORSProject3.util;

/**
 * The class which contain email message and setter getter
 * @author Rishabh Gurjar
 *
 */

public class EmailMessage {
	
    private String to = null;

    
    private String from = null;

    
    private String cc = null;

    
    private String bcc = null;

    
    private String subject = null;

    
    private String message = null;

    
    public static final int HTML_MSG = 1;

    
    public static final int TEXT_MSG = 2;

    
    private int messageType = TEXT_MSG;

    
    
    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getBcc() {
        return bcc;
    }

    public void setBcc(String bcc) {
        this.bcc = bcc;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getMessageType() {
        return messageType;
    }

    public void setMessageType(int messageType) {
        this.messageType = messageType;
    }
}
