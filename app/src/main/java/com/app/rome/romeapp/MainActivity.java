package com.app.rome.romeapp;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.microsoft.graph.authentication.IAuthenticationProvider;
import com.microsoft.graph.concurrency.ICallback;
import com.microsoft.graph.core.ClientException;
import com.microsoft.graph.http.IHttpRequest;

import static com.app.rome.romeapp.R.id.fab;
import static com.app.rome.romeapp.R.id.signinbutton;

public class MainActivity extends AppCompatActivity implements ICallback<Void> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button signinButton = (Button) findViewById(signinbutton);
        signinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Button signinButton = (Button) findViewById(signinbutton);
                signinButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(final View v) {
                        final RomeApplication application = (RomeApplication) getApplication();

//new ICallback<Void>()
                        application.getmAuthenticationAdapter().login(MainActivity.this, new DefaultCallback<Void>(MainActivity.this) {

                            @Override
                            public void success(Void aVoid) {
                                // Handles what happens here.
                            }

                            @Override
                            public void failure(ClientException ex) {
                                // Handles what happens here.

                            }
                        });

                    }
                });

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void success(Void aVoid) {

    }

    @Override
    public void failure(ClientException ex) {

    }
}
