package gtsoffenbach.nfcgamespieler_appprototype;

import java.util.ArrayList;

import gtsoffenbach.nfcgamespieler_appprototype.gameinterface.Graphics;
import gtsoffenbach.nfcgamespieler_appprototype.gameinterface.Input;
import gtsoffenbach.nfcgamespieler_appprototype.gameinterface.Screen;

/**
 * Created by Noli on 31.08.2014.
 */
public class ElementContainer {
    private ArrayList<UIElement> elements = new ArrayList<UIElement>();
    private Screen screen;
    private boolean enabled;

    ElementContainer(Screen screen, boolean visible) {
        this.screen = screen;
        enabled = true;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void bringToForeground(UIElement element) {
        if (elements.contains(element)) {
            elements.remove(element);
            elements.add(element);
        }
    }

    public void addElement(UIElement element) {
        elements.add(element);
    }

    public void updateAll(float delta, Graphics graphics) {
        if (enabled) {
            for (UIElement element : elements) {
                element.setGraphics(graphics);
                element.update(delta);
            }
        }
    }

    public void processClick(Input.TouchEvent event) {
        if (enabled && elements.size() != 0) {
            for (int i = elements.size(); i > 0; i--) {
                UIElement element = elements.get(i - 1);
                if (Utils.inBounds(event, element.getRectangle())) {
                    element.onClick(event);
                }
            }
        }
    }
}
