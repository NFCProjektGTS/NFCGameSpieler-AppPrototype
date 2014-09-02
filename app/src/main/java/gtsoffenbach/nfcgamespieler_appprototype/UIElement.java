package gtsoffenbach.nfcgamespieler_appprototype;

import android.graphics.Rect;

import java.util.ArrayList;

import gtsoffenbach.nfcgamespieler_appprototype.gameinterface.Graphics;
import gtsoffenbach.nfcgamespieler_appprototype.gameinterface.Input;

/**
 * Created by Noli on 31.08.2014.
 */
public class UIElement {
    private ElementContainer container;
    private Rect rectangle;
    private ArrayList<UIElement> childs = new ArrayList<UIElement>();
    private boolean locked = false;
    private boolean enabled;
    private boolean visible;
    private Graphics graphics;
    private boolean pressed = true;

    UIElement(final ElementContainer container, final int dx, final int dy, final int sx, final int sy) {
        this.rectangle = new Rect(dx, dy, sx, sy);
        this.container = container;
        this.container.addElement(this);
        this.visible = true;
        this.enabled = true;
        //this.graphics = graphics;
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

    public ArrayList<UIElement> getChilds() {
        return childs;
    }

    public void setChilds(ArrayList<UIElement> childs) {
        this.childs = childs;
    }

    public ElementContainer getContainer() {
        return container;
    }

    public void setContainer(ElementContainer container) {
        this.container = container;
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
                draw();
            }
            //do other
        }
    }

    public void draw() {
    }


    public void onClick(Input.TouchEvent event) {
        if (enabled) {
            if (!locked) {
                boolean hit = false;
                for (UIElement element : childs) {
                    if (Utils.inBounds(event, element.getRectangle())) {
                        element.onClick(event);
                        hit = true;
                        break;
                    }
                }
                if (!hit) { //there was no inner element of this element hit, so bring this element to foreground
                    container.bringToForeground(this);
                    if (event.type == Input.TouchEvent.TOUCH_UP) {
                        pressed = true;
                    }
                    if (event.type == Input.TouchEvent.TOUCH_DOWN) {
                        pressed = false;
                    }

                }
            }
        }
    }

    public void Click() {
    }


    public void add(UIElement element) {
        this.childs.add(element);
    }

    public void add(UIElement[] elements) {
        for (UIElement element : elements) {
            container.addElement(element);
        }
    }
}
