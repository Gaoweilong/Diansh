package com.example.com.demo2_rikao;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by 高总 on 2018/5/10.
 */

public class MyAdapter extends BaseAdapter {

    private Context context;
    private List<ReaData.ResultBean.DataBean> list;

    public MyAdapter(Context context, List<ReaData.ResultBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView==null){
            convertView = View.inflate(context, R.layout.item, null);
            holder = new ViewHolder();
            holder.tv = convertView.findViewById(R.id.tv);
            holder.img = convertView.findViewById(R.id.img);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tv.setText(list.get(position).getTitle());
        ImageLoader.getInstance().displayImage(list.get(position).getUrl(), holder.img);
        return convertView;
    }

    class ViewHolder{
        ImageView img;
        TextView tv;
    }
}
