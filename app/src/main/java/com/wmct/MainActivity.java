package com.wmct;

import android.content.res.Configuration;
import android.view.View;
import android.widget.Button;

import com.wmct.Base.BaseActivity;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    Button btn_host, btn_join;

    protected void initView() {
        if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
        {
            setContentView(R.layout.activity_main_h); //布局1
        }
        else if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
        {
            setContentView(R.layout.activity_main_v); //布局2
        }
        btn_host = (Button) findViewById(R.id.btn_host);
        btn_join = (Button) findViewById(R.id.btn_join);
        btn_host.setOnClickListener(this);
        btn_join.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_host:
                openActivity(HostActivity.class);
                break;
            case R.id.btn_join:
               openActivity(RoomNumber.class);
                break;
        }
    }


}

