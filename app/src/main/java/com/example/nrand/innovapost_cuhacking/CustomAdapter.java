package com.example.nrand.innovapost_cuhacking;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<DataModel> {

    private ArrayList<DataModel> dataSet;
    Context mContext;

    private static class ViewHolder {
        TextView txtProvider;
        TextView txtService;
        TextView txtPrice;
    }

    public CustomAdapter(@NonNull Context context, ArrayList<DataModel> objects) {
        super(context, R.layout.row_item, objects);
        dataSet = objects;
        mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        DataModel dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_item, parent, false);
            viewHolder.txtProvider = (TextView) convertView.findViewById(R.id.provider);
            viewHolder.txtPrice = (TextView) convertView.findViewById(R.id.amount);
            viewHolder.txtService = convertView.findViewById(R.id.service);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.txtProvider.setText(dataModel.getProvider());
        viewHolder.txtPrice.setText(dataModel.getPrice());
        viewHolder.txtService.setText(dataModel.getService());
        // Return the completed view to render on screen
        return convertView;
    }
}
