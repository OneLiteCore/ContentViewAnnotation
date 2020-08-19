package core.annotation.view.demo;

import android.content.Intent;
import android.view.View;

/**
 * @author DrkCore
 * @since 2017-07-11
 */
public class SecondActivity extends FirstActivity {

    @Override
    protected void init() {
        // super.init();

        info.setText("SecondActivity is extended from FirstActivity with out annotation, \n" +
                "so ContentViews.get() will still return its parent annotated layout, \n" +
                "which is R.layout.activity_first");

        btn.setText("Click me to start ThirdActivity");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SecondActivity.this, ThirdActivity.class));
            }
        });
    }
}
