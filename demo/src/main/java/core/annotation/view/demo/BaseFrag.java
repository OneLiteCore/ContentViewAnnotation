package core.annotation.view.demo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import core.annotation.view.ContentViews;

/**
 * @author DrkCore
 * @since 2017-07-11
 */
public abstract class BaseFrag extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Only call ContentViews.get(this) in you base class
        return inflater.inflate(ContentViews.get(this), container, false);
    }
}
