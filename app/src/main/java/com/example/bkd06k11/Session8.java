package com.example.bkd06k11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.view.MotionEventCompat;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Session8 extends AppCompatActivity implements GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener {
    ImageView imgShoes;

    private GestureDetectorCompat mDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session8);
        imgShoes = findViewById(R.id.imgShoes); //inflate
/*     imgShoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Session8.this,
                        "Bạn vừa chạm vào giày tớ, căng",
                        Toast.LENGTH_LONG).show();
            }
        });*/


/*     imgShoes.setOnTouchListener(new View.OnTouchListener() {
         @Override
         public boolean onTouch(View v, MotionEvent event) {
             int action = MotionEventCompat.getActionMasked(event);
             switch (action) {
                 case (MotionEvent.ACTION_DOWN):
                     System.out.println("Action down event");
                     break;

                 case (MotionEvent.ACTION_MOVE):
                     System.out.println("Action move event");
                     break;

                 case (MotionEvent.ACTION_UP):
                     System.out.println("Action up event");
                     break;
             }
             return true;
         }
     });*/

        mDetector = new GestureDetectorCompat(this, this);
        mDetector.setOnDoubleTapListener(this);

    }


    public void touchMyShoes(View v) {
        Toast.makeText(Session8.this,
                "Bạn vừa chạm vào giày tớ, căng",
                Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
     /*   int action = MotionEventCompat.getActionMasked(event);
        switch (action) {
            case (MotionEvent.ACTION_DOWN):
                System.out.println("Action down event");
                break;

            case (MotionEvent.ACTION_MOVE):
                System.out.println("Action move event");
                break;

            case (MotionEvent.ACTION_UP):
                System.out.println("Action up event");
                break;
        }*/

        //demo for gesture detector
        if (this.mDetector.onTouchEvent(event)) {
            return true;
        }
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        System.out.println("LongPress");
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        System.out.println("Fling");
        return false;
    }
}