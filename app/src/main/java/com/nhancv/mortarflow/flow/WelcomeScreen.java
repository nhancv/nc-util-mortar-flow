package com.nhancv.mortarflow.flow;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by nhancao on 6/11/16.
 */
public class WelcomeScreen implements Parcelable {
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    public WelcomeScreen() {
    }

    protected WelcomeScreen(Parcel in) {
    }

    public static final Parcelable.Creator<WelcomeScreen> CREATOR = new Parcelable.Creator<WelcomeScreen>() {
        @Override
        public WelcomeScreen createFromParcel(Parcel source) {
            return new WelcomeScreen(source);
        }

        @Override
        public WelcomeScreen[] newArray(int size) {
            return new WelcomeScreen[size];
        }
    };

    @Override
    public boolean equals(Object o) {
        return o != null && o instanceof WelcomeScreen;
    }
}
