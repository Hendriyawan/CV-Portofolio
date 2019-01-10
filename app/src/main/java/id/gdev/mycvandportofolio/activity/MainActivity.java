package id.gdev.mycvandportofolio.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.gdev.mycvandportofolio.R;
import id.gdev.mycvandportofolio.fragment.CVFragment;
import id.gdev.mycvandportofolio.fragment.PortofolioFragment;
import id.gdev.mycvandportofolio.widget.ImageProfile;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.img_profile)
    ImageProfile imageProfile;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.view_pager)
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //bind view
        ButterKnife.bind(this);

        Glide.with(this).load(R.drawable.hendriyawan).into(imageProfile);


        setupViewPager();
    }

    private void setupViewPager() {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(getResources().getDrawable(R.drawable.ic_account_circle));
        tabLayout.getTabAt(1).setIcon(getResources().getDrawable(R.drawable.ic_book));
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        String ABOUT_ME = getResources().getString(R.string.tab_title_aboutme);
        String PORTOFOLIO = getResources().getString(R.string.tab_title_portofolio);
        String[] title = {ABOUT_ME, PORTOFOLIO};

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new CVFragment();

                case 1:
                    return new PortofolioFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return title.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return title[position];
        }
    }
}
