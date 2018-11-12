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
 *  * Copyright(c) Developed by John Alves at 2018/$today.mouth/11 at 7:43:56 for quantic heart studios
 *
 */

package com.master.killercode.wizard.Splash.Create;

import android.app.Activity;
import android.content.Intent;

import com.master.killercode.wizard.Splash.Constant.SplashConstants;
import com.master.killercode.wizard.Splash.NewSplash;
import com.master.killercode.wizard.Wizard.WizardPageModel;

import java.util.ArrayList;

import static com.master.killercode.wizard.ColorBox.ConvertColorUniversal;

public class CreateSplash {
    private Activity mActivity;
    private Intent intentSplash;
    private Class initialClass;
    private ArrayList<WizardPageModel> wList = new ArrayList<>();

    //==============================================================================================
    //
    // Constructor
    //
    //==============================================================================================

    public CreateSplash Make(Activity activity) {
        mActivity = activity;
        intentSplash = new Intent(activity, NewSplash.class);
        return this;
    }

    public CreateSplash Make(Activity activity, Class afterSplash) {
        mActivity = activity;
        this.initialClass = afterSplash;
        intentSplash = new Intent(activity, NewSplash.class);
        intentSplash.putExtra(SplashConstants.splashClass, initialClass);
        return this;
    }

    //==============================================================================================
    //
    // Contruct Splash
    //
    //==============================================================================================

    public CreateSplash setSplashName(String nameSplash) {
        intentSplash.putExtra(SplashConstants.splashName, nameSplash);
        return this;
    }

    public CreateSplash setTimer(int seconds) {
        intentSplash.putExtra(SplashConstants.splashTimes, seconds);
        return this;
    }

    //==============================================================================================
    //
    // Rersorces
    //
    //==============================================================================================

    public CreateSplash setTextTitle(String textTitle) {
        intentSplash.putExtra(SplashConstants.splashTitle, textTitle);
        return this;
    }

    public CreateSplash setImage(int imgResorce) {
        intentSplash.putExtra(SplashConstants.splashImage, imgResorce);
        return this;
    }

    public CreateSplash setColorBackground(int color) {
        intentSplash.putExtra(SplashConstants.splashBackColor, ConvertColorUniversal(color));
        return this;
    }

    public CreateSplash setColorBackground(String color) {
        intentSplash.putExtra(SplashConstants.splashBackColor, ConvertColorUniversal(color));
        return this;
    }

    public CreateSplash setColorText(int color) {
        intentSplash.putExtra(SplashConstants.splashTextColor, ConvertColorUniversal(color));
        return this;
    }

    public CreateSplash setColorText(String color) {
        intentSplash.putExtra(SplashConstants.splashTextColor, ConvertColorUniversal(color));
        return this;
    }

    //==============================================================================================
    //
    // WizardList
    //
    //==============================================================================================

    public CreateSplash setWizardList(ArrayList<WizardPageModel> wList) {
        intentSplash.putExtra(SplashConstants.splashWizard, wList);
        return this;
    }

    public CreateSplash setWizardThemeGoogle() {
        intentSplash.putExtra(SplashConstants.splashWizardGoogle, true);
        return this;
    }

    //==============================================================================================
    //
    // Show Splash
    //
    //==============================================================================================

    public void show() {
        intentSplash.putExtra(SplashConstants.splashFinish, false);
        mActivity.startActivity(intentSplash);
    }

    public void show(Boolean finish) {
        intentSplash.putExtra(SplashConstants.splashFinish, finish);
        mActivity.startActivity(intentSplash);
        if (finish) {
            mActivity.finish();
        }
    }

}
