package ar.com.wolox.android.example.ui.viewpager;

import javax.inject.Inject;

import ar.com.wolox.android.R;
import ar.com.wolox.android.example.ui.viewpager.fragment.ViewPagerFragment;
import ar.com.wolox.wolmo.core.activity.WolmoActivity;
import dagger.Lazy;

/**
 * Simple {@link android.app.Activity} that displays a {@link ViewPagerFragment}.
 */
public class ViewPagerActivity extends WolmoActivity {

    @Inject Lazy<ViewPagerFragment> mLazyViewpagerFragment;

    @Override
    protected int layout() {
        return R.layout.activity_base;
    }

    @Override
    protected void init() {
        replaceFragment(R.id.activity_base_content, mLazyViewpagerFragment.get());
    }
}
