package com.example.dotsandboxes;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    ArrayList<Integer>positionX=new ArrayList<Integer>();
    ArrayList<Integer>positionY=new ArrayList<Integer>();
    int i=0,j=1,k=1,z=0,score=0,score2=0;
    boolean a1,b1,c1;
    boolean a2,b2,c2;
    boolean a3,b3,c3;
    boolean a4,b4,c4;
    boolean a11,b11,c11;
    boolean a21,b21,c21;
    boolean a31,b31,c31;
    boolean a41,b41,c41;
    Bitmap undo,background,exit;
    MediaPlayer cheer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new Myview(this));
        undo= BitmapFactory.decodeResource(getResources(),R.drawable.baseline_undo_black_18dp);
        background= BitmapFactory.decodeResource(getResources(),R.drawable.background11);
        exit=BitmapFactory.decodeResource(getResources(),R.drawable.baseline_exit_to_app_black_18dp);
    }
    public class Myview extends View {
        public Myview(Context context) {
            super(context);
        }
        @RequiresApi(api = Build.VERSION_CODES.O)
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Intent intent2=new Intent(Main2Activity.this,MainActivity.class);
            Bundle bundle = getIntent().getExtras();
            final String name1 = "" + bundle.getString("name1");
            final String name2 = "" + bundle.getString("name2");
            int n = bundle.getInt("grid");
            Paint paint = new Paint();
            Paint paint4=new Paint();
            paint4.setStyle(Paint.Style.FILL);
            paint4.setColor(Color.rgb(0,0,0));
            paint4.setTextSize(100f);
            int h = canvas.getHeight();
            Paint paint1 = new Paint();
            Paint paint2=new Paint();
            Paint paint3=new Paint();
            paint.setTypeface(Typeface.DEFAULT_BOLD);
            paint3.setStyle(Paint.Style.FILL);
            paint3.setColor(Color.rgb(0,0,0));
            paint2.setStyle(Paint.Style.FILL);
            paint2.setColor(Color.rgb(50, 150, 50));
            paint1.setStyle(Paint.Style.STROKE);
            paint1.setColor(Color.rgb(0, 158, 255));
            paint1.setStrokeWidth(20);
            int w = canvas.getWidth();
            int radius = 30;
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(Color.rgb(160,160,160));
            paint.setStrokeWidth(20);
            paint.setTextSize(80f);
            canvas.drawPaint(paint);
            paint.setColor(Color.parseColor("#FFFFFF"));
            paint3.setTextSize(40f);
            canvas.drawBitmap(background,0,0,null);
            canvas.drawBitmap(undo,70,50,null);
            canvas.drawBitmap(exit,900,50,null);
            canvas.drawText("EXIT",920,200,paint3);
            canvas.drawText(name1, 40, 350, paint);
            canvas.drawText(name2, 40, 500, paint);
            canvas.drawText("UNDO",75,190,paint3);
            CustomArrayList custom=new CustomArrayList();
            CustomArrayList custom2=new CustomArrayList();
            for (i = 1; i <= n; i++) {
                for (j = 1; j < n + 1; j++) {
                    canvas.drawCircle((i * w) / (n + 1), (h / 2 + (j * h) / (2 * (n + 1))), radius, paint);
                }
            }
            if(positionX.size()>0 && positionX.get(positionX.size()-1)>900 && positionY.get(positionY.size()-1)<150){
                startActivity(intent2);
            }
            if(positionY.size()>0 && positionY.get(positionY.size()-1)<h/2){
                positionY.remove(positionY.size()-1);
                positionX.remove(positionX.size()-1);
            }
            for (i = 0; i < positionX.size(); i++) {
                for (j = 1; j < n + 1; j++) {
                    if (positionY.get(i) - (h / 2 + ((j * h) / (2 * (n + 1)))) <= 50 && (h / 2 + ((j * h) / (2 * (n + 1))))-positionY.get(i)<=50) {
                        int y1= (h / 2 + (j * h) / (2 * (n + 1)));
                        int y2= (h / 2 + (j * h) / (2 * (n + 1)));
                        for (k = 1; k <= n; k++) {
                            if (positionX.get(i) > (k * w) / (n + 1) && positionX.get(i) < ((k + 1) * w) / (n + 1)){
                                int x1=(k * w) / (n + 1);
                                int x2=((k + 1) * w) / (n + 1);
                                if(i%2==0){
                                    canvas.drawLine(x1,y1,x2,y2,paint1);
                                    custom.addValues(x1,y1,x2,y2);
                                    for(z=0;z<custom.list.size();z++){
                                        if(x1==custom.getx1(z) && (y1-(h / (2 * (n + 1))))==custom.gety1(z) && x2==custom.getx2(z)&& (y1-(h / (2 * (n + 1))))==custom.gety2(z)) a3 = true;
                                        if(x1==custom.getx1(z) && (y1-(h / (2 * (n + 1))))==custom.gety1(z) && x1==custom.getx2(z)&& y1==custom.gety2(z)) b3=true;
                                        if (x2==custom.getx1(z)&& (y2-(h / (2 * (n + 1))))==custom.gety1(z)&& x2==custom.getx2(z)&&y2==custom.gety2(z))c3=true;
                                        if(a3 && b3&&c3){
                                            canvas.drawText(name1+" is the winner",50,800,paint4);
                                        }
                                    }
                                    for(z=0;z<custom.list.size();z++){
                                        if(x1==custom.getx1(z) && y1==custom.gety1(z) && x1==custom.getx2(z)&& (y1+(h / (2 * (n + 1))))==custom.gety2(z)) a4 = true;
                                        if(x1==custom.getx1(z) && (y1+(h / (2 * (n + 1))))==custom.gety1(z) && x2==custom.getx2(z)&& (y2+(h / (2 * (n + 1))))==custom.gety2(z)) b4=true;
                                        if (x2==custom.getx1(z)&& (y2+(h / (2 * (n + 1))))==custom.gety2(z)&& x2==custom.getx2(z)&&y2==custom.gety1(z))c4=true;
                                        if(a4&& b4&&c4){
                                            canvas.drawText(name1+" is the winner",50,800,paint4);
                                        }
                                    }
                                }
                                if(i%2==1){
                                    canvas.drawLine(x1,y1,x2,y2,paint);
                                    custom2.addValues(x1,y1,x2,y2);
                                    for(z=0;z<custom2.list.size();z++){
                                        if(x1==custom2.getx1(z) && (y1-(h / (2 * (n + 1))))==custom2.gety1(z) && x2==custom2.getx2(z)&& (y1-(h / (2 * (n + 1))))==custom2.gety2(z)) a31 = true;
                                        if(x1==custom2.getx1(z) && (y1-(h / (2 * (n + 1))))==custom2.gety1(z) && x1==custom2.getx2(z)&& y1==custom2.gety2(z)) b31=true;
                                        if (x2==custom2.getx1(z)&& (y2-(h / (2 * (n + 1))))==custom2.gety1(z)&& x2==custom2.getx2(z)&&y2==custom2.gety2(z))c31=true;
                                        if(a31 && b31&&c31){
                                            canvas.drawText(name2+" is the winner",50,800,paint4);
                                        }
                                    }
                                    for(z=0;z<custom.list.size();z++){
                                        if(x1==custom2.getx1(z) && y1==custom2.gety1(z) && x1==custom2.getx2(z)&& (y1+(h / (2 * (n + 1))))==custom2.gety2(z)) a41 = true;
                                        if(x1==custom2.getx1(z) && (y1+(h / (2 * (n + 1))))==custom2.gety1(z) && x2==custom2.getx2(z)&& (y2+(h / (2 * (n + 1))))==custom2.gety2(z)) b41=true;
                                        if (x2==custom2.getx1(z)&& (y2+(h / (2 * (n + 1))))==custom2.gety2(z)&& x2==custom2.getx2(z)&&y2==custom2.gety1(z))c41=true;
                                        if(a41&& b41&&c41){
                                            canvas.drawText(name2+" is the winner",50,800,paint4);
                                        }
                                    }
                                }

                            }
                        }
                    }
                    else if (positionX.get(i)-(j * w) / (n + 1)<=50 && (j * w) / (n + 1)-positionX.get(i)<=50){
                        int x1=(j * w) / (n + 1);
                        int x2=(j * w) / (n + 1);
                        for(k=1;k<=n;k++){
                            if(positionY.get(i)>(h / 2 + ((k * h) / (2 * (n + 1)))) && positionY.get(i)<(h / 2 + (((k+1) * h) / (2 * (n + 1))))){
                                int y1=(h / 2 + ((k * h) / (2 * (n + 1))));
                                int y2=(h / 2 + (((k+1) * h) / (2 * (n + 1))));
                                if(i%2==0){
                                    canvas.drawLine(x1,y1,x2,y2,paint1);
                                    custom.addValues(x1,y1,x2,y2);
                                    for(z=0;z<custom.list.size();z++){
                                        if(x1==custom.getx1(z) && y1==custom.gety1(z) && (x1+w/(n+1))==custom.getx2(z)&& y1==custom.gety2(z)) a1 = true;
                                        if(x1==custom.getx1(z) && y2==custom.gety1(z) && (x1+w/(n+1))==custom.getx2(z)&& y2==custom.gety2(z)) b1=true;
                                        if ((x1+w/(n+1))==custom.getx1(z)&& y1==custom.gety1(z)&& (x1+w/(n+1))==custom.getx2(z)&&y2==custom.gety2(z))c1=true;
                                        if(a1&&b1&&c1){
                                            canvas.drawText(name1+" is the winner",50,800,paint4);
                                        }
                                    }
                                    for(z=0;z<custom.list.size();z++){
                                        if((x1-w/(n+1))==custom.getx1(z) && y1==custom.gety1(z) && x1==custom.getx2(z)&& y1==custom.gety2(z)) a2 = true;
                                        if((x2-w/(n+1))==custom.getx1(z) && y2==custom.gety1(z) && x2==custom.getx2(z)&& y2==custom.gety2(z)) b2=true;
                                        if ((x1-w/(n+1))==custom.getx1(z)&& y1==custom.gety1(z)&& (x1-w/(n+1))==custom.getx2(z)&&y2==custom.gety2(z))c2=true;
                                        if(a2&&b2&&c2){
                                            canvas.drawText(name1+" is the winner",50,800,paint4);
                                        }
                                    }
                                }
                                else if(i%2==1){
                                    canvas.drawLine(x1,y1,x2,y2,paint);
                                    custom2.addValues(x1,y1,x2,y2);
                                    for(z=0;z<custom2.list.size();z++){
                                        if(x1==custom2.getx1(z) && y1==custom2.gety1(z) && (x1+w/(n+1))==custom2.getx2(z)&& y1==custom2.gety2(z)) a11 = true;
                                        if(x1==custom2.getx1(z) && y2==custom2.gety1(z) && (x1+w/(n+1))==custom2.getx2(z)&& y2==custom2.gety2(z)) b11=true;
                                        if ((x1+w/(n+1))==custom2.getx1(z)&& y1==custom2.gety1(z)&& (x1+w/(n+1))==custom2.getx2(z)&&y2==custom2.gety2(z))c11=true;
                                        if(a11&&b11&&c11){
                                            canvas.drawText(name2+" is the winner",50,800,paint4);
                                        }
                                    }
                                    for(z=0;z<custom.list.size();z++){
                                        if((x1-w/(n+1))==custom2.getx1(z) && y1==custom2.gety1(z) && x1==custom2.getx2(z)&& y1==custom2.gety2(z)) a2 = true;
                                        if((x2-w/(n+1))==custom2.getx1(z) && y2==custom2.gety1(z) && x2==custom2.getx2(z)&& y2==custom2.gety2(z)) b2=true;
                                        if ((x1-w/(n+1))==custom2.getx1(z)&& y1==custom2.gety1(z)&& (x1-w/(n+1))==custom2.getx2(z)&&y2==custom2.gety2(z))c2=true;
                                        if(a21&&b21&&c21){
                                            canvas.drawText(name2+" is the winner",50,800,paint4);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            invalidate();
        }
        @Override
        public boolean onTouchEvent(MotionEvent event)
        {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN: {
                    positionX.add((int) event.getX());
                    positionY.add((int) event.getY());
                    if(positionX.get(positionX.size()-1)>20 && positionX.get(positionX.size()-1)<150 &&positionY.get(positionY.size()-1)>20 &&positionY.get(positionY.size()-1)<150){
                        positionX.remove(positionX.size()-1);
                        positionY.remove(positionY.size()-1);
                        positionX.remove(positionX.size()-1);
                        positionY.remove(positionY.size()-1);
                    }

                }
                invalidate();
            }
            return true;
        }
    }
}
