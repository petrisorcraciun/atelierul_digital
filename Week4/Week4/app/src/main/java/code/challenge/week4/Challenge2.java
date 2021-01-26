package code.challenge.week4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class Challenge2 extends AppCompatActivity {
    RecyclerView rvDemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge2);

        rvDemo = findViewById(R.id.rv_demo);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);

        rvDemo.setLayoutManager(linearLayoutManager);

        DividerItemDecoration divider = new DividerItemDecoration(this, linearLayoutManager.getOrientation());
        rvDemo.addItemDecoration(divider);

        List<Item> dataSource = DataSource.getItems(100);

        rvDemo.setAdapter(new ItemAdapter(dataSource));

    }
}