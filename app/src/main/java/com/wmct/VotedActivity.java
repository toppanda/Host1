package com.wmct;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by zhyu on 2017/5/9.
 */
public class VotedActivity extends Activity {
    protected int key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enterkey);
        Button keyconfirm = (Button) findViewById(R.id.keyconfirm);
        keyconfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取输入的密钥
                get_key();


                //把房间号传给后台验证，返回flag为1则可以跳转否则toast提示房间号不正确重新输入
                Intent intent = new Intent(VotedActivity.this, StartStop.class);
                startActivity(intent);

            }
        });
    }

    //获取房间号
    public void get_key() {
        EditText et_key = (EditText) findViewById(R.id.editText_key);
        try{
            int key = Integer.parseInt(et_key.getText().toString());
            this.key = key;
        }
        catch(Exception e){

        }

    }
}
