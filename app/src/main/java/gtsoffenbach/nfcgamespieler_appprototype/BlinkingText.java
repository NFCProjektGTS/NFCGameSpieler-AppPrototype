package gtsoffenbach.nfcgamespieler_appprototype;

import android.graphics.Paint;

/**
 * Created by Noli on 28.08.2014.
 */
public class BlinkingText extends Element {
    //private Graphics graphics;
    private Paint paint;
    private String msg;
    private boolean toggle;
    private double speed;


    BlinkingText(UIElement father, int sx, int sy, String msg, int size, int color, double speed) {
        super(father, sx, sy);
        this.speed = speed;
        this.msg = msg;
        paint = new Paint();
        paint.setTextSize(size);
        paint.setTextAlign(Paint.Align.CENTER); //no parameter yet
        paint.setAntiAlias(true);
        paint.setColor(color);
        paint.setAlpha(50);
        toggle = true;

    }

    public Paint getPaint() {
        return paint;
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    @Override
    public void draw(float delta) {

            /*try {
                Thread.currentThread().sleep(Math.round(time * 1000 / 255));
            } catch (Exception e) {
                e.printStackTrace();
            }*/
        int alpha = paint.getAlpha();
        if (alpha < 255 && toggle) {
            alpha += (int) (255 * speed);
            if (alpha > 255)
                alpha = 255;
            paint.setAlpha(alpha);
        }
        if (paint.getAlpha() == 255 && toggle)
            toggle = !toggle;
        if (alpha <= 255 && !toggle) {
            alpha -= (int) (255 * speed);
            if (alpha < 0)
                alpha = 0;
            paint.setAlpha(alpha);
        }
        if (paint.getAlpha() == 0 && !toggle)
            toggle = !toggle;

        getGraphics().drawString(msg, getRectangle().left, getRectangle().top, paint);
    }
}
