package com.questdot.slidingpaneexample;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;



import java.util.ArrayList;
import java.util.List;

public class SlidingPaneFragment extends Fragment {
	
	private List<Bookmark> bookmarkList = new ArrayList<Bookmark>();
	
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		init();
	}





	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		
		View v = inflater.inflate(R.layout.leftside_layout, container, true);
		ListView lView = (ListView) v.findViewById(R.id.bookList);
		LinkAdapter la = new LinkAdapter(bookmarkList, getActivity());
		lView.setAdapter(la);
		lView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
									long id) {
				( (BookmarkListener) getActivity()).onChangeBookmark( bookmarkList.get(position).link );
				((MainActivity)getActivity()).pane.closePane();
			}
		});
		setHasOptionsMenu(true);
		return v;
	}



	private void init() {
		bookmarkList.add(new Bookmark("Google", "https://www.google.com/"));
		bookmarkList.add(new Bookmark("Apple", "http://www.apple.com/"));
		bookmarkList.add(new Bookmark("Microsoft", "https://www.microsoft.com/en-my/"));
	}


}
