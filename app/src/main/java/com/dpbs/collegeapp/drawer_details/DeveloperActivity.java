package com.dpbs.collegeapp.drawer_details;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.dpbs.collegeapp.CardData.TimeTable.TimeTableActivity;
import com.dpbs.collegeapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class DeveloperActivity extends AppCompatActivity {

    private CircleImageView vanshImage,varsha,prathibha,sachin,kush;
    private DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Developer Contact");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        vanshImage = findViewById(R.id.vansh);
        varsha = findViewById(R.id.varsha);
        prathibha = findViewById(R.id.prathibha);
        sachin = findViewById(R.id.sachin);
        kush = findViewById(R.id.kush);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        ref = database.getReference().child("Developer");

        vansh();
        varsha();
        prathibha();
        sachin();
        kush();


    }

    private void kush() {
        ref.child("Kush").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue(String.class);
                Picasso.get().load(value).into(kush);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(DeveloperActivity.this, "Database Error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void sachin() {
        ref.child("Sachin").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue(String.class);
                Picasso.get().load(value).into(sachin);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(DeveloperActivity.this, "Database Error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void prathibha() {
        ref.child("Prathibha").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue(String.class);
                Picasso.get().load(value).into(prathibha);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(DeveloperActivity.this, "Database Error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void varsha() {
        ref.child("Varsha").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue(String.class);
                Picasso.get().load(value).into(varsha);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(DeveloperActivity.this, "Database Error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void vansh() {

        ref.child("Vansh").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue(String.class);
                Picasso.get().load(value).into(vanshImage);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(DeveloperActivity.this, "Database Error", Toast.LENGTH_SHORT).show();
            }
        });
    }

}