package com.sniff.sniffbeta;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class RegistrationProfile extends ActionBarActivity {

    EditText firstName, lastName, email, adress, phone, password, confirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_profile);

        firstName=(EditText) findViewById(R.id.editFirstName);
        lastName=(EditText) findViewById(R.id.editLastName);
        email=(EditText) findViewById(R.id.editEmail);
        adress=(EditText) findViewById(R.id.editAdress);
        phone=(EditText) findViewById(R.id.editPhone);
        password=(EditText) findViewById(R.id.editPassword);
        confirmPassword=(EditText) findViewById(R.id.editConfirmPassword);


    }

    public void saveProfile (View view) {

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


        FileOutputStream fos = null;
        try {
            fos = openFileOutput("registration.txt", Context.MODE_PRIVATE);


            fos.write(textFirstName.getBytes());
            fos.write(textLastName.getBytes());
            fos.write(textEmail.getBytes());
            fos.write(textAdress.getBytes());
            fos.write(textPhone.getBytes());
            fos.write(textPassword.getBytes());

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




        // Declare our View Variables and assign the Views from the Layout File.
       Button showCancelProfileButton = (Button) findViewById(R.id.cancelProfile);

        //Create each the method so each button take to other activity

        // Que Boton Cancel Profile vaya a la Actividad Main Activity cuando se le haga Click.
        View.OnClickListener listenerCancelProfileButton = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Dirigirlo a la Pagina para Main Activity.

                startActivity(new Intent(getApplicationContext(), MainActivity.class));


            }
        };




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_registration_profile, menu);
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
