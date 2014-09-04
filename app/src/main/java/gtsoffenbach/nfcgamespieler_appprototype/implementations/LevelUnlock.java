package gtsoffenbach.nfcgamespieler_appprototype.implementations;

import gtsoffenbach.nfcgamespieler_appprototype.GameScreen;
import gtsoffenbach.nfcgamespieler_appprototype.ProgressScreen;
import gtsoffenbach.nfcgamespieler_appprototype.gameinterface.Game;

/**
 * Created by Noli on 04.09.2014.
 */
public class LevelUnlock {


    public static void unlock(Game game, int level) {
        GameScreen lastscreen = (GameScreen) game.getCurrentScreen();
        SaveGame.levels[level].setUnlocked(true);
        game.getSave().save();
        ProgressScreen unlockscreen = new ProgressScreen(game, 0, level);
        game.setScreen(unlockscreen);
        unlockscreen.loadChest(lastscreen);

        //game.setScreen(lastscreen);
    }

    /*public void lock(){

    }*/
}
