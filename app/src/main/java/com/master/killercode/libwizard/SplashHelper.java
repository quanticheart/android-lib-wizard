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
 *  * Copyright(c) Developed by John Alves at 2018/$today.mouth/11 at 6:53:20 for quantic heart studios
 *
 */

package com.master.killercode.libwizard;

import android.app.Activity;

import com.master.killercode.wizard.GetWizardStatus;
import com.master.killercode.wizard.Splash.Create.CreateSplash;
import com.master.killercode.wizard.Splash.Shared.GetSplashStatus;
import com.master.killercode.wizard.Wizard.WizardActivity;
import com.master.killercode.wizard.Wizard.WizardPageModel;

import java.util.ArrayList;

class SplashHelper {

    private ArrayList<WizardPageModel> wList = new ArrayList<>(); // create array for Page Wizard

    SplashHelper(Activity activity) {

        // init e create Pages for Wizard
        WizardPageModel page1 = new WizardPageModel("Hello!");
        wList.add(page1); // add page in arrayPages for Wizard

        WizardPageModel page2 = new WizardPageModel("Bem vindo", "O ZooBook espera por você!");
        wList.add(page2);

        WizardPageModel page3 = new WizardPageModel("ZooBook", "Poste fotos dos seus pets e divulgue os na internet com o ZooBook, e muito simples! \n Divirta-se!", R.mipmap.ic_launcher);
        wList.add(page3);

        GetSplashStatus splashStatus = new GetSplashStatus(activity);

        if (!splashStatus.getStatusDefault()) {
            new CreateSplash().Make(activity).setTextTitle(activity.getResources().getString(R.string.app_name)).setWizardList(wList).show();
        }

    }
}
