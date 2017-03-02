package esi.dz.recycleviewporduct.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import esi.dz.recycleviewporduct.R;
import esi.dz.recycleviewporduct.model.Product;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();
        Product product = (Product) intent.getSerializableExtra("product");

        ImageView imageDetail = (ImageView) findViewById(R.id.imageDetail);
        TextView textName = (TextView) findViewById(R.id.textName);
        TextView textSize = (TextView) findViewById(R.id.textSize);
        TextView textPrice = (TextView) findViewById(R.id.textPrice);
        TextView textDescription = (TextView) findViewById(R.id.textDescription);
        imageDetail.setImageResource(product.getDetailImage());
        textName.setText(product.getName());
        textSize.setText(getString(R.string.size_label)+" "+product.getSize());
        textPrice.setText(getString(R.string.price_label)+" "+product.getPrice());
        textDescription.setText(getString(R.string.description_label)+" "+product.getDescription());
    }
}
