package com.example.alienware.firebasefromconsole;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Alienware on 16-02-2017.
 */

public class SharedPref {
    private static final String Name = "FCMFC";
    private static final String TAG = "Token";

    private static SharedPref sharedPref;
    private static Context context;
    private static SharedPreferences sharedPreferences;

    SharedPref(Context context){
        this.context = context;
        sharedPreferences = this.context.getSharedPreferences(Name,Context.MODE_PRIVATE);
    }

    public static synchronized SharedPref getInstance(Context context){
        if(sharedPref==null) sharedPref = new SharedPref(context);
        return sharedPref;
    }

    public void setToken(String token){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(TAG,token);
        editor.apply();
    }

    public String getToken(){
        return sharedPreferences.getString("Token",null);
    }
}
