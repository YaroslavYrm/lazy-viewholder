package com.yyermolenko.lazyviewholder.sparsearrayimpl;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;

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

    @Override
    protected View getRootView() {
        return ((ViewGroup) activity
                .findViewById(android.R.id.content)).getChildAt(0);
    }
}
