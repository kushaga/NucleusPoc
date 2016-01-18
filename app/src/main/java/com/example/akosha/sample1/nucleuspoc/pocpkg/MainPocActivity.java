package com.example.akosha.sample1.nucleuspoc.pocpkg;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.akosha.sample1.nucleuspoc.R;
import com.example.akosha.sample1.nucleuspoc.pocpkg.data.MockData;

import java.util.ArrayList;
import java.util.List;

import nucleus.factory.RequiresPresenter;
import nucleus.view.NucleusActivity;

/**
 * Created by kushagarlall on 14/01/16.
 */
@RequiresPresenter(PocActivityPresenter.class)
public class MainPocActivity extends NucleusActivity<PocActivityPresenter> {

    private RecyclerView listMain;
    //    private MockAdapter mockAdapter;
    private MockAdapterRecycler adapter;
    private LinearLayoutManager mLayoutManager;

    int loadView = R.layout.on_load_view;
    int completedView = R.layout.activity_poc_main;

    ViewGroup parent;
    TextView initText;
    int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.initial_view);

        parent = (ViewGroup) findViewById(R.id.parent);
        initText = (TextView) findViewById(R.id.textInit);

//        if (savedInstanceState == null) {
        //start the presenter
        getPresenter().requestPresenter();
//        }
    }

    /*
    * receive items from presenter here and add to the adapter
    * */
    public void onItemsNext(MockData.Employee[] employees) {
//        adapter.addValues(employees);
//        adapter.notifyDataSetChanged();
        onLoadComplete(employees);
    }

    /*
      * on load complete
      * */
    public void onLoadComplete(MockData.Employee[] employees) {
        //// intialise recycler view and bind data to adapter
        //// TODO: replace th view of the activity
        showParent();
        parent.removeAllViews();
        View C = getLayoutInflater().inflate(completedView, parent, false);
        parent.addView(C, index);

        List<MockData.Employee> e2 = new ArrayList<>();

        for (MockData.Employee e1 : employees) {
            e2.add(e1);
        }

        listMain = (RecyclerView) findViewById(R.id.listViewPoc);
        adapter = new MockAdapterRecycler(this, e2);
        mLayoutManager = new LinearLayoutManager(this);
        listMain.setLayoutManager(mLayoutManager);
        listMain.setAdapter(adapter);
    }


    public void onLoadView() {
        showParent();
        View C = getLayoutInflater().inflate(loadView, parent, false);
        parent.addView(C, index);
    }

    /*
    * show parent and hide all the other components
    * */
    private void showParent() {
        initText.setVisibility(View.GONE);
        parent.setVisibility(View.VISIBLE);
    }

    /**
     * handle on network error , show on error view
     */
    public void onNetworkError(Throwable throwable) {
        //// TODO: 18/01/16
        //show on error view to this activity
        Toast.makeText(this, throwable.getMessage(), Toast.LENGTH_LONG).show();
    }

    class MockAdapterRecycler extends RecyclerView.Adapter<MockAdapterRecycler.MockAdapterRecyclerViewHolder> {
        LayoutInflater inflater;
        public List<MockData.Employee> values;

        public MockAdapterRecycler(Context context, List<MockData.Employee> values) {
            inflater = LayoutInflater.from(context);
            this.values = values;
        }

        public void addValues(MockData.Employee[] e) {
            for (MockData.Employee e1 : e) {
                values.add(e1);
            }
        }

        @Override
        public MockAdapterRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View myView = inflater.inflate(R.layout.item, parent, false);
            MockAdapterRecyclerViewHolder viewHolder = new MockAdapterRecyclerViewHolder(myView);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(MockAdapterRecyclerViewHolder holder, int position) {
            if (values != null) {
                holder.textView.setText(values.get(position).firstName);
            }
        }

        @Override
        public int getItemCount() {
            return values.size();
        }

        class MockAdapterRecyclerViewHolder extends RecyclerView.ViewHolder {
            TextView textView;

            public MockAdapterRecyclerViewHolder(View itemView) {
                super(itemView);
                textView = (TextView) itemView.findViewById(R.id.text1);
            }
        }
    }

//    public class MockAdapter extends ArrayAdapter<MockData.Employee> {
//        public final Context context;
//        public List<MockData.Employee> values;
//
//        public MockAdapter(Context context, List<MockData.Employee> values) {
//            super(context, -1, values);
//            this.context = context;
//            this.values = values;
//        }
//
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//            LayoutInflater inflater = (LayoutInflater) context
//                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            View rowView = inflater.inflate(R.layout.item, parent, false);
//            TextView textView = (TextView) rowView.findViewById(R.id.text1);
//            if (values != null) {
//                textView.setText(values.get(position).firstName);
//            }
//
//            return rowView;
//        }
//
//        public void addValues(MockData.Employee[] e) {
//            for (MockData.Employee e1 : e) {
//                values.add(e1);
//            }
//        }
//    }
}
