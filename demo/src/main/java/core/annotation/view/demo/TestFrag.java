package core.annotation.view.demo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import core.annotation.view.ContentView;

/**
 * @author DrkCore
 * @since 2017-07-11
 */
@ContentView(R.layout.frag_test)
public class TestFrag extends BaseFrag {

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView info = (TextView) view.findViewById(R.id.info);
        Button btn = (Button) view.findViewById(R.id.button);

        info.setText("Thanks for watching. Please let me know if my work inspires you or you have used it in you project.");
        btn.setText("Fork or star me on GitHub");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://github.com/DrkCore/ContentViewAnnotation");
                startActivity(new Intent(Intent.ACTION_VIEW, uri));
            }
        });
    }
}
