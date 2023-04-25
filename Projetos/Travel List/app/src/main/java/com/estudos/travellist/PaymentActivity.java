package com.estudos.travellist;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.math.BigDecimal;
import java.util.List;

import dao.PackageDao;
import model.Package;

public class PaymentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        setTitle("Payment");
        Package packageTest = new Package("Recife",
               "recife_pe",4,  new BigDecimal("754.20"));

    }
}