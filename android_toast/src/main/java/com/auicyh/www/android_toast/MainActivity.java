package com.auicyh.www.android_toast;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static com.auicyh.www.android_toast.R.id.custom_toast;

public class MainActivity extends AppCompatActivity {
    private Button mToast,mCustomToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToast = (Button) findViewById(R.id.toast);
        mToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"我是普通Toast",Toast.LENGTH_SHORT).show();
            }
        });
        mCustomToast = (Button) findViewById(custom_toast);
        mCustomToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCustomToast();
            }

            private void showCustomToast() {
                // 初始化控件
                Toast result = new Toast(MainActivity.this);
                // 获取LayoutInflater实例
                LayoutInflater inflate = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                // 渲染布局
                View v = inflate.inflate(R.layout.custom_toast, null);
                // 随心设置内容
                TextView tv = (TextView) v.findViewById(R.id.id_text);
                tv.setText("我是自定义Toast");
                // 设置填充内容
                result.setView(v);
                // 设置时间
                result.setDuration(Toast.LENGTH_SHORT);
                // 设置居中
                result.setGravity(0, 0, 0);
                result.show();

            }
        });
    }
}
