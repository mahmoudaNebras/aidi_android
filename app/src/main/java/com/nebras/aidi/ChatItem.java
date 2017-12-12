package com.nebras.aidi;

import java.io.Serializable;

/**
 * Created by mahmoudkamal on 11/5/17.
 */

public class ChatItem implements Serializable {
    private String message,timestamp,type;


    public ChatItem(String message, String timestamp, String type) {
        this.message = message;
        this.timestamp = timestamp;
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
