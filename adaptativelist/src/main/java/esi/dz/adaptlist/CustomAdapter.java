package esi.dz.adaptlist;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;




public class CustomAdapter extends BaseAdapter {
    private Context context;
    private List<Product> listProduct = new ArrayList<Product>();

    public CustomAdapter(Context context, List<Product> listProduct) {
        this.context = context;
        this.listProduct = listProduct;
    }

    @Override
    public int getCount() {
        return listProduct.size();
    }

    @Override
    public Object getItem(int position) {
        return listProduct.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = parent.inflate(context, R.layout.list_item,null);
        ImageView imageList = (ImageView) convertView.findViewById(R.id.imageList);
        TextView textName = (TextView) convertView.findViewById(R.id.textName);
        TextView textPrice = (TextView) convertView.findViewById(R.id.textPrice);
        imageList.setImageResource(listProduct.get(position).getListImage());
        textName.setText(listProduct.get(position).getName());
        textPrice.setText(listProduct.get(position).getPrice());
        return convertView;
    }

}
