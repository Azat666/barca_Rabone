package com.example.student.rabonefootbol;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<Modul> list;
    private Context context;
    int i;
    boolean flag = true;

    public MyAdapter(List<Modul> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.footbol_activity, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Picasso.with(context).load(list.get(position).getImigeUrl()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {

        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        ImageButton buttonHeart;
        TextView textView;
        ImageButton buttoncommoent;
        Button button;
        TextView textvieww;

        public MyViewHolder(View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.image_View);
            buttonHeart = (ImageButton) itemView.findViewById(R.id.button_heart);
            textView = (TextView) itemView.findViewById(R.id.text_linke);
            buttoncommoent = (ImageButton) itemView.findViewById(R.id.button_comment);
            textvieww = (TextView) itemView.findViewById(R.id.conter_comment);
            button = (Button) itemView.findViewById(R.id.button);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    list.remove(getAdapterPosition());
                    notifyDataSetChanged();
                }
            });
            buttonHeart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (flag) {
                        list.get(getAdapterPosition()).plusheart();
                        textView.setText(String.valueOf(++i));
                        flag = false;
                    } else {
                        list.get(getAdapterPosition()).minusheart();
                        textView.setText(String.valueOf(--i));
                        flag = true;
                    }
                    ;
                }
            });
        }
    }

}
