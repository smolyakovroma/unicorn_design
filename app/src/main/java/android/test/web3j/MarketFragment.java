package android.test.web3j;


import android.app.Fragment;
import android.content.Context;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import org.web3j.protocol.core.methods.response.TransactionReceipt;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscription;


public class MarketFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener, MarketListAdapter.OnItemClick {

    private final static int LIMIT = 10;
    private Subscription pagingSubscription;

    SwipeRefreshLayout swipeRefreshLayout;
    FrameLayout frameMarket;
    private FragmentActivity myContext;
    private MarketListAdapter mAdapter;

    RecyclerView recyclerView;
    TextView empty;
    ArrayList<Unicorn> list;
//    private FilterUnicorns filterMarket = new FilterUnicorns();

    public MarketFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        myContext = (FragmentActivity) context;
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_market, container, false);
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeContainer);

         frameMarket = (FrameLayout) view.findViewById(R.id.frame_market);
         recyclerView = (RecyclerView) view.findViewById(R.id.rv_unicorns);
        TextView empty = (TextView) view.findViewById(R.id.empty);

//        ButterKnife.bind(this, view);

        setRetainInstance(true);
        init(view, savedInstanceState);

        return view;
    }

    private void init(View view, Bundle savedInstanceState) {
        recyclerView.setLayoutManager(new LinearLayoutManager(myContext));
        list = new ArrayList<>();

//        mAdapter = new MarketListAdapter(new ArrayList<Unicorn>(), this, myContext, recyclerView);
//        mAdapter.setHasStableIds(true); //TODO fixbug - repeate view of 3 elements...

        recyclerView.setAdapter(mAdapter);
        recyclerView.setSaveEnabled(true);


        swipeRefreshLayout.setColorSchemeColors(Color.RED, Color.GREEN, Color.BLUE, Color.CYAN);

        swipeRefreshLayout.setOnRefreshListener(this);
        updateUI();

//        empty.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                updateUI();
//            }
//        });


//        addPagination();
//        updateUI();
        // if all items was loaded we don't need Pagination
//        if (mAdapter.isAllItemsLoaded()) {
//            return;
//        }


//        if (((MainActivity) getActivity()).getListMarket().isEmpty()) {
//            empty.setVisibility(View.VISIBLE);
//            swipeRefreshLayout.setVisibility(View.INVISIBLE);
//        } else {
//            swipeRefreshLayout.setVisibility(View.VISIBLE);
//            empty.setVisibility(View.INVISIBLE);
//            mAdapter.changeDataSet(((MainActivity) getActivity()).getListMarket());
//        }

    }


    public class GetMarket extends AsyncTask<Void, Void, ArrayList<Unicorn>> {


        @Override
        protected ArrayList<Unicorn> doInBackground(Void... args) {
            ArrayList<Unicorn> list = new ArrayList<>();

            try {

//                if (Constants.auth == null || Constants.auth.getToken() == null) {
//                    Utility.authTokenAsync();
//                    showError("not found auth token");
//                    new Exception("Not found token");
//                }
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(Constants.URL.HOST_BACKEND)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                RestApi restApi = retrofit.create(RestApi.class);

                FilterUnicorns filterMarket = new FilterUnicorns();
                filterMarket.setUserId("69");
                filterMarket.setPage(1);
                filterMarket.setSort("newest");
                filterMarket.setTarget("all");
                filterMarket.setCountOnPage(10);
                filterMarket.setQuery(null);
                Filters filters = new Filters();
                filters.setOwnerId("69");
                filterMarket.setFilters(filters);
                String token = new String("vylpU9lCoWrv4XFQPM0YsdGcyHR86wY1Zf6LDd8wuK4e50NlxWH9ile8M18borXecpI6bun2iFbp3ToQ3MIw00000045");
                Call<Unicorns> call = restApi.getUnicorns(token, filterMarket);
                Response<Unicorns> execute = call.execute();
                if (execute.isSuccessful() && execute.body() != null) {
                    list = execute.body().getItems();

                }
//                call.enqueue(new Callback<Unicorns>() {
//                    @Override
//                    public void onResponse(Call<Unicorns> call, Response<Unicorns> response) {
//                        if(response.isSuccessful() && response.body()!=null){
//
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<Unicorns> call, Throwable t) {
//
//                    }
//                });
            } catch (Exception e) {
                e.printStackTrace();
            }
            return list;


        }

        @Override
        protected void onPostExecute(ArrayList<Unicorn> unicorns) {
            list = unicorns;
            mAdapter = new MarketListAdapter(list, MarketFragment.this, myContext, recyclerView);
//        mAdapter.setHasStableIds(true); //TODO fixbug - repeate view of 3 elements...

            recyclerView.setAdapter(mAdapter);
            recyclerView.setSaveEnabled(true);

        }
    }

    @Override
    public void onDestroyView() {
        unsubscribe();

        // for memory leak prevention (RecycleView is not unsubscibed from adapter DataObserver)
        if (recyclerView != null) {
            recyclerView.setAdapter(null);
        }
        super.onDestroyView();
    }


    @Override
    public void onRefresh() {
        swipeRefreshLayout.setRefreshing(false);
        updateUI();
    }

    @Override
    public void onItemClick(@NonNull Unicorn unicorn) {

    }

    @Override
    public void update() {

    }

    public static int editablePosition = -1;

    public void buyUnicornWithEth(Unicorn unicorn, int position) {
        this.editablePosition = position;
    }

    public void buyUnicornWithCandy(Unicorn unicorn, int position) {
        this.editablePosition = position;
    }

    public void updatePositionLite(int position) {
        mAdapter.updatePositionLite(position);
    }


//    public void setFilterMarket(FilterUnicorns filterMarket) {
//        this.filterMarket = filterMarket;
//    }
//
//    public FilterUnicorns getFilterMarket() {
//        return filterMarket;
//    }

    private void showError(String msg) {
//        if (!((MainActivity) myContext).getMarketFragment().isVisible()) return;
//        Snackbar snackbar = Snackbar.make(frameMarket, msg, Snackbar.LENGTH_LONG)
//                .setAction(getResources().getString(R.string.title_Retry), v -> onRefresh());
//        snackbar.setDuration(5000);
//        snackbar.show();
    }

    public void updateUI() {
        new GetMarket().execute();
//        ((MainActivity) getActivity()).showLoadingIndicator(getResources().getString(R.string.dlg_load_market));
//        if (Constants.auth == null || Constants.auth.getToken() == null) {
//            Utility.authTokenAsync();
//            ((MainActivity) getActivity()).hideLoadingIndicator();
//            showError(getResources().getString(R.string.title_error_auth));
//            return;
//        }
//
//
//
//        new GetMarket().execute(filterMarket);
    }

    private void addPagination() {
//        // RecyclerView pagination
//        PaginationTool<List<Unicorn>> paginationTool = PaginationTool.buildPagingObservable(recyclerView, offset -> EmulateResponseManager.getInstance().getEmulateResponse(offset, LIMIT, filterMarket))
//                .setLimit(LIMIT)
//                .build();
//
//
//        pagingSubscription = paginationTool
//                .getPagingObservable()
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<List<Unicorn>>() {
//                    @Override
//                    public void onCompleted() {
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                    }
//
//                    @Override
//                    public void onNext(List<Unicorn> items) {
//
//                        mAdapter.addNewItems(items);
//                        mAdapter.notifyItemInserted(mAdapter.getItemCount() - items.size());
//                    }
//                });
    }


    public void unsubscribe() {
//        if (pagingSubscription != null && !pagingSubscription.isUnsubscribed()) {
//            pagingSubscription.unsubscribe();
//        }
    }
}
