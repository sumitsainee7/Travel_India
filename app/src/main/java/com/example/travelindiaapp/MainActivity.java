package com.example.travelindiaapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.Constants;
import com.google.firebase.messaging.FirebaseMessaging;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ConnectionChangeBroadcastReceiver connectionChangeBroadcastReceiver=new ConnectionChangeBroadcastReceiver();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // get notification for general topics
        FirebaseMessaging.getInstance().subscribeToTopic("general")
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        String msg = "Successfull";
                        if (!task.isSuccessful()) {
                            msg = "failed";
                        }
                        //Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                    }
                });
        // create a channelid for notification
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel channel= new NotificationChannel("MyNotification","MyNotification", NotificationManager.IMPORTANCE_DEFAULT);
        }

        //Button Declared
        ImageButton btnFragHome,btnFragProfile,btnFragContactUs;

        // Button initiation
        btnFragProfile=findViewById(R.id.btnFragProfile);
        btnFragHome=findViewById(R.id.btnFragHome);
        btnFragContactUs=findViewById(R.id.btnFragContactUs);

        // Fragment Manager
        loadFragment(new HomeFragment(),0);
        btnFragHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new HomeFragment(),0);

            }
        });
        btnFragProfile.setOnClickListener(new View.OnClickListener() {
            Constant constant=new Constant();
            @Override
            public void onClick(View v) {
                if (constant.signIn) {
                    loadFragment(new ProfileFragment(),1);
                }
                else{
                    loadFragment(new SignUpFragment(),1);
                }

            }
        });
        btnFragContactUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new ContactUsFragment(),1);
            }
        });
    }
    public void loadFragment(Fragment fragment,int flag){
        // Fragment Manager
        FragmentManager fm= getSupportFragmentManager();
        FragmentTransaction ft= fm.beginTransaction();


        if(flag==0){
            ft.replace(R.id.container,fragment,"root fragment");
            fm.popBackStack("root fragment",FragmentManager.POP_BACK_STACK_INCLUSIVE);

        }
        else{
            ft.replace(R.id.container,fragment,"replacement");
            ft.addToBackStack("replacement");
        }

        ft.commit();


    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter=new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(connectionChangeBroadcastReceiver,intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(connectionChangeBroadcastReceiver);
    }

    public void signInToast() {
        Toast.makeText(MainActivity.this, "Sign In SuccessFull", Toast.LENGTH_SHORT).show();
    }
}