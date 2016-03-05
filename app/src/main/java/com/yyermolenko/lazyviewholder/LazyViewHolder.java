package com.yyermolenko.lazyviewholder;

import android.view.View;

public class LazyViewHolder extends AbstractLazyViewHolder {

    private final View rootView;

    public LazyViewHolder(View rootView) {
        this.rootView = rootView;
    }

    public View find(int id) {
        View view = holder.get(id);
        if (view == null) {
            view = find(rootView, id);
        }

        return view;
    }
}
