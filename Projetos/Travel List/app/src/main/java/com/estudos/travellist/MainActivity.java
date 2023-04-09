package com.estudos.travellist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

import adapter.ListPackageAdapter;
import dao.PackageDao;
import model.Package;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configureList();
        setTitle("");

    }

    private void configureList() {
        ListView listView = findViewById(R.id.actv_main_listView);
        List<Package> packages = new PackageDao().lista();
        listView.setAdapter(new ListPackageAdapter(packages,this));
    }

}