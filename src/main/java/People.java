//開啟assert
//package org.example.u2debug;

public class People {

    //測試測資
    public static void main(String[] args) {
        //正確測資
        People mark = new People("Mark" , 1999);
        try{
            mark.setAge();
            mark.setHW(1.77 , 65);
        }catch (WrongException e){
            e.printStackTrace();
        }
        double bmi = mark.getBmi();
        System.out.println(mark.name + "'s BMI : " + Math.round(bmi*100.0) / 100.0);

        //錯誤測資:出生年份超過現今年份
        People andy = null;
        try{
            andy = new People("Andy" , 2024 , 1.81 , 63);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        double bmi2 = andy.getBmi();
        System.out.println(andy.name + "'s BMI : " + Math.round(bmi2*100.0) / 100.0);
    }

    String name = "";
    int birthdayYear = 0;
    int age = 0;
    double height = 0 , weight = 0 , bmi = 0;

    //使用姓名及出生年份生成物件
    public People(String name , int birthdayYear){
        this.name = name;
        this.birthdayYear = birthdayYear;
    }

    //使用姓名、出生年份、身高及體重生成物件
    public People(String name , int birthdayYear , double height , double weight) throws Exception{
        this.name = name;
        this.birthdayYear = birthdayYear;
        setAge();    //呼叫setAge()設定年齡
        setHW(height , weight);    //呼叫setHW()設定身高及體重，並計算BMI
    }

    //計算年齡
    //當輸入年份大於現今年份(2023)時，拋出例外處理
    public int setAge() throws WrongException{
        int year = this.birthdayYear;
        if (year > 2023){
            throw new WrongException();
        }
        this.age = 2023 - year;
        return age;
    }

    //設定身高及體重，並計算BMI
    //當輸入身高大於2.2m時，拋出例外處理
    public void setHW(double height , double weight) throws WrongException{
        if (height > 2.2){
            throw new WrongException();
        }
        this.height = height;
        this.weight = weight;
        this.bmi = weight / (height * height);
    }

    //獲得BMI
    //當不在10 < BMI <= 50中時，發生斷言，輸出Wrong BMI
    double getBmi(){
        assert this.bmi > 10 && this.bmi <= 50 : "Wrong BMI";
        return bmi;
    }

    //例外處理 : 數值不符合常理 或 函式無法執行
    class WrongException extends Exception {

        //發生錯誤，告知使用者系統的錯誤訊息
        public WrongException(String title) {
            super(title);
        }

        //發生錯誤，告知使用者輸入的數值中有錯誤之數值
        public WrongException() {
            super("Invalid value");
        }
    }
}

