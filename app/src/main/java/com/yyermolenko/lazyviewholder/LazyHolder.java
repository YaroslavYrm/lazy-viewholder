package com.yyermolenko.lazyviewholder;

import android.app.Activity;
import android.view.View;

public interface LazyHolder {

    View find(int id);

    View find(View view, int id);

    View find(Activity activity, int id);

}