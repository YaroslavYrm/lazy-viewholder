package com.yyermolenko.lazyviewholder;

import android.app.Activity;
import android.util.SparseArray;
import android.view.View;

public abstract class AbstractLazyViewHolder implements LazyHolder {

    protected SparseArray<View> holder = new SparseArray<>();

    public View find(View view, int id) {
        View foundView = view.findViewById(id);
        if (foundView != null)
            holder.put(id, foundView);

        return foundView;
    }

    public View find(Activity activity, int id) {
        View foundView = activity.findViewById(id);
        if (foundView != null)
            holder.put(id, foundView);

        return foundView;
    }

    @Override
    public void put(View view) {
        put(view.getId(), view);
    }

    @Override
    public void put(int id, View view) {
        holder.put(id, view);
    }

    @Override
    public void clear() {
        holder = new SparseArray<>();
    }

    @Override
    public void remove(int id) {
        holder.remove(id);
    }
}
