package id.gdev.mycvandportofolio.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

import id.gdev.mycvandportofolio.R;

public class ImageProfile extends AppCompatImageView {
    private Paint paint;
    private Path path;

    public ImageProfile(Context context) {
        super(context);
    }

    public ImageProfile(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ImageProfile(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    private void init() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(getResources().getDisplayMetrics().density);
        paint.setColor(ContextCompat.getColor(getContext(), R.color.colorAccent));
        path = new Path();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldW, int oldH) {
        super.onSizeChanged(w, h, oldW, oldH);
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int w = getWidth(), h = getHeight();
        if (w > 0 && h > 0) {
            canvas.save();
            float r = Math.min(w / 2, h / 2) - 3;
            path.reset();
            path.addCircle(w / 2, h / 2, r, Path.Direction.CW);
            canvas.clipPath(path);
            super.onDraw(canvas);
            canvas.restore();
            canvas.drawCircle(w / 2, h / 2, r, paint);
        } else {
            super.onDraw(canvas);
        }
    }
}
