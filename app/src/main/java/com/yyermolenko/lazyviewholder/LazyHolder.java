package com.yyermolenko.lazyviewholder;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public interface LazyHolder {

    View find(int id);

    View find(View view, int id);

    View find(Activity activity, int id);

    TextView findTextView(int id);

    Button findButton(int id);

    ImageView findImageView(int id);

    ViewGroup findViewGroup(int id);

}