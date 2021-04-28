package com.example.books.ui.add;

import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Base64;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import com.example.books.R;

import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import sqlite.MyDBHelper;

public class IncomeFragment extends Fragment {
    private IncomeViewModel incomeViewModel;
    private String img="salary";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        bar = getActionBar();  //获取ActionBar的对象，从这个方法也可知action bar是activity的一个属性
//        bar.setDisplayHomeAsUpEnabled(true);
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        incomeViewModel = ViewModelProviders.of(this).get(IncomeViewModel.class);
        final View root = inflater.inflate(R.layout.income, container, false);

        Button complete2 = (Button)root.findViewById(R.id.complete2);
        Button expenses = (Button)root.findViewById(R.id.expenses);

        final ImageView category_img=(ImageView)root.findViewById(R.id.select_category);   //取得上方顯示的收入類別圖示
        category_img.setImageDrawable(getResources().getDrawable(R.drawable.salary));   //預設是工資圖示

//        Bitmap bitmap = ((BitmapDrawable) getResources().getDrawable(R.drawable.salary)).getBitmap();
//
//        //將Bitmap壓縮至字結數組輸出流ByteArrayOutputStream
//        ByteArrayOutputStream bos = new ByteArrayOutputStream();
//        bitmap.compress(Bitmap.CompressFormat.JPEG, 80, bos);
//
//        //利用Base64 字結束組輸出流中的數據轉換成字符串String
//        byte[] byteArray = bos.toByteArray();
//        img = new String(Base64.encodeToString(byteArray, Base64.DEFAULT));


        /*
        ArrayList<String> cname = new ArrayList<String>();  //創建陣列以儲存選擇的類別名稱
        TextView category_name=(TextView)getView().findViewById(R.id.select_category_name);   //取得上方顯示的收入類別
        cname.add(category_name.getText().toString());
        */

        /*
        ArrayList cmoney = new ArrayList();  //創建陣列以儲存選擇的類別金額
        EditText input_meney=(EditText)getView().findViewById(R.id.input);    //取得輸入的金額
        int earn_money=Integer.valueOf(String.valueOf(input_meney.getText())); //將金額轉為整數
        cmoney.add(earn_money);

         */

        Button salary=(Button)root.findViewById(R.id.btn_salary);
        Button red_envelopes=(Button)root.findViewById(R.id.btn_red_envelopes);
        Button part_time=(Button)root.findViewById(R.id.btn_part_time);
        Button investment=(Button)root.findViewById(R.id.btn_investment);

        Button bonus=(Button)root.findViewById(R.id.btn_bonus);
        ImageView withdrawal=(ImageView)root.findViewById(R.id.btn_withdrawal);
        ImageView stocks=(ImageView)root.findViewById(R.id.btn_stocks);
        ImageView others=(ImageView)root.findViewById(R.id.btn_others);

        TextView tv_salary=(TextView)root.findViewById(R.id.tv_salary);
        TextView tv_red_envelopes=(TextView)root.findViewById(R.id.tv_red_envelopes);
        TextView tv_part_time=(TextView)root.findViewById(R.id.tv_part_time);
        TextView tv_investment=(TextView)root.findViewById(R.id.tv_investment);
        TextView tv_bonus=(TextView)root.findViewById(R.id.tv_bonus);
        TextView tv_withdrawal=(TextView)root.findViewById(R.id.tv_withdrawal);
        TextView tv_stocks=(TextView)root.findViewById(R.id.tv_stocks);
        TextView tv_others=(TextView)root.findViewById(R.id.tv_others);


        salary.setOnClickListener(new View.OnClickListener() {//按下收入類別按鈕
            @Override
            public void onClick(View v) {
                //TextView category_name=(TextView)root.findViewById(R.id.select_category_name);   //取得上方顯示的收入類別

                //category_name.setText("工資");    //顯示收入類型
                //category_img.setImageDrawable(getResources().getDrawable(R.drawable.salary));   //顯示收入類型圖示

                show_category("salary");

            }
        });

        red_envelopes.setOnClickListener(new View.OnClickListener() {//按下收入類別按鈕
            @Override
            public void onClick(View v) {
                //TextView category_name=(TextView)root.findViewById(R.id.select_category_name);   //取得上方顯示的收入類別
                //category_name.setText("紅包");    //顯示收入類型
                //category_img.setImageDrawable(getResources().getDrawable(R.drawable.envelope));   ////顯示收入類型圖示
                show_category("red_envelopes");
            }
        });

        part_time.setOnClickListener(new View.OnClickListener() {//按下收入類別按鈕
            @Override
            public void onClick(View v) {
                //TextView category_name=(TextView)root.findViewById(R.id.select_category_name);   //取得上方顯示的收入類別

                //category_name.setText("兼職");    //顯示兼職收入
                //category_img.setImageDrawable(getResources().getDrawable(R.drawable.parttme));
                show_category("part_time");
            }
        });

        investment.setOnClickListener(new View.OnClickListener() {//按下收入類別按鈕
            @Override
            public void onClick(View v) {
                //TextView category_name=(TextView)root.findViewById(R.id.select_category_name);   //取得上方顯示的收入類別

                //category_name.setText("投資");
                //category_img.setImageDrawable(getResources().getDrawable(R.drawable.investment));
                show_category("investment");
            }
        });

        bonus.setOnClickListener(new View.OnClickListener() {//按下收入類別按鈕
            @Override
            public void onClick(View v) {
                //TextView category_name=(TextView)root.findViewById(R.id.select_category_name);   //取得上方顯示的收入類別

                //category_name.setText("獎金");
                //category_img.setImageDrawable(getResources().getDrawable(R.drawable.bonus));
                show_category("bonus");
            }
        });

        withdrawal.setOnClickListener(new View.OnClickListener() {//按下收入類別按鈕
            @Override
            public void onClick(View v) {
                //TextView category_name=(TextView)root.findViewById(R.id.select_category_name);   //取得上方顯示的收入類別

                //category_name.setText("提款");
                //category_img.setImageDrawable(getResources().getDrawable(R.drawable.withdraw));

                show_category("withdrawal");
            }
        });

        stocks.setOnClickListener(new View.OnClickListener() {//按下收入類別按鈕
            @Override
            public void onClick(View v) {
                //TextView category_name=(TextView)root.findViewById(R.id.select_category_name);   //取得上方顯示的收入類別

                //category_name.setText("股票");
                //category_img.setImageDrawable(getResources().getDrawable(R.drawable.stock));
                show_category("stocks");
            }
        });

        others.setOnClickListener(new View.OnClickListener() {//按下收入類別按鈕
            @Override
            public void onClick(View v) {
                //TextView category_name=(TextView)root.findViewById(R.id.select_category_name);   //取得上方顯示的收入類別

                //category_name.setText("其他");
                //category_img.setImageDrawable(getResources().getDrawable(R.drawable.coins));
                show_category("others");
            }
        });

        //

        tv_salary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show_category("salary");

            }
        });

        tv_red_envelopes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show_category("red_envelopes");
            }
        });

        tv_part_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show_category("part_time");
            }
        });

        tv_investment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show_category("investment");
            }
        });

        tv_bonus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show_category("bonus");
            }
        });

        tv_withdrawal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show_category("withdrawal");
            }
        });

        tv_stocks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show_category("stocks");
            }
        });

        tv_others.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show_category("others");
            }
        });

        expenses.setOnClickListener(new View.OnClickListener() {//按下支出按鈕
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_navigation_income_to_navigation_add);
            }
        });

        complete2.setOnClickListener(new View.OnClickListener() {//按下完成按鈕，存資料
            MyDBHelper mydbHelper = new MyDBHelper(getActivity());
            String activity_type="",date = "",time="";
            int money=0;

            SimpleDateFormat simpleDateFormat_date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date today = new Date();
            String dateStr = simpleDateFormat_date.format(today); //format()方法将Date转换成指定格式的String

            String s_date=dateStr.substring(0,10);
            String s_now=dateStr.substring(11,19);

            @Override
            public void onClick(View view) {
                TextView category_name=(TextView)root.findViewById(R.id.select_category_name);   //取得上方顯示的收入類別
                EditText input_meney=(EditText)root.findViewById(R.id.input);    //取得輸入的金額

                //若使用者未輸入金額 或輸入0 或不是整數
                if(input_meney.getText().toString().equals("")||Integer.valueOf(String.valueOf(input_meney.getText()))==0){
                    // Create a Toast notification/message
                    Toast toast = Toast.makeText(
                            //getActivity(),"Custom Toast From Fragment",Toast.LENGTH_LONG
                            getActivity().getApplicationContext(), "請輸入金額", Toast.LENGTH_SHORT
                    );
                    // Set the Toast display position layout center
                    toast.setGravity(Gravity.CENTER,0,0);
                    // Finally, show the toast
                    toast.show();
                }
                else{
                    int earn_money=Integer.valueOf(String.valueOf(input_meney.getText())); //將金額轉為整數

                    //改這邊資料可以存到資料庫
                    activity_type= category_name.getText().toString();
                    date = s_date;
                    time=s_now;
                    money=earn_money;

                    mydbHelper.insertData(activity_type,"收入",money,date,time,img);//插入資料到資料庫


                    // Create a Toast notification/message
                    Toast toast = Toast.makeText(
                            //getActivity(),"Custom Toast From Fragment",Toast.LENGTH_LONG
                            getActivity().getApplicationContext(), "新增成功", Toast.LENGTH_SHORT
                    );
                    // Set the Toast display position layout center
                    toast.setGravity(Gravity.CENTER,0,0);
                    // Finally, show the toast
                    toast.show();

                    Navigation.findNavController(view).navigate(R.id.action_navigation_income_to_navigation_home);  //回主頁
                }



            }
        });



        incomeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
            }
        });
        return root;

    }

    //變換上方的圖形與文字
    private void show_category(String name) {
        TextView category_name=(TextView)getView().findViewById(R.id.select_category_name);   //取得上方顯示的收入類別
        ImageView category_img=(ImageView)getView().findViewById(R.id.select_category);   //取得上方顯示的收入類別圖示

        switch (name){
            case "salary":
                category_name.setText("工資");    //顯示收入類型
                category_img.setImageDrawable(getResources().getDrawable(R.drawable.salary));   //顯示收入類型圖示
                img = "salary";
                break;

            case "red_envelopes":
                category_name.setText("紅包");    //顯示收入類型
                category_img.setImageDrawable(getResources().getDrawable(R.drawable.envelope));   //顯示收入類型圖示
                img = "envelope";
                break;

            case "part_time":
                category_name.setText("兼職");    //顯示收入類型
                category_img.setImageDrawable(getResources().getDrawable(R.drawable.parttme));   //顯示收入類型圖示
                img = "parttme";
                break;

            case "investment":
                category_name.setText("投資");    //顯示收入類型
                category_img.setImageDrawable(getResources().getDrawable(R.drawable.investment));   //顯示收入類型圖示
                img = "investment";
                break;

            case "bonus":
                category_name.setText("獎金");    //顯示收入類型
                category_img.setImageDrawable(getResources().getDrawable(R.drawable.bonus));   //顯示收入類型圖示
                img = "bonus";
                break;

            case "withdrawal":
                category_name.setText("提款");    //顯示收入類型
                category_img.setImageDrawable(getResources().getDrawable(R.drawable.withdraw));   //顯示收入類型圖示
                img = "withdraw";
                break;

            case "stocks":
                category_name.setText("股票");    //顯示收入類型
                category_img.setImageDrawable(getResources().getDrawable(R.drawable.stock));   //顯示收入類型圖示
                img = "stock";
                break;

            case "others":
                category_name.setText("其他");    //顯示收入類型
                category_img.setImageDrawable(getResources().getDrawable(R.drawable.coins));   //顯示收入類型圖示
                img = "coins";
                break;

        }

    }
}
