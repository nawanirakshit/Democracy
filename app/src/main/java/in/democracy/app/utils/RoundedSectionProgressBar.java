package in.democracy.app.utils;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import in.democracy.app.R;


public class RoundedSectionProgressBar extends View {
    // The amount of degrees that we wanna reserve for the divider between 2 sections
    private static final float DIVIDER_ANGLE = 7;
    public static final float DEGREES_IN_CIRCLE = 360;
    public static final int PADDING = 18;
    public static final int PADDING2 = 0;
    public static final float START_ANGLE = 0;

    protected final Paint paint = new Paint();
    protected final Paint waitingPaint = new Paint();
    protected final Paint backgroundPaint = new Paint();
    private int totalSections = 15;
    private int fullSections = 5;
    private RectF rect = new RectF();

    private RectF oval = new RectF(0F, 0F, 100F, 100F);



    public RoundedSectionProgressBar(Context context) {
        super(context);
        init(context, null);
    }

    public RoundedSectionProgressBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public RoundedSectionProgressBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    public void init(Context context, AttributeSet attrs) {
        // Can come from attrs if need be?
        int strokeWidth = 10;
        setupPaint(context, strokeWidth, paint, R.color.purple_200); //
        setupPaint(context, strokeWidth, backgroundPaint, R.color.purple_700);
    }

    private void setupPaint(Context context, int strokeWidth, Paint backgroundPaint, int colorRes) {
        backgroundPaint.setStrokeCap(Paint.Cap.SQUARE);
        backgroundPaint.setColor(context.getResources().getColor(colorRes));
        backgroundPaint.setAntiAlias(true);
        backgroundPaint.setStrokeWidth(strokeWidth);
        backgroundPaint.setStyle(Paint.Style.STROKE);
    }

    public int getTotalSections() {
        return totalSections;
    }

    public void setTotalSections(int totalSections) {
        this.totalSections = totalSections;
        invalidate();
    }

    public int getFullSections() {
        return fullSections;
    }

    public void setNumberOfSections(int fullSections, int totalSections) {
        this.fullSections = fullSections;
        this.totalSections = totalSections;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        float angleOfSection = (DEGREES_IN_CIRCLE / totalSections) - DIVIDER_ANGLE;
        for (int i = 0; i < totalSections; i++) {
            float startAngle = START_ANGLE + i * (angleOfSection + DIVIDER_ANGLE) + DIVIDER_ANGLE / 2;

            if ((i + 1) == 4) {
                rect.set(0, getTop() + PADDING, getRight() - PADDING, getBottom() - PADDING);
            } else if ((i + 1) % 3 == 0) {
                rect.set(getLeft() + PADDING, getTop() + PADDING, getRight(), getBottom() - PADDING);
            } else {
                rect.set(getLeft() + PADDING, getTop() + PADDING, getRight() - PADDING, getBottom() - PADDING);
            }
            if (i < fullSections) {
//                paint.setShader(new LinearGradient(0, 0, 0, getHeight(), Color.BLACK, Color.YELLOW, Shader.TileMode.CLAMP));
                canvas.drawArc(rect, startAngle, angleOfSection, false, paint);
            } else {
                canvas.drawArc(rect, startAngle, angleOfSection, false, backgroundPaint);
            }
        }
    }
}
