package gtsoffenbach.nfcgamespieler_appprototype.implementations;

import android.graphics.Bitmap;

import gtsoffenbach.nfcgamespieler_appprototype.gameinterface.Graphics.ImageFormat;
import gtsoffenbach.nfcgamespieler_appprototype.gameinterface.Image;

/**
 * Created by Noli on 14.07.2014.
 */
public class GameImage implements Image {
    Bitmap bitmap;
    ImageFormat format;

    public GameImage(Bitmap bitmap, ImageFormat format) {
        this.bitmap = bitmap;
        this.format = format;
    }

    @Override
    public int getWidth() {
        return bitmap.getWidth();
    }

    @Override
    public int getHeight() {
        return bitmap.getHeight();
    }

    @Override
    public ImageFormat getFormat() {
        return format;
    }

    @Override
    public void dispose() {
        bitmap.recycle();
    }
}