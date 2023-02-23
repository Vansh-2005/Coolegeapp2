package com.dpbs.collegeapp.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
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

public class GalleryFragment extends Fragment {
    RecyclerView annualRecycler , otherRecycler,sportRecycler,independenceRecycler,republicRecycler;
    com.dpbs.collegeapp.ui.gallery.GalleryAdapter adapter;
    //  FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);

        annualRecycler = view.findViewById(R.id.annualRecycler);
        otherRecycler = view.findViewById(R.id.otherRecycler);
        sportRecycler = view.findViewById(R.id.sportRecycler);
        independenceRecycler = view.findViewById(R.id.independenceRecycler);
        republicRecycler = view.findViewById(R.id.republicRecycler);

        reference = FirebaseDatabase.getInstance().getReference().child("Gallery");
        getAnnualImage();
        getRepublicImage();
        getIndependanceImage();
        getSportsImage();
        getOtherImage();

        return view;
    }

    private void getSportsImage() {

        reference.child("Sports").addValueEventListener(new ValueEventListener() {
            List<String> imageList = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {

                for (DataSnapshot snapshot : datasnapshot.getChildren()){

                    String data = (String) snapshot.getValue();
                    imageList.add(data);
                }

//                GridLayoutManager layoutManager = new GridLayoutManager(getContext(),3);
//                adapter = new GalleryAdapter(getContext(),imageList);
//                sportRecycler.setLayoutManager(layoutManager);
//                layoutManager.setReverseLayout(true);
//                layoutManager.setStackFromEnd(true);
//                sportRecycler.setAdapter(adapter);

                adapter = new GalleryAdapter(getContext(),imageList);
                sportRecycler.setLayoutManager(new GridLayoutManager(getContext(),3));
                sportRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(getContext(), "Error In Fetching Data", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getIndependanceImage() {

        reference.child("Independence Day").addValueEventListener(new ValueEventListener() {
            List<String> imageList = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {

                for (DataSnapshot snapshot : datasnapshot.getChildren()){

                    String data = (String) snapshot.getValue();
                    imageList.add(data);
                }
                adapter = new com.dpbs.collegeapp.ui.gallery.GalleryAdapter(getContext(),imageList);
                independenceRecycler.setLayoutManager(new GridLayoutManager(getContext(),3));
                independenceRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(getContext(), "Error In Fetching Data", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getRepublicImage() {

        reference.child("Republic Day").addValueEventListener(new ValueEventListener() {
            List<String> imageList = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {

                for (DataSnapshot snapshot : datasnapshot.getChildren()){

                    String data = (String) snapshot.getValue();
                    imageList.add(data);
                }
                adapter = new com.dpbs.collegeapp.ui.gallery.GalleryAdapter(getContext(),imageList);
                republicRecycler.setLayoutManager(new GridLayoutManager(getContext(),3));
                republicRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(getContext(), "Error In Fetching Data", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getOtherImage() {
        reference.child("Other Events").addValueEventListener(new ValueEventListener() {
            List<String> imageList = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {

                for (DataSnapshot snapshot : datasnapshot.getChildren()){

                    String data = (String) snapshot.getValue();
                    imageList.add(data);
                }
                adapter = new com.dpbs.collegeapp.ui.gallery.GalleryAdapter(getContext(),imageList);
                otherRecycler.setLayoutManager(new GridLayoutManager(getContext(),3));
                otherRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(getContext(), "Error In Fetching Data", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getAnnualImage() {
        reference.child("Annual Function").addValueEventListener(new ValueEventListener() {
            List<String> imageList = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {

                for (DataSnapshot snapshot : datasnapshot.getChildren()){

                    String data = (String) snapshot.getValue();
                    imageList.add(data);
                }
                adapter = new com.dpbs.collegeapp.ui.gallery.GalleryAdapter(getContext(),imageList);
                annualRecycler.setLayoutManager(new GridLayoutManager(getContext(),3));
                annualRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(getContext(), "Error In Fetching Data", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
