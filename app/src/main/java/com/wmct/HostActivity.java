package com.wmct;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.wmct.vote.VoteNet.JsonBean;
import com.wmct.vote.VoteNet.Request;
import com.wmct.vote.utils.CheckUtil;
import com.wmct.vote.utils.StringUtil;
import com.wmct.vote.utils.ToastUtil;
import com.wmct.vote.VoteNet.VoteNetApi;

import org.json.JSONObject;

/**
 * Created by  on 2017/5/12.
 */

public class HostActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = "HostActivity";

    private EditText et_roomNumber, et_password;
    private Button btn_startVoting, btn_endVoting;
    private String roomnuber, password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host);
        getSupportActionBar().setTitle("主持人界面");
        initView();
    }

    private void initView() {
        et_roomNumber = (EditText) findViewById(R.id.et_input_roomnumber);
        et_password = (EditText) findViewById(R.id.et_input_password);
        btn_startVoting = (Button) findViewById(R.id.btn_start_voting);
        btn_endVoting = (Button) findViewById(R.id.btn_end_voting);
        btn_startVoting.setOnClickListener(this);
        btn_endVoting.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_start_voting:
                startVoting();
                break;
            case R.id.btn_end_voting:
                endVoting();
                break;
        }
    }

    /**
     * 开启投票
     */
    private void startVoting() {
        if (checkInput()) {
            VoteNetApi.hostLogin(roomnuber, password, new Request.RequestListener<JSONObject>() {
                @Override
                public void onComplete(int stCode, JSONObject response, String errMsg) {
                    if (JsonBean.isOK(response)) {
                        ToastUtil.showToastShort(HostActivity.this, R.string.start_success);
                    } else {
                        ToastUtil.showToastShort(HostActivity.this, StringUtil.ENChangeToCH(JsonBean.getMsg(response)));
                    }
                }
            });
        }
    }

    /**
     * 结束投票
     */
    private void endVoting() {
        if (checkInput()) {
            VoteNetApi.voteEnd(roomnuber, password, new Request.RequestListener<JSONObject>() {
                @Override
                public void onComplete(int stCode, JSONObject response, String errMsg) {
                    if (JsonBean.isOK(response)) {
                        ToastUtil.showToastShort(HostActivity.this, R.string.end_success);
                    } else {
                        ToastUtil.showToastShort(HostActivity.this,StringUtil.ENChangeToCH(JsonBean.getMsg(response)));
                    }
                }
            });
        }
    }

    /**
     * 检测输入格式
     * @return 输入不为空且网络完好时返回true
     */
    private boolean checkInput() {
        roomnuber = et_roomNumber.getText().toString();
        Log.i(TAG, "roomnuber:" + roomnuber);
        if(TextUtils.isEmpty(roomnuber)){
            ToastUtil.showToastShort(HostActivity.this, R.string.input_roomnumber);
            return false;
        }
        password = et_password.getText().toString();
        Log.i(TAG, "password:" + password);
        if(TextUtils.isEmpty(password)||!CheckUtil.isNum(password)){
            ToastUtil.showToastShort(HostActivity.this, R.string.input_password);
            return false;
        }
        if(!CheckUtil.isNetworkConnected(this)){
            ToastUtil.showToastShort(HostActivity.this, R.string.network_not_connected);
            return false;
        }
        return true;
    }
}
