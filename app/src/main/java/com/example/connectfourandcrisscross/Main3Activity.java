package com.example.connectfourandcrisscross;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity implements Animation.AnimationListener{
  public  Animation animLeftRight;
   public ImageView imageView;
     public DatabaseClass databaseClass;
    public EditText id1;
    public  EditText pass1;
    public Button signin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        MyDialog myDialog = new MyDialog();
        myDialog.show(getSupportFragmentManager(), "123");
        loadAnimations();
        loadUI();
        working();
        final TextView signup=(TextView)findViewById(R.id.textView4);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 ShowDialog dialog=new ShowDialog();
                 dialog.show(getSupportFragmentManager(), "");

            }
        });


         databaseClass=new DatabaseClass(this);
          id1=(EditText)findViewById(R.id.editText);
           pass1=(EditText)findViewById(R.id.editText2);
          signin=(Button)findViewById(R.id.button);
       signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor c = databaseClass.searchName(
                        id1.getText().toString());

                if(c.getCount() > 0) {
                    c.moveToNext();


                    if(pass1.getText().toString().equals(c.getString(2))){
                        Log.i("info","12345");
                        takeToprofile();
                    }
                    else{
                        displayErrormesege();
                    }



                }
                else{
                    displayErrormesege();
                }
            }
        });
    }
    public void loadAnimations(){
        animLeftRight= AnimationUtils.loadAnimation(
                this, R.anim.left_right);
    }
    public void loadUI(){
        imageView = (ImageView) findViewById(R.id.imageView);
    }
    public void working(){
        animLeftRight.setDuration(500);
        animLeftRight.setAnimationListener(this);
        imageView.startAnimation(animLeftRight);

    }
    public void showdiolog1(){
      //  Toast.makeText(this,"addedSuccessfully",Toast.LENGTH_SHORT).show();
        ShowDialog1 myDialog1 = new ShowDialog1();
        myDialog1.show(getSupportFragmentManager(), "123");
    }
    public void showdiolog2(){
        //  Toast.makeText(this,"addedSuccessfully",Toast.LENGTH_SHORT).show();
        ShowDialog dialog=new ShowDialog();
        dialog.show(getSupportFragmentManager(), "");
    }
    public void confermationmessege(){
        Toast.makeText(this,"signedUp successfuly",Toast.LENGTH_SHORT).show();
    }
    public void takeToprofile(){

                Intent intent1=new Intent(this,Main4Activity.class);
                startActivity(intent1);

        }
        public void displayErrormesege(){
        ShowDialog2 show1=new ShowDialog2();
        show1.show(getSupportFragmentManager(),"");
        }


    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
