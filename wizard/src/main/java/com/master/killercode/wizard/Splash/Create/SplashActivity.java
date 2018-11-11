/*
 *
 *  *                                     /@
 *  *                      __        __   /\/
 *  *                     /==\      /  \_/\/
 *  *                   /======\    \/\__ \__
 *  *                 /==/\  /\==\    /\_|__ \
 *  *              /==/    ||    \=\ / / / /_/
 *  *            /=/    /\ || /\   \=\/ /
 *  *         /===/   /   \||/   \   \===\
 *  *       /===/   /_________________ \===\
 *  *    /====/   / |                /  \====\
 *  *  /====/   /   |  _________    /      \===\
 *  *  /==/   /     | /   /  \ / / /         /===/
 *  * |===| /       |/   /____/ / /         /===/
 *  *  \==\             /\   / / /          /===/
 *  *  \===\__    \    /  \ / / /   /      /===/   ____                    __  _         __  __                __
 *  *    \==\ \    \\ /____/   /_\ //     /===/   / __ \__  ______  ____ _/ /_(_)____   / / / /__  ____ ______/ /_
 *  *    \===\ \   \\\\\\\/   ///////     /===/  / / / / / / / __ \/ __ `/ __/ / ___/  / /_/ / _ \/ __ `/ ___/ __/
 *  *      \==\/     \\\\/ / //////       /==/  / /_/ / /_/ / / / / /_/ / /_/ / /__   / __  /  __/ /_/ / /  / /_
 *  *      \==\     _ \\/ / /////        |==/   \___\_\__,_/_/ /_/\__,_/\__/_/\___/  /_/ /_/\___/\__,_/_/   \__/
 *  *        \==\  / \ / / ///          /===/
 *  *        \==\ /   / / /________/    /==/
 *  *          \==\  /               | /==/
 *  *          \=\  /________________|/=/
 *  *            \==\     _____     /==/
 *  *           / \===\   \   /   /===/
 *  *          / / /\===\  \_/  /===/
 *  *         / / /   \====\ /====/
 *  *        / / /      \===|===/
 *  *        |/_/         \===/
 *  *                       =
 *  *
 *  * Copyright(c) Developed by John Alves at 2018/$today.mouth/11 at 7:44:1 for quantic heart studios
 *
 */

package com.master.killercode.wizard.Splash.Create;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.master.killercode.wizard.Splash.Splash;
import com.master.killercode.wizard.Wizard.WizardActivity;
import com.master.killercode.wizard.Wizard.WizardPageModel;

import java.util.ArrayList;

import static com.master.killercode.wizard.ColorBox.ConvertColorUniversal;

public class SplashActivity {
    private Activity activity;
    private Intent intentSplash;
    private Class initialClass;
    private ArrayList<WizardPageModel> wList = new ArrayList<>();

    //==============================================================================================
    //
    // Constructor
    //
    //==============================================================================================

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

    //==============================================================================================
    //
    // Contruct Splash
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

    public void setSplashFinished(String nameSplash) {
        intentSplash.putExtra("namesplash", nameSplash);
    }

    public void setTimer(int seconds) {
        intentSplash.putExtra("seconds", seconds);
    }

    //==============================================================================================
    //
    // Show Splash
    //
    //==============================================================================================

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
    // Google Theme
    //
    //==============================================================================================

    public void setWizardThemeGoogle() {
        intentSplash.putExtra("thw", true);
    }

    //==============================================================================================
    //
    // WizardList
    //
    //==============================================================================================

    public void setWizard(ArrayList<WizardPageModel> wList) {
        this.wList = wList;
    }

    private void setIntent() {
        intentSplash.putExtra("arr", wList);
    }

}
