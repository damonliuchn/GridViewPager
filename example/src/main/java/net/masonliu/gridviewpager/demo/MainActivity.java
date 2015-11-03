package net.masonliu.gridviewpager.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;

import net.masonliu.gridviewpager.GridViewPager;
import net.masonliu.gridviewpager.GridViewPagerDataAdapter;

import java.util.Arrays;
import java.util.List;

/**
 * Created by liumeng on 10/30/15.
 */
public class MainActivity extends Activity {

    private String[] mStrs = new String[]{"01", "02", "03", "04", "05", "06",
            "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17",
            "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28",
            "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39",
            "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50",
            "51", "52", "53", "54", "55", "56", "57", "58", "59", "60"};

    private GridViewPager mViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final List<String> list= Arrays.asList(mStrs);
        mViewPager = (GridViewPager) findViewById(R.id.myviewpager);
        mViewPager.setGridViewPagerDataAdapter(new GridViewPagerDataAdapter<String>(list, 2, 4) {
            @Override
            public BaseAdapter getGridViewAdapter(List<String> currentList,int pageIndex) {
                return new MyGridViewAdapter(getApplicationContext(), currentList);
            }

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id, int pageIndex) {

            }
        });
    }
}
