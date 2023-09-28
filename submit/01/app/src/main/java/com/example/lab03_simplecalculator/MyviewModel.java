package com.example.lab03_simplecalculator;



import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
//储存数据模型
public class MyviewModel extends ViewModel {
    private MutableLiveData<String> mainNum;//主要数据，用户操作中的
    public String num[]={"",""};
    public String sign1= "";
    public String sign2 = "";
    public  boolean havePoint = false;
    public MutableLiveData<String> getMainNum(){
        if (mainNum == null){
            mainNum = new MutableLiveData<>();
            mainNum.setValue("0");
        }
        return mainNum;
    }
    public  void setMainNum(String n){
        if (mainNum.getValue().equals("0")){
            mainNum.setValue(n);
        }else{
            mainNum.setValue(mainNum.getValue()+n);
        }
    }

    public String mainNumwith_0_Tocal(){
        String value="0";
        if (mainNum.getValue().contains(".") || num[0].contains(".")){
            switch (sign1){
                case"+":
                    value = String.valueOf(Double.valueOf(num[0])+Double.valueOf(mainNum.getValue()));
                    break;
                case"-":
                    value = String.valueOf(Double.valueOf(num[0])-Double.valueOf(mainNum.getValue()));
                    break;
                case"*":
                    value = String.valueOf(Double.valueOf(num[0])*Double.valueOf(mainNum.getValue()));
                    break;
                case"/":
                    if (mainNum.getValue().equals("0"))
                        mainNum.setValue("1");
                    value = String.valueOf(Double.valueOf(num[0])/Double.valueOf(mainNum.getValue()));
            }
        }else {
            switch (sign1){
                case"+":
                    value = String.valueOf(Integer.valueOf(num[0])+Integer.valueOf(mainNum.getValue()));
                    break;
                case"-":
                    value = String.valueOf(Integer.valueOf(num[0])-Integer.valueOf(mainNum.getValue()));
                    break;
                case"*":
                    value = String.valueOf(Integer.valueOf(num[0])*Integer.valueOf(mainNum.getValue()));
                    break;
                case"/":
                    if (mainNum.getValue().equals("0"))
                        mainNum.setValue("1");
                    value = String.valueOf(Double.valueOf(num[0])/Double.valueOf(mainNum.getValue()));
            }

        }
        return value;
    }
    public String mainNumWithNum_1_Tocal(){
            String value="0";
            if (mainNum.getValue().contains(".") || num[1].contains(".")){
                switch (sign2){

                    case"*":
                        value = String.valueOf(Double.valueOf(num[1])*Double.valueOf(mainNum.getValue()));
                        break;
                    case"/":
                        if (mainNum.getValue().equals("0"))
                            mainNum.setValue("1");
                        value = String.valueOf(Double.valueOf(num[1])/Double.valueOf(mainNum.getValue()));
                }
            }else {
                switch (sign2){

                    case"*":
                        value = String.valueOf(Integer.valueOf(num[1])*Integer.valueOf(mainNum.getValue()));
                        break;
                    case"/":
                        if (mainNum.getValue().equals("0"))
                            mainNum.setValue("1");
                        value = String.valueOf(Double.valueOf(num[1])/Double.valueOf(mainNum.getValue()));
                }

            }
            return value;

    }

}
