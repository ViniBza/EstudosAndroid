package adapter;


import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.estudos.travellist.R;

import java.util.List;

import model.Package;
import useful.DayUseful;
import useful.ImageUseful;
import useful.LocalUsefel;

public class ListPackageAdapter extends BaseAdapter {

    private final List<Package> packages;
    private final Context context;

    public ListPackageAdapter(List<Package> packages, Context context) {
        this.packages = packages;
        this.context = context;
    }

    @Override
    public int getCount() {
        return packages.size();
    }

    @Override
    public Object getItem(int position) {
        return packages.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        View viewReturn = LayoutInflater
                .from(context)
                .inflate(R.layout.item_packge,parent, false );
        Package packageReturn = packages.get(position);

        showLocal(viewReturn, packageReturn);
        showImage(viewReturn, packageReturn);
        showDay(viewReturn, packageReturn);
        showPrice(viewReturn, packageReturn);

        return viewReturn;
    }

    private void showPrice(View viewReturn, Package packageReturn) {
        TextView price = viewReturn.findViewById(R.id.item_package_price);
        String priceTxt = packageReturn.getPreco();
        price.setText(priceTxt);
    }

    private void showDay(View viewReturn, Package packageReturn) {
        TextView textDay = viewReturn.findViewById(R.id.item_package_days);
        int dayVar = packageReturn.getDias();
        textDay.setText(DayUseful.putDays(dayVar));
    }

    private void showImage(View viewReturn, Package packageReturn) {
        ImageView image = viewReturn.findViewById(R.id.item_package_imgView);
        Drawable drawableVar = ImageUseful.putImage(context, packageReturn.getImagem());
        image.setImageDrawable(drawableVar);
    }

    private void showLocal(View viewReturn, Package packageReturn) {
        TextView textLocal = viewReturn.findViewById(R.id.item_package_txt_local);
        String localVar = LocalUsefel.putLocal(packageReturn);
        textLocal.setText(localVar);
    }


}

