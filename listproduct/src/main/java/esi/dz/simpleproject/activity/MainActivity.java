package esi.dz.simpleproject.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import esi.dz.simpleproject.R;
import esi.dz.simpleproject.adapter.CustomAdapter;
import esi.dz.simpleproject.model.Product;

public class MainActivity extends AppCompatActivity {
    List<Product> listProduct = new ArrayList<Product>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(R.id.listProduct);
        preparePorductData();
        CustomAdapter customAdapter = new CustomAdapter(this,listProduct);
        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,DetailActivity.class);
                intent.putExtra("product",listProduct.get(position));
                startActivity(intent);
            }
        });


    }

    public void preparePorductData() {
        String[] desc = getResources().getStringArray(R.array.descriptions);
        listProduct.add(new Product("MERCURIAL VICTORY VI DF","90,00 €",desc[0],"40",R.drawable.prod_1_list,R.drawable.prod_1_detail));
        listProduct.add(new Product("INTERNATIONALIST-Baskets","89,95 €",desc[1],"40",R.drawable.prod_2_list,R.drawable.prod_2_detail));
    }
}
