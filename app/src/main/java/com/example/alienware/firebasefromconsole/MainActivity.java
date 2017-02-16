package com.example.alienware.firebasefromconsole;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView token;
    Button showToken;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showToken = (Button)findViewById(R.id.showToken);
        token = (TextView)findViewById(R.id.token);
        showToken.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        String tokenFromShared = SharedPref.getInstance(getApplicationContext()).getToken();
                        token.setText(tokenFromShared==null?"Token not set":tokenFromShared);
                        return true;
                    case MotionEvent.ACTION_UP:
                        return true;
                }
                return true;
            }
        });
    }
}
