package com.example.gravitocmpwebviewandroid;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

public class WebAppInterface {
    Context mContext;
    /** Instantiate the interface and set the context */
    WebAppInterface(Context c) {
        mContext = c;
    }

    /** Show a toast from the web page */
    @JavascriptInterface
    public void showToast(String toast) {
        Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
    }
    @JavascriptInterface
    public String getValueFromStorage() {
        String key = "GCString";

        SharedPreferences sharedPref = mContext.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        return sharedPref.getString(key, "");
    }
    @JavascriptInterface
    public void getValueFromWebView( String value) {
        String key = "GCString";
        SharedPreferences sharedPref = mContext.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(key, value);
        editor.apply();
    }
    @JavascriptInterface
    public void onButtonClick() {
        Intent intent = new Intent(mContext, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); // Required if starting activity from non-activity context
        mContext.startActivity(intent);
    }
}
