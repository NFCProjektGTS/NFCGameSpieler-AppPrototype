package gtsoffenbach.nfcgamespieler_appprototype.implementations;

/**
 * Created by Noli on 14.07.2014.
 */

import android.view.View.OnTouchListener;

import java.util.List;

import gtsoffenbach.nfcgamespieler_appprototype.gameinterface.Input;


public interface TouchHandler extends OnTouchListener {
    public boolean isTouchDown(int pointer);

    public int getTouchX(int pointer);

    public int getTouchY(int pointer);

    public List<Input.TouchEvent> getTouchEvents();
}