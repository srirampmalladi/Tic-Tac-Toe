package org.spm.ttt;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class Board extends TableLayout {
    private static final int SIZE = 3;

	public Board(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.resetBoard(SIZE);
	}
	
    private void resetBoard(int size) {
        for (int row=0;row<SIZE;row++) {
        	TableRow tableRow = new TableRow(getContext());
        	addView(tableRow);
        	for (int col=0;col<SIZE;col++) {
        		TextView cell = new TextView(getContext());
        		cell.setText(row + "" + col);
				tableRow.addView(cell);
        	}
        }
    }

	
	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
		((Activity)getContext()).getLayoutInflater().inflate(R.layout.board, this);
	}
}
