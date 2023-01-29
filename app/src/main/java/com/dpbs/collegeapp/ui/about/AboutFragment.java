package com.dpbs.collegeapp.ui.about;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.dpbs.collegeapp.R;

import java.util.ArrayList;
import java.util.List;

public class AboutFragment extends Fragment {

    private ViewPager viewPager;
    private BranchAdapter adapter;
    private List<BranchModel> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about,container,false);
        list = new ArrayList<>();
        list.add(new BranchModel(R.drawable.ic_computer,"Computer Science","The BCA Degree courses at Durga Prasad Baljeet Singh College,are focused on training the students in programming, networking, developing, etc. "));
        list.add(new BranchModel(R.drawable.ic_bsc,"B.S.C","feffwfwfefefefefefefef"));
        list.add(new BranchModel(R.drawable.ic_bcom,"B.com","feffwfwfefefefefefefef"));

        adapter = new BranchAdapter(getContext(),list);
        viewPager = view.findViewById(R.id.viewPager);

        viewPager.setAdapter(adapter);

        ImageView imageView = view.findViewById(R.id.college_image);
        Glide.with(getContext()).load("https://firebasestorage.googleapis.com/v0/b/dpbs-college-app.appspot.com/o/Other%20Images%2Fprincipal%20sir.JPG?alt=media&token=4563db5b-0d18-461c-ae7e-1af81b21dca2")
                .into(imageView);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);

        return view;
    }
}
