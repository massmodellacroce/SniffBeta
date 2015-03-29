package com.sniff.sniffbeta.model;

import android.content.Context;

import com.sniff.sniffbeta.RegistrationProfile2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by maximilianocruz on 3/29/15.
 */
public class Profile implements Serializable {
    public String firstName;
    public String lastName;
    public String email;
    public String adress;
    public String phone;
    public String password;
    public String confirmPassword;


    public static Profile readProfile(Context context) {
        FileInputStream fileInputStream = null;
        ObjectInputStream ois = null;
        try {
            fileInputStream = context.openFileInput("registration.txt");
            ois = new ObjectInputStream(fileInputStream);
            Profile profile = (Profile) ois.readObject();
            ois.close();
            fileInputStream.close();
            return profile;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            try {
                ois.close();
                fileInputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return new Profile();
    }

    public static void saveProfile(Context context, Profile profile) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = context.openFileOutput("registration.txt", Context.MODE_PRIVATE);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(profile);
        } catch (IOException e){
            e.printStackTrace();
        }
        finally {
            try {
                oos.close();
                fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
