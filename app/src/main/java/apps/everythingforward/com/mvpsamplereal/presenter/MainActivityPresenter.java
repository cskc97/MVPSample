package apps.everythingforward.com.mvpsamplereal.presenter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import apps.everythingforward.com.mvpsamplereal.model.PostsModel;
import apps.everythingforward.com.mvpsamplereal.network.HttpRequest;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.Functions;

/**
 * Created by santh on 4/14/2017.
 */

public class MainActivityPresenter {


    String apiURL = "http://jsonplaceholder.typicode.com/posts";

    Observable postsObservable;
    Subscriber<ArrayList<PostsModel>> mainActivitySubscriber;

    public MainActivityPresenter()
    {

        postsObservable = Observable.just(apiURL)
                .map(new Function<String, ArrayList<PostsModel>>() {
                    @Override
                    public ArrayList<PostsModel> apply(String urlValue) throws Exception {
                        return listOfPosts(getJSONString(urlValue));
                    }
                });

        mainActivitySubscriber = new Subscriber<ArrayList<PostsModel>>() {
            @Override
            public void onSubscribe(Subscription s) {

            }

            @Override
            public void onNext(ArrayList<PostsModel> postsModels) {

            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {

            }
        };

    }

    private void initializePostsObservable()
    {





    }

    private ArrayList<PostsModel> listOfPosts(String jsonString)
    {

        Gson gson = new Gson();
        ArrayList<PostsModel> returnPosts = returnPosts=gson.fromJson(jsonString,new TypeToken<List<PostsModel>>(){}.getType());

        return returnPosts;

    }

    private String getJSONString(String apiURL)
    {
        try {
            String jsonString = HttpRequest.get(new URL(apiURL)).body().toString();
            return jsonString;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return null;

    }


}
