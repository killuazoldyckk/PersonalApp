package com.example.personalapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MyAdapter extends BaseAdapter {

    Context context;
    List<Pojo> listPojos;

    public MyAdapter(Context context,List<Pojo> listPojos){
        this.context = context;
        this.listPojos = listPojos;
    }

    @Override
    public int getCount(){
        return listPojos.size();
    }

    @Override
    public Object getItem(int position){
        return null;
    }

    @Override
    public long getItemId(int position){
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent){
        view = LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);

        ImageView imageView = view.findViewById(R.id.image);
        TextView title = view.findViewById(R.id.title);

        title.setText(listPojos.get(position).getTitle());
        imageView.setImageResource(listPojos.get(position).getImage());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Position" + position, Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }


}
