package com.example.sdcard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String filename="myf.txt";
        String filepath="fildir";

        Button bt1=(Button)findViewById(R.id.b1);
        Button bt2=(Button)findViewById(R.id.b2);
        TextView tv=(TextView)findViewById(R.id.tv);
        EditText et=(EditText)findViewById(R.id.et);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String filecontent=et.getText().toString();
                if(!filecontent.equals(""))
                {
                    File extfile=new File(getExternalFilesDir(filepath),filename);
                    try {
                        FileOutputStream fos=new FileOutputStream(extfile);
                        fos.write(filecontent.getBytes());
                        Toast.makeText(MainActivity.this, "WRITTEN ", Toast.LENGTH_SHORT).show();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        });


  bt2.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
          File myfi=new File(getExternalFilesDir(filepath),filename);
          StringBuilder sbu=new StringBuilder();
          try {
              FileReader fr=new FileReader(myfi);
             BufferedReader sb=new BufferedReader(fr);
             String line=sb.readLine();
             while(line!=null)
             {
                 sbu.append(line).append('\n');
                 line=sb.readLine();
             }


          } catch (FileNotFoundException e) {
              e.printStackTrace();
          } catch (IOException e) {
              e.printStackTrace();
          }finally {
              String finstr=sbu.toString();
              tv.setText(finstr);
          }


      }
  });




    }

}