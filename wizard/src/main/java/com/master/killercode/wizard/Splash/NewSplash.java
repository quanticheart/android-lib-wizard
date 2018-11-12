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
 *  * Copyright(c) Developed by John Alves at 2018/$today.mouth/11 at 7:24:28 for quantic heart studios
 *
 */

package com.master.killercode.wizard.Splash;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.master.killercode.wizard.R;
import com.master.killercode.wizard.Splash.Constant.SplashConstants;
import com.master.killercode.wizard.Splash.Shared.GetSplashStatus;
import com.master.killercode.wizard.Wizard.WizardActivity;
import com.master.killercode.wizard.Wizard.WizardPageModel;

import java.util.ArrayList;

/**
 * Created by John on 01/12/2017.
 */

public class NewSplash extends AppCompatActivity {

    //init
    private Activity activity;
    private int splashSeconds = 3000;
    private Class afterSplash;
    private Boolean finishSplash = null;

    //Bundle
    private Bundle extras;

    //SharedPrefs
    private GetSplashStatus prefs;

    //Recosces
    private LinearLayout ll;
    private TextView tv;
    private ImageButton img;

    //Model's Array for Wizard Adapter
    private ArrayList<WizardPageModel> wList = new ArrayList<>();
    private Boolean itens = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        initVars();
        initActions();

    }

    private void initVars() {

        //
        activity = NewSplash.this;

        //
        ll = findViewById(R.id.llControl);
        tv = findViewById(R.id.tv);
        img = findViewById(R.id.img);

        //
        prefs = new GetSplashStatus(activity);

        //
        extras = getIntent().getExtras();

    }

    private void initActions() {
        setResorces(ll, tv, img);

        if (verifieBundle(SplashConstants.splashClass)) {
            afterSplash = (Class) extras.get(SplashConstants.splashClass);
        }

        if (verifieBundle(SplashConstants.splashTimes)) {
            splashSeconds = (int) extras.get(SplashConstants.splashTimes) * 1000;
        }

        if (verifieBundle(SplashConstants.splashFinish)) {
            finishSplash = extras.getBoolean(SplashConstants.splashFinish);
        }

        if (verifieBundle(SplashConstants.splashWizard)) {
            wList = (ArrayList<WizardPageModel>) extras.getSerializable(SplashConstants.splashWizard);
        }
        valideWList(wList);

        splashVerif();//Pega do prefs se já está criado
    }

    //==============================================================================================
    //
    // Create Resorces
    //
    //==============================================================================================

    private void setResorces(LinearLayout ll, TextView tv, ImageButton img) {

        if (verifieBundle(SplashConstants.splashTextColor)) {
            tv.setTextColor(extras.getInt(SplashConstants.splashTextColor));
        }

        if (verifieBundle(SplashConstants.splashBackColor)) {
            ll.setBackgroundColor(extras.getInt(SplashConstants.splashBackColor));
        }

        if (verifieBundle(SplashConstants.splashTitle)) {
            tv.setText(extras.getString(SplashConstants.splashTitle));
        }

        if (verifieBundle(SplashConstants.splashImage)) {
            img.setBackgroundResource(extras.getInt(SplashConstants.splashImage));
        }

    }

    //==============================================================================================
    //
    // WizardList verify
    //
    //==============================================================================================

    private void valideWList(ArrayList<WizardPageModel> wList) {
        if (wList.size() > 0) {
            itens = true;
        }
    }

    //==============================================================================================
    //
    // Slash Verify
    //
    //==============================================================================================

    private void splashVerif() {
        String name = "";
        Boolean splash;
        if (verifieBundle(SplashConstants.splashName)) {
            name = extras.getString(SplashConstants.splashName);
            splash = prefs.getStatusFrom(name);
            if (!splash) {
                prefs.setStatus(name);
            }

        } else {
            splash = prefs.getStatusDefault();
            if (!splash) {
                prefs.setStatusDefault();
            }
        }

        if (splash) {
            killPage();
        } else {
            Splash();
        }
    }

    //==============================================================================================
    //
    // KillPage
    //
    //==============================================================================================

    private void killPage() {
        if (afterSplash != null) {
            final Intent nextPage = new Intent(activity, afterSplash);
            startActivity(nextPage);
        }
        finish();
    }


    //==============================================================================================
    //
    // Splash init
    //
    //==============================================================================================
    private void Splash() {

        new Handler().postDelayed(new Runnable() {
                                      @Override
                                      public void run() {

                                          if (itens) {
                                              WizardActivity wizard = new WizardActivity(activity, wList);

                                              if (verifieBundle(SplashConstants.splashWizardGoogle)) {
                                                  wizard.setThemeGoogle();
                                              }
                                              if (afterSplash != null) {
                                                  wizard.setAfterWizard(afterSplash);
                                              }

                                              if (finishSplash != null) {
                                                  wizard.show(finishSplash);
                                              } else {
                                                  wizard.show();
                                              }

                                              finish();

                                          } else {
                                              killPage();
                                          }

                                      }
                                  }, splashSeconds
        );

    }

    //==============================================================================================
    //
    // Utils
    //
    //==============================================================================================

    private boolean verifieBundle(String keyName) {
        if (extras != null && extras.containsKey(keyName)) {
            return true;
        } else {
            return false;
        }
    }

}
