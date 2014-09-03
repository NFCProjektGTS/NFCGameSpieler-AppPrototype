package gtsoffenbach.nfcgamespieler_appprototype;

import gtsoffenbach.nfcgamespieler_appprototype.gameinterface.Game;
import gtsoffenbach.nfcgamespieler_appprototype.gameinterface.Graphics;
import gtsoffenbach.nfcgamespieler_appprototype.gameinterface.Graphics.ImageFormat;
import gtsoffenbach.nfcgamespieler_appprototype.gameinterface.Image;
import gtsoffenbach.nfcgamespieler_appprototype.gameinterface.Screen;

/**
 * Created by Noli on 05.08.2014.
 */
public class LoadingScreen extends Screen {
    public LoadingScreen(Game game) {

        super(game);
    }

    @Override
    public void update(float deltaTime) {
        Graphics g = game.getGraphics();
        Assets.menu = g.newImage("menu.jpg", ImageFormat.RGB565);
        Assets.background = g.newImage("background.jpg", ImageFormat.RGB565);

        Assets.button = g.newImage("buttonStock1h_0.png", ImageFormat.RGB565);
        Assets.button_pressed = g.newImage("buttonStock1d_1.png", ImageFormat.RGB565);
        Assets.chest = new Image[]{g.newImage("chest/chest001.png", ImageFormat.RGB565), g.newImage("chest/chest002.png", ImageFormat.RGB565), g.newImage("chest/chest003.png", ImageFormat.RGB565), g.newImage("chest/chest004.png", ImageFormat.RGB565), g.newImage("chest/chest005.png", ImageFormat.RGB565), g.newImage("chest/chest006.png", ImageFormat.RGB565), g.newImage("chest/chest007.png", ImageFormat.RGB565), g.newImage("chest/chest008.png", ImageFormat.RGB565), g.newImage("chest/chest009.png", ImageFormat.RGB565), g.newImage("chest/chest010.png", ImageFormat.RGB565), g.newImage("chest/chest011.png", ImageFormat.RGB565), g.newImage("chest/chest012.png", ImageFormat.RGB565)};
        Assets.progressBackground = g.newImage("backgrounds/background3.jpg", ImageFormat.RGB565);


        //This is how you would load a sound if you had one.
        //Assets.click = game.getAudio().createSound("explode.ogg");


        game.setScreen(new MainMenuScreen(game));

    }

    @Override
    public void paint(float deltaTime) {
        Graphics g = game.getGraphics();
        g.drawImage(Assets.splash, 0, 0);
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

    }
}