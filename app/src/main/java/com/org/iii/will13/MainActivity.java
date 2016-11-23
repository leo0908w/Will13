package com.org.iii.will13;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private boolean isStart;
    private TextView textView;
    private MyReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);

        receiver = new MyReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction("will");
        registerReceiver(receiver, filter);
    }

    public void startService(View v) {
        Intent it = new Intent(this, MyService.class);
        it.putExtra("isStart", isStart);
        it.putExtra("value", (int) (Math.random() * 100 + 1));
        startService(it);
        isStart = true;
    }

    public void stopService(View v) {
        Intent it = new Intent(this, MyService.class);
        stopService(it);
    }

    private class MyReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.v("will", "got it");
            String mesg = intent.getStringExtra("data");

            textView.setText(mesg);
        }
    }

}
