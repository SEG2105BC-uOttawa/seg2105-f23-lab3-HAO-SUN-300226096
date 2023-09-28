package com.example.lab03_simplecalculator;


import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;

import android.database.DatabaseUtils;
import android.database.Observable;
import android.os.Bundle;
import android.view.View;


import com.example.lab03_simplecalculator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private MyviewModel myviewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        myviewModel = new ViewModelProvider(this,new ViewModelProvider.NewInstanceFactory()).get(MyviewModel.class);


        myviewModel.getMainNum().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.myTextView2.setText(myviewModel.getMainNum().getValue());

                if (myviewModel.sign2.equals("")) {

                    if (myviewModel.sign1.equals("")) {
                        binding.textView.setText(myviewModel.getMainNum().getValue());
                    } else {
                        binding.textView.setText(myviewModel.num[0] + myviewModel.sign1 + myviewModel.getMainNum().getValue());
                    }
                }else {
                    binding.textView.setText(myviewModel.num[0]+myviewModel.sign1+myviewModel.num[1]+myviewModel.sign2+myviewModel.getMainNum().getValue());
                }
            }
        });
        binding.button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myviewModel.setMainNum("0");
            }
        });
        binding.button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myviewModel.setMainNum("1");
            }
        });
        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myviewModel.setMainNum("2");
            }
        });
        binding.button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myviewModel.setMainNum("3");
            }
        });
        binding.button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myviewModel.setMainNum("4");
            }
        });
        binding.button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myviewModel.setMainNum("5");
            }
        });
        binding.button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myviewModel.setMainNum("6");
            }
        });
        binding.button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myviewModel.setMainNum("7");
            }
        });
        binding.button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myviewModel.setMainNum("8");
            }
        });
        binding.button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myviewModel.setMainNum("9");
            }
        });
        binding.buttonpoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!myviewModel.havePoint){
                    myviewModel.getMainNum().setValue(myviewModel.getMainNum().getValue()+".");
                    myviewModel.havePoint = true;

                }
            }
        });

        binding.buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (myviewModel.sign1.equals("")){
                    myviewModel.sign1="+";
                    myviewModel.num[0]= myviewModel.getMainNum().getValue();
                    myviewModel.getMainNum().setValue("0");
                    myviewModel.havePoint = false;
                }else if (myviewModel.sign2.equals("")){
                    myviewModel.num[0] = myviewModel.mainNumwith_0_Tocal();
                    myviewModel.sign1 = "+";
                    myviewModel.getMainNum().setValue("0");
                    myviewModel.havePoint = false;


                }else {
                    myviewModel.getMainNum().setValue(myviewModel.mainNumWithNum_1_Tocal());
                    myviewModel.sign2 = "";
                    myviewModel.num[1]="";
                    myviewModel.num[0] = myviewModel.mainNumwith_0_Tocal();
                    myviewModel.sign1="+";
                    myviewModel.getMainNum().setValue("0");
                    myviewModel.havePoint = false;
                }
            }
        });

        binding.buttonSubtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (myviewModel.sign1.equals("")){
                    myviewModel.sign1="-";
                    myviewModel.num[0]= myviewModel.getMainNum().getValue();
                    myviewModel.getMainNum().setValue("0");
                    myviewModel.havePoint = false;
                }else if (myviewModel.sign2.equals("")){
                    myviewModel.num[0] = myviewModel.mainNumwith_0_Tocal();
                    myviewModel.sign1 = "-";
                    myviewModel.getMainNum().setValue("0");
                    myviewModel.havePoint = false;


                }else {
                    myviewModel.getMainNum().setValue(myviewModel.mainNumWithNum_1_Tocal());
                    myviewModel.sign2 = "";
                    myviewModel.num[1]="";
                    myviewModel.num[0] = myviewModel.mainNumwith_0_Tocal();
                    myviewModel.sign1="-";
                    myviewModel.getMainNum().setValue("0");
                    myviewModel.havePoint = false;
                }
            }
        });
        binding.buttonmultiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(myviewModel.sign1.equals("")){
                    myviewModel.sign1 = "*";
                    myviewModel.num[0] = myviewModel.getMainNum().getValue();
                    myviewModel.getMainNum().setValue("0");
                    myviewModel.havePoint = false;

                }else if (myviewModel.sign2.equals("")){
                    if(myviewModel.sign1.equals("*") || myviewModel.sign1.equals("/")){
                        myviewModel.num[0] = myviewModel.mainNumwith_0_Tocal();
                        myviewModel.sign1 = "*";
                        myviewModel.getMainNum().setValue("0");
                        myviewModel.havePoint = false;

                    }else{
                        myviewModel.num[1] = myviewModel.getMainNum().getValue();
                        myviewModel.sign2 ="*";
                        myviewModel.getMainNum().setValue("0");
                        myviewModel.havePoint = false;


                    }
                } else {
                    myviewModel.num[1]=myviewModel.mainNumWithNum_1_Tocal();
                    myviewModel.sign2="*";
                    myviewModel.getMainNum().setValue("0");
                    myviewModel.havePoint = false;

                }
            }
        });

        binding.buttondivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(myviewModel.sign1.equals("")){
                    myviewModel.sign1 = "/";
                    myviewModel.num[0] = myviewModel.getMainNum().getValue();
                    myviewModel.getMainNum().setValue("0");
                    myviewModel.havePoint = false;

                }else if (myviewModel.sign2.equals("")){
                    if(myviewModel.sign1.equals("/") || myviewModel.sign1.equals("/")){
                        myviewModel.num[0] = myviewModel.mainNumwith_0_Tocal();
                        myviewModel.sign1 = "/";
                        myviewModel.getMainNum().setValue("0");
                        myviewModel.havePoint = false;

                    }else{
                        myviewModel.num[1] = myviewModel.getMainNum().getValue();
                        myviewModel.sign2 ="/";
                        myviewModel.getMainNum().setValue("0");
                        myviewModel.havePoint = false;


                    }
                } else {
                    myviewModel.num[1]=myviewModel.mainNumWithNum_1_Tocal();
                    myviewModel.sign2="/";
                    myviewModel.getMainNum().setValue("0");
                    myviewModel.havePoint = false;

                }
            }
        });
        binding.buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myviewModel.sign2="";
                myviewModel.num[1]="";
                myviewModel.sign1="";
                myviewModel.num[0]="";
                myviewModel.getMainNum().setValue("0");
                myviewModel.havePoint = false;

            }
        });
        binding.buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (myviewModel.sign2.equals("")){
                    if (! myviewModel.sign1.equals("")){
                        myviewModel.getMainNum().setValue(myviewModel.mainNumwith_0_Tocal());
                        if (myviewModel.getMainNum().getValue().contains("."))
                            myviewModel.havePoint = true;
                        else
                            myviewModel.havePoint = false;

                        myviewModel.num[0] = "";
                        myviewModel.sign1 = "";

                    }
                }else {
                    myviewModel.getMainNum().setValue(myviewModel.mainNumWithNum_1_Tocal());
                    myviewModel.num[1]="";
                    myviewModel.sign2 = "";
                    myviewModel.getMainNum().setValue(myviewModel.mainNumwith_0_Tocal());
                    if (myviewModel.getMainNum().getValue().contains("."))
                        myviewModel.havePoint = true;
                    else
                        myviewModel.havePoint = false;
                    myviewModel.num[0] = "";
                    myviewModel.sign1 = "";

                }

                binding.textView.setText(myviewModel.getMainNum().getValue());

            }
        });

        binding.imageButtontuige.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (! myviewModel.getMainNum().getValue().equals("0")){
                    myviewModel.getMainNum().setValue(myviewModel.getMainNum().getValue().substring(0,myviewModel.getMainNum().getValue().length()-1));
                    if (myviewModel.getMainNum().getValue().equals(""))
                        myviewModel.getMainNum().setValue("0");
                }
            }
        });


    }
}