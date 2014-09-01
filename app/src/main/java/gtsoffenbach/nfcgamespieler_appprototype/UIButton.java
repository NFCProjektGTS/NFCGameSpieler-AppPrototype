package gtsoffenbach.nfcgamespieler_appprototype;

import gtsoffenbach.nfcgamespieler_appprototype.gameinterface.Graphics;

/**
 * Created by Noli on 01.09.2014.
 */
public class UIButton extends UIElement {
    boolean toggle = true;

    UIButton(final ElementContainer container, final Graphics graphics, final int dx, final int dy, final int sx, final int sy) {
        super(container, dx, dy, sx, sy, graphics);
    }

    @Override
    public void draw() {
        if (toggle) {
            //getGraphics().drawImage(Assets.button,getRectangle().left,getRectangle().top, 0, 0,getRectangle().width(),getRectangle().height());
            //getGraphics().drawImage(Assets.button,getRectangle().left,getRectangle().top, getRectangle().width(), getRectangle().height() );
            getGraphics().drawImage(Assets.button, getRectangle().left, getRectangle().top);
        } else {
            //getGraphics().drawImage(Assets.button_pressed,getRectangle().left,getRectangle().top, 0, 0,getRectangle().width(),getRectangle().height());
            getGraphics().drawImage(Assets.button_pressed, getRectangle().left, getRectangle().top);
        }
    }

    @Override
    public void Click() {
        toggle = !toggle;
    }
}
