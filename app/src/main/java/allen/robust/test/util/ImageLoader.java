package allen.robust.test.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import allen.robust.test.R;

/**
 * Created by Allen on 14-Sep-16.
 */
public class ImageLoader {
    public static void load(Context context, String url, ImageView iv) {
        Glide.with(context)
                .load(url)
                .error(R.mipmap.ic_launcher)
                .fallback(R.mipmap.ic_launcher)
                .placeholder(R.mipmap.ic_launcher)
                .crossFade()
                .into(iv);
    }
}
