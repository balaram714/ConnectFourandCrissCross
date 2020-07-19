package com.example.connectfourandcrisscross;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.appcompat.app.AppCompatActivity;

public class ConnectFourGame extends SurfaceView implements Runnable {
private Thread mThread=null;
private Thread mThread1;
private boolean goingOn=false;
private Canvas mCanvus;
private SurfaceHolder mSurfaceHolder;
private Paint mPaint;
private RectF view;
private RectF view1;
private RectF  reset;
private Point point;
private int count=0;
private int ju=1;
private double mNextFrameTime=System.currentTimeMillis();
private int distance=50;
private int[][] connectfourGame={{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0}};
   // private int[][] connectfourGame1={{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0}};
    //private int[][] connectfourGame2={{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0}};
private int a=5;
private int b=5;
private int c=5;
private int d=5;
private int e=5;
private int f=5;
private  int  count1=1;
private int count2=0;
private int count3=1;
private boolean player1=true;
private boolean player2=false;
private String s=" ";
private int pqr;
private int pqr1;
private int kg;
int arr[]=new int[4];
public ConnectFourGame(Context context, Point size){
   super(context);
   point=size;
mSurfaceHolder=getHolder();
mPaint=new Paint();
view=new RectF(0,0,350,600);
view1=new RectF(0,0,350,600);
}

    @Override
    public void run() {
        while(goingOn){
            if(updateRequired()){
                update();}
            drawingFrontScreen();
           //
            // Log.i("info"," "+123);
        }


    }
    public  void drawingFrontScreen(){
   if(mSurfaceHolder.getSurface().isValid()){
       mCanvus=mSurfaceHolder.lockCanvas();

       mCanvus.drawColor(Color.argb(225,0,0,0));
       mPaint.setColor(Color.argb(225,0,0,225));

       mCanvus.drawRect(view,mPaint);
       mPaint.setColor(Color.argb(225,0,225,0));
       mPaint.setTextSize(50);
       mCanvus.drawText("ConnectFour",50,50,mPaint);
       mPaint.setTextSize(35);
       mCanvus.drawText("Turn of ",50,250,mPaint);
       if(player1==true)
       mCanvus.drawText(":player1",200,250,mPaint);
       else
           mCanvus.drawText(":player2",200,250,mPaint);
       mCanvus.drawText("Restart",50,500,mPaint);
       mCanvus.drawText("Quite",200,500,mPaint);
       mPaint.setColor(Color.argb(225,225,225,225));
       mCanvus.drawCircle(400,50 ,50, mPaint);
       mCanvus.drawCircle(500,50 ,50, mPaint);
       mCanvus.drawCircle(600,50 ,50, mPaint);
       mCanvus.drawCircle(700,50 ,50, mPaint);
       mCanvus.drawCircle(800,50 ,50, mPaint);
       mCanvus.drawCircle(900,50 ,50, mPaint);
       mCanvus.drawCircle(400,150 ,50, mPaint);
       mCanvus.drawCircle(500,150,50, mPaint);
       mCanvus.drawCircle(600,150 ,50, mPaint);
       mCanvus.drawCircle(700,150,50, mPaint);
       mCanvus.drawCircle(800,150 ,50, mPaint);
       mCanvus.drawCircle(900,150,50, mPaint);
       mCanvus.drawCircle(400,250 ,50, mPaint);
       mCanvus.drawCircle(500,250 ,50, mPaint);
       mCanvus.drawCircle(600,250 ,50, mPaint);
       mCanvus.drawCircle(700,250 ,50, mPaint);
       mCanvus.drawCircle(800,250 ,50, mPaint);
       mCanvus.drawCircle(900,250 ,50, mPaint);
       mCanvus.drawCircle(400,350 ,50, mPaint);
       mCanvus.drawCircle(500,350 ,50, mPaint);
       mCanvus.drawCircle(600,350 ,50, mPaint);
       mCanvus.drawCircle(700,350 ,50, mPaint);
       mCanvus.drawCircle(800,350 ,50, mPaint);
       mCanvus.drawCircle(900,350 ,50, mPaint);
       mCanvus.drawCircle(400,450 ,50, mPaint);
       mCanvus.drawCircle(500,450 ,50, mPaint);
       mCanvus.drawCircle(600,450 ,50, mPaint);
       mCanvus.drawCircle(700,450 ,50, mPaint);
       mCanvus.drawCircle(800,450 ,50, mPaint);
       mCanvus.drawCircle(900,450 ,50, mPaint);
       mCanvus.drawCircle(400,550 ,50, mPaint);
       mCanvus.drawCircle(500,550 ,50, mPaint);
       mCanvus.drawCircle(600,550 ,50, mPaint);
       mCanvus.drawCircle(700,550 ,50, mPaint);
       mCanvus.drawCircle(800,550 ,50, mPaint);
       mCanvus.drawCircle(900,550 ,50, mPaint);

       if(count==1){

               mPaint.setColor(Color.argb(225,84,0,84));

           mCanvus.drawCircle(400,distance ,50, mPaint);}
       else if(count==2){
           mPaint.setColor(Color.argb(225,84,0,84));
           mCanvus.drawCircle(500,distance ,50, mPaint);
       }
       else if(count==3){
           mPaint.setColor(Color.argb(225,84,0,84));
           mCanvus.drawCircle(600,distance,50, mPaint);}
       else if(count==4){
           mPaint.setColor(Color.argb(225,84,0,84));
           mCanvus.drawCircle(700,distance,50, mPaint);}
       else if(count==5){
           mPaint.setColor(Color.argb(225,84,0,84));
           mCanvus.drawCircle(800,distance,50, mPaint);}
       else if(count==6){
           mPaint.setColor(Color.argb(225,84,0,84));
           mCanvus.drawCircle(900,distance,50, mPaint);}
       if(count1==1){
           for(int i=0;i<6;i++){
               for(int j=0;j<6;j++){
                   if(connectfourGame[i][j]>0){
                       if(i==0){
                           if(j==0){
                               if(connectfourGame[i][j]==1)
                               mPaint.setColor(Color.argb(225,225,0,225));
                               if(connectfourGame[i][j]==2)
                                   mPaint.setColor(Color.argb(225,225,225,0));
                               mCanvus.drawCircle(400,50,50, mPaint);
                           }
                           else if(j==1){
                               if(connectfourGame[i][j]==1)
                                   mPaint.setColor(Color.argb(225,225,0,225));
                               if(connectfourGame[i][j]==2)
                                   mPaint.setColor(Color.argb(225,225,225,0));
                               mCanvus.drawCircle(400,150 ,50, mPaint);
                           }
                           else if(j==2){
                               if(connectfourGame[i][j]==1)
                                   mPaint.setColor(Color.argb(225,225,0,225));
                               if(connectfourGame[i][j]==2)
                                   mPaint.setColor(Color.argb(225,225,225,0));
                               mCanvus.drawCircle(400,250 ,50, mPaint);
                           }
                           else if(j==3){
                               if(connectfourGame[i][j]==1)
                                   mPaint.setColor(Color.argb(225,225,0,225));
                               if(connectfourGame[i][j]==2)
                                   mPaint.setColor(Color.argb(225,225,225,0));
                               mCanvus.drawCircle(400,350 ,50, mPaint);
                           }
                           else if(j==4){
                               if(connectfourGame[i][j]==1)
                                   mPaint.setColor(Color.argb(225,225,0,225));
                               if(connectfourGame[i][j]==2)
                                   mPaint.setColor(Color.argb(225,225,225,0));
                               mCanvus.drawCircle(400,450 ,50, mPaint);
                           }
                           else if(j==5){
                               if(connectfourGame[i][j]==1)
                                   mPaint.setColor(Color.argb(225,225,0,225));
                               if(connectfourGame[i][j]==2)
                                   mPaint.setColor(Color.argb(225,225,225,0));
                               mCanvus.drawCircle(400,550 ,50, mPaint);
                           }
                       }
                      else if(i==1){
                           if(j==0){
                               if(connectfourGame[i][j]==1)
                                   mPaint.setColor(Color.argb(225,225,0,225));
                               if(connectfourGame[i][j]==2)
                                   mPaint.setColor(Color.argb(225,225,225,0));
                               mCanvus.drawCircle(500,50,50, mPaint);
                           }
                           else if(j==1){
                               if(connectfourGame[i][j]==1)
                                   mPaint.setColor(Color.argb(225,225,0,225));
                               if(connectfourGame[i][j]==2)
                                   mPaint.setColor(Color.argb(225,225,225,0));
                               mCanvus.drawCircle(500,150 ,50, mPaint);
                           }
                           else if(j==2){
                               if(connectfourGame[i][j]==1)
                                   mPaint.setColor(Color.argb(225,225,0,225));
                               if(connectfourGame[i][j]==2)
                                   mPaint.setColor(Color.argb(225,225,225,0));
                               mCanvus.drawCircle(500,250 ,50, mPaint);
                           }
                           else if(j==3){
                               if(connectfourGame[i][j]==1)
                                   mPaint.setColor(Color.argb(225,225,0,225));
                               if(connectfourGame[i][j]==2)
                                   mPaint.setColor(Color.argb(225,225,225,0));
                               mCanvus.drawCircle(500,350 ,50, mPaint);
                           }
                           else if(j==4){
                               if(connectfourGame[i][j]==1)
                                   mPaint.setColor(Color.argb(225,225,0,225));
                               if(connectfourGame[i][j]==2)
                                   mPaint.setColor(Color.argb(225,225,225,0));
                               mCanvus.drawCircle(500,450 ,50, mPaint);
                           }
                           else if(j==5){
                               if(connectfourGame[i][j]==1)
                                   mPaint.setColor(Color.argb(225,225,0,225));
                               if(connectfourGame[i][j]==2)
                                   mPaint.setColor(Color.argb(225,225,225,0));
                               mCanvus.drawCircle(500,550 ,50, mPaint);
                           }
                       }
                       else if(i==2){
                           if(j==0){
                               if(connectfourGame[i][j]==1)
                                   mPaint.setColor(Color.argb(225,225,0,225));
                               if(connectfourGame[i][j]==2)
                                   mPaint.setColor(Color.argb(225,225,225,0));
                               mCanvus.drawCircle(600,50,50, mPaint);
                           }
                           else if(j==1){
                               if(connectfourGame[i][j]==1)
                                   mPaint.setColor(Color.argb(225,225,0,225));
                               if(connectfourGame[i][j]==2)
                                   mPaint.setColor(Color.argb(225,225,225,0));
                               mCanvus.drawCircle(600,150 ,50, mPaint);
                           }
                           else if(j==2){
                               if(connectfourGame[i][j]==1)
                                   mPaint.setColor(Color.argb(225,225,0,225));
                               if(connectfourGame[i][j]==2)
                                   mPaint.setColor(Color.argb(225,225,225,0));
                               mCanvus.drawCircle(600,250 ,50, mPaint);
                           }
                           else if(j==3){
                               if(connectfourGame[i][j]==1)
                                   mPaint.setColor(Color.argb(225,225,0,225));
                               if(connectfourGame[i][j]==2)
                                   mPaint.setColor(Color.argb(225,225,225,0));
                               mCanvus.drawCircle(600,350 ,50, mPaint);
                           }
                           else if(j==4){
                               if(connectfourGame[i][j]==1)
                                   mPaint.setColor(Color.argb(225,225,0,225));
                               if(connectfourGame[i][j]==2)
                                   mPaint.setColor(Color.argb(225,225,225,0));
                               mCanvus.drawCircle(600,450 ,50, mPaint);
                           }
                           else if(j==5){
                               if(connectfourGame[i][j]==1)
                                   mPaint.setColor(Color.argb(225,225,0,225));
                               if(connectfourGame[i][j]==2)
                                   mPaint.setColor(Color.argb(225,225,225,0));
                               mCanvus.drawCircle(600,550 ,50, mPaint);
                           }
                       }
                       else if(i==3){
                           if(j==0){
                               if(connectfourGame[i][j]==1)
                                   mPaint.setColor(Color.argb(225,225,0,225));
                               if(connectfourGame[i][j]==2)
                                   mPaint.setColor(Color.argb(225,225,225,0));
                               mCanvus.drawCircle(700,50,50, mPaint);
                           }
                           else if(j==1){
                               if(connectfourGame[i][j]==1)
                                   mPaint.setColor(Color.argb(225,225,0,225));
                               if(connectfourGame[i][j]==2)
                                   mPaint.setColor(Color.argb(225,225,225,0));
                               mCanvus.drawCircle(700,150 ,50, mPaint);
                           }
                           else if(j==2){
                               if(connectfourGame[i][j]==1)
                                   mPaint.setColor(Color.argb(225,225,0,225));
                               if(connectfourGame[i][j]==2)
                                   mPaint.setColor(Color.argb(225,225,225,0));
                               mCanvus.drawCircle(700,250 ,50, mPaint);
                           }
                           else if(j==3){
                               if(connectfourGame[i][j]==1)
                                   mPaint.setColor(Color.argb(225,225,0,225));
                               if(connectfourGame[i][j]==2)
                                   mPaint.setColor(Color.argb(225,225,225,0));
                               mCanvus.drawCircle(700,350 ,50, mPaint);
                           }
                           else if(j==4){
                               if(connectfourGame[i][j]==1)
                                   mPaint.setColor(Color.argb(225,225,0,225));
                               if(connectfourGame[i][j]==2)
                                   mPaint.setColor(Color.argb(225,225,225,0));
                               mCanvus.drawCircle(700,450 ,50, mPaint);
                           }
                           else if(j==5){
                               if(connectfourGame[i][j]==1)
                                   mPaint.setColor(Color.argb(225,225,0,225));
                               if(connectfourGame[i][j]==2)
                                   mPaint.setColor(Color.argb(225,225,225,0));
                               mCanvus.drawCircle(700,550 ,50, mPaint);
                           }
                       }
                       else if(i==4){
                           if(j==0){
                               if(connectfourGame[i][j]==1)
                                   mPaint.setColor(Color.argb(225,225,0,225));
                               if(connectfourGame[i][j]==2)
                                   mPaint.setColor(Color.argb(225,225,225,0));
                               mCanvus.drawCircle(800,50,50, mPaint);
                           }
                           else if(j==1){
                               if(connectfourGame[i][j]==1)
                                   mPaint.setColor(Color.argb(225,225,0,225));
                               if(connectfourGame[i][j]==2)
                                   mPaint.setColor(Color.argb(225,225,225,0));
                               mCanvus.drawCircle(800,150 ,50, mPaint);
                           }
                           else if(j==2){
                               if(connectfourGame[i][j]==1)
                                   mPaint.setColor(Color.argb(225,225,0,225));
                               if(connectfourGame[i][j]==2)
                                   mPaint.setColor(Color.argb(225,225,225,0));
                               mCanvus.drawCircle(800,250 ,50, mPaint);
                           }
                           else if(j==3){
                               if(connectfourGame[i][j]==1)
                                   mPaint.setColor(Color.argb(225,225,0,225));
                               if(connectfourGame[i][j]==2)
                                   mPaint.setColor(Color.argb(225,225,225,0));
                               mCanvus.drawCircle(800,350 ,50, mPaint);
                           }
                           else if(j==4){
                               if(connectfourGame[i][j]==1)
                                   mPaint.setColor(Color.argb(225,225,0,225));
                               if(connectfourGame[i][j]==2)
                                   mPaint.setColor(Color.argb(225,225,225,0));
                               mCanvus.drawCircle(800,450 ,50, mPaint);
                           }
                           else if(j==5){
                               if(connectfourGame[i][j]==1)
                                   mPaint.setColor(Color.argb(225,225,0,225));
                               if(connectfourGame[i][j]==2)
                                   mPaint.setColor(Color.argb(225,225,225,0));
                               mCanvus.drawCircle(800,550 ,50, mPaint);
                           }
                       }
                       else if(i==5){
                           if(j==0){
                               if(connectfourGame[i][j]==1)
                                   mPaint.setColor(Color.argb(225,225,0,225));
                               if(connectfourGame[i][j]==2)
                                   mPaint.setColor(Color.argb(225,225,225,0));
                               mCanvus.drawCircle(900,50,50, mPaint);
                           }
                           else if(j==1){
                               if(connectfourGame[i][j]==1)
                                   mPaint.setColor(Color.argb(225,225,0,225));
                               if(connectfourGame[i][j]==2)
                                   mPaint.setColor(Color.argb(225,225,225,0));
                               mCanvus.drawCircle(900,150 ,50, mPaint);
                           }
                           else if(j==2){
                               if(connectfourGame[i][j]==1)
                                   mPaint.setColor(Color.argb(225,225,0,225));
                               if(connectfourGame[i][j]==2)
                                   mPaint.setColor(Color.argb(225,225,225,0));
                               mCanvus.drawCircle(900,250 ,50, mPaint);
                           }
                           else if(j==3){
                               if(connectfourGame[i][j]==1)
                                   mPaint.setColor(Color.argb(225,225,0,225));
                               if(connectfourGame[i][j]==2)
                                   mPaint.setColor(Color.argb(225,225,225,0));
                               mCanvus.drawCircle(900,350 ,50, mPaint);
                           }
                           else if(j==4){
                               if(connectfourGame[i][j]==1)
                                   mPaint.setColor(Color.argb(225,225,0,225));
                               if(connectfourGame[i][j]==2)
                                   mPaint.setColor(Color.argb(225,225,225,0));
                               mCanvus.drawCircle(900,450 ,50, mPaint);
                           }
                           else if(j==5){
                               if(connectfourGame[i][j]==1)
                                   mPaint.setColor(Color.argb(225,225,0,225));
                               if(connectfourGame[i][j]==2)
                                   mPaint.setColor(Color.argb(225,225,225,0));
                               mCanvus.drawCircle(900,550 ,50, mPaint);
                           }
                       }
                   }
               }
           }
       }
       checkWinningHorizantal1();
       checkWinningHorizantal2();
       checkWinningVertical1();
       checkWinningVertical2();
       DraigonalCheck1();
       DraigonalCheck2();
       DraigonalOppositCheck1();
       DraigonalOppositCheck2();
       if(s.equals("done"))
       {

           mPaint.setColor(Color.argb(220,20,67,26));
           if(kg==1){
           Log.i("info"," "+pqr1);
           Log.i("info","winn"+pqr);
           for(int i=0;i<4;i++){
               if(pqr1==0){
                   if(pqr==0){
                       mCanvus.drawCircle(400,50 ,50, mPaint);
                   }
                   else if(pqr==1){
                       mCanvus.drawCircle(500,50 ,50, mPaint);
                   }
                   else if(pqr==2){
                       mCanvus.drawCircle(600,50 ,50, mPaint);
                   }else if(pqr==3){
                       mCanvus.drawCircle(700,50 ,50, mPaint);
                   }
                   else if(pqr==4){
                       mCanvus.drawCircle(800,50 ,50, mPaint);
                   }else if(pqr==5){
                       mCanvus.drawCircle(900,50 ,50, mPaint);
                   }
               }
               if(pqr1==1){
                   if(pqr==0){
                       mCanvus.drawCircle(400,150 ,50, mPaint);
                   }
                   else if(pqr==1){
                       mCanvus.drawCircle(500,150 ,50, mPaint);
                   }
                   else if(pqr==2){
                       mCanvus.drawCircle(600,150 ,50, mPaint);
                   }else if(pqr==3){
                       mCanvus.drawCircle(700,150 ,50, mPaint);
                   }
                   else if(pqr==4){
                       mCanvus.drawCircle(800,150 ,50, mPaint);
                   }else if(pqr==5){
                       mCanvus.drawCircle(900,150 ,50, mPaint);
                   }
               }
               if(pqr1==2){
                   if(pqr==0){
                       mCanvus.drawCircle(400,250 ,50, mPaint);
                   }
                   else if(pqr==1){
                       mCanvus.drawCircle(500,250 ,50, mPaint);
                   }
                   else if(pqr==2){
                       mCanvus.drawCircle(600,250 ,50, mPaint);
                   }else if(pqr==3){
                       mCanvus.drawCircle(700,250 ,50, mPaint);
                   }
                   else if(pqr==4){
                       mCanvus.drawCircle(800,250 ,50, mPaint);
                   }else if(pqr==5){
                       mCanvus.drawCircle(900,250 ,50, mPaint);
                   }
               }
               if(pqr1==3){
                   if(pqr==0){
                       mCanvus.drawCircle(400,350 ,50, mPaint);
                   }
                   else if(pqr==1){
                       mCanvus.drawCircle(500,350 ,50, mPaint);
                   }
                   else if(pqr==2){
                       mCanvus.drawCircle(600,350 ,50, mPaint);
                   }else if(pqr==3){
                       mCanvus.drawCircle(700,350 ,50, mPaint);
                   }
                   else if(pqr==4){
                       mCanvus.drawCircle(800,350 ,50, mPaint);
                   }else if(pqr==5){
                       mCanvus.drawCircle(900,350 ,50, mPaint);
                   }
               }
               if(pqr1==4){
                   if(pqr==0){
                       mCanvus.drawCircle(400,450 ,50, mPaint);
                   }
                   else if(pqr==1){
                       mCanvus.drawCircle(500,450 ,50, mPaint);
                   }
                   else if(pqr==2){
                       mCanvus.drawCircle(600,450 ,50, mPaint);
                   }else if(pqr==3){
                       mCanvus.drawCircle(700,450 ,50, mPaint);
                   }
                   else if(pqr==4){
                       mCanvus.drawCircle(800,450 ,50, mPaint);
                   }else if(pqr==5){
                       mCanvus.drawCircle(900,450 ,50, mPaint);
                   }
               }
               if(pqr1==5){
                   if(pqr==0){
                       mCanvus.drawCircle(400,550 ,50, mPaint);
                   }
                   else if(pqr==1){
                       mCanvus.drawCircle(500,550 ,50, mPaint);
                       Log.i("info"," "+1);
                   }
                   else if(pqr==2){
                       mCanvus.drawCircle(600,550 ,50, mPaint);
                       Log.i("info"," "+2);
                   }else if(pqr==3){
                       mCanvus.drawCircle(700,550 ,50, mPaint);
                       Log.i("info"," "+3);
                   }
                   else if(pqr==4){
                       mCanvus.drawCircle(800,550 ,50, mPaint);
                       Log.i("info"," "+4);
                   }else if(pqr==5){
                       mCanvus.drawCircle(900,550 ,50, mPaint);
                   }
               }
               pqr--;
           }}
           if(kg==2){
               Log.i("info"," "+pqr1);
               Log.i("info","winn"+pqr);
               for(int i=0;i<4;i++){
                   if(pqr1==0){
                       if(pqr==0){
                           mCanvus.drawCircle(400,50 ,50, mPaint);
                       }
                       else if(pqr==1){
                           mCanvus.drawCircle(400,150 ,50, mPaint);
                       }
                       else if(pqr==2){
                           mCanvus.drawCircle(400,250 ,50, mPaint);
                       }else if(pqr==3){
                           mCanvus.drawCircle(400,350 ,50, mPaint);
                       }
                       else if(pqr==4){
                           mCanvus.drawCircle(400,450 ,50, mPaint);
                       }else if(pqr==5){
                           mCanvus.drawCircle(400,550 ,50, mPaint);
                       }
                   }
                   if(pqr1==1){
                       if(pqr==0){
                           mCanvus.drawCircle(500,50 ,50, mPaint);
                       }
                       else if(pqr==1){
                           mCanvus.drawCircle(500,150 ,50, mPaint);
                       }
                       else if(pqr==2){
                           mCanvus.drawCircle(500,250 ,50, mPaint);
                       }else if(pqr==3){
                           mCanvus.drawCircle(500,350 ,50, mPaint);
                       }
                       else if(pqr==4){
                           mCanvus.drawCircle(500,450 ,50, mPaint);
                       }else if(pqr==5){
                           mCanvus.drawCircle(500,550 ,50, mPaint);
                       }
                   }
                   if(pqr1==2){
                       if(pqr==0){
                           mCanvus.drawCircle(600,50 ,50, mPaint);
                       }
                       else if(pqr==1){
                           mCanvus.drawCircle(600,150 ,50, mPaint);
                       }
                       else if(pqr==2){
                           mCanvus.drawCircle(600,250 ,50, mPaint);
                       }else if(pqr==3){
                           mCanvus.drawCircle(600,350 ,50, mPaint);
                       }
                       else if(pqr==4){
                           mCanvus.drawCircle(600,450 ,50, mPaint);
                       }else if(pqr==5){
                           mCanvus.drawCircle(600,550 ,50, mPaint);
                       }
                   }
                   if(pqr1==3){
                       if(pqr==0){
                           mCanvus.drawCircle(700,50 ,50, mPaint);
                       }
                       else if(pqr==1){
                           mCanvus.drawCircle(700,150 ,50, mPaint);
                       }
                       else if(pqr==2){
                           mCanvus.drawCircle(700,250 ,50, mPaint);
                       }else if(pqr==3){
                           mCanvus.drawCircle(700,350 ,50, mPaint);
                       }
                       else if(pqr==4){
                           mCanvus.drawCircle(700,450 ,50, mPaint);
                       }else if(pqr==5){
                           mCanvus.drawCircle(700,550 ,50, mPaint);
                       }
                   }
                   if(pqr1==4){
                       if(pqr==0){
                           mCanvus.drawCircle(800,50 ,50, mPaint);
                       }
                       else if(pqr==1){
                           mCanvus.drawCircle(800,150 ,50, mPaint);
                       }
                       else if(pqr==2){
                           mCanvus.drawCircle(800,250 ,50, mPaint);
                       }else if(pqr==3){
                           mCanvus.drawCircle(800,350 ,50, mPaint);
                       }
                       else if(pqr==4){
                           mCanvus.drawCircle(800,450 ,50, mPaint);
                       }else if(pqr==5){
                           mCanvus.drawCircle(800,550 ,50, mPaint);
                       }
                   }
                   if(pqr1==5){
                       if(pqr==0){
                           mCanvus.drawCircle(900,50 ,50, mPaint);
                       }
                       else if(pqr==1){
                           mCanvus.drawCircle(900,150 ,50, mPaint);
                           Log.i("info"," "+1);
                       }
                       else if(pqr==2){
                           mCanvus.drawCircle(900,250 ,50, mPaint);
                           Log.i("info"," "+2);
                       }else if(pqr==3){
                           mCanvus.drawCircle(900,350 ,50, mPaint);
                           Log.i("info"," "+3);
                       }
                       else if(pqr==4){
                           mCanvus.drawCircle(900,450 ,50, mPaint);
                           Log.i("info"," "+4);
                       }else if(pqr==5){
                           mCanvus.drawCircle(900,550 ,50, mPaint);
                       }
                   }

                   pqr--;
               }}
           if(kg==3){
             //  Log.i("info"," "+pqr1);
               //Log.i("info","winn"+pqr);
               Log.i("info"," "+pqr);
               Log.i("info"," "+pqr1);
               for(int i=0;i<4;i++){
                   if(pqr1==0){
                       if(pqr==0){
                           mCanvus.drawCircle(400,50 ,50, mPaint);
                       }
                       else if(pqr==1){
                           mCanvus.drawCircle(500,50 ,50, mPaint);
                       }
                       else if(pqr==2){
                           mCanvus.drawCircle(600,50 ,50, mPaint);
                       }else if(pqr==3){
                           mCanvus.drawCircle(700,550 ,50, mPaint);
                       }
                       else if(pqr==4){
                           mCanvus.drawCircle(800,50 ,50, mPaint);
                       }else if(pqr==5){
                           mCanvus.drawCircle(900,50 ,50, mPaint);
                       }
                   }
                   if(pqr1==1){
                       if(pqr==0){
                           mCanvus.drawCircle(400,150 ,50, mPaint);
                       }
                       else if(pqr==1){
                           mCanvus.drawCircle(500,150 ,50, mPaint);
                       }
                       else if(pqr==2){
                           mCanvus.drawCircle(600,150 ,50, mPaint);
                       }else if(pqr==3){
                           mCanvus.drawCircle(700,150 ,50, mPaint);
                       }
                       else if(pqr==4){
                           mCanvus.drawCircle(800,150 ,50, mPaint);
                       }else if(pqr==5){
                           mCanvus.drawCircle(900,150 ,50, mPaint);
                       }
                   }
                   if(pqr1==2){
                       if(pqr==0){
                           mCanvus.drawCircle(400,250 ,50, mPaint);
                       }
                       else if(pqr==1){
                           mCanvus.drawCircle(500,250 ,50, mPaint);
                       }
                       else if(pqr==2){
                           mCanvus.drawCircle(600,250 ,50, mPaint);
                       }else if(pqr==3){
                           mCanvus.drawCircle(700,250 ,50, mPaint);
                       }
                       else if(pqr==4){
                           mCanvus.drawCircle(800,250 ,50, mPaint);
                       }else if(pqr==5){
                           mCanvus.drawCircle(900,250 ,50, mPaint);
                       }
                   }
                   if(pqr1==3){
                       if(pqr==0){
                           mCanvus.drawCircle(400,350 ,50, mPaint);
                       }
                       else if(pqr==1){
                           mCanvus.drawCircle(500,350 ,50, mPaint);
                       }
                       else if(pqr==2){
                           mCanvus.drawCircle(600,350 ,50, mPaint);
                       }else if(pqr==3){
                           mCanvus.drawCircle(700,350 ,50, mPaint);
                       }
                       else if(pqr==4){
                           mCanvus.drawCircle(800,350 ,50, mPaint);
                       }else if(pqr==5){
                           mCanvus.drawCircle(900,350 ,50, mPaint);
                       }
                   }
                   if(pqr1==4){
                       if(pqr==0){
                           mCanvus.drawCircle(400,450 ,50, mPaint);
                       }
                       else if(pqr==1){
                           mCanvus.drawCircle(500,450 ,50, mPaint);
                       }
                       else if(pqr==2){
                           mCanvus.drawCircle(600,450 ,50, mPaint);
                       }else if(pqr==3){
                           mCanvus.drawCircle(700,450 ,50, mPaint);
                       }
                       else if(pqr==4){
                           mCanvus.drawCircle(800,450 ,50, mPaint);
                       }else if(pqr==5){
                           mCanvus.drawCircle(900,450 ,50, mPaint);
                       }
                   }
                   if(pqr1==5){
                       if(pqr==0){
                           mCanvus.drawCircle(400,550 ,50, mPaint);
                       }
                       else if(pqr==1){
                           mCanvus.drawCircle(500,550 ,50, mPaint);
                           Log.i("info"," "+1);
                       }
                       else if(pqr==2){
                           mCanvus.drawCircle(600,550 ,50, mPaint);
                           Log.i("info"," "+2);
                       }else if(pqr==3){
                           mCanvus.drawCircle(700,550 ,50, mPaint);
                           Log.i("info"," "+3);
                       }
                       else if(pqr==4){
                           mCanvus.drawCircle(800,550 ,50, mPaint);
                           Log.i("info"," "+4);
                       }else if(pqr==5){
                           mCanvus.drawCircle(900,550 ,50, mPaint);
                       }
                   }
                   Log.i("info"," "+pqr);
                   Log.i("info"," "+pqr1);
                   pqr1++;
                   pqr--;
               }}
           if(kg==4){
               //  Log.i("info"," "+pqr1);
               //Log.i("info","winn"+pqr);
               Log.i("info"," "+pqr);
               Log.i("info"," "+pqr1);
               for(int i=0;i<4;i++){
                   if(pqr1==0){
                       if(pqr==0){
                           mCanvus.drawCircle(400,50 ,50, mPaint);
                       }
                       else if(pqr==1){
                           mCanvus.drawCircle(500,50 ,50, mPaint);
                       }
                       else if(pqr==2){
                           mCanvus.drawCircle(600,50 ,50, mPaint);
                       }else if(pqr==3){
                           mCanvus.drawCircle(700,550 ,50, mPaint);
                       }
                       else if(pqr==4){
                           mCanvus.drawCircle(800,50 ,50, mPaint);
                       }else if(pqr==5){
                           mCanvus.drawCircle(900,50 ,50, mPaint);
                       }
                   }
                   if(pqr1==1){
                       if(pqr==0){
                           mCanvus.drawCircle(400,150 ,50, mPaint);
                       }
                       else if(pqr==1){
                           mCanvus.drawCircle(500,150 ,50, mPaint);
                       }
                       else if(pqr==2){
                           mCanvus.drawCircle(600,150 ,50, mPaint);
                       }else if(pqr==3){
                           mCanvus.drawCircle(700,150 ,50, mPaint);
                       }
                       else if(pqr==4){
                           mCanvus.drawCircle(800,150 ,50, mPaint);
                       }else if(pqr==5){
                           mCanvus.drawCircle(900,150 ,50, mPaint);
                       }
                   }
                   if(pqr1==2){
                       if(pqr==0){
                           mCanvus.drawCircle(400,250 ,50, mPaint);
                       }
                       else if(pqr==1){
                           mCanvus.drawCircle(500,250 ,50, mPaint);
                       }
                       else if(pqr==2){
                           mCanvus.drawCircle(600,250 ,50, mPaint);
                       }else if(pqr==3){
                           mCanvus.drawCircle(700,250 ,50, mPaint);
                       }
                       else if(pqr==4){
                           mCanvus.drawCircle(800,250 ,50, mPaint);
                       }else if(pqr==5){
                           mCanvus.drawCircle(900,250 ,50, mPaint);
                       }
                   }
                   if(pqr1==3){
                       if(pqr==0){
                           mCanvus.drawCircle(400,350 ,50, mPaint);
                       }
                       else if(pqr==1){
                           mCanvus.drawCircle(500,350 ,50, mPaint);
                       }
                       else if(pqr==2){
                           mCanvus.drawCircle(600,350 ,50, mPaint);
                       }else if(pqr==3){
                           mCanvus.drawCircle(700,350 ,50, mPaint);
                       }
                       else if(pqr==4){
                           mCanvus.drawCircle(800,350 ,50, mPaint);
                       }else if(pqr==5){
                           mCanvus.drawCircle(900,350 ,50, mPaint);
                       }
                   }
                   if(pqr1==4){
                       if(pqr==0){
                           mCanvus.drawCircle(400,450 ,50, mPaint);
                       }
                       else if(pqr==1){
                           mCanvus.drawCircle(500,450 ,50, mPaint);
                       }
                       else if(pqr==2){
                           mCanvus.drawCircle(600,450 ,50, mPaint);
                       }else if(pqr==3){
                           mCanvus.drawCircle(700,450 ,50, mPaint);
                       }
                       else if(pqr==4){
                           mCanvus.drawCircle(800,450 ,50, mPaint);
                       }else if(pqr==5){
                           mCanvus.drawCircle(900,450 ,50, mPaint);
                       }
                   }
                   if(pqr1==5){
                       if(pqr==0){
                           mCanvus.drawCircle(400,550 ,50, mPaint);
                       }
                       else if(pqr==1){
                           mCanvus.drawCircle(500,550 ,50, mPaint);
                           Log.i("info"," "+1);
                       }
                       else if(pqr==2){
                           mCanvus.drawCircle(600,550 ,50, mPaint);
                           Log.i("info"," "+2);
                       }else if(pqr==3){
                           mCanvus.drawCircle(700,550 ,50, mPaint);
                           Log.i("info"," "+3);
                       }
                       else if(pqr==4){
                           mCanvus.drawCircle(800,550 ,50, mPaint);
                           Log.i("info"," "+4);
                       }else if(pqr==5){
                           mCanvus.drawCircle(900,550 ,50, mPaint);
                       }
                   }
                   Log.i("info"," "+pqr);
                   Log.i("info"," "+pqr1);
                   pqr1++;
                   pqr++;
               }}

           Log.i("info","winn"+pqr);
           //goingOn=false;

           goingOn=false;

       }

if(goingOn==false){
    mPaint.setColor(Color.argb(225,225,225,225));
    mCanvus.drawRect(view1,mPaint);
    mPaint.setColor(Color.argb(225,0,0,225));
    mPaint.setTextSize(50);
    mCanvus.drawText("winner is ",50,250,mPaint);
    if(player1==true)
    mCanvus.drawText("player2 ",50,350,mPaint);
    else
        mCanvus.drawText("player1 ",50,350,mPaint);

    mCanvus.drawText("Restart",50,500,mPaint);
    ju=1;
}
       mSurfaceHolder.unlockCanvasAndPost(mCanvus);
   }
    }
    @Override
    public boolean onTouchEvent(MotionEvent motionEvent){
        if ((motionEvent.getAction() &
                MotionEvent.ACTION_MASK)
                == MotionEvent.ACTION_MOVE){
            if(count3==1){
         if((motionEvent.getX()>325)&&(motionEvent.getX()<425)){
            // mPaint.setColor(Color.argb(225,225,0,225));
             //mCanvus.drawCircle(400,50 ,50, mPaint);
             count=1;
            count2=1;
            distance=50;
            count3=0;
            if(player1==true)
            {
                player1=false;
                //player2=true;
            }
            else{
                player1=true;
               // player2=false;
            }

         }
         else if((motionEvent.getX()>425)&&(motionEvent.getX()<525)){
             count=2;
             count2=1;
             distance=50;
             count3=0;
             if(player1==true)
             {
                 player1=false;
                 //player2=true;
             }
             else{
                 player1=true;
                 // player2=false;
             }
         }
         else if((motionEvent.getX()>525)&&(motionEvent.getX()<625)){
             count=3;
             count2=1;
             distance=50;
             count3=0;
             if(player1==true)
             {
                 player1=false;
                 //player2=true;
             }
             else{
                 player1=true;
                 // player2=false;
             }
         }
         else if((motionEvent.getX()>625)&&(motionEvent.getX()<725)){
             count=4;
             count2=1;
             distance=50;
             count3=0;
             if(player1==true)
             {
                 player1=false;
                 //player2=true;
             }
             else{
                 player1=true;
                 // player2=false;
             }
         }
         else if((motionEvent.getX()>725)&&(motionEvent.getX()<825)){
             count=5;
             count2=1;
             distance=50;
             count3=0;
             if(player1==true)
             {
                 player1=false;
                 //player2=true;
             }
             else{
                 player1=true;
                 // player2=false;
             }
         }
         else if((motionEvent.getX()>825)&&(motionEvent.getX()<925)){
             count=6;
             count2=1;
             distance=50;
             count3=0;
             if(player1==true)
             {
                 player1=false;
                 //player2=true;
             }
             else{
                 player1=true;
                 // player2=false;
             }
         }

        }
         if((motionEvent.getX()>50)&&(motionEvent.getX()<150)&&(motionEvent.getY()>500)&&(motionEvent.getY()<530)){
            restart();
            }
        }
    return true;
}
    public boolean updateRequired() {

        // Run at 10 frames per second
        final long TARGET_FPS = 1;
        // There are 1000 milliseconds in a second
        final long MILLIS_PER_SECOND = 1000;

        // Are we due to update the frame
        if(mNextFrameTime <= System.currentTimeMillis()){
            // Tenth of a second has passed

            // Setup when the next update will be triggered
            mNextFrameTime =System.currentTimeMillis()+0.0005;
                    //MILLIS_PER_SECOND / TARGET_FPS;

            // Return true so that the update and draw
            // methods are executed
            return true;
        }

        return false;
    }
    public void update(){
    if(count2==1){

        if((count==1)&&(a>=0)){
            distance++;
            if(a==5){
                if(distance==550){
                    distance=-50;
                    if(player1==true)
                     connectfourGame[0][a]=1;
                    else
                        connectfourGame[0][a]=2;
                    a--;
                    count2=0;
                    count3=1;
                }
            }
            else if(a==4){
                if(distance==450){
                    distance=-50;
                    if(player1==true)
                    connectfourGame[0][a]=1;
                    else
                        connectfourGame[0][a]=2;
                    a--;
                    count2=0;
                    count3=1;
                }
            }
            else if(a==3){
                if(distance==350){
                    distance=-50;
                    if(player1==true)
                        connectfourGame[0][a]=1;
                    else
                        connectfourGame[0][a]=2;
                    a--;
                    count2=0;
                    count3=1;
                }
            }
            else if(a==2){
                if(distance==250){
                    distance=-50;
                    if(player1==true)
                        connectfourGame[0][a]=1;
                    else
                        connectfourGame[0][a]=2;
                    a--;
                    count2=0;
                    count3=1;
                }
            }
            else if(a==1){
                if(distance==150){
                    distance=-50;
                    if(player1==true)
                        connectfourGame[0][a]=1;
                    else
                        connectfourGame[0][a]=2;
                    a--;
                    count2=0;
                    count3=1;
                }
            }
            else if(a==0) {
                distance--;
                if (distance==50) {
                    distance = -50;
                    if(player1==true)
                        connectfourGame[0][a]=1;
                    else
                        connectfourGame[0][a]=2;
                    a--;
                    count2=0;
                    count3=1;
                }
            }
        }
        else if((count==2)&&(b>=0)){
            distance++;
            if(b==5){
                if(distance==550){
                    distance=-50;
                    if(player1==true)
                        connectfourGame[1][b]=1;
                    else
                        connectfourGame[1][b]=2;
                    b--;
                   count2=0;
                    count3=1;
                }
            }
            else if(b==4){
                if(distance==450){
                    distance=-50;
                    if(player1==true)
                        connectfourGame[1][b]=1;
                    else
                        connectfourGame[1][b]=2;
                    b--;
                    count2=0;
                    count3=1;
                }
            }
            else if(b==3){
                if(distance==350){
                    distance=-50;
                    if(player1==true)
                        connectfourGame[1][b]=1;
                    else
                        connectfourGame[1][b]=2;
                    b--;
                    count2=0;
                    count3=1;
                }
            }
            else if(b==2){
                if(distance==250){
                    distance=-50;
                    if(player1==true)
                        connectfourGame[1][b]=1;
                    else
                        connectfourGame[1][b]=2;
                    b--;
                    count2=0;
                    count3=1;
                }
            }
            else if(b==1){
                if(distance==150){
                    distance=-50;
                    if(player1==true)
                        connectfourGame[1][b]=1;
                    else
                        connectfourGame[1][b]=2;
                    b--;
                    count2=0;
                    count3=1;
                }
            }
            else if(b==0) {
                distance--;
                if (distance == 50) {
                    distance = 50;
                    if(player1==true)
                        connectfourGame[1][b]=1;
                    else
                        connectfourGame[1][b]=2;
                    b--;
                    count2=0;
                    count3=1;
                }
            }
        }
        if((count==3)&&(c>=0)){
            distance++;
            if(c==5){
                if(distance==550){
                    distance=-50;
                    if(player1==true)
                        connectfourGame[2][c]=1;
                    else
                        connectfourGame[2][c]=2;
                    c--;
                    count2=0;
                    count3=1;
                }
            }
            else if(c==4){
                if(distance==450){
                    distance=-50;
                    if(player1==true)
                        connectfourGame[2][c]=1;
                    else
                        connectfourGame[2][c]=2;
                    c--;
                    count2=0;
                    count3=1;
                }
            }
            else if(c==3){
                if(distance==350){
                    distance=-50;
                    if(player1==true)
                        connectfourGame[2][c]=1;
                    else
                        connectfourGame[2][c]=2;
                    c--;
                    count2=0;
                    count3=1;
                }
            }
            else if(c==2){
                if(distance==250){
                    distance=-50;
                    if(player1==true)
                        connectfourGame[2][c]=1;
                    else
                        connectfourGame[2][c]=2;
                    c--;
                    count2=0;
                    count3=1;
                }
            }
            else if(c==1){
                if(distance==150){
                    distance=-50;
                    if(player1==true)
                        connectfourGame[2][c]=1;
                    else
                        connectfourGame[2][c]=2;
                    c--;
                    count2=0;
                    count3=1;
                }
            }
            else if(c==0) {
                distance--;
                if (distance==50) {
                    distance = -50;
                    if(player1==true)
                        connectfourGame[2][c]=1;
                    else
                        connectfourGame[2][c]=2;
                    c--;
                    count2=0;
                    count3=1;
                }
            }
        }
        if((count==4)&&(d>=0)){
            distance++;
            if(d==5){
                if(distance==550){
                    distance=-50;
                    if(player1==true)
                        connectfourGame[3][d]=1;
                    else
                        connectfourGame[3][d]=2;
                    d--;
                    count2=0;
                    count3=1;
                }
            }
            else if(d==4){
                if(distance==450){
                    distance=-50;
                    if(player1==true)
                        connectfourGame[3][d]=1;
                    else
                        connectfourGame[3][d]=2;
                    d--;
                    count2=0;
                    count3=1;
                }
            }
            else if(d==3){
                if(distance==350){
                    distance=-50;
                    if(player1==true)
                        connectfourGame[3][d]=1;
                    else
                        connectfourGame[3][d]=2;
                    d--;
                    count2=0;
                    count3=1;
                }
            }
            else if(d==2){
                if(distance==250){
                    distance=-50;
                    if(player1==true)
                        connectfourGame[3][d]=1;
                    else
                        connectfourGame[3][d]=2;
                    d--;
                    count2=0;
                    count3=1;
                }
            }
            else if(d==1){
                if(distance==150){
                    distance=-50;
                    if(player1==true)
                        connectfourGame[3][d]=1;
                    else
                        connectfourGame[3][d]=2;
                    d--;
                    count2=0;
                    count3=1;
                }
            }
            else if(d==0) {
                distance--;
                if (distance==50) {
                    distance = -50;
                    if(player1==true)
                        connectfourGame[3][d]=1;
                    else
                        connectfourGame[3][d]=2;
                    d--;
                    count2=0;
                    count3=1;
                }
            }
        }
        if((count==5)&&(e>=0)){
            distance++;
            if(e==5){
                if(distance==550){
                    distance=-50;
                    if(player1==true)
                        connectfourGame[4][e]=1;
                    else
                        connectfourGame[4][e]=2;
                    e--;
                    count2=0;
                    count3=1;
                }
            }
            else if(e==4){
                if(distance==450){
                    distance=-50;
                    if(player1==true)
                        connectfourGame[4][e]=1;
                    else
                        connectfourGame[4][e]=2;
                    e--;
                    count2=0;
                    count3=1;
                }
            }
            else if(e==3){
                if(distance==350){
                    distance=-50;
                    if(player1==true)
                        connectfourGame[4][e]=1;
                    else
                        connectfourGame[4][e]=2;
                    e--;
                    count2=0;
                    count3=1;
                }
            }
            else if(e==2){
                if(distance==250){
                    distance=-50;
                    if(player1==true)
                        connectfourGame[4][e]=1;
                    else
                        connectfourGame[4][e]=2;
                    e--;
                    count2=0;
                    count3=1;
                }
            }
            else if(e==1){
                if(distance==150){
                    distance=-50;
                    if(player1==true)
                        connectfourGame[4][e]=1;
                    else
                        connectfourGame[4][e]=2;
                    e--;
                    count2=0;
                    count3=1;
                }
            }
            else if(e==0) {
                distance--;
                if (distance==50) {
                    distance = -50;
                    if(player1==true)
                        connectfourGame[4][e]=1;
                    else
                        connectfourGame[4][e]=2;
                    e--;
                    count2=0;
                    count3=1;
                }
            }
        }
        if((count==6)&&(f>=0)){
            distance++;
            if(f==5){
                if(distance==550){
                    distance=-50;
                    if(player1==true)
                        connectfourGame[5][f]=1;
                    else
                        connectfourGame[5][f]=2;
                    f--;
                    count2=0;
                    count3=1;
                }
            }
            else if(f==4){
                if(distance==450){
                    distance=-50;
                    if(player1==true)
                        connectfourGame[5][f]=1;
                    else
                        connectfourGame[5][f]=2;
                    f--;
                    count2=0;
                    count3=1;
                }
            }
            else if(f==3){
                if(distance==350){
                    distance=-50;
                    if(player1==true)
                        connectfourGame[5][f]=1;
                    else
                        connectfourGame[5][f]=2;
                    f--;
                    count2=0;
                    count3=1;
                }
            }
            else if(f==2){
                if(distance==250){
                    distance=-50;
                    if(player1==true)
                        connectfourGame[5][f]=1;
                    else
                        connectfourGame[5][f]=2;
                    f--;
                    count2=0;
                    count3=1;
                }
            }
            else if(f==1){
                if(distance==150){
                    distance=-50;
                    if(player1==true)
                        connectfourGame[5][f]=1;
                    else
                        connectfourGame[5][f]=2;
                    f--;
                    count2=0;
                    count3=1;
                }
            }
            else if(f==0) {
                distance--;
                if (distance==50) {
                    distance = -50;
                    if(player1==true)
                        connectfourGame[5][f]=1;
                    else
                        connectfourGame[5][f]=2;
                    f--;
                    count2=0;
                    count3=1;
                }
            }
        }
    }}
    public void checkWinningHorizantal1(){
    int ll=0 ;
    int kk=0;
    int gg=1;
    int hj=0;
    int countable=0;
    for(int m=0;m<6;m++){
    for(int k=0;k<3;k++){
        for(int l=0;l<4;l++){
            if(connectfourGame[kk][ll]==1)
                countable++;
            kk++;
        }
        if(countable==4)
        {
            pqr=kk-1;
            pqr1=ll;
            kg=1;
            hj=1;
            break;
        }
        kk=gg;
        gg++;
        countable=0;
    }
    if(hj==1){
        s="done";
        break;}
    ll++;
    kk=0;
    gg=1;
    }
    }
    public void checkWinningHorizantal2(){
        int ll=0 ;
        int kk=0;
        int gg=1;
        int hj=0;
        int countable=0;
        for(int m=0;m<6;m++){
            for(int k=0;k<3;k++){
                for(int l=0;l<4;l++){
                    if(connectfourGame[kk][ll]==2)
                        countable++;
                    kk++;
                }
                if(countable==4)
                {
                    pqr=kk-1;
                    pqr1=ll;
                    kg=1;
                    hj=1;
                    break;
                }
                kk=gg;
                gg++;
                countable=0;
            }
            if(hj==1){
                s="done";
                break;}
            ll++;
            kk=0;
            gg=1;
        }
    }
    public void checkWinningVertical1(){
    int ll=0;
    int kk=0;
    int gg=1;
    int hj=0;
    int countify=0;
    for(int i=0;i<6;i++){
        for(int j=0;j<3;j++){
            for(int k=0;k<4;k++){
                if(connectfourGame[ll][kk]==1)
                    countify++;
                kk++;
            }
            if(countify==4){
                pqr=kk-1;
                pqr1=ll;
                kg=2;
                hj=1;
                break;
            }
            kk=gg;
            gg++;
            countify=0;
        }
        if(hj==1){
            s="done";
            break;
        }
        ll++;
        kk=0;
        gg=1;
    }
    }
    public void checkWinningVertical2(){
        int ll=0;
        int kk=0;
        int gg=1;
        int hj=0;
        int countify=0;
        for(int i=0;i<6;i++){
            for(int j=0;j<3;j++){
                for(int k=0;k<4;k++){
                    if(connectfourGame[ll][kk]==2)
                        countify++;
                    kk++;
                }
                if(countify==4){
                    pqr=kk-1;
                    pqr1=ll;
                    kg=2;
                    hj=1;
                    break;
                }
                kk=gg;
                gg++;
                countify=0;
            }
            if(hj==1){
                s="done";
                break;
            }
            ll++;
            kk=0;
            gg=1;
        }
    }
    public void DraigonalCheck2(){
    int l=0;
    int ll=5;
    int g=1;
    int gg=5;
    int cot=0;
    int hj=0;
    for(int i=0;i<3;i++){
        for(int j=0;j<3;j++){
            for(int k=0;k<4;k++){
                if(connectfourGame[l][ll]==2)
                    cot++;
                l++;
                ll--;
            }
            if(cot==4){
                pqr=l-1;
                pqr1=ll+1;
                kg=3;
                hj=1;
                break;
            }
            l=g;
            ll=gg;
            g++;
            cot=0;
        }
        if(hj==1){
         s="done";
         break;
        }
        gg--;
        ll=gg;
        l=0;
        g=1;
    }
    }
    public void DraigonalCheck1(){
        int l=0;
        int ll=5;
        int g=1;
        int gg=5;
        int cot=0;
        int hj=0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                for(int k=0;k<4;k++){
                    if(connectfourGame[l][ll]==1)
                        cot++;
                    l++;
                    ll--;
                }
                if(cot==4){
                    pqr=l-1;
                    pqr1=ll+1;
                    kg=3;
                    hj=1;
                    break;
                }
                l=g;
                ll=gg;
                g++;
                cot=0;
            }
            if(hj==1){
                s="done";
                break;
            }
            gg--;
            ll=gg;
            l=0;
            g=1;
        }
    }
    public void DraigonalOppositCheck1(){
        int l=5;
        int ll=5;
        int g=4;
        int gg=5;
        int cot=0;
        int hj=0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                for(int k=0;k<4;k++){
                    if(connectfourGame[l][ll]==1)
                        cot++;
                    l--;
                    ll--;
                }
                if(cot==4){
                    pqr=l+1;
                    pqr1=ll+1;
                    kg=4;
                    hj=1;
                    break;
                }
                l=g;
                ll=gg;
                g--;
                cot=0;
            }
            if(hj==1){
                s="done";
                break;
            }
            gg--;
            ll=gg;
            l=5;
            g=4;
        }
    }
    public void DraigonalOppositCheck2(){
        int l=5;
        int ll=5;
        int g=4;
        int gg=5;
        int cot=0;
        int hj=0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                for(int k=0;k<4;k++){
                    if(connectfourGame[l][ll]==2)
                        cot++;
                    l--;
                    ll--;
                }
                if(cot==4){
                    pqr=l+1;
                    pqr1=ll+1;
                    kg=4;
                    hj=1;
                    break;
                }
                l=g;
                ll=gg;
                g--;
                cot=0;
            }
            if(hj==1){
                s="done";
                break;
            }
            gg--;
            ll=gg;
            l=5;
            g=4;
        }
    }
    public void restart(){
    Log.i("info","restart");
    goingOn=true;
    if(ju==1){
        mThread = new Thread(this);
        mThread.start();

    }
        count1=1;
        count2=0;
        count3=1;
        ju=0;
    for(int i=0;i<6;i++){
        for(int j=0;j<6;j++){
            connectfourGame[i][j]=0;
        }
    }
       // connectfourGame=connectfourGame1;
        //connectfourGame1=connectfourGame1;
        player1=true;
        a=5;
        b=5;
        c=5;
        d=5;
        e=5;
        f=5;
        s=" ";
       // distance=50;

    }
    public void pause() {
        goingOn = false;
        try {
            mThread.join();

        } catch (InterruptedException e) {
            // Error
        }
    }


    // Start the thread
    public void resume() {
        goingOn = true;

        mThread = new Thread(this);
       //mThread1=mThread;
        mThread.start();
    }


}
