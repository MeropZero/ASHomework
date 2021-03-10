/*package com.example.first;

import android.widget.Filter;

import java.util.ArrayList;

public class MyFilter extends Filter {

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();
        if (mOriginalValues == null){
            synchronized (mLock){
                mOriginalValves = new ArrayList<String>(mListData);
            }
        }

        if (constraint == null || constraint.length() == 0){
            synchronized (mLock){
                ArrayList<String> list = new ArrayList(mOriginalValues);
                results.values = list;
                results.count = list.size();
            }
        }else{
            String constraintString = constraint.toString().toLowerCase();

            final ArrayList<String> values = mOriginalValues;
            final int count = values.size();

            ArrayList<String> newValues = new ArrayList<>(count);
            for (int i = 0; i < count; i++) {
                String value = values.get(i);
                if(value.getR)
            }
        }
    }
}
*/