package com.example.lab1_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class List51Adapter extends BaseAdapter {
    Context context;
    private final String[] values;
    private final String[] numbers;
    private final int[] images;

    public List51Adapter(Context context, String[] values, String[] numbers, int[] images) {
        this.context = context;
        this.values = values;
        this.numbers = numbers;
        this.images = images;
    }

    @Override
    public int getCount() {
        return values.length;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        final View result;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.item_listview5_1, parent, false);
            viewHolder.txtName = (TextView) convertView.findViewById(R.id.aNametxt);

            viewHolder.txtVersion = (TextView) convertView.findViewById(R.id.aVersiontxt);
            viewHolder.icon = (ImageView) convertView.findViewById(R.id.appIconIV);
            result = convertView;
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }
        viewHolder.txtName.setText(values[position]);
        viewHolder.txtVersion.setText("Version: " + numbers[position]);
        viewHolder.icon.setImageResource(images[position]);
        return convertView;
    }

    private static class ViewHolder {
        TextView txtName;
        TextView txtVersion;
        ImageView icon;
    }
}
