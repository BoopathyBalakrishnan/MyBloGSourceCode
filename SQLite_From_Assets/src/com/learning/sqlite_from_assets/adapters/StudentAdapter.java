/**
 * 
 */
package com.learning.sqlite_from_assets.adapters;

import com.learning.sqlite_from_assets.R;
import com.learning.sqlite_from_assets.models.StudentsInformationModel;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * @author Boopathy Balakrishnan
 * 
 * @version 1.0
 */
public class StudentAdapter extends BaseAdapter  {
    private static final String ADAPTER_TAG = "StudentAdapter";
    Context mContext;
    List<StudentsInformationModel> list;

    public StudentAdapter(Context mContext, List<StudentsInformationModel> list) {
        super();
        this.mContext = mContext;
        this.list = list;
    }

    @Override
    public int getCount() {
        Log.i(ADAPTER_TAG, String.valueOf(list.size()));
        return list.size();
    }

    @Override
    public Object getItem(int arg0) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        StudentsInformationModel contactListItems = list.get(position);
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.row, null);
        }
        TextView tvName = (TextView) convertView.findViewById(R.id.name);
        tvName.setText(contactListItems.getName());
        TextView tvDept = (TextView) convertView.findViewById(R.id.dept);
        tvDept.setText(contactListItems.getDept());
        return convertView;
    }


}
