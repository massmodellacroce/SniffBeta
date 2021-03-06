package com.sniff.sniffbeta;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Declare our View Variables and assign the Views from the Layout File.
        Button showTagPetIntroButton = (Button) findViewById(R.id.TagPetIntro);
        Button showSearchMyPetIntroButton = (Button) findViewById(R.id.SearchMyPetIntro);
        Button showProfileIntroButton = (Button) findViewById(R.id.ProfileIntro);
        Button showSigninMainButton = (Button) findViewById(R.id.SigninMain);
        Button showCreateAccountButton = (Button) findViewById(R.id.CreateAccount);

        //Create each the method so each button take to other activity

        // Que Boton TagPet vaya a la Actividad RegisterLostPet cuando se le haga Click.
        View.OnClickListener listenerTagPetIntroButton = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Dirigirlo a la Pagina para ingresar Info Perro perdido.

                Intent intent = new Intent(getApplicationContext(), RegisterLostPet.class);
                intent.putExtra("action", "LostPet");
                startActivity(intent);


            }
        };
        showTagPetIntroButton.setOnClickListener(listenerTagPetIntroButton);

        // Que Boton SearchMyPet vaya a la Actividad ¿¿?? cuando se le haga Click.
        View.OnClickListener listenerSearchMyPetIntroButton = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Dirigirlo a la Pagina de las mascotas que esta buscando.

                startActivity(new Intent(getApplicationContext(),MyPets.class));

            }
        };
        showSearchMyPetIntroButton.setOnClickListener(listenerSearchMyPetIntroButton);

        // Que Boton Profile vaya a la Actividad ¿¿?? cuando se le haga Click.
        View.OnClickListener listenerProfileIntroButton = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Dirigirlo a la Pagina de su Perfil.
                startActivity(new Intent(getApplicationContext(),ProfileActivity.class));

            }
        };
        showProfileIntroButton.setOnClickListener(listenerProfileIntroButton);

        // Que Boton Settings vaya a la Actividad ¿¿?? cuando se le haga Click.
        View.OnClickListener listenerSettingsIntroButton = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Dirigirlo a la Pagina de Settings.

            }
        };

        // Que Boton Sign In Main vaya a la Actividad LogInActivity cuando se le haga Click.
        View.OnClickListener listenerSigninMainButton = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Dirigirlo a la Pagina de LoginActivity.

                startActivity(new Intent(getApplicationContext(), LogInActivity.class));
            }
        };
        showSigninMainButton.setOnClickListener(listenerSigninMainButton);

        // Que Boton Create Account Main vaya a la Actividad RegistrationProfile Activity cuando se le haga Click.
        View.OnClickListener listenerCreateAccountButton = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Dirigirlo a la Pagina de RegistrationProfile.

                startActivity(new Intent(getApplicationContext(), RegistrationProfile2.class));
            }
        };
        showCreateAccountButton.setOnClickListener(listenerCreateAccountButton);
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
}
