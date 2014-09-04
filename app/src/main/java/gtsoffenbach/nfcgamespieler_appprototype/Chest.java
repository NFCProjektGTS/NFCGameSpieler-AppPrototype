package gtsoffenbach.nfcgamespieler_appprototype;

import gtsoffenbach.nfcgamespieler_appprototype.gameinterface.Image;
import gtsoffenbach.nfcgamespieler_appprototype.gameinterface.Input;

/**
 * Created by Noli on 03.09.2014.
 */
public class Chest extends Element {
    private Animation chest_anim = new Animation();
    private int speed, finalshow;

    Chest(UIElement father, int sx, int sy, int speed, int finalshow) {
        super(father, sx, sy);
        this.chest_anim = new Animation();
        this.speed = speed;
        this.finalshow = finalshow;
        for (int i = 0; i < Assets.chest.length - 1; i++) {
            chest_anim.addFrame(Assets.chest[i], speed);
        }
        chest_anim.addFrame(Assets.chest[Assets.chest.length - 1], finalshow);
    }

    @Override
    public void update(float delta) {
        chest_anim.update(50);
        super.update(delta);
    }

    @Override
    public void draw(float delta) {
        Image image = chest_anim.getImage();
        // getGraphics().drawImage(image,getRectangle().left,getRectangle().top,getRectangle().right,getRectangle().bottom,getRectangle().right/2,getRectangle().bottom/2);
        //getGraphics().drawImage(image,0,0,Assets.chest[0].getWidth(),Assets.chest[0].getHeight(),Assets.chest[0].getWidth()/2,Assets.chest[0].getHeight()/2);
        // super.draw(delta);
        getGraphics().drawScaledImage(image, 0, 0, Assets.chest[0].getWidth() / 2, Assets.chest[0].getHeight() / 2, 0, 0, Assets.chest[0].getWidth(), Assets.chest[0].getHeight());
    }

    @Override
    public void onClick(Input.TouchEvent event) {
        super.onClick(event);
    }

    @Override
    public void Click() {
        super.Click();
    }

    @Override
    public void dismiss() {
        super.dismiss();
    }
}
