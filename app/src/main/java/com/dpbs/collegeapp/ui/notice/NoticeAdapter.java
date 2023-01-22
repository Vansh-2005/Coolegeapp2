package com.dpbs.collegeapp.ui.notice;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.dpbs.collegeapp.FullImageView;
import com.dpbs.collegeapp.R;

import java.util.ArrayList;

public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.NoticeViewAdapter>{
    private Context context;
    private ArrayList<NoticeData> list;

    public NoticeAdapter(Context context, ArrayList<NoticeData> list) {
        this.context = context;
        this.list = list;

    }

    @NonNull
    @Override
    public NoticeViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.notice_layout, parent, false);
        return new NoticeViewAdapter(view);

    }

    @Override
    public void onBindViewHolder(@NonNull NoticeViewAdapter holder, int position) {

        NoticeData currrentItem = list.get(position);

        holder.updateNoticeTitle.setText(currrentItem.getTitle());
        holder.date.setText(currrentItem.getDate());
        holder.time.setText(currrentItem.getTime());

        try {
            if (currrentItem.getImage() != null)
                Glide.with(context).load(currrentItem.getImage()).into(holder.updateNoticeImage);
        } catch (Exception e) {
            e.printStackTrace();
        }

        holder.updateNoticeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, FullImageView.class);
                intent.putExtra("image",currrentItem.getImage());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class NoticeViewAdapter extends RecyclerView.ViewHolder {

        private TextView updateNoticeTitle, date, time;
        private ImageView updateNoticeImage;

        public NoticeViewAdapter(@NonNull View itemView) {
            super(itemView);
            updateNoticeTitle = itemView.findViewById(R.id.updateNoticeTitle);
            updateNoticeImage = itemView.findViewById(R.id.updateNoticeImage);
            date = itemView.findViewById(R.id.date);
            time = itemView.findViewById(R.id.time);
        }
    }


}
