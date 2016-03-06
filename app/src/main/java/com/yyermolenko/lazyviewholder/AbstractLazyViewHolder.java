package com.yyermolenko.lazyviewholder;

import android.app.Activity;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public abstract class AbstractLazyViewHolder implements LazyHolder {

    protected SparseArray<View> holder = new SparseArray<>();

    @Override
    public View find(View view, int id) {
        View foundView = view.findViewById(id);
        if (foundView != null)
            holder.put(id, foundView);

        return foundView;
    }

    @Override
    public View find(Activity activity, int id) {
        View foundView = activity.findViewById(id);
        if (foundView != null)
            holder.put(id, foundView);

        return foundView;
    }

    @Override
    public TextView findTextView(int id) {
        return (TextView) find(id);
    }

    @Override
    public Button findButton(int id) {
        return (Button) find(id);
    }

    @Override
    public ImageView findImageView(int id) {
        return (ImageView) find(id);
    }

    @Override
    public ViewGroup findViewGroup(int id) {
        return (ViewGroup) find(id);
    }

}
