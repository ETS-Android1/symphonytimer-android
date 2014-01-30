package com.romanpulov.symphonytimer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class HistoryListFragment extends Fragment {
	
	private DMTimerHistList mDMimerHistList = new DMTimerHistList();
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View rootView = inflater.inflate(R.layout.history_list_frag, container, false);
		
		DBHelper.getInstance(this.getActivity()).fillHistList(mDMimerHistList);		
		
		DMTimers dmTimers = ((HistoryActivity)this.getActivity()).getTimers();
	
		ArrayAdapter<?> adapter = new HistoryArrayAdapter(this.getActivity(), mDMimerHistList, dmTimers);
		
		((ListView)rootView.findViewById(R.id.history_list_view)).setAdapter(adapter);
		
        return rootView;
	}
}
