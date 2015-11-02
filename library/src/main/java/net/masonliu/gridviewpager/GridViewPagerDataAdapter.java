package net.masonliu.gridviewpager;

import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;

public abstract class GridViewPagerDataAdapter  {
	public int sizeAll;
	public int rowInOnePage;
	public int columnInOnePage;
	public GridViewPagerDataAdapter(int sizeAll,int rowInOnePage,int columnInOnePage) {
		this.sizeAll = sizeAll;
		this.rowInOnePage = rowInOnePage;
		this.columnInOnePage = columnInOnePage;
	}

	public abstract BaseAdapter getGridViewAdapter(int sizeInOnePage, int pageIndex,int start,int end) ;
	public abstract void onItemClick(AdapterView<?> parent, View view, int position, long id, int pageIndex);
}
