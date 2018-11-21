package jhlasso.gymfitness.Fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;


import jhlasso.gymfitness.Clases.EjercicioVo;
import jhlasso.gymfitness.Fragments.Tabs.TabEspaldaFragment;
import jhlasso.gymfitness.Fragments.Tabs.TabPechoFragment;
import jhlasso.gymfitness.IComunicaFragments;
import jhlasso.gymfitness.R;
import jhlasso.gymfitness.Fragments.Tabs.TabHombroFragment;

public class EjerciciosFragment extends Fragment {

    private AppBarLayout appBar;
    private TabLayout tabs;
    private ViewPager viewPager;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_ejercicios, container, false);

        View contenedor = (View) container.getParent();
        appBar =(AppBarLayout) contenedor.findViewById(R.id.appbar);
        tabs = new TabLayout(getActivity());
        tabs.setTabTextColors(Color.parseColor("#FFFFFF"),Color.parseColor("#FFFFFF"));
        appBar.addView(tabs);

        viewPager=(ViewPager)view.findViewById(R.id.pager);
        ViewPagerAdapter pagerAdapter=new ViewPagerAdapter(getFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        tabs.setupWithViewPager(viewPager);



        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        appBar.removeView(tabs);
    }


    public class ViewPagerAdapter extends FragmentStatePagerAdapter{
        public ViewPagerAdapter(FragmentManager fragmentManager){
            super(fragmentManager);
        }

        String[] titulosTabs = {getString(R.string.nombre_espalda),getString(R.string.nombre_pecho),getString(R.string.nombre_hombro)};

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:return new TabEspaldaFragment();
                case 1:return new TabPechoFragment();
                case 2:return new TabHombroFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return titulosTabs[position];
        }
    }

}
