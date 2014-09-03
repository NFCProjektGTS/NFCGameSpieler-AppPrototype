package gtsoffenbach.nfcgamespieler_appprototype;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.DragEvent;
import android.view.View;

import java.util.List;

import gtsoffenbach.nfcgamespieler_appprototype.gameinterface.Game;
import gtsoffenbach.nfcgamespieler_appprototype.gameinterface.Graphics;
import gtsoffenbach.nfcgamespieler_appprototype.gameinterface.Input;
import gtsoffenbach.nfcgamespieler_appprototype.gameinterface.Screen;

/**
 * Created by Noli on 03.09.2014.
 */
public class ProgressScreen extends Screen implements View.OnDragListener {
    private int lastLevel;
    private int selectedLevel;
    private ElementContainer container;
    private int speed = 0;
    private UIButton button;
    private float x, y;
    private Point last, now;

    public ProgressScreen(Game game, int lastlevel) {
        super(game);
        this.lastLevel = lastlevel;
        this.container = new ElementContainer(this, true);
        button = new UIButton(container, new Rect(0, 0, 800, 1280).centerX(), new Rect(0, 0, 800, 1280).centerY());
    }

    @Override
    public void paint(float deltaTime) {
        Graphics g = game.getGraphics();
        g.drawImage(Assets.progressBackground, 0, 0);
        container.updateAll(deltaTime, g);
    }



    @Override
    public void update(float deltaTime) {
        Graphics g = game.getGraphics();
        List<Input.TouchEvent> touchEvents = game.getInput().getTouchEvents();

        int len = touchEvents.size();
        for (int i = 0; i < len; i++) {
            Input.TouchEvent event = touchEvents.get(i);

            if (event.type == Input.TouchEvent.TOUCH_DOWN) {
                last = new Point(event.x, event.y);
            }
            if (event.type == Input.TouchEvent.TOUCH_DRAGGED) {
                now = new Point(event.x, event.y);
                this.speed = (int) ((now.x - last.x) / 10);
                button.getRectangle().offsetTo(button.getRectangle().left + speed, button.getRectangle().top);
            }
            if (event.type == Input.TouchEvent.TOUCH_UP) {

            }

        }


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
        game.setScreen(new GameScreen(game, lastLevel));
    }

    @Override
    public boolean onDrag(View v, DragEvent event) {
        if (event.getAction() == DragEvent.ACTION_DRAG_STARTED) {
            this.x = event.getX();
        }
        if (event.getAction() == DragEvent.ACTION_DRAG_ENDED) {
            this.speed = (int) (this.x - event.getX());
        }
        return false;
    }
}
