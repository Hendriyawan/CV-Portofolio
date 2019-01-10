package id.gdev.mycvandportofolio.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

import id.gdev.mycvandportofolio.R;
import id.gdev.mycvandportofolio.model.Portofolio;

public class SliderAdapter extends PagerAdapter {
    private Context context;
    private List<Portofolio> portofolio;

    public SliderAdapter(Context context, List<Portofolio> portofolio) {
        this.context = context;
        this.portofolio = portofolio;
    }

    @Override
    public int getCount() {
        return portofolio.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_slider, null);

        ImageView screenshot = view.findViewById(R.id.image_screenshot);
        Glide.with(context).load(portofolio.get(position).getResId()).into(screenshot);
        ViewPager vp = (ViewPager) container;
        vp.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup viewGroup, int position, Object object) {
        ViewPager vp = (ViewPager) viewGroup;
        View view = viewGroup;
        vp.removeView(view);
    }
}
