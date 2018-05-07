package ar.com.wolox.android.example.ui.example;

import android.support.annotation.NonNull;

import javax.inject.Inject;

import ar.com.wolox.android.example.utils.UserSession;
import ar.com.wolox.wolmo.core.presenter.BasePresenter;

/**
 * Login example presenter which allows the user to login with a mandatory.
 */
public class ExamplePresenter extends BasePresenter<IExampleView> {

    private UserSession mUserSession;

    @Inject
    public ExamplePresenter(UserSession userSession) {
        mUserSession = userSession;
    }

    public void onLogin(@NonNull String login) {
        mUserSession.setUsername(login);
        getView().finishLogin();
    }
}
