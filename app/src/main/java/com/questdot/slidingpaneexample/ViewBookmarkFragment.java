package com.questdot.slidingpaneexample;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ViewBookmarkFragment extends Fragment {

	private WebView webView;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		
		View v = inflater.inflate(R.layout.bookmarkview_layout, container, false);
		webView = (WebView) v.findViewById(R.id.webPage);
		webView.getSettings().setJavaScriptEnabled(true);
		webView.setWebViewClient(new SwAWebClient());
		setHasOptionsMenu(true);
		return v;
	}




	public void setBookmark(String link) {
		if (link != null) {
			System.out.println("loading url");
			webView.loadUrl(link);
		}
	}


	private class SwAWebClient extends WebViewClient {

		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			return false;
		}

	}

}
