package com.jcoder.clickarea;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

/**
 * Android不规则点击区域详解 - vanezkw - 博客园
 * https://www.cnblogs.com/vanezkw/p/3806360.html
 */
public class MainActivity extends Activity implements OnClickListener {

    private Toast mToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState);
        setContentView( R.layout.activity_main);
        // onTouch 在 onClick 之前，同时 setOnClickListener 之后，view 就是 clickable的了
        findViewById( R.id.menu_1).setOnClickListener( this);
        findViewById( R.id.menu_2).setOnClickListener( this);
        findViewById( R.id.menu_3).setOnClickListener( this);
        findViewById( R.id.menu_4).setOnClickListener( this);
    }

    @Override
    public void onClick(View v) {
        if(null != mToast) {
            mToast.cancel();
        }
        switch(v.getId()) {
            case R.id.menu_1:
                mToast = Toast.makeText( this, "red", Toast.LENGTH_SHORT);
                break;
            case R.id.menu_2:
                mToast = Toast.makeText( this, "yellow", Toast.LENGTH_SHORT);
                break;
            case R.id.menu_3:
                mToast = Toast.makeText( this, "green", Toast.LENGTH_SHORT);
                break;
            case R.id.menu_4:
                mToast = Toast.makeText( this, "blue", Toast.LENGTH_SHORT);
                break;
        }
        mToast.show();
    }
}
