package ar.com.wolox.android.example.ui.viewpager.request;

import android.support.annotation.NonNull;

import javax.inject.Inject;

import ar.com.wolox.android.example.model.Post;
import ar.com.wolox.android.example.network.PostService;
import ar.com.wolox.wolmo.core.presenter.BasePresenter;
import ar.com.wolox.wolmo.networking.retrofit.RetrofitServices;
import ar.com.wolox.wolmo.networking.retrofit.callback.NetworkCallback;
import okhttp3.ResponseBody;

/**
 * Requests news and presents them to the view.
 */
public class RequestPresenter extends BasePresenter<IRequestView> {

    private static final int POST_ID = 1;

    @Inject RetrofitServices mRetrofitServices;

    @Inject
    RequestPresenter() {}

    @Override
    public void onViewAttached() {
        mRetrofitServices.getService(PostService.class).getPostById(POST_ID).enqueue(new NetworkCallback<Post>() {
            @Override
            public void onResponseSuccessful(final Post response) {
                runIfViewAttached(view -> view.showNews(response.getTitle(), response.getBody()));
            }

            @Override
            public void onResponseFailed(ResponseBody responseBody, int code) {
                runIfViewAttached(() -> getView().showError());
            }

            @Override
            public void onCallFailure(@NonNull Throwable t) {
                runIfViewAttached(() -> getView().showError());
            }
        });
    }
}
