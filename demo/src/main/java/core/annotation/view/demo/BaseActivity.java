package core.annotation.view.demo;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import core.annotation.view.ContentViews;

/**
 * @author DrkCore
 * @since 2017-07-11
 */
public abstract class BaseActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Only call ContentViews.get(this) in you base class
        setContentView(ContentViews.get(this));
    }
}
