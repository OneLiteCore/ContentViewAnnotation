package core.annotation.view.demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import core.annotation.view.ContentView;

/**
 * @author DrkCore
 * @since 2017-07-11
 */
@ContentView(R.layout.activity_first)
public class FirstActivity extends BaseActivity {

    TextView info;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(getClass().getSimpleName());

        // ContentViewAnnotation is ONLY designed for getting ContentView layout id
        // You are highly recommended to use ButterKnife with this lib, to deal with these FindByIds
        // ButterKnife GitHub: https://github.com/JakeWharton/butterknife
        info = (TextView) findViewById(R.id.info);
        btn = (Button) findViewById(R.id.button);

        init();
    }

    protected void init() {
        info.setText("FirstActivity class is annotated by ContentView to find R.layout.activity_first");

        btn.setText("Click me to start SecondActivity");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FirstActivity.this, SecondActivity.class));
            }
        });
    }
}
