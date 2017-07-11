package core.annotation.view.demo;

import android.content.Intent;
import android.view.View;

import core.annotation.view.ContentView;

/**
 * @author DrkCore
 * @since 2017-07-11
 */
@ContentView(R.layout.activity_third)
public class ThirdActivity extends SecondActivity {

    @Override
    protected void init() {
        // super.init();

        info.setText("ThirdActivity is extended from SecondActivity and is annotated with R.layout.activity_third");

        btn.setText("Click me to start FragActivity");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ThirdActivity.this, FragActivity.class));
            }
        });
    }
}
