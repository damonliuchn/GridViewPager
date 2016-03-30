package net.masonliu.gridviewpager;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liumeng on 10/30/15.
 */
public class GridViewPager extends ViewPager {
    private List<GridView> mLists = new ArrayList<>();
    private GridViewPagerAdapter adapter;
    private List listAll;
    private int rowInOnePage;
    private int columnInOnePage;
    private GridViewPagerDataAdapter gridViewPagerDataAdapter;

    public GridViewPager(Context context) {
        super(context);
    }

    public GridViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public GridViewPagerDataAdapter getGridViewPagerDataAdapter() {
        return gridViewPagerDataAdapter;
    }

    public void setGridViewPagerDataAdapter(GridViewPagerDataAdapter gridViewPagerDataAdapter) {
        this.gridViewPagerDataAdapter = gridViewPagerDataAdapter;
        if (gridViewPagerDataAdapter.listAll == null || gridViewPagerDataAdapter.listAll.size() == 0) {
            return;
        }
        listAll = gridViewPagerDataAdapter.listAll;
        rowInOnePage = gridViewPagerDataAdapter.rowInOnePage;
        columnInOnePage = gridViewPagerDataAdapter.columnInOnePage;
        init();
    }

    public void init() {
        int sizeInOnePage = rowInOnePage * columnInOnePage;
        int pageCount = listAll.size() / sizeInOnePage;
        pageCount += listAll.size() % sizeInOnePage == 0 ? 0 : 1;
        if (mLists.size() > pageCount) {
            for (int i = mLists.size() - 1; i >= pageCount; i--) {
                mLists.remove(i);
            }
        }
        WrapContentGridView gv;
        int end;
        for (int i = 0; i < pageCount; i++) {
            final int pageIndex = i;
            if (i < mLists.size()) {
                gv = (WrapContentGridView) mLists.get(i);
            } else {
                gv = new WrapContentGridView(getContext());
                gv.setGravity(Gravity.CENTER);
                gv.setClickable(true);
                gv.setFocusable(true);
                mLists.add(gv);
            }
            gv.setNumColumns(columnInOnePage);
            end = Math.min((i + 1) * sizeInOnePage, listAll.size());
            gv.setAdapter(gridViewPagerDataAdapter.getGridViewAdapter(listAll.subList(i * sizeInOnePage, end), i));
            gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                    gridViewPagerDataAdapter.onItemClick(arg0, arg1, arg2, arg3, pageIndex);
                }
            });
        }
        adapter = new GridViewPagerAdapter(getContext(), mLists);
        setAdapter(adapter);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int height = 0;
        for (int i = 0; mLists != null && i < mLists.size(); i++) {
            View child = mLists.get(i);
            child.measure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
            int h = child.getMeasuredHeight();
            if (h > height)
                height = h;
        }
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(height + getPaddingBottom() + getPaddingTop(), MeasureSpec.EXACTLY);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
