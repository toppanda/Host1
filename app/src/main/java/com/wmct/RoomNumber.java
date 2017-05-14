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
public class RoomNumber extends Activity {
    protected int rn;
    EditText editText_rn;
    Button roomconfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.roomnumber);
        Button roomconfirm = (Button) findViewById(R.id.roomconfirm);
        editText_rn = (EditText) findViewById(R.id.editText_rn);

        roomconfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                get_rn();
                Intent intent = new Intent(RoomNumber.this, Detail.class);
                startActivity(intent);

            }
        });
    }
    //获取输入房间号
    public void get_rn() {
        EditText et_rn = (EditText) findViewById(R.id.editText_rn);
        try {
            int rn = Integer.parseInt(et_rn.getText().toString());
            this.rn = rn;
        } catch (Exception e) {
        }
    }

}
