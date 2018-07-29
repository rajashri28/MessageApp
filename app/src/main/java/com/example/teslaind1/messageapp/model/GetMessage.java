package com.example.teslaind1.messageapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class GetMessage {

    @SerializedName("allmessage")
    private ArrayList<MessageData> allMessage;


    public ArrayList<MessageData> getAllMessage() {
        return allMessage;
    }

    public void setAllMessage(ArrayList<MessageData> allMessage) {
        this.allMessage = allMessage;
    }



 public class MessageData{

    String messageId,messageName;

     public String getMessageId() {
         return messageId;
     }

     public void setMessageId(String messageId) {
         this.messageId = messageId;
     }

     public String getMessageName() {
         return messageName;
     }

     public void setMessageName(String messageName) {
         this.messageName = messageName;
     }
 }
}