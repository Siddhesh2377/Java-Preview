package com.dark.preview.views.members.layouts.LinearLayout;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.dark.preview.data.Props;

import java.util.Objects;

public class LinearLayoutView {

    public static final String TAG = "LinearLayout";
    private final Props props;
    private final Context context;

    private final LinearLayout linearLayout;

    public LinearLayoutView(Props props, Context context) {
        this.props = props;
        this.context = context;
        linearLayout = new LinearLayout(getContext());
        linearLayout.setLayoutParams(getParams());
        linearLayout.setOrientation(getOrientation());
        linearLayout.setGravity(getItemsAlign());
        linearLayout.setBackgroundColor(Color.parseColor(getBackgroundColor()));
    }

    public int getOrientation() {
        return props.orientation.equals("vertical") ? LinearLayout.VERTICAL : LinearLayout.HORIZONTAL;
    }

    public void setOrientation(String orientation) {
        props.orientation = orientation;
    }

    public int getItemsAlign() {
        switch (props.items_align) {
            case "center":
                return Gravity.CENTER;
            case "left":
                return Gravity.START;
            case "right":
                return Gravity.END;
            case "top":
                return Gravity.TOP;
            case "bottom":
                return Gravity.BOTTOM;
            case "right-top":
                return Gravity.END | Gravity.TOP;
            case "right-bottom":
                return Gravity.END | Gravity.BOTTOM;
            case "left-top":
                return Gravity.START | Gravity.TOP;
            case "left-bottom":
                return Gravity.START | Gravity.BOTTOM;
            default:
                return Gravity.CENTER;
        }

    }

    public void setItemsAlign(String items_align) {
        props.items_align = items_align;
    }

    public Context getContext() {
        return context;
    }

    public View getLayout() {
        return linearLayout;
    }


    public void addView(View view) {
        linearLayout.addView(view);
    }

    private ViewGroup.LayoutParams getParams() {
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        params.width = getWidth();
        params.height = getHeight();

        return params;
    }

    public String getBackgroundColor() {
        return Objects.requireNonNullElse(props.backgroundColor, "#454676");
    }

    public void setBackgroundColor(String color) {
        props.backgroundColor = color;
    }

    public int getWidth() {
        if (props.width.isEmpty()) {
            return ViewGroup.LayoutParams.MATCH_PARENT;
        } else if (props.width.equals("fill")) {
            return ViewGroup.LayoutParams.MATCH_PARENT;
        } else if (props.width.equals("wrap")) {
            return ViewGroup.LayoutParams.WRAP_CONTENT;
        } else {
            return Integer.parseInt(props.width);
        }
    }

    public void setWidth(String width) {
        props.width = width;
    }

    public void setWidth(int width) {
        props.width = String.valueOf(width);
    }

    public int getHeight() {
        if (props.height.isEmpty()) {
            return ViewGroup.LayoutParams.MATCH_PARENT;
        } else if (props.height.equals("fill")) {
            return ViewGroup.LayoutParams.MATCH_PARENT;
        } else if (props.height.equals("wrap")) {
            return ViewGroup.LayoutParams.WRAP_CONTENT;
        } else {
            return Integer.parseInt(props.height);
        }
    }

    public void setHeight(int height) {
        props.height = String.valueOf(height);
    }

    public void setHeight(String height) {
        props.height = height;
    }
}
