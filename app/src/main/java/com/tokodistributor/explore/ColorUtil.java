package com.tokodistributor.explore;

import android.graphics.Color;

public class ColorUtil {
    public static int setupColorAlpha(int itemPosition) {
        int color = Color.parseColor("#FFFFFF");
        if (itemPosition > 0) {
            int alpha = (itemPosition << 24) | (-1 >>> 8);
            color &= (alpha);
        }

        return color;
    }
}
