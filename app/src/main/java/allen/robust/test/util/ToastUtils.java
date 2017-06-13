package allen.robust.test.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Tuan Nguyen on 6/3/2015.
 */
public class ToastUtils {

    public static void quickToast(Context context, String msg) {
        quickToast(context, msg, false);
    }

    public static void quickToast(Context context, int resource) {
        if (context == null) return;
        String msg = context.getResources().getString(resource);
        quickToast(context, msg, false);
    }

    public static void quickToast(Context context, String msg, boolean isLong) {
        Toast toast = null;
        if (isLong) {
            toast = Toast.makeText(context, msg, Toast.LENGTH_LONG);
        } else {
            toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
        }
        toast.show();
    }
}
