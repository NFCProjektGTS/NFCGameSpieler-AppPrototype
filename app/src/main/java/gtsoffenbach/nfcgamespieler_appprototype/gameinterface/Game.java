package gtsoffenbach.nfcgamespieler_appprototype.gameinterface;

import android.content.Context;

import gtsoffenbach.nfcgamespieler_appprototype.implementations.SaveGame;

/**
 * Created by Noli on 14.07.2014.
 */
public interface Game {

    public Audio getAudio();

    public Input getInput();

    public FileIO getFileIO();

    public Graphics getGraphics();

    public void setScreen(Screen screen);

    public SaveGame getSave();

    public void setSave(SaveGame save);

    public Screen getCurrentScreen();

    public Screen getInitScreen();

    public NFC getNFC();

    public Context getThiscontext();

}
