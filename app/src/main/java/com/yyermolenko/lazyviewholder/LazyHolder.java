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

    /**
     * Find and hold view for future reuse.
     * Search is skipped if view was found already.
     *
     * @param id view id
     * @return view with specified id
     */
    View find(int id);

    /**
     * Eagle initialize {@link LazyHolder}.
     * Allow to iterate and store all views at once.
     * Avoid multiple search iterations within layout.
     * May increase performance in case of big view count or tree layout structure.
     */
    void findAll();

    /**
     * Search within specified view
     *
     * @return view with specified id
     */
    View find(View view, int id);

    /**
     * Search within specified activity
     *
     * @return view with specified id
     */
    View find(Activity activity, int id);

    /**
     * Manual put view into holder with real id.
     */
    void put(View view);

    /**
     * Manual put view into holder with specified id.
     *
     * @param id custom value
     */
    void put(int id, View view);

    void putAll(LazyHolder lazyHolder);

    void clear();

    void remove(int id);

    <T extends View> T find(Class<T> clazz, int id);

    TextView findTextView(int id);

    Button findButton(int id);

    EditText findEditText(int id);

    ImageView findImageView(int id);

    ViewGroup findViewGroup(int id);

    ListView findListView(int id);

}