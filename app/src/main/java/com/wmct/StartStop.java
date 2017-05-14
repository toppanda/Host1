package com.wmct;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


/**
 * Created by ZHYu on 2017/5/12.
 */

public class StartStop extends Activity {

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startsop);
        Button start = (Button)findViewById(R.id.start);
        final EditText roomnum_begin =(EditText)findViewById(R.id.roomnum_begin);
        final EditText begin_key = (EditText)findViewById(R.id.begin_key);
        final Button startconfirm = (Button)findViewById(R.id.startconfirm) ;
        Button stop = (Button)findViewById(R.id.stop);
        final EditText roomnum_stop =(EditText)findViewById(R.id.roomnum_stop) ;
        final EditText stop_key =(EditText) findViewById(R.id.stop_key) ;
        final Button stopconfirm = (Button)findViewById(R.id.stopconfirm) ;

        start.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                roomnum_begin.setVisibility(View.VISIBLE);
                begin_key.setVisibility(View.VISIBLE);
                startconfirm.setVisibility(View.VISIBLE);

                //将房间号和密钥发送给服务器，返回1则开始。
            }
        });
        stop.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                roomnum_stop.setVisibility(View.VISIBLE);
                stop_key.setVisibility(View.VISIBLE);
                stopconfirm.setVisibility(View.VISIBLE);
                //发送房间号和密钥，结束投票。
            }
        });

        startconfirm.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

            }
        });

    }
}
