package useful;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import model.Package;

public class ImageUseful {

    public static Drawable putImage(Context context,String drawableTxt){
    Resources resources = context.getResources();
    String drawableText = drawableTxt;
    int idDrawable = resources.getIdentifier(
            drawableText,
            "drawable",
            context.getPackageName());
    return resources.getDrawable(idDrawable);
    }
}
