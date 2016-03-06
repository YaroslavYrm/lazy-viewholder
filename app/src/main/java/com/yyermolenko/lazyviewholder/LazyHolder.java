package com.yyermolenko.lazyviewholder;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public interface LazyHolder {

    View find(int id);

    View find(View view, int id);

    View find(Activity activity, int id);

    <T extends View> T find(Class<T> clazz, int id);

    TextView findTextView(int id);

    Button findButton(int id);

    EditText findEditText(int id);

    ImageView findImageView(int id);

    ViewGroup findViewGroup(int id);

    ListView findListView(int id);

}