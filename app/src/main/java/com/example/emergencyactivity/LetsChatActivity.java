package com.example.emergencyactivity;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.hardware.biometrics.BiometricManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.security.keystore.KeyGenParameterSpec;
import android.security.keystore.KeyProperties;
import android.security.keystore.UserNotAuthenticatedException;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;



public class LetsChatActivity extends AppCompatActivity {



    Button askT;
    Button askFriend1;
    Button virtual;
    public static final String TAG = LetsChatActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lets_chat);

        Executor newExecutor = Executors.newSingleThreadExecutor();



        askT = (Button) findViewById(R.id.askTeacher);
        askFriend1 = (Button) findViewById(R.id.askFriend);
        virtual = (Button) findViewById(R.id.virtualbuddy);

        //Start listening for authentication events//

        final BiometricPrompt myBiometricPrompt = new BiometricPrompt(LetsChatActivity.this, newExecutor, new BiometricPrompt.AuthenticationCallback() {
            @Override

//onAuthenticationError is called when a fatal error occurrs//

            public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
                if (errorCode == BiometricPrompt.ERROR_NEGATIVE_BUTTON) {
                } else {

//Print a message to Logcat//

                    Log.d(TAG, "An unrecoverable error occurred");
                }
            }

//onAuthenticationSucceeded is called when a fingerprint is matched successfully//

            @Override
            public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);

//Print a message to Logcat//
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
                sendIntent.setType("text/plain");
                sendIntent.setPackage("com.whatsapp");
                startActivity(Intent.createChooser(sendIntent, ""));
                startActivity(sendIntent);


                Log.d(TAG, "Fingerprint recognised successfully");
            }
//onAuthenticationFailed is called when the fingerprint doesn’t match//

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();

//Print a message to Logcat//

                Log.d(TAG, "Fingerprint not recognised");
            }
        });

//Create the BiometricPrompt instance//

        final BiometricPrompt.PromptInfo promptInfo = new BiometricPrompt.PromptInfo.Builder()

//Add some text to the dialog//

                .setTitle("Add your fingerprint")
                .setSubtitle("Fingerprint authentication")
                .setDescription("If you see this sign use your fingerprint t authenticate")
                .setNegativeButtonText("Cancel")

//Build the dialog//

                .build();


        askT.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.Q)
            @Override
            public void onClick(View view) {

//                final BiometricPrompt.PromptInfo promptInfo = new BiometricPrompt.PromptInfo.Builder()
//                        .setTitle("Title text goes here")
//                        .setSubtitle("Subtitle goes here")
//                        .setDescription("This is the description")
//                        .setNegativeButtonText("Cancel")
//                        .build();

//                final BiometricPrompt myBiometricPrompt = new BiometricPrompt(LetsChatActivity.this, ContextCompat.getMainExecutor(LetsChatActivity.this), new BiometricPrompt.AuthenticationCallback() {
//                    @Override
//                    public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
//                        super.onAuthenticationSucceeded(result);
//                        Log.d(TAG, "Fingerprint recognised successfully");

                myBiometricPrompt.authenticate(promptInfo);



//                Intent smsIntent = new Intent(Intent.ACTION_VIEW);
//                smsIntent.setType("vnd.android-dir/mms-sms");
//                smsIntent.putExtra("address", "12125551212");
//                smsIntent.putExtra("sms_body","Body of Message");
//                startActivity(smsIntent);
//                BiometricManager biometricManager = new BiometricManager();
//                switch (biometricManager.canAuthenticate()) {
//                    case BiometricManager.BIOMETRIC_SUCCESS:
//                        Log.d("MY_APP_TAG", "App can authenticate using biometrics.");
//                        break;
//                    case BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE:
//                        Log.e("MY_APP_TAG", "No biometric features available on this device.");
//                        break;
//                    case BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE:
//                        Log.e("MY_APP_TAG", "Biometric features are currently unavailable.");
//                        break;
//                    case BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED:
//                        Log.e("MY_APP_TAG", "The user hasn't associated " +
//                                "any biometric credentials with their account.");
//                        break;
//                }


                //opens the portfolio details class


                // }
//                    @Override
//                    public void onAuthenticationFailed() {
//                        super.onAuthenticationFailed();
//                        Log.d(TAG, "Fingerprint not recognised");
//                    }
//                    @Override
//                    public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
//                        super.onAuthenticationError(errorCode, errString);
//                        if (errorCode == BiometricPrompt.ERROR_NEGATIVE_BUTTON) {
//                        } else {
//                            Log.d(TAG, "An unrecoverable error occurred");
//                        }
//                    }
//                    @Override
//                    public void onAuthenticationHelp(int helpCode, CharSequence helpString) {
//                        super.onAuthenticationHelp(helpCode, helpString);
//                        biometricCallback.onAuthenticationHelp(helpCode, helpString);
//                    }
//


            }

        });
        askFriend1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                myBiometricPrompt.authenticate(promptInfo);
            }
        });
        virtual.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_call_a_virtual_friend);
            }
        });
    }



}

