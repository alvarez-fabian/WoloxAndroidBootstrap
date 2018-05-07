package ar.com.wolox.android.example.ui.viewpager.random;

import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.TextView;

import javax.inject.Inject;

import ar.com.wolox.android.R;
import ar.com.wolox.wolmo.core.fragment.WolmoFragment;
import butterknife.BindColor;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Displays a username and random numbers through {@link TextView}s. Allows regenerating a random
 * number through {@link Button} actions.
 */
public class RandomFragment extends WolmoFragment<RandomPresenter> implements IRandomView {

    @BindView(R.id.fragment_page1_toolbar) Toolbar mToolbar;
    @BindView(R.id.fragment_page1_title) TextView mFragmentViewpagerTitle;
    @BindView(R.id.fragment_page1_message_text_view) TextView mFragmentPage1MessageTextView;
    @BindView(R.id.fragment_page1_randomize_button) Button mFragmentPage1RandomizeButton;

    @BindColor(R.color.colorPrimary) int mColorPrimary;

    @Inject
    public RandomFragment() {}

    @Override
    public int layout() {
        return R.layout.fragment_random;
    }

    @Override
    public void init() {
        mToolbar.setTitle(getString(R.string.page_1_toolbar_title));
    }

    @Override
    public void showUsername(@NonNull String username) {
        mFragmentViewpagerTitle.setText(getString(R.string.page_1_title, username));
    }

    @OnClick(R.id.fragment_page1_randomize_button)
    void onRandomClick() {
        getPresenter().generateRandomNumber();
    }

    @Override
    public void updateRandomNumber(int someNumber) {
        mFragmentPage1MessageTextView.setText(getString(R.string.example_message, someNumber));
    }
}
