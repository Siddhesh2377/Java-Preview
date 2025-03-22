package com.dark.preview.views;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.dark.preview.data.UIElement;
import com.dark.preview.views.members.layouts.LinearLayout.LinearLayoutView;
import com.google.gson.Gson;

public class PreviewView extends ViewGroup {
    private UIElement uiElement;


    public PreviewView(Context context) {
        super(context);
        init();
    }

    public PreviewView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PreviewView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childCount = getChildCount();
        int top = 0;

        for (int i = 0; i < childCount; i++) {
            android.view.View child = getChildAt(i);
            int width = child.getMeasuredWidth();
            int height = child.getMeasuredHeight();

            child.layout(0, top, width, top + height);
            top += height;
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int totalHeight = 0;
        int maxWidth = 0;

        for (int i = 0; i < getChildCount(); i++) {
            android.view.View child = getChildAt(i);
            measureChild(child, widthMeasureSpec, heightMeasureSpec);
            totalHeight += child.getMeasuredHeight();
            maxWidth = Math.max(maxWidth, child.getMeasuredWidth());
        }

        setMeasuredDimension(resolveSize(maxWidth, widthMeasureSpec),
                resolveSize(totalHeight, heightMeasureSpec));
    }


    private void init() {
        setBackgroundColor(Color.WHITE);
    }

    public void feedData(String data) {
        Gson gson = new Gson();
        uiElement = gson.fromJson(data, UIElement.class);

        LinearLayoutView linearLayoutView = new LinearLayoutView(uiElement.props, getContext());

        Button button = new Button(getContext());
        button.setText("Click Me");
        button.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        ));


        linearLayoutView.addView(button);

        addView(linearLayoutView.getLayout());


        invalidate();
    }
}
