package com.sniff.sniffbeta;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.io.FileOutputStream;
import java.io.IOException;


public class RegistrationProfile2 extends ActionBarActivity {

    EditText firstName, lastName, email, adress, phone, password, confirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_profile2);

        firstName=(EditText) findViewById(R.id.editFirstName);
        lastName=(EditText) findViewById(R.id.editLastName);
        email=(EditText) findViewById(R.id.editEmail);
        adress=(EditText) findViewById(R.id.editAdress);
        phone=(EditText) findViewById(R.id.editPhone);
        password=(EditText) findViewById(R.id.editPassword);
        confirmPassword=(EditText) findViewById(R.id.editConfirmPassword);



            }




    public void Save (View view) {
        Log.d("RegistrationProfile2", ""  + firstName.getText());

        String textFirstName=firstName.getText().toString();
        String textLastName=lastName.getText().toString();
        String textEmail=email.getText().toString();
        String textAdress=adress.getText().toString();
        String textPhone=phone.getText().toString();
        String textPassword=password.getText().toString();
        String textConfirmPassword=confirmPassword.getText().toString();


        textFirstName=textFirstName+" ";
        textLastName=textLastName+" ";
        textEmail=textEmail+" ";
        textAdress=textAdress+" ";
        textPhone=textPhone+" ";
        textPassword=textPassword+" ";
        textConfirmPassword=textConfirmPassword+" ";


        FileOutputStream fos = null;
        try {
            fos = openFileOutput("registration.txt", Context.MODE_PRIVATE);


            fos.write(textFirstName.getBytes());
            fos.write(textLastName.getBytes());
            fos.write(textEmail.getBytes());
            fos.write(textAdress.getBytes());
            fos.write(textPhone.getBytes());
            fos.write(textPassword.getBytes());
            fos.write(textConfirmPassword.getBytes());

        } catch (IOException e){
            e.printStackTrace();
        }
        finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Toast.makeText(this,"Saved successfully",Toast.LENGTH_LONG).show();

    }

    public void Cancel (View view)
    {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_registration_profile2, menu);
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
