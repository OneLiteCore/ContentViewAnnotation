package core.annotation.view.demo;

import android.app.Activity;
import android.os.Bundle;

import core.annotation.view.ContentView;
import core.annotation.view.ContentViews;

@ContentView(R.layout.activity_main)
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(ContentViews.get(this));
    }
}
