package com.org.iii.will13;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private boolean isStrat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startService(View v) {
        Intent it = new Intent(this, MyService.class);
        it.putExtra("isStart", isStrat);
        it.putExtra("value", (int) (Math.random() * 100 + 1));
        startService(it);
        isStrat = true;
    }

    public void stopService(View v) {
        Intent it = new Intent(this, MyService.class);
        stopService(it);
    }


}
