package ir.samiantec.advancedrecyclerviewexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import ir.samiantec.advancedrecyclerviewexample.Adapter.Adapter;
import ir.samiantec.advancedrecyclerviewexample.Model.Section;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView recyclerView = findViewById(R.id.rv);


        final List<Section> sectionList = new ArrayList<>();

        final List<String> list1= new ArrayList<>();
        list1.add("L1 Item 1");
        list1.add("L1 Item 2");
        sectionList.add(new Section("Sec 1", list1));

        final List<String> list2= new ArrayList<>();
        list2.add("L2 Item 1");
        list2.add("L2 Item 2");
        list2.add("L2 Item 3");
        sectionList.add(new Section("Sec 2", list2));

        final List<String> list3= new ArrayList<>();
        list3.add("L3 Item 1");
        sectionList.add(new Section("Sec 3", list3));

        final Adapter adapter = new Adapter(sectionList);

        recyclerView.setAdapter(adapter);
    }

}