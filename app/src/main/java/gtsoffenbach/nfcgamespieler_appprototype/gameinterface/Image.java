package gtsoffenbach.nfcgamespieler_appprototype.gameinterface;


import gtsoffenbach.nfcgamespieler_appprototype.gameinterface.Graphics.ImageFormat;

/**
 * Created by Noli on 14.07.2014.
 */
public interface Image {
    public int getWidth();

    public int getHeight();

    public ImageFormat getFormat();

    public void dispose();
}
