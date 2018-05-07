package ar.com.wolox.android.example.utils;

import javax.inject.Inject;

import ar.com.wolox.wolmo.core.di.scopes.ApplicationScope;
import ar.com.wolox.wolmo.core.util.SharedPreferencesManager;

/**
 * Holds and manages all user related data.
 */
@ApplicationScope
public class UserSession {

    private SharedPreferencesManager mSharedPreferencesManager;
    private String mUsername;

    private static final String USER_LOGIN_EXTRA = "user_login";

    @Inject
    public UserSession(SharedPreferencesManager sharedPreferencesManager) {
        mSharedPreferencesManager = sharedPreferencesManager;
    }

    public void setUsername(String username) {
        mUsername = username;
        mSharedPreferencesManager.store(USER_LOGIN_EXTRA, username);
    }

    public String getUsername() {
        // Really, we don't need to query the username because this instance live as long as the
        // application, but we should add a check in case Android decides to kill the application
        // and return to a state where this isn't initialized.
        if (mUsername == null) {
            mUsername = mSharedPreferencesManager.get(USER_LOGIN_EXTRA, null);
        }
        return mUsername;
    }
}
