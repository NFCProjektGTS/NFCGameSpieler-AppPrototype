package gtsoffenbach.nfcgamespieler_appprototype;

import android.graphics.Paint;

import gtsoffenbach.nfcgamespieler_appprototype.gameinterface.Graphics;

/**
 * Created by Noli on 28.08.2014.
 */
public class BlinkingText {
    //private Graphics graphics;
    private Paint paint;
    private String msg;
    private int x, y;
    private boolean toggle;
    private double speed;

    BlinkingText(String msg, int size, int color, double speed, int x, int y) {
        this.speed = speed;
        this.msg = msg;
        this.x = x;
        this.y = y;
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

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void update(Graphics g) {

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

        g.drawString(msg, x, y, paint);
    }
}
