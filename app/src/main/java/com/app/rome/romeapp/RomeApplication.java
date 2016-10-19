package com.app.rome.romeapp;

import android.app.Activity;
import android.app.Application;
import android.widget.Toast;

import com.microsoft.graph.concurrency.ICallback;
import com.microsoft.graph.core.ClientException;
import com.microsoft.graph.http.IHttpRequest;


public class RomeApplication extends Application {

    private IAuthenticationAdapter mAuthenticationAdapter;

    @Override
    public void onCreate () {
        super.onCreate();
        mAuthenticationAdapter = new MSAAuthAndroidAdapter(RomeApplication.this) {
            @Override
            public String getClientId() {
                return "5ee9c316-7099-4934-874f-8976e327456e";
            }

            @Override
            public String[] getScopes() {
                return new String[] {
                        "dds.read",
                        "dds.register",
                        "offline_access"

                };
            }
        };
    }

    void signOut() {
        mAuthenticationAdapter.logout(new ICallback<Void>() {
            @Override
            public void success(Void aVoid) {
                //handle logout go to an Activity
            }

            @Override
            public void failure(ClientException ex) {
                Toast.makeText(getBaseContext(), "Logout error " + ex, Toast.LENGTH_LONG).show();
            }
        });
    }
    public synchronized IAuthenticationAdapter getmAuthenticationAdapter() {
        return mAuthenticationAdapter;
    }
}
