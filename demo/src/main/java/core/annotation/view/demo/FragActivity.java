package core.annotation.view.demo;

import android.os.Bundle;

import core.annotation.view.ContentView;

/**
 * @author DrkCore
 * @since 2017-07-11
 */
@ContentView(R.layout.activity_frag)
public class FragActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("FragActivity");
    }
}
