package com.app.rome.romeapp;

import android.app.Activity;

import com.microsoft.graph.authentication.IAuthenticationProvider;
import com.microsoft.graph.concurrency.ICallback;
import com.microsoft.graph.http.IHttpRequest;

/**
 * Created by carmenf on 10/17/2016.
 */

public class AuthenticationProvider implements IAuthenticationAdapter {
    @Override
    public void logout(ICallback<Void> callback) {

    }

    @Override
    public void login(Activity activity, ICallback<Void> callback) {

    }

    @Override
    public void authenticateRequest(IHttpRequest request) {

    }
}
