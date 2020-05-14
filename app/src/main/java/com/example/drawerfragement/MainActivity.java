package com.example.drawerfragement;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.DrawableWrapper;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{


    NotificationCompat.Builder notification;
    private static final int uniqueID = 45612;

    FloatingActionButton fabPerson,fabExplore,fabExit;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar toolbar;
    NavigationView navigationView;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("MyNotifications","MyNotifications", NotificationManager.IMPORTANCE_DEFAULT);

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }


        notification = new NotificationCompat.Builder(this,"MyNotifications");
        notification.setAutoCancel(true);

        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToggle.syncState();

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container_fragment,new MainFragment());
        fragmentTransaction.commit();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        RelativeLayout main_veiw = (RelativeLayout) findViewById(R.id.main_view);

        switch (item.getItemId()){
            case R.id.menu_red:
                if(item.isChecked())
                    item.setCheckable(false);
                else
                    item.setCheckable(true);
                main_veiw.setBackgroundColor(Color.RED);
                return true;

            case R.id.menu_blue:
                if(item.isChecked())
                    item.setCheckable(false);
                else
                    item.setCheckable(true);
                main_veiw.setBackgroundColor(Color.BLUE);
                return true;

            case R.id.menu_green:
                if(item.isChecked())
                    item.setCheckable(false);
                else
                    item.setCheckable(true);
                main_veiw.setBackgroundColor(Color.GREEN);
                return true;

            case R.id.menu_white:
                if(item.isChecked())
                    item.setCheckable(false);
                else
                    item.setCheckable(true);
                main_veiw.setBackgroundColor(Color.WHITE);
                return true;
            default:return super.onOptionsItemSelected(item);
        }

    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        drawerLayout.closeDrawer(GravityCompat.START);
        switch (menuItem.getItemId()) {
            case R.id.another1:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container_fragment,new MainFragment());
                fragmentTransaction.commit();
                return true;
            case R.id.home1:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container_fragment,new fragment_third());
                fragmentTransaction.commit();
                return true;
        }

        return true;
    }

    public  void changeText(View view){
        Button load = (Button) findViewById(R.id.load);
        EditText buckysText =(EditText) findViewById(R.id.buckysText);
        buckysText.setText("Please do review!!!");
        buckysText.setTextColor(Color.BLACK);
        notification.setSmallIcon(R.drawable.ic_launcher_foreground);
        notification.setTicker("This is my first notification");
        notification.setWhen(System.currentTimeMillis());
        notification.setContentTitle("OH u did touch me ");
        notification.setContentText("It seems like you are not touching me feels like u have grabbed me!!!!");

        Intent intent = new Intent(this,MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setContentIntent(pendingIntent);

        //Builds notification and issues it
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.notify(uniqueID,notification.build());

        Toast.makeText(this,"Notification panel",Toast.LENGTH_LONG).show();
    }

}
