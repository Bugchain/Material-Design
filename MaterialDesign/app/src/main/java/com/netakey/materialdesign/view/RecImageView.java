package com.netakey.materialdesign.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by POSEIDON on 18/3/2559.
 */
public class RecImageView extends ImageView {
    public RecImageView(Context context) {
        super(context);
    }

    public RecImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RecImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = getMeasuredWidth();
        int height = (width * 9) / 16;
        setMeasuredDimension(width,height);

    }
}
