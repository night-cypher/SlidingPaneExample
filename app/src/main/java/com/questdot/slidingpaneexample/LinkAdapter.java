package com.questdot.slidingpaneexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import java.util.List;

public class LinkAdapter extends ArrayAdapter<Bookmark> {
	
	private List<Bookmark> bookList;
	private Context ctx;
	
	public LinkAdapter(List<Bookmark> bookList, Context ctx) {
		super(ctx, R.layout.link_list_item, bookList);
		this.ctx = ctx;
		this.bookList = bookList;
	}

	@Override
	public int getCount() {
		return bookList.size();
	}

	@Override
	public Bookmark getItem(int position) {		
		return bookList.get(position);
	}

	@Override
	public long getItemId(int position) {		
		return bookList.get(position).hashCode();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;
		
		if ( v == null) {
			LayoutInflater inf = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v = (View) inf.inflate(R.layout.link_list_item, null);
			TextView tName = (TextView) v.findViewById(R.id.bkmName);
			TextView tlink = (TextView) v.findViewById(R.id.bkmLink);
			
			tName.setText(bookList.get(position).name);
			tlink.setText(bookList.get(position).link);
		}
		
		return v;
	}
	
	
	

}
