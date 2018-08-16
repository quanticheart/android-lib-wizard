package com.master.killercode.wizard.Splash;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.master.killercode.wizard.Wizard.WizardActivity;
import com.master.killercode.wizard.Wizard.WizardPageModel;

import java.util.ArrayList;

import static com.master.killercode.wizard.ColorBox.ConvertColorUniversal;

public class SplashActivity {
    private Activity activity;
    private Intent intentSplash;
    private Class initialClass;
    private ArrayList<WizardPageModel> wList = new ArrayList<>();

    public SplashActivity(Activity activity) {
        this.activity = activity;
        intentSplash = new Intent(activity, Splash.class);
    }

    public SplashActivity(Activity activity, Class afterSplash) {
        this.activity = activity;
        this.initialClass = afterSplash;
        intentSplash = new Intent(activity, Splash.class);
        intentSplash.putExtra("class", initialClass);
    }

    public void show() {
        setIntent();
        activity.startActivity(intentSplash);
    }

    public void show(Boolean finish) {
        setIntent();
        activity.startActivity(intentSplash);
        if (finish)
            activity.finish();
    }


    //==============================================================================================
    //
    //
    //
    //==============================================================================================

    public void setSplashFinished(String nameSplash) {
        intentSplash.putExtra("namesplash", nameSplash);
    }

    public void setTimer(int seconds) {
        intentSplash.putExtra("seconds", seconds);
    }

    //==============================================================================================
    //
    //
    //
    //==============================================================================================

    public void setWizardThemeGoogle() {
        intentSplash.putExtra("thw", true);
    }

    public void setWizard(ArrayList<WizardPageModel> wList) {
        this.wList = wList;
    }

    private void setIntent() {

        intentSplash.putExtra("arr", wList);
    }

    //==============================================================================================
    //
    //
    //
    //==============================================================================================

    public void setTextTitle(String textTitle) {
        intentSplash.putExtra("title", textTitle);
    }

    public void setImage(int imgResorce) {
        intentSplash.putExtra("img", imgResorce);
    }

    public void setColorBackground(int color) {
        intentSplash.putExtra("colorback", ConvertColorUniversal(color));
    }

    public void setColorBackground(String color) {
        intentSplash.putExtra("colorback", ConvertColorUniversal(color));
    }

}
