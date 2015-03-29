package com.sniff.sniffbeta;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.sniff.sniffbeta.model.Profile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;


public class ProfileInfo extends ActionBarActivity {
    private Profile profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_info);
        profile = Profile.readProfile(this);
        EditText firstNameP = (EditText) findViewById(R.id.FirstNameP);
        firstNameP.setText(profile.firstName);
        EditText lastNameP = (EditText) findViewById(R.id.LastNameP);
        lastNameP.setText(profile.lastName);
        EditText emailP = (EditText) findViewById(R.id.EmailP);
        emailP.setText(profile.email);
        EditText adressP = (EditText) findViewById(R.id.AdressP);
        adressP.setText(profile.adress);
        EditText phoneP = (EditText) findViewById(R.id.PhoneP);
        phoneP.setText(profile.phone);
        EditText passwordP = (EditText) findViewById(R.id.PasswordP);
        passwordP.setText(profile.password);
        EditText confirmPasswordP = (EditText) findViewById(R.id.ConfirmPasswordP);
        confirmPasswordP.setText(profile.confirmPassword);

    }

    public void load (View view){


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_profile_info, menu);
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
}
