package com.estudos.travellist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import adapter.ListPackageAdapter;
import dao.PackageDao;
import model.Package;

public class MainActivity extends AppCompatActivity {

    public static final String NAME_APPBAR = "List package for travel";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configureList();
        setTitle(NAME_APPBAR);

    }
    private void configureList() {
        ListView listView = findViewById(R.id.actv_main_listView);
      final List<Package> packages = new PackageDao().lista();
        listView.setAdapter(new ListPackageAdapter(packages,this));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent newIntent = new Intent(MainActivity.this, SumaryPackageActivity.class);
                startActivity(newIntent);
            }
        });
    }

}