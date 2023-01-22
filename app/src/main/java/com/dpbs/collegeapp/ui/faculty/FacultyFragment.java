package com.dpbs.collegeapp.ui.faculty;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dpbs.collegeapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FacultyFragment extends Fragment {
    private RecyclerView bcaDepartment, bscDepartment, bcomDepartment,baDepartment;
    private LinearLayout bcaNoData, bscNoData, bcomNoData,baNoData;
    private List<TeacherData> list1, list2, list3;

    private ProgressBar progressBar;

    private DatabaseReference reference, dbRef;
    private com.dpbs.collegeapp.ui.faculty.TeacherAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_faculty, container, false);
        bcaNoData = view.findViewById(R.id.bcaNoData);
        bcomNoData = view.findViewById(R.id.bcomNoData);
        bscNoData = view.findViewById(R.id.bscNoData);
        baNoData = view.findViewById(R.id.baNoData);

        progressBar = view.findViewById(R.id.progressBarN);

        bcaDepartment = view.findViewById(R.id.bcaDepartment);
        bcomDepartment = view.findViewById(R.id.bcomDepartment);
        bscDepartment = view.findViewById(R.id.bscDepartment);
        baDepartment = view.findViewById(R.id.baDepartment);

        reference = FirebaseDatabase.getInstance().getReference().child("teacher");
        bcaDepartment();
        bscDepartment();
        baDepartment();
        bcomDepartment();
        return view;
    }

    private void bcaDepartment() {

        dbRef = reference.child("BCA Department");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list1 = new ArrayList<>();
                if (!dataSnapshot.exists()) {
                    bcaNoData.setVisibility(View.VISIBLE);
                    bcaDepartment.setVisibility(View.GONE);
                } else {
                    bcaNoData.setVisibility(View.GONE);
                    bcaDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        com.dpbs.collegeapp.ui.faculty.TeacherData data = snapshot.getValue(TeacherData.class);
                        list1.add(data);
                    }
                    bcaDepartment.setHasFixedSize(true);
                    bcaDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new com.dpbs.collegeapp.ui.faculty.TeacherAdapter(list1, getContext());
                    bcaDepartment.setAdapter(adapter);
                    progressBar.setVisibility(View.GONE);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                progressBar.setVisibility(View.GONE);

                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void bscDepartment() {

        dbRef = reference.child("BSC Department");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list1 = new ArrayList<>();
                if (!dataSnapshot.exists()) {
                    bscNoData.setVisibility(View.VISIBLE);
                    bscDepartment.setVisibility(View.GONE);
                } else {
                    bscNoData.setVisibility(View.GONE);
                    bscDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        com.dpbs.collegeapp.ui.faculty.TeacherData data = snapshot.getValue(TeacherData.class);
                        list1.add(data);
                    }
                    bscDepartment.setHasFixedSize(true);
                    bscDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new com.dpbs.collegeapp.ui.faculty.TeacherAdapter(list1, getContext());
                    bscDepartment.setAdapter(adapter);
                    progressBar.setVisibility(View.GONE);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                progressBar.setVisibility(View.GONE);

                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void bcomDepartment() {

        dbRef = reference.child("BCom Department");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list2 = new ArrayList<>();
                if (!dataSnapshot.exists()) {
                    bcomNoData.setVisibility(View.VISIBLE);
                    bcomDepartment.setVisibility(View.GONE);
                } else {
                    bcomNoData.setVisibility(View.GONE);
                    bcomDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        com.dpbs.collegeapp.ui.faculty.TeacherData data = snapshot.getValue(TeacherData.class);
                        list2.add(data);
                    }
                    bcomDepartment.setHasFixedSize(true);
                    bcomDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new com.dpbs.collegeapp.ui.faculty.TeacherAdapter(list2, getContext());
                    bcomDepartment.setAdapter(adapter);
                    progressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void baDepartment() {

        dbRef = reference.child("BA Department");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list3 = new ArrayList<>();
                if (!dataSnapshot.exists()) {
                    baNoData.setVisibility(View.VISIBLE);
                    baDepartment.setVisibility(View.GONE);
                } else {
                    baNoData.setVisibility(View.GONE);
                    baDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        com.dpbs.collegeapp.ui.faculty.TeacherData data = snapshot.getValue(TeacherData.class);
                        list3.add(data);
                    }
                    baDepartment.setHasFixedSize(true);
                    baDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new com.dpbs.collegeapp.ui.faculty.TeacherAdapter(list3, getContext());
                    baDepartment.setAdapter(adapter);
                    progressBar.setVisibility(View.GONE);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
