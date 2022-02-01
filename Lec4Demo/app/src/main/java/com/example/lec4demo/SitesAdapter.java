package com.example.lec4demo;

import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.core.content.res.ResourcesCompat;

import java.util.List;

public class SitesAdapter extends BaseAdapter {
    List<SiteAttraction> sitesData;
    List<String> SitesNamesList;
    List<Integer> SitesPicsList;

    public SitesAdapter(List<String> sitesNamesList, List<Integer> sitesPicsList) {
        SitesNamesList = sitesNamesList;
        SitesPicsList = sitesPicsList;
    }

    @Override
    public int getCount() {
        return SitesNamesList.size(); // returns the size of the data
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
      if (view==null){
          // inflate the view
          LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
          view = layoutInflater.inflate(R.layout.layout_siteitem, viewGroup, false);
      }
        TextView txtViewSiteItem = view.findViewById(R.id.textViewSiteItem);
        txtViewSiteItem.setText(SitesNamesList.get(i));

        Drawable img = ResourcesCompat.getDrawable(viewGroup.getResources(),
                SitesPicsList.get(i), viewGroup.getContext().getTheme());

        img.setBounds(0,0,80,80);
        txtViewSiteItem.setCompoundDrawables(img,null, null, null);
        txtViewSiteItem.setCompoundDrawablePadding(8);
        txtViewSiteItem.setGravity(Gravity.LEFT| Gravity.CENTER_VERTICAL);
        return view;
    }
}
