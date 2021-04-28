package HomeList;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.books.R;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

public class HomeListAdapter  extends BaseAdapter {

    //    private Context context;
    private List<String> ID;
    private List<String> DateInfo;
    private List<String> TotalExp;
    private  List<String> ActType;
    private  List<String> Money;
    private  List<String> Type;
    private  List<String> TypeIcon;


//    private  List<String> month_incomeInt;
//    private  List<String> month_expencesInt;

//    private List<Integer> mIcons;

    public HomeListAdapter(List<String> ID, List<String> DateInfo, List<String> TotalExp,
                           List<String> ActType,List<String> Money,List<String> Type, List<String> TypeIcon) {
        this.ID = ID;
        this.DateInfo = DateInfo;
        this.TotalExp = TotalExp;
        this.ActType = ActType;
        this.Money = Money;
        this.Type = Type;
        this.TypeIcon = TypeIcon;
    }

    @Override
    public int getCount() {
        return DateInfo.size();
    }

    @Override
    public Object getItem(int i) {
        return DateInfo.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public String getId(int i) {
        return ID.get(i);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 檢查convertView是否有值，有值表示是重複使用的
        if (convertView == null) {
            // 沒有值就要自己建立一個
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_list, null);
        }

        // 找到TextView,ImageView
        TextView date_info = (TextView) convertView.findViewById(R.id.date_info);
        TextView total_exp = (TextView) convertView.findViewById(R.id.total_exp);
        TextView actType = (TextView) convertView.findViewById(R.id.actType);
        TextView type = (TextView) convertView.findViewById(R.id.type);
        TextView money = (TextView) convertView.findViewById(R.id.money);
        ImageView type_icon = (ImageView) convertView.findViewById(R.id.type_icon);

        // 取出文字
        String date_info_text = (String) getItem(position);
        String total_exp_text = (String) TotalExp.get(position);
        String actType_text = (String) ActType.get(position);
        String type_text = (String) Type.get(position);
        String money_text = (String) Money.get(position);
        String type_icon_str = (String) TypeIcon.get(position);

        if(type_text.equals("收入")){
            money.setText(" + "+money_text);
        }
        else {
            money.setText(" - "+money_text);
        }
        // 將文字內容設定給TextView
        date_info.setText(date_info_text);
        total_exp.setText(total_exp_text);
        actType.setText(actType_text);
        type.setText(type_text);

        switch (type_icon_str){
            case "salary":
                type_icon.setImageResource(R.drawable.salary);
                break;
            case "envelope":
                type_icon.setImageResource(R.drawable.envelope);
                break;
            case "parttme":
                type_icon.setImageResource(R.drawable.parttme);
                break;
            case "investment":
                type_icon.setImageResource(R.drawable.investment);
                break;
            case "bonus":
                type_icon.setImageResource(R.drawable.bonus);
                break;
            case "withdraw":
                type_icon.setImageResource(R.drawable.withdraw);
                break;
            case "stock":
                type_icon.setImageResource(R.drawable.stock);
                break;
            case "coins":
                type_icon.setImageResource(R.drawable.coins);
                break;
            case "eat":
                type_icon.setImageResource(R.drawable.eat);
                break;
            case "clothes":
                type_icon.setImageResource(R.drawable.clothes);
                break;
            case "bag":
                type_icon.setImageResource(R.drawable.bag);
                break;
            case "shoppingcart":
                type_icon.setImageResource(R.drawable.shoppingcart);
                break;
            case "airticket":
                type_icon.setImageResource(R.drawable.airticket);
                break;
            case "entertainment":
                type_icon.setImageResource(R.drawable.entertainment);
                break;
            case "callphone":
                type_icon.setImageResource(R.drawable.callphone);
                break;
            case "medical":
                type_icon.setImageResource(R.drawable.medical);
                break;
            case "car":
                type_icon.setImageResource(R.drawable.car);
                break;
            case "water":
                type_icon.setImageResource(R.drawable.water);
                break;
            case "gift":
                type_icon.setImageResource(R.drawable.gift);
                break;
            case "paybook":
                type_icon.setImageResource(R.drawable.paybook);
                break;
        }



//        // 找到ImageView
//        ImageView icon = (ImageView) convertView.findViewById(R.id.img);
//        // 依照位置算出對應的圖片
//        int resId = mIcons[position % mIcons.length];
//        // 將圖片設定給ImageView
//        icon.setImageResource(resId);

        // 一定要將convertView回傳，供ListView呈現使用，並加入重用機制中
        return convertView;
    }



}
