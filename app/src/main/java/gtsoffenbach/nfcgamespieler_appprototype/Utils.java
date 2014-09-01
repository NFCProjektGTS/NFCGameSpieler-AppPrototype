package gtsoffenbach.nfcgamespieler_appprototype;

import android.graphics.Rect;

import java.nio.ByteBuffer;

import gtsoffenbach.nfcgamespieler_appprototype.gameinterface.Input;

/**
 * Created by Noli on 31.08.2014.
 */
public class Utils {
    public static String convertByteArrayToHexString(byte[] array) {
        StringBuilder hex = new StringBuilder(array.length * 2);
        for (byte b : array) {
            hex.append(String.format("%02X ", b));
        }
        return hex.toString();
    }

    public static long convertByteArrayToDecimal(byte[] array) {
        ByteBuffer bb = ByteBuffer.wrap(array);
        return bb.getLong();
    }

    public static boolean inBounds(Input.TouchEvent event, Rect rect) {
        if (event.x > rect.left && event.x < rect.left + rect.width() - 1 && event.x > rect.top
                && event.y < rect.top + rect.height() - 1)
            return true;
        else
            return false;
    }
}
