package org.raaufcodeforandroid.greennumbertunisia.controller;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.widget.Toast;

import java.util.Locale;

public class AreaController {
    private static Context context;
    private static Activity activity;
    private static AreaController areaController;
    public AreaController(Context context, Activity activity){
        context=context;
        activity=activity;
    }

    public static synchronized AreaController get_instance(Context context, Activity activity){
        if(areaController==null){
            areaController=new AreaController(context, activity);
        }
        return areaController;
    }

    public void setLocal(String language){
        Locale local=new Locale(language);
        Locale.setDefault(local);
        Configuration config=new Configuration();
        config.locale=local;
        activity.getBaseContext().getResources().updateConfiguration(config, activity.getBaseContext().getResources().getDisplayMetrics());

    }

}
