package org.spm.ttt;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class Board extends View {
	private static final int SIZE = 3;

	public Board(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.resetBoard(SIZE);
	}

	private void resetBoard(int size) {
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		int availableSize = Math.min(getMeasuredWidth(), getMeasuredHeight());
		float start = 0.1f * availableSize;
		float end = 0.9f * availableSize;

		Paint innerPaint = new Paint();
		innerPaint.setColor(Color.LTGRAY);
		innerPaint.setStrokeWidth(2);

		float dist = 0.8f * availableSize / SIZE;
		float next = dist;
		for (int i = 1; i < SIZE; i++) {
			canvas.drawLine(start + next, start, start + next, end, innerPaint);
			canvas.drawLine(start, start + next, end, start + next, innerPaint);
			next += dist;

		}
		Paint outerPaint = new Paint();
		outerPaint.setColor(Color.WHITE);
		outerPaint.setStrokeWidth(5);
		outerPaint.setStyle(Style.STROKE);
		outerPaint.setAntiAlias(true);

		RectF main = new RectF(start, start, end, end);
		canvas.drawRoundRect(main, 5, 5, outerPaint);
	}
}
