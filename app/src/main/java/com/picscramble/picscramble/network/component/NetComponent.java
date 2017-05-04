package com.picscramble.picscramble.network.component;

import com.picscramble.picscramble.network.module.AppModule;
import com.picscramble.picscramble.network.module.NetModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by Akanksha on 04-May-17.
 */

@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {
    Retrofit retrofit();
}

