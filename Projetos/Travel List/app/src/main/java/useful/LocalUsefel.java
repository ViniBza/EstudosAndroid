package useful;

import android.view.View;
import android.widget.TextView;

import com.estudos.travellist.R;

import model.Package;

public class LocalUsefel {

    public static String putLocal(Package packageVar) {
        String localTxt = packageVar.getLocal();
        return localTxt;

    }

}
