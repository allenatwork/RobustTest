package allen.robust.test.util;

import android.view.View;

/**
 * Created by Allen on 13-Oct-16.
 */
public class ViewUtils {
    public static void showView(View... views) {
        for (View view : views) {
            if (view.getVisibility() != View.VISIBLE) view.setVisibility(View.VISIBLE);
        }
    }

    public static void goneView(View... views) {
        for (View view : views) {
            if (view.getVisibility() == View.VISIBLE) view.setVisibility(View.GONE);
        }
    }
}
