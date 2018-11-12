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
 *  * Copyright(c) Developed by John Alves at 2018/$today.mouth/11 at 7:44:26 for quantic heart studios
 *
 */

package com.master.killercode.wizard.Splash.Shared;

import android.content.Context;
import android.content.SharedPreferences;

import com.master.killercode.wizard.Splash.Constant.SplashConstants;

public class GetSplashStatus {

    public static final String CONSTANTE_SHAREDPREFS_DO_PROJETO = "splashActivity";
    private final SharedPreferences Prefs;

    public GetSplashStatus(Context context) {
        Prefs = context.getSharedPreferences(CONSTANTE_SHAREDPREFS_DO_PROJETO, Context.MODE_PRIVATE);
    }

    public Boolean getStatusFrom(String nameSplash) {
        return Prefs.getBoolean(nameSplash, false);
    }

    public void setStatus(String nameSplash) {
        SharedPreferences.Editor editor = Prefs.edit();
        editor.putBoolean(nameSplash, true);
        editor.commit();
    }

    public Boolean getStatusDefault() {
        return Prefs.getBoolean(SplashConstants.splashDefaultName, false);
    }

    public void setStatusDefault() {
        SharedPreferences.Editor editor = Prefs.edit();
        editor.putBoolean(SplashConstants.splashDefaultName, true);
        editor.commit();
    }

}
