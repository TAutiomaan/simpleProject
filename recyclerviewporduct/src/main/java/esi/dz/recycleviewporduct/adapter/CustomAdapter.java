package esi.dz.recycleviewporduct.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
import esi.dz.recycleviewporduct.R;
import esi.dz.recycleviewporduct.activity.DetailActivity;
import esi.dz.recycleviewporduct.model.Product;



public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    private Context context;
    private List<Product> productsList;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textName, textPrice;
        public ImageView imageList;


        public MyViewHolder(View view) {
            super(view);
            imageList = (ImageView) view.findViewById(R.id.imageList);
            textName = (TextView) view.findViewById(R.id.textName);
            textPrice = (TextView) view.findViewById(R.id.textPrice);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context,DetailActivity.class);
                    intent.putExtra("product",productsList.get(getAdapterPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }


    public CustomAdapter(Context context,List<Product> productsList) {
        this.context = context;
        this.productsList = productsList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final Product product = productsList.get(position);
        holder.imageList.setImageResource(product.getListImage());
        holder.textName.setText(product.getName());
        holder.textPrice.setText(product.getPrice());
        //  delete item when clicking on the product name
        holder.textName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                remove(product);
            }
        });
    }

    @Override
    public int getItemCount() {
        return productsList.size();
    }

    public void remove(Product item) {
        int position = productsList.indexOf(item);
        productsList.remove(position);
        notifyItemRemoved(position);
    }
}
