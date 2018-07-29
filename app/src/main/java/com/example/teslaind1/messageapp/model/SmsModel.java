package com.example.teslaind1.messageapp.model;

import java.io.Serializable;

import io.realm.RealmObject;

/**
 * Created by Teslaind 1 on 3/21/2018.
 */

public class SmsModel  extends RealmObject implements Serializable {

    private String txtSms;
    private boolean isSelected;
    private int messageId;

   public SmsModel(){

    }

    public SmsModel(String txtSms) {
        this.txtSms = txtSms;
    }

    public String getTxtSms() {
        return txtSms;
    }

    public void setTxtSms(String txtSms) {
        this.txtSms = txtSms;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }


    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }
}
