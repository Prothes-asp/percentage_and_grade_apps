package com.prothesbrand.subjectgradecalculate;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText edPhysics,edChemistry,edBiology,edMath,edComputer;
    private Button btn,resetBtn;
    private TextView tvDisplay,note;
    private AlertDialog.Builder alertDialogBuilder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES,WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES);
        this.getWindow().setStatusBarColor(getResources().getColor(R.color.black));
        this.getSupportActionBar().hide();
        View decorView = getWindow().getDecorView();
        int uioption = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        decorView.setSystemUiVisibility(uioption);
        setContentView(R.layout.activity_main);


        edPhysics = findViewById(R.id.edPhysics);
        edChemistry = findViewById(R.id.edChemistry);
        edBiology = findViewById(R.id.edBiology);
        edMath = findViewById(R.id.edMath);
        edComputer = findViewById(R.id.edComputer);
        btn = findViewById(R.id.btn);
        resetBtn = findViewById(R.id.resetBtn);
        tvDisplay = findViewById(R.id.tvDisplay);
        note = findViewById(R.id.note);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String physice = edPhysics.getText().toString();
                String chemistry = edChemistry.getText().toString();
                String biology = edBiology.getText().toString();
                String math = edMath.getText().toString();
                String computer = edComputer.getText().toString();

                if (physice.length()>0 && chemistry.length()>0 && biology.length()>0 && math.length()>0 && computer.length()>0){
                    int physicsSub,chemistrySub,biologySub,mathSub,computerSub;
                    physicsSub = Integer.parseInt(physice);
                    chemistrySub = Integer.parseInt(chemistry);
                    biologySub = Integer.parseInt(biology);
                    mathSub = Integer.parseInt(math);
                    computerSub = Integer.parseInt(computer);
                    if (physicsSub<=100 && chemistrySub<=100 && biologySub<=100 && mathSub<=100 && computerSub<=100){
                        int allSubPercentage;
                        allSubPercentage = ((physicsSub+chemistrySub+biologySub+mathSub+computerSub)/5);
                        note.setText("Good Job");
                        note.setTextColor(getResources().getColor(R.color.success));
                        if(allSubPercentage>=80){
                            tvDisplay.setText("Percentage is : "+allSubPercentage+"\nAnd"+"\nYour Grade is : A+");
                        }else if (allSubPercentage>=70) {
                            tvDisplay.setText("Percentage is : "+allSubPercentage+"\nAnd"+"\nYour Grade is : A");
                        }else if (allSubPercentage>=65) {
                            tvDisplay.setText("Percentage is : "+allSubPercentage+"\nAnd"+"\nYour Grade is : A-");
                        }else if (allSubPercentage>=60) {
                            tvDisplay.setText("Percentage is : "+allSubPercentage+"\nAnd"+"\nYour Grade is : B");
                        }else if (allSubPercentage>=50) {
                            tvDisplay.setText("Percentage is : "+allSubPercentage+"\nAnd"+"\nYour Grade is : B-");
                        }else if (allSubPercentage>=40) {
                            tvDisplay.setText("Percentage is : "+allSubPercentage+"\nAnd"+"\nYour Grade is : C");
                        }else if (allSubPercentage>=33) {
                            tvDisplay.setText("Percentage is : "+allSubPercentage+"\nAnd"+"\nYour Grade is : D");
                        }else{
                            tvDisplay.setText("Percentage is : "+allSubPercentage+"\nAnd"+"\nYour Grade is : F");
                        }

                    }else if (physicsSub>100) {
                        edPhysics.setError("Max 100");
                        tvDisplay.setText(null);
                    }else if (chemistrySub>100){
                        edChemistry.setError("Max 100");
                        tvDisplay.setText(null);
                    }else if (biologySub>100){
                        edBiology.setError("Max 100");
                        tvDisplay.setText(null);
                    }else if (mathSub>100){
                        edMath.setError("Max 100");
                        tvDisplay.setText(null);
                    }else if (computerSub>100){
                        edComputer.setError("Max 100");
                        tvDisplay.setText(null);
                    }
                }else if (physice.length()<=0 && chemistry.length()<=0 && biology.length()<=0 && math.length()<=0 && computer.length()<=0) {
                    tvDisplay.setText(null);
                    edPhysics.setError("Empty Field");
                    edChemistry.setError("Empty Field");
                    edBiology.setError("Empty Field");
                    edMath.setError("Empty Field");
                    edComputer.setError("Empty Field");
                }else if (physice.length()<=0) {
                    tvDisplay.setText(null);
                    edPhysics.setError("Empty Field");
                }else if (chemistry.length()<=0) {
                    tvDisplay.setText(null);
                    edChemistry.setError("Empty Field");
                }else if (biology.length()<=0) {
                    tvDisplay.setText(null);
                    edBiology.setError("Empty Field");
                }else if (math.length()<=0) {
                    tvDisplay.setText(null);
                    edMath.setError("Empty Field");
                }else if (computer.length()<=0) {
                    tvDisplay.setText(null);
                    edComputer.setError("Empty Field");
                }


            }
        });



        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvDisplay.setText(null);
                edPhysics.setText(null);
                edChemistry.setText(null);
                edBiology.setText(null);
                edMath.setText(null);
                edComputer.setText(null);
            }
        });


    }


    /** @noinspection deprecation*/
    @Override
    public void onBackPressed() {
        if(isTaskRoot()){
            alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setIcon(R.drawable.warning_svgrepo_com);
            alertDialogBuilder.setTitle("Warning");
            alertDialogBuilder.setMessage("Do you want exit this app?");
            alertDialogBuilder.setCancelable(false);
            alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }else{
            super.onBackPressed();
        }
    }
}