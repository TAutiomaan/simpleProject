package esi.dz.recycleviewporduct.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import esi.dz.recycleviewporduct.R;
import esi.dz.recycleviewporduct.adapter.CustomAdapter;
import esi.dz.recycleviewporduct.model.Product;

public class MainActivity extends AppCompatActivity {
    List<Product> listProduct = new ArrayList<Product>();
    private RecyclerView recyclerView;
    private CustomAdapter customAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        customAdapter = new CustomAdapter(this,listProduct);
        GridLayoutManager mLayoutManager = new GridLayoutManager(this,2);
        //RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
        itemAnimator.setAddDuration(1000);
        itemAnimator.setRemoveDuration(1000);
        recyclerView.setItemAnimator(itemAnimator);
        recyclerView.setAdapter(customAdapter);
        preparePorductData();

    }
    public void preparePorductData() {
        String[] desc = getResources().getStringArray(R.array.descriptions);
        listProduct.add(new Product("MERCURIAL VICTORY VI DF","90,00 €",desc[0],"40",R.drawable.prod_1_list,R.drawable.prod_1_detail));
        listProduct.add(new Product("INTERNATIONALIST-Baskets","89,95 €",desc[1],"40",R.drawable.prod_2_list,R.drawable.prod_2_detail));
    }
}
