package com.yyermolenko.lazyviewholder;

import android.app.Activity;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public abstract class AbstractLazyViewHolder implements LazyHolder {

    protected SparseArray<View> holder = new SparseArray<>();

    @Override
    public void findAll() {
        findAll(getRootView());
    }

    protected abstract View getRootView();

    private void findAll(View view) {
        put(view);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                findAll(viewGroup.getChildAt(i));
            }
        }
    }

    @Override
    public View find(View view, int id) {
        View foundView = view.findViewById(id);
        if (foundView != null)
            put(id, foundView);

        return foundView;
    }

    @Override
    public View find(Activity activity, int id) {
        View foundView = activity.findViewById(id);
        if (foundView != null)
            put(id, foundView);

        return foundView;
    }

    @Override
    public void put(View view) {
        put(view.getId(), view);
    }

    @Override
    public void put(int id, View view) {
        if (id > 0)
            holder.put(id, view);
    }

    @Override
    public void putAll(LazyHolder lazyHolder) {
        AbstractLazyViewHolder alh = (AbstractLazyViewHolder) lazyHolder;
        for (int i = 0; i < alh.holder.size(); i++) {
            int id = alh.holder.keyAt(i);
            View view = alh.holder.get(id);
            put(id, view);
        }
    }

    @Override
    public void clear() {
        holder = new SparseArray<>();
    }

    @Override
    public void remove(int id) {
        holder.remove(id);
    }

    @Override
    public <T extends View> T find(Class<T> clazz, int id) {
        return clazz.cast(find(id));
    }

    @Override
    public TextView findTextView(int id) {
        return find(TextView.class, id);
    }

    @Override
    public Button findButton(int id) {
        return find(Button.class, id);
    }

    @Override
    public EditText findEditText(int id) {
        return find(EditText.class, id);
    }

    @Override
    public ImageView findImageView(int id) {
        return find(ImageView.class, id);
    }

    @Override
    public ViewGroup findViewGroup(int id) {
        return find(ListView.class, id);
    }

    @Override
    public ListView findListView(int id) {
        return find(ListView.class, id);
    }

}
