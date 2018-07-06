package sampleproject.com.task1;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;



public class ProfileActivity2 extends AppCompatActivity {
    private Context mContext;
    private Resources mResources;
    private RelativeLayout mRelativeLayout;
    private Button mButton;
    private ImageView mImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);
        mContext = getApplicationContext();

        // Get the Resources
        mResources = getResources();

        // Get the widgets reference from XML layout
        mRelativeLayout = (RelativeLayout) findViewById(R.id.r1);
        mImageView = (ImageView) findViewById(R.id.iv);

        // Set a click listener for Button widge
        // Initialize a new Bitmap
       Bitmap mBitmap = BitmapFactory.decodeResource(mResources, R.drawable.sample1);
                Bitmap bitmap = Bitmap.createBitmap(
                600, // Width
                300, // Height
                Bitmap.Config.ARGB_8888 // Config
        );

        // Initialize a new Canvas instance
        Canvas canvas = new Canvas(bitmap);

        // Draw a solid color on the canvas as background
        canvas.drawColor(Color.WHITE);

        // Initialize a new Paint instance to draw the rounded rectangle
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.RED);
        paint.setAntiAlias(true);

        // Set an offset value in pixels to draw rounded rectangle on canvas
        int offset = 50;

                /*
                    public RectF (float left, float top, float right, float bottom)
                        Create a new rectangle with the specified coordinates. Note: no range
                        checking is performed, so the caller must ensure that
                        left <= right and top <= bottom.

                    Parameters
                        left  The X coordinate of the left side of the rectangle
                        top  The Y coordinate of the top of the rectangle
                        right  The X coordinate of the right side of the rectangle
                        bottom  The Y coordinate of the bottom of the rectangle
                */
        // Initialize a new RectF instance
        RectF rectF = new RectF(
                offset, // left
                offset, // top
                canvas.getWidth() - offset, // right
                canvas.getHeight() - offset // bottom
        );

                /*
                    public void drawRoundRect (RectF rect, float rx, float ry, Paint paint)
                        Draw the specified round-rect using the specified paint. The roundrect
                        will be filled or framed based on the Style in the paint.

                    Parameters
                        rect : The rectangular bounds of the roundRect to be drawn
                        rx : The x-radius of the oval used to round the corners
                        ry : The y-radius of the oval used to round the corners
                        paint : The paint used to draw the roundRect
                */

        // Define the corners radius of rounded rectangle
        int cornersRadius = 25;

        // Finally, draw the rounded corners rectangle object on the canvas
        canvas.drawRoundRect(
                rectF, // rect
                cornersRadius, // rx
                cornersRadius, // ry
                paint // Paint
        );

        // Display the newly created bitmap on app interface
        mImageView.setImageBitmap(bitmap);
    }


}
