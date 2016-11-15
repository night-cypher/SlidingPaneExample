package com.questdot.slidingpaneexample;
/*
 * Copyright (C) 2013 Surviving with Android (http://www.survivingwithandroid.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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

public class ListBookmarkFragment extends Fragment {
	
	private List<Bookmark> bookmarkList = new ArrayList<Bookmark>();
	
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		init();
	}


	

	
	@Override
	public void onAttach(Activity activity) {
		
		// It's time we check if our activity implements the right inteface
		if (! (activity instanceof BookmarkListener) )
			throw new ClassCastException();
		
		super.onAttach(activity);

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
		bookmarkList.add(new Bookmark("Google", "http://www.google.it"));
		bookmarkList.add(new Bookmark("Android dev", "http://developer.android.com/index.html"));
	}


}
