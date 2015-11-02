package net.masonliu.gridviewpager.demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import java.util.List;

public class MyGridViewAdapter extends BaseAdapter {

    private Context mContext;
    private List<String> mLists;

    public MyGridViewAdapter(Context pContext, List<String> mLists) {
        this.mContext = pContext;
        this.mLists = mLists;

    }

    @Override
    public int getCount() {

        return mLists.size();
    }

    @Override
    public Object getItem(int position) {

        return mLists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        Holder holder = null;
        if (null == convertView) {
            holder = new Holder();
            LayoutInflater mInflater = LayoutInflater.from(mContext);
            convertView = mInflater.inflate(R.layout.gridview_item, null);
            holder.btn_gv_item = (Button) convertView.findViewById(R.id.btn_gv_item);
            holder.btn_gv_item.setFocusable(false);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        holder.btn_gv_item.setText(mLists.get(position));

        return convertView;
    }

    private static class Holder {
        Button btn_gv_item;
    }

}
