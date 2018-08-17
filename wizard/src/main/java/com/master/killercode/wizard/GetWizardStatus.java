package com.master.killercode.wizard;

import android.content.Context;
import android.content.SharedPreferences;

public class GetWizardStatus {

    public static final String CONSTANTE_SHAREDPREFS_DO_PROJETO = "Wizard";
    private final SharedPreferences Prefs;

    public GetWizardStatus(Context context) {
        Prefs = context.getSharedPreferences(CONSTANTE_SHAREDPREFS_DO_PROJETO, Context.MODE_PRIVATE);
    }

    public Boolean getWizardFinished(String nameWizard) {
        return Prefs.getBoolean(nameWizard, false);
    }

    public void setWizardFinish(String nameWizard) {
        SharedPreferences.Editor editor = Prefs.edit();
        editor.putBoolean(nameWizard, true);
        editor.commit();
    }

    //===========================================================================================================================

    public Boolean getSplashFinished(String nameSplash) {
        return Prefs.getBoolean(nameSplash, false);
    }

    public void setSplashFinish(String nameSplash) {
        SharedPreferences.Editor editor = Prefs.edit();
        editor.putBoolean(nameSplash, true);
        editor.commit();
    }

}
