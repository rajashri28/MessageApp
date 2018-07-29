package com.example.teslaind1.messageapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.teslaind1.messageapp.R;
import com.example.teslaind1.messageapp.model.SmsModel;

import java.util.List;

public class CitySelectAdapter extends RecyclerView.Adapter<CitySelectAdapter.ViewHolder> {

/*

    private List<SmsModel> stList;
    // private CommonPickCityList mContext;
    private Object mObject;


    public CitySelectAdapter(){}

    public CitySelectAdapter(List<SmsModel> cities, Object mObject){
        this.stList = cities;
        this.mObject = mObject;
    }
    // Create new views
    @Override
    public CitySelectAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                           int viewType) {
        // create a new view
        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.cardview_row, null);

        // create ViewHolder

        ViewHolder viewHolder = new ViewHolder(itemLayoutView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, int position) {

        final int pos = position;


        viewHolder.tvCityName.setText(stList.get(position).getTxtSms());

        //viewHolder.tvEmailId.setText(String.valueOf(stList.get(position).getId()));

        viewHolder.chkSelected.setChecked(stList.get(position).isSelected());

        viewHolder.chkSelected.setTag(stList.get(position));


        viewHolder.chkSelected.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                CheckBox cb = (CheckBox) v;
                SmsModel city = (SmsModel) cb.getTag();

                city.setSelected(cb.isChecked());
                stList.get(pos).setSelected(cb.isChecked());

                if(cb.isChecked()){

                    ((CheckboxSelection)mObject).onCheckboxSelected(city);
                }
                else{
                    ((CheckboxSelection)mObject).onCheckboxDeselected(city);
                }
            }
        });


    }

    // Return the size arraylist
    @Override
    public int getItemCount() {
        return stList.size();
    }



    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvCityName;
        public CheckBox chkSelected;
        public RelativeLayout mRelativeLayout;
        public LinearLayout mLinearLayout;

        public SmsModel singlestudent;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);

            tvCityName =  itemLayoutView.findViewById(R.id.tvName);

            chkSelected = (CheckBox) itemLayoutView
                    .findViewById(R.id.chkSelected);
            // mRelativeLayout=(RelativeLayout) itemLayoutView.findViewById(R.id.rltChBox);
            // mLinearLayout=(LinearLayout) itemLayoutView.findViewById(R.id.rltChBox);
        }
    }

    public interface CheckboxSelection{
        void onCheckboxSelected(SmsModel city);
        void onCheckboxDeselected(SmsModel city);
    }


    // method to access in activity after updating selection
    public List<SmsModel> getStudentist() {
        return stList;
    }













*/




  private List<SmsModel> stList;

   Context context;
    private Object mObjContext;



    public CitySelectAdapter(List<SmsModel> cities, Context context){
        this.stList = cities;
        this.context = context;
    }

    public CitySelectAdapter(List<SmsModel> cities, Context context,Object mObjContext){
        this.stList = cities;
        this.context = context;
        this.mObjContext = mObjContext;
    }
    // Create new views
    @Override
    public CitySelectAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                           int viewType) {
        // create a new view
        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.cardview_row, null);

        // create ViewHolder

        ViewHolder viewHolder = new ViewHolder(itemLayoutView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, int position) {

        final int pos = position;


        final SmsModel smsModel=stList.get(position);

        viewHolder.tvCityName.setText(stList.get(position).getTxtSms());


        viewHolder.chkSelected.setChecked(stList.get(position).isSelected());

        viewHolder.chkSelected.setTag(stList.get(position));

/*

    viewHolder.chkSelected.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                CheckBox cb = (CheckBox) v;
                SmsModel city = (SmsModel) cb.getTag();

                boolean check=cb.isChecked();



               // city.setSelected(cb.isChecked());
                //stList.get(pos).setSelected(cb.isChecked());

                if(cb.isChecked()){
                    ((CheckboxSelection)mObjContext).onCheckboxSelected(city);
                }
                else{
                    ((CheckboxSelection)mObjContext).onCheckboxDeselected(city);
                }
            }
        });

  viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            boolean value=viewHolder.chkSelected.isChecked();
                if(value==false){
                    viewHolder.chkSelected.setChecked(true);
                }else {
                    viewHolder.chkSelected.setChecked(false);
                }

                //  CheckBox cb = (CheckBox) v;
                CheckBox cb = viewHolder.chkSelected;
                SmsModel city = (SmsModel) cb.getTag();

                city.setSelected(cb.isChecked());
                stList.get(pos).setSelected(cb.isChecked());

                if(cb.isChecked()){

                    ((CheckboxSelection)mObjContext).onCheckboxSelected(city);
                }
                else{

                    ((CheckboxSelection)mObjContext).onCheckboxDeselected(city);
                }
            }



        });

*/

    viewHolder.chkSelected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CheckBox cb = (CheckBox) v;
                SmsModel city = (SmsModel) cb.getTag();

                city.setSelected(cb.isChecked());
                stList.get(pos).setSelected(cb.isChecked());

                if(cb.isChecked()){

                    ((CheckboxSelection)mObjContext).onCheckboxSelected(city);
                }
                else{

                    ((CheckboxSelection)mObjContext).onCheckboxDeselected(city);
                }
            }

        });


        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean value=viewHolder.chkSelected.isChecked();
                if(value==false){
                    viewHolder.chkSelected.setChecked(true);
                }else {
                    viewHolder.chkSelected.setChecked(false);
                }

                //  CheckBox cb = (CheckBox) v;
                CheckBox cb = viewHolder.chkSelected;
                SmsModel city = (SmsModel) cb.getTag();

                city.setSelected(cb.isChecked());
                stList.get(pos).setSelected(cb.isChecked());

                if(cb.isChecked()){
                    ((CheckboxSelection)mObjContext).onCheckboxSelected(city);
                }
                else{
                    ((CheckboxSelection)mObjContext).onCheckboxDeselected(city);
                }
            }
        });

    }


    // Return the size arraylist
    @Override
    public int getItemCount() {
        return stList.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvCityName;
        public CheckBox chkSelected;

        public LinearLayout mLinearLayout;
       public SmsModel singlestudent;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);

            tvCityName =  itemLayoutView.findViewById(R.id.tvName);

            chkSelected = (CheckBox) itemLayoutView
                    .findViewById(R.id.chkSelected);
            mLinearLayout=(LinearLayout) itemLayoutView
                    .findViewById(R.id.cardLayout);
                   }
    }

    public interface CheckboxSelection{
        void onCheckboxSelected(SmsModel city);
        void onCheckboxDeselected(SmsModel city);
    }



}