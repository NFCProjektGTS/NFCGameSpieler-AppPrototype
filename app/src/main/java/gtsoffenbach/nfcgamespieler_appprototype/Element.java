package gtsoffenbach.nfcgamespieler_appprototype;

import android.graphics.Rect;

import gtsoffenbach.nfcgamespieler_appprototype.gameinterface.Graphics;
import gtsoffenbach.nfcgamespieler_appprototype.gameinterface.Input;

/**
 * Created by Noli on 31.08.2014.
 */
public class Element {
    private UIElement father;
    private Rect rectangle;
    private boolean locked = false;
    private boolean enabled;
    private boolean visible;
    private Graphics graphics;
    private boolean pressed = true;

    Element(final UIElement father, final int sx, final int sy) {
        this.father = father;
        this.father.add(this);
        this.graphics = father.getGraphics();
        this.rectangle = new Rect(father.getRectangle().left, father.getRectangle().top, sx, sy);
        this.visible = true;
        this.enabled = true;
        //this.graphics = graphics;
    }

    public UIElement getFather() {
        return father;
    }

    public void setFather(UIElement father) {
        this.father = father;
    }

    public boolean isPressed() {
        return pressed;
    }

    public void setPressed(boolean toggle) {
        this.pressed = toggle;
    }

    public Rect getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rect rectangle) {
        this.rectangle = rectangle;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public Graphics getGraphics() {
        return graphics;
    }

    public void setGraphics(Graphics graphics) {
        this.graphics = graphics;
    }

    public void update(float delta) {
        if (enabled) {
            if (visible) {
                draw(delta);
            }
            //do other
        }
    }

    public void draw(float delta) {
    }


    public void onClick(Input.TouchEvent event) {
        if (enabled) {
            if (!locked) {
                if (event.type == Input.TouchEvent.TOUCH_UP) {
                    pressed = true;
                    Click();
                }
                if (event.type == Input.TouchEvent.TOUCH_DOWN) {
                    pressed = false;

                }
            }
        }
    }

    public void Click() {
    }


    public void dismiss() {
        this.graphics = null;
        this.father = null;
        this.enabled = false;
        this.rectangle = null;
        try {
            super.finalize();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }


}
