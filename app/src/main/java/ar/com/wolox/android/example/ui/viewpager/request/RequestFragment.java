package ar.com.wolox.android.example.ui.viewpager.request;

import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import javax.inject.Inject;

import ar.com.wolox.android.R;
import ar.com.wolox.wolmo.core.fragment.WolmoFragment;
import ar.com.wolox.wolmo.core.util.ToastFactory;
import butterknife.BindView;

/**
 * Allows the user to request some news.
 */
public class RequestFragment extends WolmoFragment<RequestPresenter> implements IRequestView {

    @BindView(R.id.fragment_page2_toolbar) Toolbar mToolbar;
    @BindView(R.id.fragment_page2_title) TextView mTitle;
    @BindView(R.id.fragment_page2_body) TextView mBody;

    @Inject ToastFactory mToastFactory;

    @Inject
    public RequestFragment() {}

    @Override
    public int layout() {
        return R.layout.fragment_request;
    }

    @Override
    public void init() {
        mToolbar.setTitle(getString(R.string.page_2_toolbar_title));
    }

    @Override
    public void showNews(@NonNull String title, @NonNull String body) {
        mTitle.setText(title);
        mBody.setText(body);
    }

    @Override
    public void showError() {
        mToastFactory.show(R.string.unknown_error);
    }
}
