package com.picscramble.picscramble.app;

import android.app.Application;

import com.picscramble.picscramble.network.component.DaggerNetComponent;
import com.picscramble.picscramble.network.component.NetComponent;
import com.picscramble.picscramble.network.module.AppModule;
import com.picscramble.picscramble.network.module.NetModule;

/**
 * Created by Akanksha on 04-May-17.
 */

public class PicScrambleApplication extends Application {
    private NetComponent mNetComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mNetComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("https://api.flickr.com/services/rest/"))
                .build();
    }

    public NetComponent getNetComponent() {
        return mNetComponent;
    }
}
