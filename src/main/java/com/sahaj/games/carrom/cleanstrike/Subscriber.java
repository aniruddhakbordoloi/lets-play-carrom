package com.sahaj.games.carrom.cleanstrike;

import com.sahaj.games.carrom.cleanstrike.striketypes.Strike;

/**
 * Created by Aniruddha on 17-11-2018.
 */
public interface Subscriber {
    void update(final Strike strike);
}
