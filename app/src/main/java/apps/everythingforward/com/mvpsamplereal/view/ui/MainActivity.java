package apps.everythingforward.com.mvpsamplereal.view.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import apps.everythingforward.com.mvpsamplereal.R;
import apps.everythingforward.com.mvpsamplereal.view.contracts.MainActivityContract;

public class MainActivity extends AppCompatActivity implements MainActivityContract{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void showContent() {

    }
}
