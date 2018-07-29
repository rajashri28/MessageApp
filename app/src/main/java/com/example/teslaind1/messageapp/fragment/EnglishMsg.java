package com.example.teslaind1.messageapp.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;

import com.example.teslaind1.messageapp.R;
import com.example.teslaind1.messageapp.adapter.CitySelectAdapter;
import com.example.teslaind1.messageapp.apiclass.ApiClass;
import com.example.teslaind1.messageapp.commondata.CommonWidgets;
import com.example.teslaind1.messageapp.interfaces.Api;
import com.example.teslaind1.messageapp.model.GetMessage;
import com.example.teslaind1.messageapp.model.SmsModel;
import com.example.teslaind1.messageapp.realm.Migration;
import com.facebook.stetho.Stetho;
import com.uphyca.stetho_realm.RealmInspectorModulesProvider;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Teslaind 1 on 3/23/2018.
 */

public class EnglishMsg extends Fragment  implements CitySelectAdapter.CheckboxSelection {

      private EditText mEditText;
    private View mView;
    private RecyclerView mRecyclerView;
    private MenuItem mMenuAddMsg, mMenuImg, mMenuCount, mMenuSelectedText, mMenuDelete;
    private Realm mRealm;

    private int checked = 0;
    private final String MessageId = "messageId";

    private SmsModel city1;

    private ArrayList<SmsModel> selectedList = new ArrayList<>();
    private ArrayList<SmsModel> mSelectedMessage = new ArrayList<>();
    private ArrayList<SmsModel> messageList;

    private RecyclerView.Adapter mAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.frag_mor_engmsg, null);

        return mView;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setHasOptionsMenu(true);

        initFindViewByIds();

        initRealm();

       viewMessages();

        setArrayList();
    }


    public void initRealm() {

        Realm.init(getActivity());

        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .migration(new Migration())
                .name("student.realm")
                .schemaVersion(1)
                .build();
        // realm= Realm.getInstance(realmConfiguration);
        mRealm = Realm.getDefaultInstance();
        // Stetho.initializeWithDefaults(this);
        Stetho.initialize(
                Stetho.newInitializerBuilder(getActivity())
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(getActivity()))
                        .enableWebKitInspector(RealmInspectorModulesProvider.builder(getActivity()).build())
                        .build());

    }


    public void initFindViewByIds() {

        mRecyclerView = mView.findViewById(R.id.listview);
    }


    public void setArrayList() {

        messageList = new ArrayList<>();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new CitySelectAdapter(messageList, getActivity(), EnglishMsg.this);
        mRecyclerView.setAdapter(mAdapter);


        }

   @Override
    public void onCheckboxSelected(SmsModel city) {

       mSelectedMessage.add(city);
       mMenuCount.setTitle(mSelectedMessage.size() + "");

       if (mSelectedMessage.size() > 0) {

           mMenuDelete.setVisible(true);
           mMenuSelectedText.setVisible(true);
       }

        /*city1 = city;
        selectedList.clear();
        selectedList.add(city);
        mSelectedMessage.addAll(selectedList);
        checked = selectedList.size();
        mMenuCount.setTitle(checked + "");

       if (checked > 0) {

            mMenuDelete.setVisible(true);
             mMenuSelectedText.setVisible(true);
        }*/


    }

    @Override
    public void onCheckboxDeselected(SmsModel city) {

        mSelectedMessage.remove(city);
        mMenuCount.setTitle(mSelectedMessage.size() + "");

        if (mSelectedMessage.size() == 0) {

            mMenuDelete.setVisible(false);
            mMenuSelectedText.setVisible(false);
        }


       /* selectedList.remove(city);
        mSelectedMessage.removeAll(selectedList);
        checked = selectedList.size();
        mMenuCount.setTitle(checked + "");

        if (checked == 0) {

            mMenuDelete.setVisible(false);
        }*/
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        inflater.inflate(R.menu.menu, menu);

        mMenuSelectedText = menu.findItem(R.id.action_selected);
        mMenuCount = menu.findItem(R.id.action_count);
        mMenuDelete = menu.findItem(R.id.delete);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id) {

            case R.id.action_addMsg:

                showChangeLangDialog();
                break;

            case R.id.delete:

                deleteSelectMessage();
                break;
                }

        return super.onOptionsItemSelected(item);
    }


    private void deleteSelectMessage() {

        String URL = "http://192.168.2.7/MessageApp/delete.php/";

        //int id = city1.getMessageId();

for(int i=0;i<mSelectedMessage.size();i++){

    SmsModel smsModel=mSelectedMessage.get(i);

        Api apiService = ApiClass.getClient(URL).create(Api.class);

        Call<SmsModel> call = apiService.deleteFood(smsModel.getMessageId());

        call.enqueue(new Callback<SmsModel>() {


            @Override
            public void onResponse(Call<SmsModel> call, Response<SmsModel> response) {

                CommonWidgets.displayToast(getActivity(),"Success");

                }

            @Override
            public void onFailure(Call<SmsModel> call, Throwable t) {

                CommonWidgets.displayToast(getActivity(),"failure");

                if (messageList.size() > 0) {

                    messageList.clear();
                }

                viewMessages();

            }

        });
    }
    }

    public void deleteRecord() {

        RealmResults<SmsModel> results = mRealm.where(SmsModel.class)
                .equalTo("messageId", city1.getMessageId()).findAll();

        mRealm.beginTransaction();

        results.deleteAllFromRealm();

        mRealm.commitTransaction();
    }


    private void showChangeLangDialog() {

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = this.getLayoutInflater();

        final View dialogView = inflater.inflate(R.layout.custom_dialog, null);
        dialogBuilder.setView(dialogView);

        mEditText = dialogView.findViewById(R.id.etMessageBox);

        dialogBuilder.setTitle("Custom dialog");
        dialogBuilder.setMessage("Enter text below");

        dialogBuilder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {

                final String URL = "http://192.168.2.7/MessageApp/insert.php/";

                String name = mEditText.getText().toString();

                Api apiService =ApiClass.addingMessage(URL).create(Api.class);

                Call<SmsModel> call = apiService.insertFood(name);

                call.enqueue(new Callback<SmsModel>() {


                    @Override
                    public void onResponse(Call<SmsModel> call, Response<SmsModel> response) {

                        CommonWidgets.displayToast(getActivity(),"added");

                    }

                    @Override
                    public void onFailure(Call<SmsModel> call, Throwable t) {

                        CommonWidgets.displayToast(getActivity(),"no added");

                        if (messageList.size() > 0) {

                            messageList.clear();
                        }

                        viewMessages();

                        }

                        });
            }
        });


        dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //pass
            }
        });
        AlertDialog b = dialogBuilder.create();
        b.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        b.show();
    }


    public void viewMessages() {

        Api apiService1 = ApiClass.getClientForViewMessage().create(Api.class);

        Call<GetMessage> call = apiService1.getMessage(0);

        call.enqueue(new Callback<GetMessage>() {


            @Override
            public void onResponse(Call<GetMessage> call, Response<GetMessage> response) {

                 CommonWidgets.displayToast(getActivity(),"Success");

                ArrayList<GetMessage.MessageData> student = new ArrayList(response.body().getAllMessage());

                for (int i = 0; i < student.size(); i++) {

                    SmsModel smsModel = new SmsModel();
                    smsModel.setMessageId(Integer.parseInt(student.get(i).getMessageId()));
                    smsModel.setTxtSms(student.get(i).getMessageName());

                    messageList.add(smsModel);

                }

                mAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<GetMessage> call, Throwable t) {

                 CommonWidgets.displayToast(getActivity(),"failure");

            }

        });
    }


    public int getMaxLocalId() {

        long localId = 0;
        try {

            Number num = mRealm.where(SmsModel.class).max(MessageId);
            if (num == null) {
                return 0;
            } else {

                localId = (long) num;

                //return (int) localId;
            }
        } catch (Exception e) {

        } finally {

            return (int) localId;
        }
    }

}

