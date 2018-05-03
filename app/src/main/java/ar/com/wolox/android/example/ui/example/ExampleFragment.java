package ar.com.wolox.android.example.ui.example;

import android.content.Intent;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;

import javax.inject.Inject;

import ar.com.wolox.android.R;
import ar.com.wolox.android.example.ui.viewpager.ViewpagerActivity;
import ar.com.wolox.wolmo.core.fragment.WolmoFragment;
import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnTextChanged;

public class ExampleFragment extends WolmoFragment<ExamplePresenter> implements IExampleView {

    // Views (using Butterknife)
    @BindView(R.id.fragment_example_username) TextView mUsername;
    @BindView(R.id.fragment_example_login) Button mGoToViewpager;

    @Inject
    public ExampleFragment() {}

    @Override
    public int layout() {
        return R.layout.fragment_example;
    }

    @Override
    public void init() {
        mGoToViewpager.setEnabled(false);
    }

    @OnTextChanged(R.id.fragment_example_username)
    protected void onUsernameChanged(CharSequence value) {
        mGoToViewpager.setEnabled(!TextUtils.isEmpty(value));
    }

    @OnClick(R.id.fragment_example_login)
    public void onGoToViewpage() {
        getPresenter().storeUsername(mUsername.getText().toString());
    }

    public void onUsernameSaved() {
        Intent intent = new Intent(getActivity(), ViewpagerActivity.class);
        startActivity(intent);
    }
}
