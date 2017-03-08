package esi.dz.adaptlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ImageView imageDetail;
    TextView textName;
    TextView textSize;
    TextView textPrice;
    TextView textDescription ;

    List<Product> listProduct = new ArrayList<Product>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(R.id.listProduct);
         imageDetail = (ImageView) findViewById(R.id.imageDetail);
         textName = (TextView) findViewById(R.id.textName);
         textSize = (TextView) findViewById(R.id.textSize);
         textPrice = (TextView) findViewById(R.id.textPrice);
         textDescription = (TextView) findViewById(R.id.textDescription);
         preparePorductData();
         CustomAdapter customAdapter = new CustomAdapter(this,listProduct);
         listView.setAdapter(customAdapter);
         listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (isTwoPane()) {
                    Product product = listProduct.get(position);
                    imageDetail.setImageResource(product.getDetailImage());
                    textName.setText(product.getName());
                    textSize.setText(getString(R.string.size_label)+" "+product.getSize());
                    textPrice.setText(getString(R.string.price_label)+" "+product.getPrice());
                    textDescription.setText(getString(R.string.description_label)+" "+product.getDescription());
                }
                else {
                    Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                    intent.putExtra("product", listProduct.get(position));
                    startActivity(intent);
                }

            }
        });

    }

    public boolean isTwoPane(){
        View view = findViewById(R.id.fragment2);
        return (view!=null);
    }

        public void preparePorductData(){
            String[] desc = getResources().getStringArray(R.array.descriptions);
            listProduct.add(new Product("MERCURIAL VICTORY VI DF","90,00 €",desc[0],"40",R.drawable.prod_1_list,R.drawable.prod_1_detail));
            listProduct.add(new Product("INTERNATIONALIST-Baskets","89,95 €",desc[1],"40",R.drawable.prod_2_list,R.drawable.prod_2_detail));
        }


}
