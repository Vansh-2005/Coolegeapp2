package com.dpbs.collegeapp.ui.home;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.dpbs.collegeapp.CardData.Exam.ExamActivity;
import com.dpbs.collegeapp.CardData.Syllabus.SyllabusActivity;
import com.dpbs.collegeapp.CardData.TimeTable.TimeTableActivity;
import com.dpbs.collegeapp.R;
import com.dpbs.collegeapp.drawer_details.ContactUsActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements View.OnClickListener {

    private ImageSlider mainslider;
    private DatabaseReference databaseReference;
    private TextView marquee;

    CardView timeTable, exam, syllabus, events, toppers, fees, contact, website;
    //private ImageView mapLocation;
    //TextView bcadepart,bscdepart,bcomdepart,badepart;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        marquee = view.findViewById(R.id.marquee);
        timeTable = view.findViewById(R.id.timeTable);
        exam = view.findViewById(R.id.exam);
        syllabus = view.findViewById(R.id.syllabus);
        events = view.findViewById(R.id.events);
        toppers = view.findViewById(R.id.toppers);
        fees = view.findViewById(R.id.fees);
        contact = view.findViewById(R.id.contact);
        website = view.findViewById(R.id.website);

        timeTable.setOnClickListener(this);
        exam.setOnClickListener(this);
        syllabus.setOnClickListener(this);
        events.setOnClickListener(this);
        toppers.setOnClickListener(this);
        fees.setOnClickListener(this);
        contact.setOnClickListener(this);
        website.setOnClickListener(this);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("Marquee");
        databaseReference.child("News").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String link = snapshot.getValue(String.class);
                marquee.setSelected(true);
                marquee.setText(link);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        //Getting the image slder

        mainslider = (ImageSlider) view.findViewById(R.id.image_slider);
        final List<SlideModel> remoteimages = new ArrayList<>();
        FirebaseDatabase.getInstance().getReference().child("Slider")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for (DataSnapshot data : snapshot.getChildren())
                            remoteimages.add(new SlideModel(data.child("url").getValue().toString()
                                    , data.child("title").getValue().toString(), ScaleTypes.FIT));

                        mainslider.setImageList(remoteimages, ScaleTypes.FIT);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });


        return view;
    }

    @Override
    public void onClick(View view) {

        Intent intent;
        switch (view.getId()) {
            case R.id.timeTable:
                intent = new Intent(getContext(),TimeTableActivity.class);
                startActivity(intent);
                break;

            case R.id.exam:
                intent = new Intent(getContext(), ExamActivity.class);
                startActivity(intent);
                break;

            case R.id.events:
                Toast.makeText(getContext(), "Events", Toast.LENGTH_SHORT).show();
                break;

            case R.id.syllabus:
                intent = new Intent(getContext(), SyllabusActivity.class);
                startActivity(intent);
                break;

            case R.id.toppers:
                Toast.makeText(getContext(), "Toppers", Toast.LENGTH_SHORT).show();
                break;

            case R.id.fees:
                Toast.makeText(getContext(), "Fees", Toast.LENGTH_SHORT).show();
                break;

            case R.id.contact:
               intent = new Intent(getContext(),ContactUsActivity.class);
               startActivity(intent);
                break;

            case R.id.website:
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://dpbspgcollege.edu.in/"));
                startActivity(intent);
                break;
        }
    }
}

