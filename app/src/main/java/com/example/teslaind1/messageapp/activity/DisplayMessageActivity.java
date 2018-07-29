package com.example.teslaind1.messageapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.teslaind1.messageapp.R;
import com.example.teslaind1.messageapp.model.SmsModel;


public class DisplayMessageActivity extends AppCompatActivity  {
private TextView mTxtDisplay;
private Button mBtnSend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        initData();
    }

    private void initData(){
SmsModel smsModel= (SmsModel) getIntent().getSerializableExtra("msData");
        mTxtDisplay=findViewById(R.id.txtDisplay);
        mTxtDisplay.setText(smsModel.getTxtSms());
        mBtnSend=findViewById(R.id.btnSend);
        mBtnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message=mTxtDisplay.getText().toString();
                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("text/plain");
                share.putExtra(Intent.EXTRA_TEXT, message);

                startActivity(Intent.createChooser(share, "Title of the dialog the system will open"));

            }
        });
    }


}
