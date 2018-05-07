package ar.com.wolox.android.example.ui.example;

import android.app.Activity;

import javax.inject.Inject;

import ar.com.wolox.android.R;
import ar.com.wolox.wolmo.core.activity.WolmoActivity;

/**
 * A basic {@link Activity} that displays an {@link ExampleFragment}.
 */
public class ExampleActivity extends WolmoActivity {

    @Inject ExampleFragment mExampleFragment;

    @Override
    protected int layout() {
        return R.layout.activity_base;
    }

    @Override
    protected void init() {
        replaceFragment(R.id.activity_base_content, mExampleFragment);
    }
}
