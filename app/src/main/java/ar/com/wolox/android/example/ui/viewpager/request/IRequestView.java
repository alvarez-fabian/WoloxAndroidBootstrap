package ar.com.wolox.android.example.ui.viewpager.request;

import android.support.annotation.NonNull;

/**
 * Simple news view that allows showing a news title and body, as well as an an error.
 */
public interface IRequestView {

    void showNews(@NonNull String title, @NonNull String body);

    void showError();
}
