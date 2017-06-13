package allen.robust.test.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import java.util.Hashtable;

import allen.robust.test.R;


public class STextView extends TextView {

    private static Typeface s_font_w1;
    private static Typeface s_font_w2;
    private static Typeface s_font_w3;

    public STextView(Context context) {
        super(context);
        loadFontFromAsset(context);
        loadStateFromAttrs(context, null);
    }

    public STextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        loadFontFromAsset(context);
        loadStateFromAttrs(context, attrs);
    }

    public STextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        loadFontFromAsset(context);
        loadStateFromAttrs(context, attrs);
    }

    private void loadFontFromAsset(Context context) {
        if (s_font_w1 == null || s_font_w2 == null || s_font_w3 == null) {
            s_font_w1 = FontCache.get("fonts/Roboto-Regular.ttf", context);
            s_font_w2 = FontCache.get("fonts/Roboto-Medium.ttf", context);
            s_font_w3 = FontCache.get("fonts/Roboto-Bold.ttf", context);
        }
    }

    private void loadStateFromAttrs(Context context, AttributeSet attrs) {
        if (attrs == null)
            return;
        TypedArray style_attrs = null;
        int font_id;
        final int ERROR_VALUE = -1;

        // Set font base on value
        try {
            style_attrs = context.obtainStyledAttributes(attrs, R.styleable.STextView);
            font_id = style_attrs.getInt(R.styleable.STextView_sfont, ERROR_VALUE);
            switch (font_id) {
                case 1:
                    setTypeface(s_font_w1);
                    break;
                case 2:
                    setTypeface(s_font_w2);
                    break;
                case 3:
                    setTypeface(s_font_w3);
                    break;
                default:
                    setTypeface(s_font_w1);
                    break;
            }
        } finally {
            if (style_attrs != null) {
                style_attrs.recycle(); // ensure this is always called
            }
        }
    }

    private static class FontCache {

        private static Hashtable<String, Typeface> fontCache = new Hashtable<String, Typeface>();

        public static Typeface get(String name, Context context) {
            Typeface tf = fontCache.get(name);
            if (tf == null) {
                try {
                    tf = Typeface.createFromAsset(context.getAssets(), name);
                } catch (Exception e) {
                    return null;
                }
                fontCache.put(name, tf);
            }
            return tf;
        }
    }
}