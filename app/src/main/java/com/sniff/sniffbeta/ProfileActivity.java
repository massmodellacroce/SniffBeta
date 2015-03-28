package com.sniff.sniffbeta;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class ProfileActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Declare our View Variables and assign the Views from the Layout File.
        Button showMyInfoButton = (Button) findViewById(R.id.MyInfo);
        Button showMyPetButton = (Button) findViewById(R.id.MyPets);
        Button showLostMyDogButton = (Button) findViewById(R.id.LostMyDog);

        // Que Boton MyInfo vaya a la Actividad RegistrationProfile cuando se le haga Click.
        View.OnClickListener listenerMyInfo = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Dirigirlo a la Pagina de Informacion Personal
                Log.d("ProfileActivity", "Calling RegistrationProfile2");
                startActivity(new Intent(getApplicationContext(), RegistrationProfile2.class));

            }
        };
        showMyInfoButton.setOnClickListener(listenerMyInfo);


        // Que Boton MyPet vaya a la Actividad ¿¿? cuando se le haga Click.
        View.OnClickListener listenerMyPet = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Dirigirlo a la Pagina de My Pets
                startActivity(new Intent(getApplicationContext(),MyPets.class));


            }
        };
        showMyPetButton.setOnClickListener(listenerMyPet);

        // Que Boton LostMyDog vaya a la Actividad ¿¿?? cuando se le haga Click.
        View.OnClickListener listenerLostMyDog = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Dirigirlo a la Pagina de LostMyDog

            }
        };
        showLostMyDogButton.setOnClickListener(listenerLostMyDog);


    }

    public void back (View view){
        Intent intent=new Intent(this,MainActivity.class);

       startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_profile, menu);
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
