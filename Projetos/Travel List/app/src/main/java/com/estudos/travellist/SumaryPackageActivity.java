package com.estudos.travellist;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigDecimal;

import model.Package;
import useful.DayUseful;
import useful.ImageUseful;
import useful.PriceUseful;

public class SumaryPackageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sumary_package);
//"Recife", "recife_pe", 4, new BigDecimal(754.20)
        Package packageTest = new Package("Recife", "recife_pe",4,  new BigDecimal(754.20));

        ImageView imageLocalActivity = findViewById(R.id.act_sum_img);
        Drawable drawableImage = ImageUseful.putImage(this, packageTest.getImagem());
        imageLocalActivity.setImageDrawable(drawableImage);

        TextView textLocalActivity = findViewById(R.id.act_sum_txt_city);
        String txtLocal = packageTest.getLocal();
        textLocalActivity.setText(txtLocal);

        TextView textDays = findViewById(R.id.act_sum_txt_days);
        String txtDays = DayUseful.putDays(packageTest.getDias());
        textDays.setText(txtDays);

        TextView textPeriod = findViewById(R.id.act_sum_txt_period);
        textPeriod.setText("05/01 - 07/01 de 2018");

        TextView textPrice = findViewById(R.id.act_sum_price);
       // String txtPrice = PriceUseful.putPrice(packageTest.getPreco());

    }
}