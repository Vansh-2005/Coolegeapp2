package com.dpbs.collegeapp.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.dpbs.collegeapp.CourseDescriptionHome.BaDepartmentActivity;
import com.dpbs.collegeapp.CourseDescriptionHome.BcaDepartmentActivity;
import com.dpbs.collegeapp.CourseDescriptionHome.BcomDepartmentActivity;
import com.dpbs.collegeapp.CourseDescriptionHome.BscDepartmentActivity;
import com.dpbs.collegeapp.R;
import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderLayout;

public class HomeFragment extends Fragment {
    private SliderLayout sliderLayout;
    private ImageView mapLocation;
    TextView bcadepart,bscdepart,bcomdepart,badepart;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home,container,false);
        //Getting the image slder

        sliderLayout = view.findViewById(R.id.slider);

        bcadepart = (TextView)view.findViewById(R.id.bcaDepartment);
        bscdepart = (TextView)view.findViewById(R.id.bscDepartment);
        bcomdepart = (TextView)view.findViewById(R.id.bcomDepartment);
        badepart = (TextView)view.findViewById(R.id.baDepartment);

        bcadepart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), BcaDepartmentActivity.class);
                startActivity(intent);
            }
        });

        bscdepart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), BscDepartmentActivity.class);
                startActivity(intent);
            }
        });

        bcomdepart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), BcomDepartmentActivity.class);
                startActivity(intent);
            }
        });

        badepart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), BaDepartmentActivity.class);
                startActivity(intent);
            }
        });
        //Adding some properties of slider layout
        sliderLayout.setIndicatorAnimation(IndicatorAnimations.FILL);
        sliderLayout.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderLayout.setScrollTimeInSec(3);

        setSliderImages();

        mapLocation = view.findViewById(R.id.mapLocation);
        mapLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMap();
            }
        });

        return view;
    }


    private void openMap() {
        Uri uri = Uri.parse("geo:0,0?q=Durga Prasad Baljeet Singh (PG) College, Anupshahr");

        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }

    private void setSliderImages() {
        //setting the number of images and getting them
        for (int i = 0;i<5;i++)
        {
            DefaultSliderView sliderView = new DefaultSliderView(getContext());
            switch(i){
                case 0:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/dpbs-college-app.appspot.com/o/Slider%20Images%2F5%20(1).jpg?alt=media&token=6c5a645d-71ff-45a6-8115-733d78707cb7");
                    sliderView.setDescription(" ");
                    break;
                case 1:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/dpbs-college-app.appspot.com/o/Slider%20Images%2F6%20(2).jpg?alt=media&token=b7743b13-575c-4dd5-8717-474d6ae5969e");
                    sliderView.setDescription(" ");
                    break;
                case 2:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/dpbs-college-app.appspot.com/o/Slider%20Images%2FWhatsApp%20Image%202022-11-27%20at%2011.46.34%20AM%20(1).jpeg?alt=media&token=16ac39cf-341c-43d1-a31e-973f8e7e91ee");
                    sliderView.setDescription(" ");
                    break;
                case 3:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/dpbs-college-app.appspot.com/o/Slider%20Images%2FWhatsApp%20Image%202022-11-28%20at%206.14.37%20PM.jpeg?alt=media&token=4d9a936b-eaf3-4f77-8d71-ee3089eb7b4a");
                    sliderView.setDescription(" ");
                    break;
                case 4:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/dpbs-college-app.appspot.com/o/Slider%20Images%2F3.jpg?alt=media&token=4fc39285-d182-4a1b-9d71-bca534aaee93");
                    sliderView.setDescription(" ");
                    break;
            }
            sliderView.setImageScaleType(ImageView.ScaleType.FIT_XY);
            sliderLayout.addSliderView(sliderView);
        }
    }
}
