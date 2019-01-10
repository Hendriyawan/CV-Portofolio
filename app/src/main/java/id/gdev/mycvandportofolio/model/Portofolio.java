package id.gdev.mycvandportofolio.model;

import android.support.annotation.DrawableRes;

public class Portofolio {
    @DrawableRes
    private int resId;

    public Portofolio(int resId) {
        this.resId = resId;
    }
    public int getResId(){
        return resId;
    }
}
