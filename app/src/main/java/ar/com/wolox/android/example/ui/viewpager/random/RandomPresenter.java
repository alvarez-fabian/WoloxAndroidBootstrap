package ar.com.wolox.android.example.ui.viewpager.random;

import android.util.Log;

import java.util.Random;

import javax.inject.Inject;

import ar.com.wolox.android.example.model.ExampleModel;
import ar.com.wolox.android.example.utils.UserSession;
import ar.com.wolox.wolmo.core.presenter.BasePresenter;

/**
 * Basic Presenter that commands the View to display a username and generates random numbers when
 * {@link #generateRandomNumber()} is called.
 */
public final class RandomPresenter extends BasePresenter<IRandomView> {

    private static final String TAG = "RandomPresenter";

    private static final int NUMBER_MAX = 1000;
    private static final int NUMBER_MIN = 200;

    private UserSession mUserSession;
    private ExampleModel mExampleModel = new ExampleModel();

    @Inject
    RandomPresenter(UserSession userSession) {
        mUserSession = userSession;
    }

    @Override
    public void onViewAttached() {
        getView().showUsername(mUserSession.getUsername());
    }

    public void generateRandomNumber() {
        // Do some backend logic here, in this case generate just some random number
        // between a given range and update our model
        mExampleModel.someNumber = (new Random().nextInt((NUMBER_MAX - NUMBER_MIN) + 1)) + NUMBER_MIN;
        Log.i(TAG, "A new random number has been generated: " + mExampleModel.someNumber);

        // Notify the view so it can update the UI however it wants to
        getView().updateRandomNumber(mExampleModel.someNumber);
    }
}
