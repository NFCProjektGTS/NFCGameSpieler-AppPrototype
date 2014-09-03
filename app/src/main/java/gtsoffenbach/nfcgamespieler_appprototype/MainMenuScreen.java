package gtsoffenbach.nfcgamespieler_appprototype;

import android.graphics.Color;

import java.util.List;

import gtsoffenbach.nfcgamespieler_appprototype.gameinterface.Game;
import gtsoffenbach.nfcgamespieler_appprototype.gameinterface.Graphics;
import gtsoffenbach.nfcgamespieler_appprototype.gameinterface.Input;
import gtsoffenbach.nfcgamespieler_appprototype.gameinterface.Screen;
import gtsoffenbach.nfcgamespieler_appprototype.implementations.AndroidGame;

/**
 * Created by Noli on 30.07.2014.
 */
public class MainMenuScreen extends Screen {
    private ElementContainer container;
    private int levelselected = 0;
    UIButton button_start,button_settings,button_help;

    public MainMenuScreen(Game game) {
        super(game);
        container = new ElementContainer(this, true);
        button_start = new UIButton(container,104,479){
            @Override
            public void Click(){
                goToScreenGame();
            }
        };
        button_help = new UIButton(container,104,689){
            @Override
            public void Click(){

            }
        };

        button_settings = new UIButton(container,104,899) {
                @Override
                public void Click () {

                }
        };



    }

    private void goToScreenGame(){
        game.setScreen(new GameScreen(game, levelselected));
    }

    @Override
    public void update(float deltaTime) {
        Graphics g = game.getGraphics();
        List<Input.TouchEvent> touchEvents = game.getInput().getTouchEvents();

        int len = touchEvents.size();
        for (int i = 0; i < len; i++) {
            Input.TouchEvent event = touchEvents.get(i);
            container.processClick(event);
        }
    }

    private boolean inBounds(Input.TouchEvent event, int x, int y, int width,
                             int height) {
        if (event.x > x && event.x < x + width - 1 && event.y > y
                && event.y < y + height - 1)
            return true;
        else
            return false;
    }

    @Override
    public void paint(float deltaTime) {
        Graphics g = game.getGraphics();
        g.drawImage(Assets.menu, 0, 0);
        container.updateAll(deltaTime,g);


    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }

    @Override
    public void backButton() {
        android.os.Process.killProcess(android.os.Process.myPid());
    }
}
