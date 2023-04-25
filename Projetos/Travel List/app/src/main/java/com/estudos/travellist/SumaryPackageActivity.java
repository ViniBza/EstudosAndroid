package com.estudos.travellist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigDecimal;

import model.Package;
import useful.DayUseful;
import useful.ImageUseful;
import useful.PeriodUseful;

public class SumaryPackageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sumary_package);
        Package packageTest = new Package("Recife", "recife_pe",4,  new BigDecimal("754.20"));

        showImagePackage(packageTest);
        showLocalPackage(packageTest);
        showDaysPackage(packageTest);
        showPeriodPackage(packageTest);
        showPricePackage(packageTest);
        goToPaymentActivity();

    }

    private void goToPaymentActivity() {
        Button btnChosePackage = findViewById(R.id.act_sum_btn_chose);
        btnChosePackage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SumaryPackageActivity.this, PaymentActivity.class);
                startActivity(intent);
            }
        });
    }

    private void showPricePackage(Package packageTest) {
        TextView textPrice = findViewById(R.id.act_sum_price);
        String txtPrice = packageTest.getPreco();
        textPrice.setText(txtPrice);
    }

    private void showPeriodPackage(Package packageTest) {
        TextView textPeriod = getTextView();
        String txtPeriod = PeriodUseful.setPeriod(packageTest);
        textPeriod.setText(txtPeriod);
    }

    private TextView getTextView() {
        TextView textPeriod = findViewById(R.id.act_sum_txt_period);
        return textPeriod;
    }

    private void showDaysPackage(Package packageTest) {
        TextView textDays = findViewById(R.id.act_sum_txt_days);
        String txtDays = DayUseful.putDays(packageTest.getDias());
        textDays.setText(txtDays);
    }

    private void showLocalPackage(Package packageTest) {
        TextView textLocalActivity = findViewById(R.id.act_sum_txt_city);
        String txtLocal = packageTest.getLocal();
        textLocalActivity.setText(txtLocal);
    }

    private void showImagePackage(Package packageTest) {
        ImageView imageLocalActivity = findViewById(R.id.act_sum_img);
        Drawable drawableImage = ImageUseful.putImage(this, packageTest.getImagem());
        imageLocalActivity.setImageDrawable(drawableImage);
    }
}