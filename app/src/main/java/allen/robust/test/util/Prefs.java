package allen.robust.test.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;

/**
 * Created by TuanNguyen on 5/3/2016.
 */
public class Prefs {
    private static final String FILE_NAME = "SamplePrefs";
    private static final String KEY_TOKEN_SECRET = "oauth_secret";
    private static final String KEY_AUTH_TOKEN = "oauth_token";
    private static final String KEY_USER_ID = "id";
    private static final String TAG_DO_NOT_SHOW_TUTORIAL = "TAG_DO_NOT_SHOW_TUTORIAL";
    private static final String IS_FIRST_RUN = "FirstRun";
    private static final String IS_SHOW_DIALOG_VIDEO = "ShowDialogVideo";
    public static final String IS_FIRST_CREATE_CV = "FirstCreateCV";
    private static Prefs instance;

    private final SharedPreferences preferences;

    private Prefs(Context context) {
        preferences = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
    }

    public static Prefs getInstance(Context context) {
        if (instance == null || instance.preferences == null) {
            instance = new Prefs(context);
        }
        return instance;
    }

    private void edit(String key, String value) {
        preferences.edit().putString(key, value).apply();
    }

    @Nullable
    public String getOauthToken() {
        return preferences.getString(KEY_AUTH_TOKEN, null);
    }

    public void setOauthToken(String token) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(KEY_AUTH_TOKEN, token);
        editor.apply();
    }

    @Nullable
    public String getOauthSecret() {
        return preferences.getString(KEY_TOKEN_SECRET, null);
    }

    public void setOauthSecret(String tokenSecret) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(KEY_TOKEN_SECRET, tokenSecret);
        editor.apply();
    }

    public void logout() {
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove(KEY_AUTH_TOKEN);
        editor.remove(KEY_TOKEN_SECRET);
        editor.remove(KEY_USER_ID);
        editor.apply();
    }

    public void setUserId(String userId) {
        edit(KEY_USER_ID, userId);
    }

    public void setDataDoNotShowTutorial (boolean isDoNotShow){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(TAG_DO_NOT_SHOW_TUTORIAL, isDoNotShow);
        editor.commit();
    }

    public void setFirstRunApp(boolean isFisrtRun) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(IS_FIRST_RUN, isFisrtRun);
        editor.commit();
    }

    public void setFirstCreateCV(boolean isFirstCreateCV) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(IS_FIRST_CREATE_CV, isFirstCreateCV);
        editor.commit();
    }

    public boolean isFirstRunApp() {
        return preferences.getBoolean(IS_FIRST_RUN, true);
    }

    public boolean isFirstCreateCV() {
        return preferences.getBoolean(IS_FIRST_CREATE_CV, true);
    }

    public boolean isDoNotShowTutorial (){
        return preferences.getBoolean(TAG_DO_NOT_SHOW_TUTORIAL, false);
    }

    public boolean isAlreadyRunTutorialMakeVideo (){
        return preferences.getBoolean(IS_SHOW_DIALOG_VIDEO, false);
    }

    public void setAlreadyRunTutorialMakeVideo (boolean isShow){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(IS_SHOW_DIALOG_VIDEO, isShow);
        editor.commit();
    }
}
