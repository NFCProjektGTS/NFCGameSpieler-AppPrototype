package gtsoffenbach.nfcgamespieler_appprototype.implementations;

/**
 * Created by Noli on 05.08.2014.
 */

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.PowerManager;

import gtsoffenbach.nfcgamespieler_appprototype.gameinterface.Audio;
import gtsoffenbach.nfcgamespieler_appprototype.gameinterface.FileIO;
import gtsoffenbach.nfcgamespieler_appprototype.gameinterface.Game;
import gtsoffenbach.nfcgamespieler_appprototype.gameinterface.Graphics;
import gtsoffenbach.nfcgamespieler_appprototype.gameinterface.Input;
import gtsoffenbach.nfcgamespieler_appprototype.gameinterface.NFC;
import gtsoffenbach.nfcgamespieler_appprototype.gameinterface.Screen;

public class AndroidGame extends Activity implements Game {


    GameFastRenderView renderView;
    Graphics graphics;
    Audio audio;
    Input input;
    FileIO fileIO;
    Screen screen = getInitScreen();
    PowerManager.WakeLock wakeLock;
    NFC nfc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);*/


        //setContentView(R.layout.activity_fullscreen);

        boolean isPortrait = getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT;
        int frameBufferWidth = isPortrait ? 800 : 1280;
        int frameBufferHeight = isPortrait ? 1280 : 800;
        Bitmap frameBuffer = Bitmap.createBitmap(frameBufferWidth,
                frameBufferHeight, Bitmap.Config.RGB_565);

        float scaleX = (float) frameBufferWidth
                / getWindowManager().getDefaultDisplay().getWidth();
        float scaleY = (float) frameBufferHeight
                / getWindowManager().getDefaultDisplay().getHeight();

        renderView = new GameFastRenderView(this, frameBuffer);
        graphics = new GameGraphics(getAssets(), frameBuffer);
        fileIO = new GameFileIO(this);
        audio = new GameAudio(this);
        input = new GameInput(this, renderView, scaleX, scaleY);
        screen = getInitScreen();
        setContentView(renderView);


        PowerManager powerManager = (PowerManager) getSystemService(Context.POWER_SERVICE);
        wakeLock = powerManager.newWakeLock(PowerManager.FULL_WAKE_LOCK, "MyGame");
        wakeLock.acquire();
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        // Trigger the initial hide() shortly after the activity has been
        // created, to briefly hint to the user that UI controls
        // are available.


        // delayedHide(100);
    }

    /**
     * Schedules a call to hide() in [delay] milliseconds, canceling any
     * previously scheduled calls.
     */

    @Override
    public Input getInput() {
        return input;
    }

    @Override
    public FileIO getFileIO() {
        return fileIO;
    }

    @Override
    public Graphics getGraphics() {
        return graphics;
    }

    @Override
    public Audio getAudio() {
        return audio;
    }

    @Override
    public NFC getNFC() {
        return nfc;
    }

    @Override
    public void setScreen(Screen screen) {
        if (screen == null)
            throw new IllegalArgumentException("Screen must not be null");

        this.screen.pause();
        this.screen.dispose();
        screen.resume();
        screen.update(0);
        this.screen = screen;
    }

    @Override
    public Screen getCurrentScreen() {

        return screen;
    }

    @Override
    public Screen getInitScreen() { //TODO


        return screen; // default, weil kein InitScreen festgelegt, evtl ladebildschirm?
    }

    @Override
    public void onBackPressed() {
        getCurrentScreen().backButton();
    }
}