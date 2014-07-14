package gtsoffenbach.nfcgamespieler_appprototype.gameinterface;

/**
 * Created by Noli on 14.07.2014.
 */
public interface Game {

    public Audio getAudio();

    public Input getInput();

    public FileIO getFileIO();

    public Graphics getGraphics();

    public void setScreen(Screen screen);

    public Screen getCurrentScreen();

    public Screen getInitScreen();

    public NFC getNFC();

}
