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

        TextView local = viewReturn.findViewById(R.id.item_package_txt_local);
        String localTxt = packageReturn.getLocal();
        local.setText(localTxt);

        ImageView image = viewReturn.findViewById(R.id.item_package_imgView);
        Resources resources = context.getResources();
        String drawableText = packageReturn.getImagem();
        int idDrawable = resources.getIdentifier(
                drawableText,
                "drawable",
                context.getPackageName());
        Drawable drawable = resources.getDrawable(idDrawable);
        image.setImageDrawable(drawable);

        TextView days = viewReturn.findViewById(R.id.item_package_days);
        int daysTxt;
        daysTxt = packageReturn.getDias();
        days.setText(daysTxt+"");

        TextView price = viewReturn.findViewById(R.id.item_package_price);
        String priceTxt = packageReturn.getPreco();
        price.setText(priceTxt);
        return viewReturn;
    }
}
