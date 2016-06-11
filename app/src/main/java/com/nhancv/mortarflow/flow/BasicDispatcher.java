package com.nhancv.mortarflow.flow;

import android.app.Activity;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nhancv.mortarflow.R;

import flow.Dispatcher;
import flow.Traversal;
import flow.TraversalCallback;

/**
 * Created by nhancao on 6/11/16.
 */
public class BasicDispatcher implements Dispatcher {

    private final Activity activity;

    BasicDispatcher(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void dispatch(@NonNull Traversal traversal, @NonNull TraversalCallback callback) {
        Log.d("BasicDispatcher", "dispatching " + traversal);
        Object dest = traversal.destination.top();

        ViewGroup frame = (ViewGroup) activity.findViewById(R.id.basic_activity_frame);

        if (traversal.origin != null) {
            if (frame.getChildCount() > 0) {
                traversal.getState(traversal.origin.top()).save(frame.getChildAt(0));
                frame.removeAllViews();
            }
        }

        @LayoutRes final int layout;
        if (dest instanceof HelloScreen) {
            layout = R.layout.hello_screen;
        } else if (dest instanceof WelcomeScreen) {
            layout = R.layout.welcome_screen;
        } else {
            throw new AssertionError("Unrecognized screen " + dest);
        }

        View incomingView = LayoutInflater.from(traversal.createContext(dest, activity)) //
                .inflate(layout, frame, false);

        frame.addView(incomingView);
        traversal.getState(traversal.destination.top()).restore(incomingView);

        callback.onTraversalCompleted();
    }
}