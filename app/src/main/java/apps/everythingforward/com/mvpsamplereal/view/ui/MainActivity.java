package apps.everythingforward.com.mvpsamplereal.view.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.orhanobut.logger.Logger;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

import apps.everythingforward.com.mvpsamplereal.R;
import apps.everythingforward.com.mvpsamplereal.events.PostsEvent;
import apps.everythingforward.com.mvpsamplereal.model.PostsModel;
import apps.everythingforward.com.mvpsamplereal.presenter.MainActivityPresenter;
import apps.everythingforward.com.mvpsamplereal.view.adapters.PostsRecyclerViewAdapter;
import apps.everythingforward.com.mvpsamplereal.view.contracts.MainActivityContract;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainActivityContract{

    MainActivityPresenter mainActivityPresenter;

    @BindView(R.id.recyvlerview)RecyclerView postsRecyclerView;

    PostsRecyclerViewAdapter postsRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        initRecyclerView();

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
        ArrayList<PostsModel> postsModels = (ArrayList<PostsModel>) event.getPosts();

        Logger.e("All the posts have been received!");

        postsRecyclerViewAdapter.addPosts(postsModels);


    }

    private void initRecyclerView()
    {
        postsRecyclerViewAdapter = new PostsRecyclerViewAdapter();
        postsRecyclerView.setAdapter(postsRecyclerViewAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        postsRecyclerView.setLayoutManager(layoutManager);
        postsRecyclerView.setHasFixedSize(true);
    }



}
