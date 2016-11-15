package com.questdot.slidingpaneexample;
;
import android.os.Bundle;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class MainActivity extends AppCompatActivity implements BookmarkListener{
	SlidingPaneLayout pane;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		pane = (SlidingPaneLayout) findViewById(R.id.sp);
		pane.setPanelSlideListener(new PaneListener());
		
		if (!pane.isSlideable()) {
			getFragmentManager().findFragmentById(R.id.leftpane).setHasOptionsMenu(false);
			getFragmentManager().findFragmentById(R.id.rightpane).setHasOptionsMenu(true);
		}
	}


	
	private class PaneListener implements SlidingPaneLayout.PanelSlideListener {

		@Override
		public void onPanelClosed(View view) {
			System.out.println("Panel closed");
			
			getFragmentManager().findFragmentById(R.id.leftpane).setHasOptionsMenu(false);
			getFragmentManager().findFragmentById(R.id.rightpane).setHasOptionsMenu(true);
		}

		@Override
		public void onPanelOpened(View view) {
			System.out.println("Panel opened");
			getFragmentManager().findFragmentById(R.id.leftpane).setHasOptionsMenu(true);
			getFragmentManager().findFragmentById(R.id.rightpane).setHasOptionsMenu(false);
		}

		@Override
		public void onPanelSlide(View view, float arg1) {
			System.out.println("Panel sliding");
		}
		
	}



	@Override
	public void onChangeBookmark(String bookmark) {
		// We get notified when user clicks on a bookmark in the ListBookmarkFragment
		System.out.println("Bookmark ["+bookmark+"]");
		ViewBookmarkFragment f = (ViewBookmarkFragment) getFragmentManager().findFragmentById(R.id.rightpane);
		f.setBookmark(bookmark);
		
	}

}
