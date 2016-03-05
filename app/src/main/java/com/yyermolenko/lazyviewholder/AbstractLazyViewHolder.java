package com.yyermolenko.lazyviewholder;

import android.app.Activity;
import android.util.SparseArray;
import android.view.View;

public abstract class AbstractLazyViewHolder {

    protected SparseArray<View> holder = new SparseArray<>();

    abstract View find(int id);

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

}
