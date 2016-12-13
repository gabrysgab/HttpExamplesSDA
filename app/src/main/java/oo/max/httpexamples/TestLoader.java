package oo.max.httpexamples;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.Loader;
import android.widget.TextView;

public class TestLoader implements LoaderManager.LoaderCallbacks<String> {

    private final TextView textView;
    private final Context context;

    public TestLoader(TextView textView, Context context) {
        this.textView = textView;
        this.context = context;
    }

    @Override
    public Loader<String> onCreateLoader(int id, Bundle args) {
        return new AsyncTaskLoader<String>(context) {
            @Override
            protected void onStartLoading() {
                super.onStartLoading();
                forceLoad();
            }

            @Override
            public String loadInBackground() {

                return null;
            }
        };
    }


    @Override
    public void onLoadFinished(Loader<String> loader, final String data) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                handleResult(data);
            }
        });
    }

    private void handleResult(String data) {
        textView.setText(data);
        //handle fragments here
    }

    @Override
    public void onLoaderReset(Loader<String> loader) {

    }

}