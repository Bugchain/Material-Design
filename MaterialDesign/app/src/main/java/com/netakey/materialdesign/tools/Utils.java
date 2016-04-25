package com.netakey.materialdesign.tools;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.view.Display;
import android.view.WindowManager;

import com.netakey.materialdesign.Contextor;

/**
 * Created by POSEIDON on 25/4/2559.
 */
public class Utils {

    public static boolean isAndroidVersionAboveLollipop(){
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP;
    }

    public static int getScreenWidth(){
        WindowManager windowManager = (WindowManager)Contextor.getInstance().getContext()
                .getSystemService(Context.WINDOW_SERVICE);
        Display screenSize = windowManager.getDefaultDisplay();
        Point size = new Point();
        screenSize.getSize(size);
        return size.x;
    }
    public static int getScreenHeight(){
        WindowManager windowManager = (WindowManager) Contextor.getInstance().getContext()
                .getSystemService(Context.WINDOW_SERVICE);
        Display screenSize = windowManager.getDefaultDisplay();
        Point size = new Point();
        screenSize.getSize(size);
        return size.y;
    }

    public static int pxToDp(int px){
        return (int) (px / Contextor.getInstance().getContext().getResources().getDisplayMetrics().density);
    }
    public static int dpToPx(int dp){
        return (int) (dp * Contextor.getInstance().getContext().getResources().getDisplayMetrics().density);
    }

    public static Drawable changeDrawableColor(int drawableId, int colorId){
        Drawable drawable = ContextCompat.getDrawable(Contextor.getInstance().getContext(),drawableId);
        drawable.setColorFilter(ContextCompat.getColor(Contextor.getInstance().getContext(),colorId), PorterDuff.Mode.SRC_ATOP);
        return drawable;
    }


}
