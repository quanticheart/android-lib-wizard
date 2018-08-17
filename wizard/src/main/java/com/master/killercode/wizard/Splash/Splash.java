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

import com.master.killercode.wizard.GetWizardStatus;
import com.master.killercode.wizard.R;
import com.master.killercode.wizard.Wizard.WizardActivity;
import com.master.killercode.wizard.Wizard.WizardPageModel;

import java.util.ArrayList;

/**
 * Created by John on 01/12/2017.
 */

public class Splash extends AppCompatActivity {

    //init
    private Activity activity;
    private Bundle extras;
    private int splashSeconds = 3000;
    private GetWizardStatus prefs;
    private Class afterSplash;

    //
    private LinearLayout ll;
    private TextView tv;
    private ImageButton img;


    //Model's Array for Wizard Adapter
    private ArrayList<WizardPageModel> wList = new ArrayList<>();
    Boolean itens = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout._00_splash);

        activity = Splash.this;
        ll = findViewById(R.id.llControl);
        tv = findViewById(R.id.tv);
        img = findViewById(R.id.img);
        prefs = new GetWizardStatus(activity);
        extras = getIntent().getExtras();

        setResorces(ll, tv, img);

        if (extras != null && extras.containsKey("class")) {
            afterSplash = (Class) extras.get("class");
        }

        if (extras != null && extras.containsKey("seconds")) {
            splashSeconds = (int) extras.get("seconds") * 1000;
        }

        if (extras != null) {
            wList = (ArrayList<WizardPageModel>) extras.getSerializable("arr");
        }
        valideWList(wList);

        splashVerif();//Pega do prefs se já está criado
    }

    private void setResorces(LinearLayout ll, TextView tv, ImageButton img) {
        if (extras != null && extras.containsKey("title")) {
            tv.setText(extras.getString("title"));
        }

        if (extras != null && extras.containsKey("img")) {
            img.setBackgroundResource(extras.getInt("img"));
        }

        if (extras != null && extras.containsKey("colorback")) {
            ll.setBackgroundColor(extras.getInt("colorback"));
        }
    }

    private void valideWList(ArrayList<WizardPageModel> wList) {
        if (wList.size() > 0) {
            itens = true;
        }
    }

    private void splashVerif() {
        String name = "";
        Boolean splash = false;
        if (extras != null && extras.containsKey("namesplash")) {
            name = extras.getString("namesplash");
            splash = prefs.getStatusFinishedFrom(name);
            if (!splash) {
                prefs.setStatusFinish(name);
            }
        }

        if (splash) {
            killPage();
        } else {
            Splash();

        }
    }

    private void Splash() {

        new Handler().postDelayed(new Runnable() {
                                      @Override
                                      public void run() {

                                          if (itens) {
                                              WizardActivity wizard = new WizardActivity(activity, wList);
                                              wizard.setAfterWizard(afterSplash);
                                              if (extras != null && extras.containsKey("thw")) {
                                                  wizard.setThemeGoogle();
                                              }
                                              wizard.show(true);
                                          } else {
                                              killPage();
                                          }

                                      }
                                  }, splashSeconds
        );

    }

    private void killPage() {
        if (afterSplash != null) {
            final Intent nextPage = new Intent(activity, afterSplash);
            startActivity(nextPage);
        }
        finish();
    }

    private Bundle verifieBundle(String keyName) {
        if (extras != null && extras.containsKey(keyName)) {
            return (Bundle) extras.get(keyName);
        } else {
            return null;
        }
    }

}
