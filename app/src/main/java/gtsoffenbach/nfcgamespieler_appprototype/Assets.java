package gtsoffenbach.nfcgamespieler_appprototype;

import gtsoffenbach.nfcgamespieler_appprototype.gameinterface.Image;
import gtsoffenbach.nfcgamespieler_appprototype.gameinterface.Music;
import gtsoffenbach.nfcgamespieler_appprototype.gameinterface.Sound;
import gtsoffenbach.nfcgamespieler_appprototype.implementations.AndroidGame;

/**
 * Created by Noli on 30.07.2014.
 */
public class Assets {

    public static Image menu, splash, background;
    public static Image button;
    public static Sound click;
    public static Music theme;

    public static void load(AndroidGame game) {
        // TODO Auto-generated method stub
        theme = game.getAudio().createMusic("menutheme.mp3");
        theme.setLooping(true);
        theme.setVolume(0.85f);
        theme.play();
    }

}