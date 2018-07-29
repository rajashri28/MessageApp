package com.example.teslaind1.messageapp.commondata;

import android.content.Context;
import android.widget.Toast;

public class CommonWidgets {

    public static void displayToast(Context mContext, String strMessage) {

        if (strMessage != null) {

            Toast.makeText(mContext, strMessage, Toast.LENGTH_SHORT).show();
        }
    }

}
