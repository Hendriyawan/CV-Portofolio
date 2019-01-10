package id.gdev.mycvandportofolio.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindViews;
import butterknife.ButterKnife;
import id.gdev.mycvandportofolio.R;
import id.gdev.mycvandportofolio.adapter.SliderAdapter;
import id.gdev.mycvandportofolio.model.Portofolio;

/**
 * A simple {@link Fragment} subclass.
 */
public class PortofolioFragment extends Fragment {
    @BindViews({R.id.vp_slider_ads_script_parser, R.id.vp_slider_konversi_suhu, R.id.vp_slider_gnews, R.id.vp_slider_gencoder, R.id.vp_slider_gcolorpicker})
    List<ViewPager> vpSlider;

    @BindViews({R.id.dot_indicator_ads_script_parser, R.id.dot_indicator_konversi_suhu, R.id.dot_indicator_gnews, R.id.dot_indicator_gencoder, R.id.dot_indicator_gcolorpicker})
    List<TabLayout> indicator;

    public PortofolioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_portofolio, container, false);
        ButterKnife.bind(this, view);

        SliderAdapter adapterAdsScript = new SliderAdapter(getActivity(), getScreenshotAdsScriptParser());
        SliderAdapter adapterKonversiSuhu = new SliderAdapter(getActivity(), getScreenshotKonversiSuhu());
        SliderAdapter adapterGnews = new SliderAdapter(getActivity(), getScreenshotGnews());
        SliderAdapter adapterGencoder = new SliderAdapter(getActivity(), getScreenshotGencoder());
        SliderAdapter adapterGcolorpicker = new SliderAdapter(getActivity(), getScreenshotGcolorpicker());

        vpSlider.get(0).setAdapter(adapterAdsScript);
        vpSlider.get(1).setAdapter(adapterKonversiSuhu);
        vpSlider.get(2).setAdapter(adapterGnews);
        vpSlider.get(3).setAdapter(adapterGencoder);
        vpSlider.get(4).setAdapter(adapterGcolorpicker);

        indicator.get(0).setupWithViewPager(vpSlider.get(0), true);
        indicator.get(1).setupWithViewPager(vpSlider.get(1), true);
        indicator.get(2).setupWithViewPager(vpSlider.get(2), true);
        indicator.get(3).setupWithViewPager(vpSlider.get(3), true);
        indicator.get(4).setupWithViewPager(vpSlider.get(4), true);

        return view;
    }

    private List<Portofolio> getScreenshotAdsScriptParser() {
        List<Portofolio> screenshot = new ArrayList<>();
        screenshot.add(new Portofolio(R.drawable.ads_script_parser_0));
        screenshot.add(new Portofolio(R.drawable.ads_script_parser_1));
        screenshot.add(new Portofolio(R.drawable.ads_script_parser_2));
        return screenshot;
    }

    private List<Portofolio> getScreenshotKonversiSuhu() {
        List<Portofolio> screenshot = new ArrayList<>();
        screenshot.add(new Portofolio(R.drawable.temperature_conversion_0));
        screenshot.add(new Portofolio(R.drawable.temperature_conversion_1));
        screenshot.add(new Portofolio(R.drawable.temperature_conversion_2));
        return screenshot;
    }

    private List<Portofolio> getScreenshotGnews() {
        List<Portofolio> screenshot = new ArrayList<>();
        screenshot.add(new Portofolio(R.drawable.gnews_0));
        screenshot.add(new Portofolio(R.drawable.gnews_1));
        screenshot.add(new Portofolio(R.drawable.gnews_2));
        screenshot.add(new Portofolio(R.drawable.gnews_3));
        return screenshot;
    }

    private List<Portofolio> getScreenshotGencoder() {
        List<Portofolio> screenshot = new ArrayList<>();
        screenshot.add(new Portofolio(R.drawable.gencoder_0));
        screenshot.add(new Portofolio(R.drawable.gencoder_1));
        screenshot.add(new Portofolio(R.drawable.gencoder_2));
        screenshot.add(new Portofolio(R.drawable.gencoder_3));
        screenshot.add(new Portofolio(R.drawable.gencoder_4));
        return screenshot;
    }

    private List<Portofolio> getScreenshotGcolorpicker() {
        List<Portofolio> screenshot = new ArrayList<>();
        screenshot.add(new Portofolio(R.drawable.gcolorpicker_0));
        screenshot.add(new Portofolio(R.drawable.gcolorpicker_1));
        return screenshot;
    }
}
