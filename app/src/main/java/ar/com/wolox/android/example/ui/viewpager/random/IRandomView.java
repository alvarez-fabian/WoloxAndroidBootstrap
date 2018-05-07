package ar.com.wolox.android.example.ui.viewpager.random;

import android.support.annotation.NonNull;

/**
 * A random number simple view that also allows displaying a username.
 */
public interface IRandomView {

    void showUsername(@NonNull String username);

    void updateRandomNumber(int someNumber);
}
