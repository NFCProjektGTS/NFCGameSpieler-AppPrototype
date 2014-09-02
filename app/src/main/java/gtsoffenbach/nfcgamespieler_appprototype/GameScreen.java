package gtsoffenbach.nfcgamespieler_appprototype;


import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import java.util.ArrayList;
import java.util.List;

import gtsoffenbach.nfcgamespieler_appprototype.gameinterface.Game;
import gtsoffenbach.nfcgamespieler_appprototype.gameinterface.Graphics;
import gtsoffenbach.nfcgamespieler_appprototype.gameinterface.Image;
import gtsoffenbach.nfcgamespieler_appprototype.gameinterface.Input.TouchEvent;
import gtsoffenbach.nfcgamespieler_appprototype.gameinterface.Screen;
import gtsoffenbach.nfcgamespieler_appprototype.implementations.AndroidGame;

/**
 * Created by Noli on 05.08.2014.
 */
public class GameScreen extends Screen {
    private static Background bg1, bg2;
    GameState state = GameState.Ready;

    // Variable Setup
    int livesLeft = 1;
    Paint paint, paint2, paint3;
    private Image currentSprite;
    private Animation anim, hanim;
    private ArrayList tilearray = new ArrayList();
    private BlinkingText text;
    private ElementContainer container;
    private UIButton firstbutton;

    public GameScreen(Game game) {
        super(game);

        // Initialize game objects here

        bg1 = new Background(0, 0);
        bg2 = new Background(AndroidGame.width, 0);

        // Defining a paint object
        paint = new Paint();
        paint.setTextSize(30);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setAntiAlias(true);
        paint.setColor(Color.WHITE);


        paint2 = new Paint();
        paint2.setTextSize(100);
        paint2.setTextAlign(Paint.Align.CENTER);
        paint2.setAntiAlias(true);
        paint2.setColor(Color.WHITE);

        paint3 = new Paint();
        paint3.setTextSize(100);
        paint3.setTextAlign(Paint.Align.CENTER);
        paint3.setAntiAlias(true);
        paint3.setColor(Color.BLACK);
        paint3.setAlpha(50);

        container = new ElementContainer(this, true);
        firstbutton = new UIButton(container, (AndroidGame.width - Assets.button.getWidth()) / 2, AndroidGame.height - Assets.button.getHeight());
        firstbutton.setGraphics(game.getGraphics());
        //container.addElement(firstbutton);

        //game.getGraphics().drawString("Tap to Start.", 400, 240, paint);
        text = new BlinkingText("Blinking!", 50, Color.BLACK, 0.02, 200, 550);
    }

    public static Background getBg1() {
        // TODO Auto-generated method stub
        return bg1;
    }

    public static Background getBg2() {
        // TODO Auto-generated method stub
        return bg2;
    }

    @Override
    public void update(float deltaTime) {
        List touchEvents = game.getInput().getTouchEvents();

        // We have four separate update methods in this example.
        // Depending on the state of the game, we call different update methods.
        // Refer to Unit 3's code. We did a similar thing without separating the
        // update methods.

        if (state == GameState.Ready)
            updateReady(touchEvents);
        if (state == GameState.Running)
            updateRunning(touchEvents, deltaTime);
        if (state == GameState.Paused)
            updatePaused(touchEvents);
    }

    private void updateReady(List touchEvents) {

        // This example starts with a "Ready" screen.
        // When the user touches the screen, the game begins.
        // state now becomes GameState.Running.
        // Now the updateRunning() method will be called!

        if (touchEvents.size() > 0)
            state = GameState.Running;
    }

    private void updateRunning(List touchEvents, float deltaTime) {

        // This is identical to the update() method from our Unit 2/3 game.

        // 1. All touch input is handled here:
        int len = touchEvents.size();
        for (int i = 0; i < len; i++) {
            TouchEvent event = (TouchEvent) touchEvents.get(i);
            container.processClick(event);
        }


        // 3. Call individual update() methods here.
        // This is where all the game updates happen.
        // For example, robot.update();
        //text.update(deltaTime);

        bg1.update();
        bg2.update();
        animate();

    }


    private void updatePaused(List touchEvents) {
        int len = touchEvents.size();
        for (int i = 0; i < len; i++) {
            TouchEvent event = (TouchEvent) touchEvents.get(i);
            if (event.type == TouchEvent.TOUCH_UP) {    //TODO TOUCH EVENTS
                if (Utils.inBounds(event, new Rect(0, 0, 800, 240))) {

                    if (!Utils.inBounds(event, new Rect(0, 0, 35, 35))) {
                        resume();
                    }
                }

                if (Utils.inBounds(event, new Rect(0, 240, 800, 240))) {
                    nullify();
                    goToMenu();
                }
            }
        }
    }

    @Override
    public void paint(float deltaTime) {
        Graphics g = game.getGraphics();

        g.drawImage(Assets.background, bg1.getBgX(), bg1.getBgY());
        g.drawImage(Assets.background, bg2.getBgX(), bg2.getBgY());

        text.update(g);

        // First draw the game elements.

        // Example:
        // g.drawImage(Assets.background, 0, 0);
        // g.drawImage(Assets.character, characterX, characterY);

        // Secondly, draw the UI above the game elements.
        if (state == GameState.Ready)
            drawReadyUI();
        if (state == GameState.Running)
            drawRunningUI(deltaTime);
        if (state == GameState.Paused)
            drawPausedUI();

    }

    public void animate() {
//        anim.update(10);
        //       hanim.update(50);
    }

    private void nullify() {

        // Set all variables to null. You will be recreating them in the
        // constructor.
        paint = null;
        bg1 = null;
        bg2 = null;
        currentSprite = null;
        anim = null;
        hanim = null;

        // Call garbage collector to clean up memory.
        System.gc();

    }

    private void drawReadyUI() {
        Graphics g = game.getGraphics();

        g.drawARGB(155, 0, 0, 0);
        g.drawString("Tap to Start.", 400, 240, paint);

    }

    private void drawRunningUI(float deltaTime) {
        Graphics g = game.getGraphics();
        container.updateAll(deltaTime, g);

        /*g.drawImage(Assets.button, 0, 285, 0, 0, 60, 60);
        g.drawImage(Assets.button, 0, 350, 0, 65, 60, 60);
        g.drawImage(Assets.button, 0, 415, 0, 130, 60, 60);
        g.drawImage(Assets.button, 0, 0, 0, 195, 60, 60);*/


    }

    private void drawPausedUI() {
        Graphics g = game.getGraphics();
        // Darken the entire screen so you can display the Paused screen.
        g.drawARGB(155, 0, 0, 0);
        g.drawString("Resume", 400, 165, paint2);
        g.drawString("Menu", 400, 360, paint2);

    }

    @Override
    public void pause() {
        if (state == GameState.Running)
            state = GameState.Paused;

    }

    @Override
    public void resume() {
        if (state == GameState.Paused)
            state = GameState.Running;
    }

    @Override
    public void dispose() {
    }

    @Override
    public void backButton() {
        pause();
    }

    private void goToMenu() {
        // TODO Auto-generated method stub
        game.setScreen(new MainMenuScreen(game));

    }

    enum GameState {
        Ready, Running, Paused
    }

}