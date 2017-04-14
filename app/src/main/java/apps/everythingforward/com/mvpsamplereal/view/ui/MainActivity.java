package apps.everythingforward.com.mvpsamplereal.view.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import apps.everythingforward.com.mvpsamplereal.R;
import apps.everythingforward.com.mvpsamplereal.events.PostsEvent;
import apps.everythingforward.com.mvpsamplereal.presenter.MainActivityPresenter;
import apps.everythingforward.com.mvpsamplereal.view.contracts.MainActivityContract;

public class MainActivity extends AppCompatActivity implements MainActivityContract{

    MainActivityPresenter mainActivityPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();

        mainActivityPresenter = new MainActivityPresenter();
        showContent();


    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);

    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void showContent() {

        mainActivityPresenter.loadPosts();

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onObtainingAllPosts(PostsEvent event)
    {


    }
}
