package com.yyermolenko.lazyviewholder;

import android.app.Activity;
import android.view.View;

public class LazyActivityViewHolder extends AbstractLazyViewHolder {

    private final Activity activity;

    public LazyActivityViewHolder(Activity activity) {
        this.activity = activity;
    }

    public View find(int id) {
        View view = holder.get(id);
        if (view == null) {
            view = find(activity, id);
        }

        return view;
    }
}
