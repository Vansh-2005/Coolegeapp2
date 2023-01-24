package com.dpbs.collegeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

import com.dpbs.collegeapp.Pdf.PdfActivity;
import com.dpbs.collegeapp.authentication.LoginActivity;
import com.dpbs.collegeapp.drawer_details.ContactUsActivity;
import com.dpbs.collegeapp.drawer_details.DeveloperActivity;
import com.dpbs.collegeapp.ui.Videos.YoutubePlayerActivity;
import com.dpbs.collegeapp.ui.home.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.messaging.FirebaseMessaging;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private BottomNavigationView bottomNavigationView;
    private NavController navController;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;
    private WebView webView;
    private android.widget.Button Button;
    private FirebaseAuth auth;
    private MenuItem item;
   // private static  int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseMessaging.getInstance().subscribeToTopic("notification");

        auth = FirebaseAuth.getInstance();

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        navController = Navigation.findNavController(this,R.id.frame_layout);

        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigation_view);

        webView = (WebView)findViewById(R.id.privacy);

        toggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.start,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(this);

        NavigationUI.setupWithNavController(bottomNavigationView,navController);
//
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                SharedPreferences sharedPreferences = getSharedPreferences(LoginActivity.PREFS_NAME,0);
//                boolean hasLoggedIn = sharedPreferences.getBoolean("hasLoggedIn",false);
//
//                if (hasLoggedIn){
//                    Intent intent = new Intent(MainActivity.this, HomeFragment.class);
//                    startActivity(intent);
//                    finish();
//                }
//                else{
//                    Intent intent = new Intent(MainActivity.this,LoginActivity.class);
//                    startActivity(intent);
//                    finish();
//                }
//            }
//        },SPLASH_TIME_OUT);
//
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.option_menu,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        this.item = item;
        if(toggle.onOptionsItemSelected(item)){
                return true;
            }
            if (item.getItemId()== R.id.logout){
                auth.signOut();
                openLogin();
            }
            return true;
    }
    private void openLogin() {

        Toast.makeText(this, "Logout Succesfully", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(MainActivity.this, LoginActivity.class));
        finish();
    }
    @Override
    protected void onStart() {
        super.onStart();
        if (auth.getCurrentUser() == null){
            openLogin();
        }
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.navigation_developer:
                startActivity(new Intent(this, DeveloperActivity.class));
                //Toast.makeText(this,"Developer",Toast.LENGTH_SHORT).show();
                break;

            case R.id.navigation_video:
                startActivity(new Intent(this, YoutubePlayerActivity.class));
                //Toast.makeText(this,"Video Lectures",Toast.LENGTH_SHORT).show();
                break;

            case R.id.navigation_share:
                Intent shareIntent = new Intent();
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT,"Download DPBS College app  \n\n https://play.google.com/store/apps/details?id="+getPackageName());
                startActivity(Intent.createChooser(shareIntent,"Share via"));
                //Toast.makeText(this,"Share",Toast.LENGTH_SHORT).show();
                break;

            case R.id.navigation_rate:
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://deatils?id="+getPackageName())));

                }
                catch (ActivityNotFoundException e){
                    startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://play.google.com/store/apps/details?id="+getPackageName())));
                }

                //Toast.makeText(this,"Rate",Toast.LENGTH_SHORT).show();
                break;

            case R.id.navigation_pdf:
                startActivity(new Intent(this, PdfActivity.class));
                break;

            case R.id.navigation_website:

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://dpbspgcollege.edu.in/"));
                startActivity(intent);
                //Toast.makeText(this,"Website",Toast.LENGTH_SHORT).show();
                break;

            case R.id.navigation_privacy:
                startActivity(new Intent(this, PrivacyPolicyActivity.class));
                break;

            case R.id.navigation_contact_us:
                startActivity(new Intent(this, ContactUsActivity.class));
                break;

            case R.id.navigation_terms_condition:
                startActivity(new Intent(this,TermsConditionActivity.class));
                break;
        }

        return true;
    }

}