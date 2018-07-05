package com.example.student.rabonefootbol;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Modul> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        list = new ArrayList<>();
        list.add(new Modul("https://k60.kn3.net/taringa/3/5/2/6/0/7/Beriku/464.jpg"));
        list.add(new Modul("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTF8mU05pudZKsCd1BGUq_ZtSBHZuucZLXTLqsAj8Uy8zxq2Yagug"));
        list.add(new Modul("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR-HkR46xcmBbSa7EJ5P3w6jYgMcx2S3dI4lq9ctsRtvKq2gOYYiA"));
        list.add(new Modul("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRYqIFsnBDVpcFU5-4iX-eyjZtD64NFLg_Mzs36WCdCdC22v_2H"));
        list.add(new Modul("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR27ORaA0nEsreKwqVAj5flF7ms4niU55nKeA_t_U9oJcDY6vDMGQ"));
        list.add(new Modul("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQBRSz5VjjIoVIlSisROYT7an2VsKFMjpQcJbHPCdUuuIFffai8Sg"));
        list.add(new Modul("https://pbs.twimg.com/media/DhQBffLVAAYmXdF.jpg"));
        list.add(new Modul("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSDSJbXAY0KJQv6fAY_TBlQHyHX_aESFqMci8AwvRac3m-Nssl_"));
        list.add(new Modul("https://cdn.vox-cdn.com/thumbor/Q35JgP4u_T7NsX8qIUmapvei25w=/0x0:5322x3472/1200x800/filters:focal(2411x261:3261x1111)/cdn.vox-cdn.com/uploads/chorus_image/image/59030783/932030898.jpg.0.jpg"));
        list.add(new Modul("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQcRmokjFwXiWbogvq-_ShbOhZ4Z0GImZ4eCujG9o7FsLbgoochTQ"));
        MyAdapter myAdapter = new MyAdapter(list, MainActivity.this);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.idrecyc);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(myAdapter);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PostActivity.class);
                startActivityForResult(intent, 5);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == 5 && data != null) {
                String a = data.getStringExtra(PostActivity.KEY);
                list.add(new Modul(a));
            }
        }
    }
}
