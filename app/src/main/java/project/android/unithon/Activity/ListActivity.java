package project.android.unithon.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;

import project.android.unithon.Adapter.ItemAdapter;
import project.android.unithon.Model.Item;
import project.android.unithon.R;

public class ListActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;

    StaggeredGridLayoutManager st;
    ArrayList<Item> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        init();
    }

    void init(){

        items = new ArrayList<Item>();
        setData();

        recyclerView = (RecyclerView)findViewById(R.id.recycler1);
        st = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(st);
        adapter = new ItemAdapter(items, getApplicationContext(), R.layout.item_layout);
        recyclerView.setAdapter(adapter);

    }

    void setData(){
        items.add(new Item("가라", "1111111sdfsdgWgGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG111111111111", "30분전", "40k", "DDD"));
        items.add(new Item("가라", "222222222222222222", "30분전", "40k", "DDD"));
        items.add(new Item("가라", "233333333E33333333333", "30분전", "40k", "DDD"));
        items.add(new Item("가라", "44444444FEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE44444444", "30분전", "40k", "DDD"));
        items.add(new Item("가라", "5555555555555", "30분전", "40k", "DDD"));


    }
}
