package com.romanpulov.symphonytimer;

import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class HistoryArrayAdapter extends ArrayAdapter<DMTimerHistRec> {
	
	private DMTimers mDMTimers;
	private DMTimerHistList mDMTimerHistList;
	
	private class ViewHolder {
		public TextView mTitle;
		public ImageView mImage;
		public TextView mTime;
		
		public ViewHolder(View view) {
			mTitle = (TextView)view.findViewById(R.id.history_text_view);
			mImage = (ImageView)view.findViewById(R.id.history_image_view);
			mTime = (TextView)view.findViewById(R.id.history_time_view);
		}
		
	}

	public HistoryArrayAdapter(Context context, DMTimerHistList dmTimerHistList, DMTimers dmTimers) {
		super(context, R.layout.history_row_view);
		mDMTimerHistList = dmTimerHistList;
		mDMTimers = dmTimers;		
	}
	
	@Override
	public int getCount() {
		return mDMTimerHistList.size();
	}
	
	@Override
	public DMTimerHistRec getItem(int position) {
		return mDMTimerHistList.get(position);
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final String tag = getClass().toString();
		// TODO Auto-generated method stub
		
		View rowView;
		ViewHolder viewHolder;
	
		if (convertView == null) {
			
			//inflate view
			LayoutInflater inflater = ((Activity)getContext()).getLayoutInflater();
			rowView = inflater.inflate(R.layout.history_row_view, parent, false);
			
			//setup viewholder
			viewHolder = new ViewHolder(rowView);
			rowView.setTag(viewHolder);			
			
		}
		else { 
			rowView = convertView;
			viewHolder = (ViewHolder)rowView.getTag();
		}
		
		// create viewHolder(just in case)
		if (null == viewHolder) {
			viewHolder = new ViewHolder(rowView);
			rowView.setTag(viewHolder);
		}
		
		DMTimerHistRec rec = mDMTimerHistList.get(position);
		DMTimerRec dmTimerRec = mDMTimers.getItemById(rec.timerId);
		
		viewHolder.mTitle.setText(dmTimerRec.title);		
		viewHolder.mTime.setText(java.text.DateFormat.getDateTimeInstance().format(new Date(rec.startTime)));
		viewHolder.mImage.setImageURI(
				null != dmTimerRec.image_name ? Uri.parse(dmTimerRec.image_name) : null);
		
		Log.d(tag, dmTimerRec.title + " " + dmTimerRec.image_name);
		return rowView;
	}

}
