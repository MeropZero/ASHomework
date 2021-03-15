package com.ss.android.ugc.demo;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;

import com.ss.android.ugc.demo.widget.Clock;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ClockActivity extends AppCompatActivity {

    private View mRootView;
    private Clock mClockView;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
//            super.handleMessage(msg);/
            switch (msg.what) {
                case 1:
                    mClockView.invalidate();
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock);
        mRootView = findViewById(R.id.root);
        mClockView = findViewById(R.id.clock);
        new TimeThread().start();
    }

    public class TimeThread extends Thread {

        @Override
        public void run() {
//            super.run();

            do {
                try {
                    Thread.sleep(1000);
                    Message msg = new Message();
                    msg.what = 1;
                    handler.sendMessage(msg);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }while (true);
        }
    }

}
