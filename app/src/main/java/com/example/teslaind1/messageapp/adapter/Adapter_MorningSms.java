package com.example.teslaind1.messageapp.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.teslaind1.messageapp.R;
import com.example.teslaind1.messageapp.model.SmsModel;

import java.util.ArrayList;

/**
 * Created by Teslaind 1 on 3/21/2018.
 */

public class Adapter_MorningSms extends ArrayAdapter {
private Context mContext;

private ArrayList<SmsModel> mArryMsg;
private int count=0;
    private Object mObjContext;
    LayoutInflater inflater;
private ArrayList<SmsModel>mSelectedMessage;
 /*   public Adapter_MorningSms(Context mContext, ArrayList<SmsModel> mArryMsg) {
        this.mContext = mContext;
        this.mArryMsg = mArryMsg;
        this.mObjContext = mObjContext;
        mSelectedMessage=new ArrayList<>();
    }
*/

    public Adapter_MorningSms(Context mContext, Object mObjContext, int resource, ArrayList<SmsModel> mArryMsg) {
        super(mContext,resource,mArryMsg);
        this.mContext = mContext;
        this.mArryMsg = mArryMsg;
        this.mObjContext = mObjContext;
        mSelectedMessage=new ArrayList<>();
        inflater = LayoutInflater.from(mContext);
    }


   /* public Adapter_MorningSms(Context mContext,Object mObjContext, ArrayList<SmsModel> mArryMsg) {
        this.mContext = mContext;
        this.mArryMsg = mArryMsg;
        this.mObjContext = mObjContext;
        mSelectedMessage=new ArrayList<>();
    }*/

  /*  class MorSmsClass extends RecyclerView.ViewHolder {
        private TextView mTxtView;
        private CheckBox mcheckBox;

        public MorSmsClass(View itemView) {
            super(itemView);
            mTxtView=(TextView) itemView.findViewById(R.id.txtMsg);
            mcheckBox=itemView.findViewById(R.id.checkbox);

        }
    }*/

    class MorSmsClass
    {
        private TextView mTxtView;
        private CheckBox mcheckBox;

        }

  /*  @Override
    public MorSmsClass onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(mContext);
        View view=inflater.inflate(R.layout.single_row1,null);
        MorSmsClass morSmsClass=new MorSmsClass(view);
        return morSmsClass;
    }

    @Override
    public int getItemCount() {
        return mArryMsg.size();
    }

    @Override
    public void onBindViewHolder(final MorSmsClass holder, final int position) {

        final SmsModel smsModel=mArryMsg.get(position);
        holder.mTxtView.setText( smsModel.getTxtSms());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.content.Intent intent=new android.content.Intent(mContext,com.example.teslaind1.messagesapp.DisplayMessageActivity.class);
                intent.putExtra("msData",smsModel);
                mContext.startActivity(intent);

            }
        });

        holder.mcheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked==true){
                    holder.mcheckBox.setSelected(true);
                    count++;
                    holder.itemView.setBackgroundColor(Color.GRAY);
                   mSelectedMessage.add(mArryMsg.get(position));
                    ((SelectedMsgCount)mObjContext).setCount(count,true,mSelectedMessage, holder.itemView,holder.mcheckBox);

                }else {
                    holder.mcheckBox.setSelected(false);
                    holder. itemView.setBackgroundColor(mContext.getResources().getColor(R.color.colorAccent));
                    count--;
                    mSelectedMessage.remove(mArryMsg.get(position));
                    ((SelectedMsgCount)mObjContext).setCount(count,false,mSelectedMessage, holder.itemView,holder.mcheckBox);

                }
            }
        });


        }

        public interface SelectedMsgCount{
        public void setCount(int count,boolean ischecked,ArrayList<SmsModel>arrayList,View itemView,CheckBox checkBox);
        }*/



    public View getView(final int position, View view, ViewGroup parent) {
        final MorSmsClass holder;
        if (view == null) {
            holder = new MorSmsClass();
            view = inflater.inflate(R.layout.single_row1, null);

            holder.mTxtView = (TextView) view.findViewById(R.id.txtMsg);
            holder.mcheckBox = view.findViewById(R.id.checkbox);
            view.setTag(holder);
        } else {
            holder = (MorSmsClass) view.getTag();
        }
        // Capture position and set to the TextViews
        holder.mTxtView.setText(mArryMsg.get(position). getTxtSms());
        holder.mcheckBox.setChecked(mArryMsg.get(position).isSelected());

        final View finalView = view;
        holder.mcheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked==true){
                    finalView.setBackgroundColor(Color.GRAY);
                    holder.mcheckBox.setSelected(true);
                    count++;
                    // holder.itemView.setBackgroundColor(Color.GRAY);
                    mSelectedMessage.add(mArryMsg.get(position));
                    ((SelectedMsgCount)mObjContext).setCount(count,true,mSelectedMessage, finalView, holder.mcheckBox);

                }else {
                    finalView.setBackgroundColor(Color.WHITE);
                    holder.mcheckBox.setSelected(false);
                    count--;
                    mSelectedMessage.remove(mArryMsg.get(position));
                    ((SelectedMsgCount)mObjContext).setCount(count,false,mSelectedMessage, finalView, holder.mcheckBox);
                }
            }
        });


        return view;
    }

    public interface SelectedMsgCount{
        public void setCount(int count, boolean ischecked, ArrayList<SmsModel> arrayList, View itemView, CheckBox checkBox);
    }

}
