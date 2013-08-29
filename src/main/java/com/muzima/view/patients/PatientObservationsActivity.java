package com.muzima.view.patients;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.muzima.R;
import com.muzima.adapters.observations.ObservationsPagerAdapter;
import com.muzima.utils.Fonts;
import com.muzima.view.customViews.PagerSlidingTabStrip;

public class PatientObservationsActivity extends SherlockFragmentActivity {

	public boolean quickSearch = false;
    private ViewPager viewPager;
    private ObservationsPagerAdapter cohortPagerAdapter;
    private PagerSlidingTabStrip pagerTabsLayout;

    @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_patient_observations);
		
		Bundle extras = getIntent().getExtras();
        if (extras != null && "true".equals(extras.getString("quickSearch"))) {
            quickSearch = true;
        }
        // Show the Up button in the action bar.
		setupActionBar();
        initPager();
        initPagerIndicator();
	}

    private void initPagerIndicator() {
        pagerTabsLayout = (PagerSlidingTabStrip) findViewById(R.id.pager_indicator);
        pagerTabsLayout.setTextColor(Color.WHITE);
        pagerTabsLayout.setTextSize((int) getResources().getDimension(R.dimen.pager_indicator_text_size));
        pagerTabsLayout.setSelectedTextColor(getResources().getColor(R.color.tab_indicator));
        pagerTabsLayout.setTypeface(Fonts.roboto_medium(this), -1);
        pagerTabsLayout.setViewPager(viewPager);
        viewPager.setCurrentItem(0);
        pagerTabsLayout.markCurrentSelected(0);
    }

    private void initPager() {
        viewPager = (ViewPager) findViewById(R.id.pager);
        cohortPagerAdapter = new ObservationsPagerAdapter(getApplicationContext(), getSupportFragmentManager());
        viewPager.setAdapter(cohortPagerAdapter);
    }

	/**
	 * Set up the {@link android.app.ActionBar}.
	 */
	private void setupActionBar() {
		getActionBar().setDisplayHomeAsUpEnabled(true);
	}
}