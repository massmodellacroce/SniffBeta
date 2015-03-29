package com.sniff.sniffbeta;

import android.content.Intent;
import android.media.Image;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.widget.ImageView;

import java.io.IOException;


public class MyPets extends ActionBarActivity {

    ImageView imageViewPet3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_pets);

        imageViewPet3=(ImageView) findViewById(R.id.imagePet1);
    }

    public void Cancel (View view){

        startActivity(new Intent(this, ProfileActivity.class));
    }

    public void addMyPet (View view){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Pet Image"), 1);
    }

    public void onActivityResult(int reqCode, int resCode, Intent data) {
        if (resCode == RESULT_OK){
            if (reqCode == 1)
                try {
                    imageViewPet3.setImageBitmap(MediaStore.Images.Media.getBitmap(
                            this.getContentResolver(), data.getData()));
                    Log.d("MyPets","Setting Image");
                } catch (IOException e) {
                    Toast.makeText(getApplicationContext(), "Couldn't save image",Toast.LENGTH_LONG);
                    e.printStackTrace();
                }
        }
    }

    public void save (View view){
        Toast.makeText(this, "Saved Successfully", Toast.LENGTH_LONG).show();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my_pets, menu);
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
