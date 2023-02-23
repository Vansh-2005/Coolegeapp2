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
    private RecyclerView bcaDepartment, bcomDepartment, CmscDepartment, doeDepartment, dopDepartment, docDepartment, domDepartment, dosDepartment, dopsDepartment, dopeDepartment, dospgDepartment, DoeDepartment, DosDepartment, dohDepartment, doenDepartment, princDepartment;

    private LinearLayout bcaNoData, bcomNoData, CmscNoData, doeNoData, dopNoData, docNoData, domNoData, dosNoData, dopsNoData, dopeNoData, dospgNoData, DoeNoData, DosNoData, dohNoData, doenNoData, princNoData;
    private List<TeacherData> list1, list2, list3, list4, list5, list6, list7, list8, list9, list10, list11, list12, list13, list14, list15, list16;

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
        CmscNoData = view.findViewById(R.id.CmscNoData);
        doeNoData = view.findViewById(R.id.doeNoData);
        dopNoData = view.findViewById(R.id.dopNoData);
        docNoData = view.findViewById(R.id.docNoData);
        domNoData = view.findViewById(R.id.domNoData);
        dosNoData = view.findViewById(R.id.dosNoData);
        dopsNoData = view.findViewById(R.id.dopsNoData);
        dopeNoData = view.findViewById(R.id.dopeNoData);
        dospgNoData = view.findViewById(R.id.dospgNoData);
        DoeNoData = view.findViewById(R.id.DoeNoData);
        DosNoData = view.findViewById(R.id.DosNoData);
        dohNoData = view.findViewById(R.id.dohNoData);
        doenNoData = view.findViewById(R.id.doenNoData);
        princNoData = view.findViewById(R.id.princNoData);


        progressBar = view.findViewById(R.id.progressBarN);

        bcaDepartment = view.findViewById(R.id.bcaDepartment);
        bcomDepartment = view.findViewById(R.id.bcomDepartment);
        CmscDepartment = view.findViewById(R.id.CmscDepartment);
        doeDepartment = view.findViewById(R.id.doeDepartment);
        dopDepartment = view.findViewById(R.id.dopDepartment);
        docDepartment = view.findViewById(R.id.docDepartment);
        domDepartment = view.findViewById(R.id.domDepartment);
        dosDepartment = view.findViewById(R.id.dosDepartment);
        dopsDepartment = view.findViewById(R.id.dopsDepartment);
        dopeDepartment = view.findViewById(R.id.dopeDepartment);
        dospgDepartment = view.findViewById(R.id.dospgDepartment);
        DoeDepartment = view.findViewById(R.id.DoeDepartment);
        DosDepartment = view.findViewById(R.id.DosDepartment);
        dohDepartment = view.findViewById(R.id.dohDepartment);
        doenDepartment = view.findViewById(R.id.doenDepartment);
        princDepartment = view.findViewById(R.id.princDepartment);


        reference = FirebaseDatabase.getInstance().getReference().child("teacher");
        bcaDepartment();
        bcomDepartment();
        CmscDepartment();
        doeDepartment();
        dopDepartment();
        docDepartment();
        domDepartment();
        dosDepartment();
        dopsDepartment();
        dopeDepartment();
        dospgDepartment();
        DoeDepartment();
        DosDepartment();
        dohDepartment();
        doenDepartment();
        princDepartment();

        return view;
    }

    private void princDepartment() {

        dbRef = reference.child("Principal");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list16 = new ArrayList<>();
                if (!dataSnapshot.exists()) {
                    princNoData.setVisibility(View.VISIBLE);
                    princDepartment.setVisibility(View.GONE);
                } else {
                    princNoData.setVisibility(View.GONE);
                    princDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list16.add(data);
                    }
                    princDepartment.setHasFixedSize(true);
                    princDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list16, getContext());
                    princDepartment.setAdapter(adapter);
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
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list1.add(data);
                    }
                    bcaDepartment.setHasFixedSize(true);
                    bcaDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list1, getContext());
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
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list2.add(data);
                    }
                    bcomDepartment.setHasFixedSize(true);
                    bcomDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list2, getContext());
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

    private void CmscDepartment() {

        dbRef = reference.child("Chemistry Department");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list3 = new ArrayList<>();
                if (!dataSnapshot.exists()) {
                    CmscNoData.setVisibility(View.VISIBLE);
                    CmscDepartment.setVisibility(View.GONE);
                } else {
                    CmscNoData.setVisibility(View.GONE);
                    CmscDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list3.add(data);
                    }
                    CmscDepartment.setHasFixedSize(true);
                    CmscDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list3, getContext());
                    CmscDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void doeDepartment() {

        dbRef = reference.child("Department Of Education");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list4 = new ArrayList<>();
                if (!dataSnapshot.exists()) {
                    doeNoData.setVisibility(View.VISIBLE);
                    doeDepartment.setVisibility(View.GONE);
                } else {
                    doeNoData.setVisibility(View.GONE);
                    doeDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list4.add(data);
                    }
                    doeDepartment.setHasFixedSize(true);
                    doeDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list4, getContext());
                    doeDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void dopDepartment() {

        dbRef = reference.child("Department Of Physics");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list5 = new ArrayList<>();
                if (!dataSnapshot.exists()) {
                    dopNoData.setVisibility(View.VISIBLE);
                    dopDepartment.setVisibility(View.GONE);
                } else {
                    dopNoData.setVisibility(View.GONE);
                    dopDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list5.add(data);
                    }
                    dopDepartment.setHasFixedSize(true);
                    dopDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list5, getContext());
                    dopDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void docDepartment() {

        dbRef = reference.child("Department Of Chemistry");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list6 = new ArrayList<>();
                if (!dataSnapshot.exists()) {
                    docNoData.setVisibility(View.VISIBLE);
                    docDepartment.setVisibility(View.GONE);
                } else {
                    docNoData.setVisibility(View.GONE);
                    docDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list6.add(data);
                    }
                    docDepartment.setHasFixedSize(true);
                    docDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list6, getContext());
                    docDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void domDepartment() {

        dbRef = reference.child("Department Of Mathematics");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list7 = new ArrayList<>();
                if (!dataSnapshot.exists()) {
                    domNoData.setVisibility(View.VISIBLE);
                    domDepartment.setVisibility(View.GONE);
                } else {
                    domNoData.setVisibility(View.GONE);
                    domDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list7.add(data);
                    }
                    domDepartment.setHasFixedSize(true);
                    domDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list7, getContext());
                    domDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void dosDepartment() {

        dbRef = reference.child("Department Of Statistics");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list8 = new ArrayList<>();
                if (!dataSnapshot.exists()) {
                    dosNoData.setVisibility(View.VISIBLE);
                    dosDepartment.setVisibility(View.GONE);
                } else {
                    dosNoData.setVisibility(View.GONE);
                    dosDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list8.add(data);
                    }
                    dosDepartment.setHasFixedSize(true);
                    dosDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list8, getContext());
                    dosDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void dopsDepartment() {

        dbRef = reference.child("Department Of Political Science");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list9 = new ArrayList<>();
                if (!dataSnapshot.exists()) {
                    dopsNoData.setVisibility(View.VISIBLE);
                    dopsDepartment.setVisibility(View.GONE);
                } else {
                    dopsNoData.setVisibility(View.GONE);
                    dopsDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list9.add(data);
                    }
                    dopsDepartment.setHasFixedSize(true);
                    dopsDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list9, getContext());
                    dopsDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void dopeDepartment() {

        dbRef = reference.child("Department Of Physical Education");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list10 = new ArrayList<>();
                if (!dataSnapshot.exists()) {
                    dopeNoData.setVisibility(View.VISIBLE);
                    dopeDepartment.setVisibility(View.GONE);
                } else {
                    dopeNoData.setVisibility(View.GONE);
                    dopeDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list10.add(data);
                    }
                    dopeDepartment.setHasFixedSize(true);
                    dopeDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list10, getContext());
                    dopeDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void dospgDepartment() {

        dbRef = reference.child("Department Of Sanskrit");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list11 = new ArrayList<>();
                if (!dataSnapshot.exists()) {
                    dospgNoData.setVisibility(View.VISIBLE);
                    dospgDepartment.setVisibility(View.GONE);
                } else {
                    dospgNoData.setVisibility(View.GONE);
                    dospgDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list11.add(data);
                    }
                    dospgDepartment.setHasFixedSize(true);
                    dospgDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list11, getContext());
                    dospgDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void DoeDepartment() {

        dbRef = reference.child("Department Of Economics");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list12 = new ArrayList<>();
                if (!dataSnapshot.exists()) {
                    DoeNoData.setVisibility(View.VISIBLE);
                    DoeDepartment.setVisibility(View.GONE);
                } else {
                    DoeNoData.setVisibility(View.GONE);
                    DoeDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list12.add(data);
                    }
                    DoeDepartment.setHasFixedSize(true);
                    DoeDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list12, getContext());
                    DoeDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void DosDepartment() {

        dbRef = reference.child("Department Of Sociology");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list13 = new ArrayList<>();
                if (!dataSnapshot.exists()) {
                    DosNoData.setVisibility(View.VISIBLE);
                    DosDepartment.setVisibility(View.GONE);
                } else {
                    DosNoData.setVisibility(View.GONE);
                    DosDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list13.add(data);
                    }
                    DosDepartment.setHasFixedSize(true);
                    DosDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list13, getContext());
                    DosDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void dohDepartment() {

        dbRef = reference.child("Department Of Hindi");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list14 = new ArrayList<>();
                if (!dataSnapshot.exists()) {
                    dohNoData.setVisibility(View.VISIBLE);
                    dohDepartment.setVisibility(View.GONE);
                } else {
                    dohNoData.setVisibility(View.GONE);
                    dohDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list14.add(data);
                    }
                    dohDepartment.setHasFixedSize(true);
                    dohDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list14, getContext());
                    dohDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void doenDepartment() {

        dbRef = reference.child("Department Of English");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list15 = new ArrayList<>();
                if (!dataSnapshot.exists()) {
                    doenNoData.setVisibility(View.VISIBLE);
                    doenDepartment.setVisibility(View.GONE);
                } else {
                    doenNoData.setVisibility(View.GONE);
                    doenDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list15.add(data);
                    }
                    doenDepartment.setHasFixedSize(true);
                    doenDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list15, getContext());
                    doenDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}
