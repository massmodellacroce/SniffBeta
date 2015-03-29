package com.sniff.sniffbeta;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;


public class RegisterLostPet extends ActionBarActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinnerBreed;
    Spinner spinnerColor1;
    Spinner spinnerColor2;
    Spinner spinnerTypeCollar;
    Spinner spinnerCollarColor;
    Spinner spinnerAge;
    Spinner spinnerTook;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_lost_pet);
        String action = getIntent().getExtras()!=null?getIntent().getExtras().getString("action"):"";
        String title;
        if ("MyPet".equals(action)) {
            title = "Register My Pet";
        } else if ("LostPet".equals(action)) {
            title = "Register Lost Pet";
        } else {
            title = "Not sure what we are doing here...";
        }
        setTitle(title);

        // Spinner Breed
        spinnerBreed = (Spinner) findViewById(R.id.spinnerBreed);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.breed, android.support.v7.appcompat.R.layout.support_simple_spinner_dropdown_item);
        spinnerBreed.setAdapter(adapter);

        // Spinner Color1
        spinnerColor1 = (Spinner) findViewById(R.id.spinnerColor1);
        ArrayAdapter adapter2 = ArrayAdapter.createFromResource(this, R.array.color1, android.support.v7.appcompat.R.layout.support_simple_spinner_dropdown_item);
        spinnerColor1.setAdapter(adapter2);

        // Spinner Color2
        spinnerColor2 = (Spinner) findViewById(R.id.spinnerColor2);
        ArrayAdapter adapter3 = ArrayAdapter.createFromResource(this, R.array.color2, android.support.v7.appcompat.R.layout.support_simple_spinner_dropdown_item);
        spinnerColor2.setAdapter(adapter3);

        // Spinner Type Collar
        spinnerTypeCollar = (Spinner) findViewById(R.id.spinnerCollarType);
        ArrayAdapter adapter4 = ArrayAdapter.createFromResource(this, R.array.typeCollar, android.support.v7.appcompat.R.layout.support_simple_spinner_dropdown_item);
        spinnerTypeCollar.setAdapter(adapter4);

        // Spinner Collar Color
        spinnerCollarColor = (Spinner) findViewById(R.id.spinnerCollarColor);
        ArrayAdapter adapter5 = ArrayAdapter.createFromResource(this, R.array.collarColor, android.support.v7.appcompat.R.layout.support_simple_spinner_dropdown_item);
        spinnerCollarColor.setAdapter(adapter5);

        // Spinner Age
        spinnerAge = (Spinner) findViewById(R.id.spinnerAge);
        ArrayAdapter adapter6 = ArrayAdapter.createFromResource(this, R.array.age, android.support.v7.appcompat.R.layout.support_simple_spinner_dropdown_item);
        spinnerAge.setAdapter(adapter6);

        // Spinner Took
        spinnerTook = (Spinner) findViewById(R.id.spinnerTook);
        ArrayAdapter adapter7 = ArrayAdapter.createFromResource(this, R.array.took, android.support.v7.appcompat.R.layout.support_simple_spinner_dropdown_item);
        spinnerTook.setAdapter(adapter7);


    }

    public void Cancel(View view){

        Intent intent = new Intent(this,MainActivity.class);

        startActivity(intent);

    }

    public void BreedChart (View view){

        Intent intent = new Intent(this,BreedChart.class);

        startActivity(intent);
    }

    public void tagPet (View view){

        Toast.makeText(this, "Tag Successfully", Toast.LENGTH_LONG).show();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_register_lost_pet, menu);
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
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
