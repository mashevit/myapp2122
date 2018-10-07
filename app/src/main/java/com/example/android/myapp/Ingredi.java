package com.example.android.myapp;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;

import com.example.android.myapp.database.AppDB;
import com.example.android.myapp.database.Dish;
import com.example.android.myapp.database.Mitzrahnames;
import com.example.android.myapp.ingredi.MyViewModel;
import com.example.android.myapp.ingredi.MyViewModelFactoryDishParams;
import com.example.android.myapp.ingredi.ingrediViewModel;

import java.util.List;

import static android.support.v7.widget.DividerItemDecoration.VERTICAL;

public class Ingredi extends AppCompatActivity implements ingrediAdapter.ingrediAdapterOnClickHandler{
    public static final String EXTRA_DATA_ID ="blanan" ;
    private static final int DEFAULT_TASK_ID = -1;
    public static final String EXTRA_DATA_ID1 ="blalal" ;
    private RecyclerView mRecyclerView;
    private ingrediAdapter myAdapter;
    private FloatingActionButton fabButton;
    private String[] mTaskId;// = DEFAULT_TASK_ID+"";
    private AppDB mDb;

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredi);





        mRecyclerView = (RecyclerView) findViewById(R.id.recyingre);

        LinearLayoutManager layoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        /* setLayoutManager associates the LayoutManager we created above with our RecyclerView */

        DividerItemDecoration decoration = new DividerItemDecoration(getApplicationContext(), VERTICAL);
        mRecyclerView.addItemDecoration(decoration);
        mRecyclerView.setLayoutManager(layoutManager);
        mDb = AppDB.getInstance(getApplicationContext());

        /*
         * Use this setting to improve performance if you know that changes in content do not
         * change the child layout size in the RecyclerView
         */
        mRecyclerView.setHasFixedSize(true);

        /*
         * The ForecastAdapter is responsible for linking our weather data with the Views that
         * will end up displaying our weather data.
         *
         * Although passing in "this" twice may seem strange, it is actually a sign of separation
         * of concerns, which is best programming practice. The ForecastAdapter requires an
         * Android Context (which all Activities are) as well as an onClickHandler. Since our
         * MainActivity implements the ForecastAdapter ForecastOnClickHandler interface, "this"
         * is also an instance of that type of handler.
         */
        myAdapter = new ingrediAdapter(this, this);

        /* Setting the adapter attaches it to the RecyclerView in our layout. */
        mRecyclerView.setAdapter(myAdapter);


     new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

///    Called when a user swipes left or right on a ViewHolder
           @Override
           public void onSwiped(final RecyclerView.ViewHolder viewHolder, int swipeDir) {
                // Here is where you'll implement swipe to delete
                if(swipeDir==ItemTouchHelper.LEFT){
                    AppExecutors.getInstance().diskIO().execute(new Runnable() {
                        @Override
                        public void run() {
                            int position = viewHolder.getAdapterPosition();
                            List<Mitzrahnames> tasks = myAdapter.getingreds();

                            Mitzrahnames ingredii=tasks.get(position);

                            mDb.mitzrahnamesDao().deleteingreds(ingredii);



                   //todo:         mDb.ingredientsDao().DelParams(ingredii.getIngredientidglobal());
                          //  mDb.mitzrahnamesDao().deleteingreds(ingredii);

                        }



                    });
                }

                else if(swipeDir== ItemTouchHelper.RIGHT){

                }
            }
        }).attachToRecyclerView(mRecyclerView);


        Intent intent = getIntent();
        if (intent != null && intent.hasExtra(EXTRA_DATA_ID)) {
            //  mButton.setText(R.string.update_button);

                // populate the UI
                mTaskId = intent.getStringArrayExtra(EXTRA_DATA_ID);
//            if (mTaskId != DEFAULT_TASK_ID+"") {
               // setupViewModel11(mTaskId);
               // aa(mTaskId);
                setupViewModel11(mTaskId);
  //          }

        }

else{



            setupViewModel();


        }
//else setupViewModel();
        fabButton = findViewById(R.id.floatingActionButton2);
/*       fabButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create a new intent to start an AddTaskActivity
                //   func1();
                Intent intent = new Intent(MainActivity.this, AddDish.class);
                intent.putExtra(AddDish.EXTRA_TASK_ID, count);
                startActivity(intent);
               final Dish dish = new Dish("my dish name "+count);
                count++;
               mDb.dishDao().insertDish(dish);
                ///Intent addTaskIntent = new Intent(MainActivity.this, AddTaskActivity.class);
                // startActivity(addTaskIntent);
            }
        });*/

    }

    private void setupViewModel() {
        ingrediViewModel viewModel = ViewModelProviders.of(this).get(ingrediViewModel.class);
        viewModel.getTasks().observe(this, new Observer<List<Mitzrahnames>>() {
            @Override
            public void onChanged(@Nullable List<Mitzrahnames> taskEntries) {
                Log.d(TAG, "Updating list of tasks from LiveData in ViewModel");
                myAdapter.setingreds(taskEntries);
            }
        });
    }

            private void setupViewModel11(String[] aa) {
     /*           ingrediViewModel viewModel = ViewModelProviders.of(this).get(ingrediViewModel.class);
                viewModel.getTasks().observe(this, new Observer<List<Mitzrahnames>>() {
                    @Override
                    public void onChanged(@Nullable List<Mitzrahnames> taskEntries) {
                        Log.d(TAG, "Updating list of tasks from LiveData in ViewModel");
                        myAdapter.setingreds(taskEntries);
                    }
                });*/
                Log.i("ijkjasas",aa+"");
                MyViewModel myViewModel = ViewModelProviders.of(this, new MyViewModelFactoryDishParams(mDb, aa)).get(MyViewModel.class);
                myViewModel.getIngrediwithparam().observe(this, new Observer<List<Mitzrahnames>>() {
                    @Override
                    public void onChanged(@Nullable List<Mitzrahnames> taskEntries) {
                        Log.d(TAG, "Updating list of tasks from LiveData in ViewModel");
                        myAdapter.setingreds(taskEntries);
                    }
                });
            }


    @Override
    public void onClick(long date) {

    }

    private void aa(final int aa){
        Log.i("ijkjasas1",aa+"");


        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                /*          if (mTaskId == DEFAULT_TASK_ID) {*/
                // insert new task
                List<Mitzrahnames> myObjectList = mDb.mitzrahnamesDao().loadAllingredswithp1(aa);
                myAdapter.setingreds(myObjectList);
               /* } else {
                    //update task
                    task.setId(mTaskId);
                    mDb.dishDao().updateDish(task);
                }*/

                //myAdapter.setingreds(myObjectList);
                finish();
            }
        });
        //List<Mitzrahnames> myObjectList = mDb.mitzrahnamesDao().loadAllingredswithp1(aa);
    //    myAdapter.setingreds(myObjectList);
    }
}
