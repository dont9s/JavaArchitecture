package com.example.javaarchitecture.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.javaarchitecture.R;

public class ImageTextView extends View {
    public static final int DEFAULT_IMAGE_SIZE = 10000;
    public static final int DEFAULT_TEXT_SIZE = 1000;
    private int textSize, imageSize;

    public ImageTextView(Context context) {
        super(context);
    }

    public ImageTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray array = context.getTheme().obtainStyledAttributes(attrs,
                R.styleable.ImageTextView,
                0, 0);
        try {
            textSize = array.getDimensionPixelSize(R.styleable.ImageTextView_text_size, DEFAULT_TEXT_SIZE);

            imageSize = array.getDimensionPixelSize(R.styleable.ImageTextView_image_size, DEFAULT_IMAGE_SIZE);
        } finally {
            array.recycle();
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        // Try for a width based on our minimum
        int minw = getPaddingLeft() + getPaddingRight() + getSuggestedMinimumWidth();
        int w = resolveSizeAndState(minw, widthMeasureSpec, 1);

        // Whatever the width ends up being, ask for a height that would let the pie
        // get as big as it can
        int minh = MeasureSpec.getSize(w) + getPaddingBottom() + getPaddingTop();
        int h = resolveSizeAndState(minh, heightMeasureSpec, 0);

        setMeasuredDimension(w, h);

    }

}
