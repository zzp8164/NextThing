package app.next.udacity.com.nextthing;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ListView;
import android.widget.Toast;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Shaman on 12/27/14.
 */
public class NextThingFragment extends Fragment {

    public static final String WEB_36_KR = "http://www.36kr.com";
    NextThingAdapter mNextThingAdapter;

    @InjectView(R.id.listView)
    PullToRefreshListView mListView;
    Handler handler = new Handler();
    @InjectView(R.id.webview)
    WebView mWebview;

    public NextThingFragment() {
        mNextThingAdapter = new NextThingAdapter();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.inject(this, rootView);
        WebSettings webSettings = mWebview.getSettings();
        webSettings.setJavaScriptEnabled(true);


        mWebview.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true ;
            }
        });
        mWebview.loadUrl(WEB_36_KR);
        mWebview.setVisibility(View.GONE);
//        mListView.setVisibility(View.GONE);
        for (int i = 0; i < 20; i++) {
            String data = "title";
            mNextThingAdapter.addOneData(data);
        }
        mListView.setAdapter(mNextThingAdapter);
        mListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>() {
            @Override
            public void onRefresh(PullToRefreshBase<ListView> refreshView) {
                Toast.makeText(getActivity(), "refresh", Toast.LENGTH_SHORT).show();
                for (int i = 0; i < 5; i++) {
                    String data = "title";
                    mNextThingAdapter.addOneData(data);
                }
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mListView.onRefreshComplete();
                    }
                }, 2000);


            }
        });
        return rootView;
    }


}

