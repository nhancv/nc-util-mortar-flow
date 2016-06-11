package com.nhancv.mortarflow.flow;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by nhancao on 6/11/16.
 */
public class HelloScreen implements Parcelable {
    final String name;

    public HelloScreen(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
    }

    protected HelloScreen(Parcel in) {
        this.name = in.readString();
    }

    public static final Parcelable.Creator<HelloScreen> CREATOR = new Parcelable.Creator<HelloScreen>() {
        @Override
        public HelloScreen createFromParcel(Parcel source) {
            return new HelloScreen(source);
        }

        @Override
        public HelloScreen[] newArray(int size) {
            return new HelloScreen[size];
        }
    };

    //Config to get Key
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HelloScreen that = (HelloScreen) o;

        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
