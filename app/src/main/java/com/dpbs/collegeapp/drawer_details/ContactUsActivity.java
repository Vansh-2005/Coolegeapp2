package com.dpbs.collegeapp.drawer_details;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.webkit.WebView;
import android.widget.Toast;

import com.dpbs.collegeapp.R;

import java.util.Calendar;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

public class ContactUsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        getSupportActionBar().setTitle("Contact Us");

        Element adsElement = new Element();
        View aboutPage = new AboutPage(this)
                .setImage(R.drawable.contact)
                .isRTL(false)
                .setDescription("Durga Prasad Baljeet Singh (P.G.) College\n" +
                        "Mahashay Durga Prasad Marg\n" +
                        "Anupshahr, District-Bulandshahr (U.P.)-203390\n for any query or suggestion kindly contact us.")
                .addItem(new Element().setTitle("Version:1.0.3"))
                .addGroup("Connect With Us")
                .addEmail("dpbsprincipal@gmail.com")
                .addWebsite("http://dpbspgcollege.edu.in/")
                // .addYoutube("https://www.youtube.com/watch?v=LSUAlr7_qmA")
                .addPlayStore("com.dpbs.collegeapp")
                .addItem(createCopyright())
                .create();
        setContentView(aboutPage);
    }


    private Element createCopyright() {

        Element copyright = new Element();
        @SuppressLint("DefaultLocale")final String copyrightString = String.format("Copyight %d by DPBS College"
                , Calendar.getInstance().get(Calendar.YEAR));
        copyright.setTitle(copyrightString);
        copyright.setIconDrawable(R.drawable.ic_copyright);
        copyright.setGravity(Gravity.CENTER);
        copyright.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ContactUsActivity.this, copyrightString, Toast.LENGTH_SHORT).show();
            }
        });
        return copyright;


    }
}