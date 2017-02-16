package com.example.alienware.firebasefromconsole;

import android.util.Log;
import android.widget.TextView;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by Alienware on 16-02-2017.
 */


//by the instanceId you could target specific user
//if you want to send it to all, you don't need individual user Id

public class FirebaseToken extends FirebaseInstanceIdService {
    static final String TAG = "InstanceID";
    public static String id= "";
    @Override
    public void onTokenRefresh() {
        id = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG,id);
        SharedPref.getInstance(getApplicationContext()).setToken(id);
        //Log.d("InstanceID", ""+ FirebaseInstanceId.getInstance().getToken());
    }



}
