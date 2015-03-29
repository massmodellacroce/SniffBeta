package com.sniff.sniffbeta;

import android.content.Intent;
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

    ImageView imageViewPet1;
    ImageView imageViewPet2;
    ImageView imageViewPet3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_pets);

        imageViewPet1 = (ImageView) findViewById(R.id.imagePet1);
        imageViewPet2 = (ImageView) findViewById(R.id.imagePet2);
        imageViewPet3 = (ImageView) findViewById(R.id.imagePet3);
    }

    public void Cancel(View view) {

        startActivity(new Intent(this, ProfileActivity.class));
    }

    public void addMyPet1(View view) {
        addMyPet(view, 1);
    }

    public void addMyPet2(View view) {
        addMyPet(view, 2);
    }

    public void addMyPet3(View view) {
        addMyPet(view, 3);
    }

    private void addMyPet(View view, int number) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Pet Image"), number);
    }

    public void onActivityResult(int reqCode, int resCode, Intent data) {
        if (resCode == RESULT_OK) {

            ImageView selectedImage= imageViewPet1;
            if (reqCode == 1) {
                selectedImage = imageViewPet1;

            } else if (reqCode == 2) {
                selectedImage = imageViewPet2;

            } else if (reqCode == 3) {
                selectedImage = imageViewPet3;
            }
            try {
                    selectedImage.setImageBitmap(MediaStore.Images.Media.getBitmap(
                            this.getContentResolver(), data.getData()));
                Log.d("MyPets", "Setting Image");
                Toast.makeText(getApplicationContext(), "Saved successfully!", Toast.LENGTH_SHORT);
            } catch (IOException e) {
                Toast.makeText(getApplicationContext(), "Couldn't save image", Toast.LENGTH_LONG);
                e.printStackTrace();
            }
        }
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
