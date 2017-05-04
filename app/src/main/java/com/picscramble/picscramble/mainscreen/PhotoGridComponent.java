package com.picscramble.picscramble.mainscreen;

import com.picscramble.picscramble.network.component.NetComponent;
import com.picscramble.picscramble.util.CustomScope;

import dagger.Component;

/**
 * Created by Akanksha on 04-May-17.
 */

@CustomScope
@Component(dependencies = NetComponent.class, modules = PhotoGridModule.class)
public interface PhotoGridComponent {
    void inject(MainActivity activity);
}