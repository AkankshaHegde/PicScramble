package com.picscramble.picscramble.mainscreen;

import com.picscramble.picscramble.util.CustomScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Akanksha on 04-May-17.
 */

@Module
public class PhotoGridModule {
    private final PhotoGridContract.View mView;

    public PhotoGridModule(PhotoGridContract.View inView) {
        mView = inView;
    }

    @Provides
    @CustomScope
    PhotoGridContract.View providesMainScreenContractView() {
        return mView;
    }

}